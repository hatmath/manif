package com.projet_integrateur.app.controller.http.callback;

import android.util.Log;

import com.projet_integrateur.Globals;
import com.projet_integrateur.app.model.Members_by_Manif;
import com.projet_integrateur.utils.Utils;
import com.squareup.okhttp.Request;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

public class InterestsByMember_Callback
{
    public static String  TAG = InterestsByMember_Callback.class.getSimpleName().toUpperCase();
    //!---------------------------------------------------------------------------------------------
    //GET ALL- HTTP RESPONSE
    public static HttpCallback onResponse_getAllInterestsByMember =  new HttpCallback()
    {
        //!?????????????????????????????????????????????????????????????????????????????????????????
        @Override  public void onRequestStart()  {  super.onRequestStart();  }
        @Override  public void onRequestFinish() {  super.onRequestFinish(); }
        //!?????????????????????????????????????????????????????????????????????????????????????????
        @Override public void onSuccess(String response)
        {
            if (Globals.DialogOnSuccess_IsEnabled)
                Utils.showAlert("[Interests_by_Member]", response, null, "OK");
            try
            {
                JSONObject thisObject = new JSONObject(response);  if (thisObject == null) return;
                JSONArray thisArray  = thisObject.getJSONArray("result");

                for (int i = 0; i < thisArray.length(); i++)
                {
                    JSONObject currentObject = thisArray.getJSONObject(i);
                    if (currentObject != null)
                    {
                        String id = currentObject.getString(             "id");
                        String manif = currentObject.getString(             "manif");
                        String member = currentObject.getString(            "member");
                        String is_present = currentObject.getString(        "is_present");
                        String rating = currentObject.getString(            "rating");
                        String date_created = currentObject.getString(      "date_created");
                        String last_update = currentObject.getString(       "last_update");

                        Members_by_Manif.Create( manif, member, is_present, rating, date_created, last_update);

                    }

                }
            }
            catch ( JSONException e)     {  e.printStackTrace();  Log.e(TAG, e.getMessage());          }
        };
    };
    //!---------------------------------------------------------------------------------------------
    //GET - HTTP RESPONSE
    public static HttpCallback onResponse_getInterestsByMember = new HttpCallback()
    {

        //!?????????????????????????????????????????????????????????????????????????????????????????
        @Override  public void onSuccess(String response)
        {
            if (Globals.DialogOnSuccess_IsEnabled)
                Utils.showAlert("[Interests_by_Member]", response, null, "OK");
            try
            {
                JSONObject thisObject = new JSONObject(response);   if (thisObject == null) return;
                JSONArray   thisArray  = thisObject.getJSONArray("result");

                for (int i = 0; i < thisArray.length(); i++)
                {
                    JSONObject currentObject = thisArray.getJSONObject(i);
                  /*  if (currentObject != null)
                    {

                        String id                     = currentObject.getString( "id");
                        String name                   = currentObject.getString( "name");
                        String description            = currentObject.getString( "description");
                        String date_created           = currentObject.getString( "date_created");

                        Interest     thisInterest = Models.getInterest(name);
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
                    }*/
                }
            }
            catch ( JSONException e)  {   e.printStackTrace();  Log.e(TAG, e.getMessage());  }
        };
        //!?????????????????????????????????????????????????????????????????????????????????????????

    };
    //!---------------------------------------------------------------------------------------------


}