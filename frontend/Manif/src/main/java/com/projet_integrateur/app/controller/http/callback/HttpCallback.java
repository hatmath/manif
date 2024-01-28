package com.projet_integrateur.app.controller.http.callback;

import android.util.Log;

import com.projet_integrateur.Globals;
import com.projet_integrateur.utils.Utils;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;
import java.io.IOException;

import com.projet_integrateur.base.BaseCallback;

public abstract class HttpCallback extends BaseCallback
{
    public static String  TAG = HttpCallback.class.getSimpleName().toUpperCase();



    public void setDialog_OnSuccess(Boolean isEnabled) { Globals.DialogOnSuccess_IsEnabled = isEnabled; }
    public void setDialog_OnFailure(Boolean isEnabled) { Globals.DialogOnFailure_IsEnabled = isEnabled; }

    public void onFailure(int statusCode)
    {
        String Title = "Une erreur est survenue" ;
        String Message = "Error code : " + String.valueOf(statusCode);

        if(Globals.DialogOnFailure_IsEnabled)
            Utils.showAlert(Title, Message, null, "OK"); Log.e( Title, Message);
    }

    public abstract void onSuccess(String response);

    //!?????????????????????????????????????????????????????????????????????????????????????????
    public void onFailure(Request request, IOException e)
    {
        String Title = TAG + " -> [onFailure]";
        String Message = "IOException: ";// + e.toString() + "\n"+request.toString();

        if(Globals.DialogOnFailure_IsEnabled)
            Utils.showAlert(Title, Message, null, "OK");   Log.e( Title, Message);
    }
    //!?????????????????????????????????????????????????????????????????????????????????????????

    @Override  public void onRequestStart()    {   Utils.Dialog_InProgress_Show("En attente...");    }
    @Override  public void onRequestFinish() {    Utils.Dialog_InProgress_Dismiss();}

    @Override public void onResponse(Response response) throws IOException
    {
        requestFinish();
        if (response.isSuccessful())  requestSuccess(response);
        else                          requestFailure(response.code());
    }

    private void requestSuccess(Response response)
    {
        try {
            final String responseString = response.body().string();
            Runnable successRunnable = new Runnable() {  @Override public void run() { onSuccess(responseString);   }         };
            if (mUIHandler != null)  mUIHandler.post(successRunnable);   else   successRunnable.run();
        }
        catch (IOException e) {    e.printStackTrace();     requestFailure(-1);    }
    }

    private void requestFailure(final int statusCode)
    {
        Runnable failureRunnable = new Runnable() {  @Override public void run() { onFailure(statusCode);  }    };
        if (mUIHandler != null) {  mUIHandler.post(failureRunnable);    } else {  failureRunnable.run(); }
    }
}
