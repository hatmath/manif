package com.projet_integrateur.app.controller.http.callback;


import android.util.Log;

import com.projet_integrateur.Globals;
import com.projet_integrateur.app.model.Interest;
import com.projet_integrateur.app.model.Models;
import com.projet_integrateur.utils.Utils;
import com.squareup.okhttp.Request;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

public class Interest_Callback
{
    public static String TAG = Interest_Callback.class.getSimpleName().toUpperCase();

    //!---------------------------------------------------------------------------------------------
    //GET ALL - HTTP RESPONSE
    public static HttpCallback onResponse_getAllInterest =  new HttpCallback()
    {

        @Override  public void onRequestStart()  {  super.onRequestStart();    }
        @Override  public void onRequestFinish() {  super.onRequestFinish(); }

        //!?????????????????????????????????????????????????????????????????????????????????????????
        @Override public void onSuccess(String response)
        {
            if (Globals.DialogOnSuccess_IsEnabled)
                Utils.showAlert("[Interests]", response, null, "OK");
            try
            {
                JSONObject thisObject = new JSONObject(response);   if (thisObject == null) return;
                JSONArray   thisArray  = thisObject.getJSONArray("result");

                for (int i = 0; i < thisArray.length(); i++)
                {
                    JSONObject currentObject = thisArray.getJSONObject(i);
                    if (currentObject != null)
                    {
                        String id           = currentObject.getString( "id");
                        String name         = currentObject.getString( "name");
                        String description  = currentObject.getString( "description");
                        String date_created = currentObject.getString( "date_created");


                        Interest thisInterest = Models.getInterest(name);
                        if (thisInterest == null)
                        {    //new entity
                            Interest newInterest = Interest.Create(id,  name, description, date_created, "");
                            Log.i(TAG,  newInterest.getName() + " CREATED");
                        }
                        else
                        {  //update data
                            Log.i(TAG, "UPDATING " + thisInterest.getName());
                            thisInterest.setName(id);
                            thisInterest.setName(name);
                            thisInterest.setDescription(description);
                            thisInterest.setDate_created(date_created);
                        }
                    }
                }
            }
            catch ( JSONException e)  {   e.printStackTrace();  Log.e(TAG, e.getMessage());  }
        };

    };
    //!---------------------------------------------------------------------------------------------

    //!?????????????????????????????????????????????????????????????????????????????????????????
    public static HttpCallback onResponse_getInterest = new HttpCallback()
    {
        @Override  public void onSuccess(String response)
        {

            if (Globals.DialogOnSuccess_IsEnabled)
                Utils.showAlert("[Interests]", response, null, "OK");

            try
            {
                JSONObject thisObject = new JSONObject(response);   if (thisObject == null) return;
                JSONArray   thisArray  = thisObject.getJSONArray("result");

                for (int i = 0; i < thisArray.length(); i++)
                {
                    JSONObject currentObject = thisArray.getJSONObject(i);
                    if (currentObject != null)
                    {
                        String id                     = currentObject.getString( "id");
                        String name                   = currentObject.getString( "name");
                        String description            = currentObject.getString( "description");
                        String date_created           = currentObject.getString( "date_created");

                        Interest     thisInterest = Models.getInterest(Integer.valueOf(id));
                        if (thisInterest != null)
                        {
                            String  LocalData = "\nLOCAL DATA (INTEREST): \n" + thisInterest.toJSON();
                            String  ServerData = "\nSERVER DATA (INTEREST): \n";
                                    ServerData += "\t{";
                                    ServerData += "\t\"id\": \""  + id.toString()  + "\", " + "\"name\": \"" + name  + "\", " + "\"description\": \"" + description  + "\"date_created\": \"" + date_created  + "\"";
                                    ServerData += "\t}";  Log.i(TAG, ServerData + LocalData);

                                    if (!thisInterest.getName().equals(name)                ||
                                        !thisInterest.getDescription().equals(description)
                                       // || !thisInterest.getDate_created().equals(date_created)
                                    )
                                    {
                                        Log.i(TAG, "UPDATING LOCALDATA BY SERVERDATA");
                                        thisInterest.setName(name);
                                        thisInterest.setDescription(description);
                                        thisInterest.setDate_created(date_created);
                                    }


                        }
                    }
                }
            }
            catch ( JSONException e)  {   e.printStackTrace();  Log.e(TAG, e.getMessage());  }

        };


    };
    //!?????????????????????????????????????????????????????????????????????????????????????????


}