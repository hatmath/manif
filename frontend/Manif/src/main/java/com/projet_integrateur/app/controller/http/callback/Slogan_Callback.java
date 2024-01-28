package com.projet_integrateur.app.controller.http.callback;

import android.util.Log;

import com.projet_integrateur.Globals;
import com.projet_integrateur.app.model.Models;
import com.projet_integrateur.app.model.Slogan;
import com.projet_integrateur.utils.Utils;
import com.squareup.okhttp.Request;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.UUID;


public class Slogan_Callback
{
    public static String TAG = Slogan_Callback.class.getSimpleName().toUpperCase();

    //!---------------------------------------------------------------------------------------------
    //GET ALL - HTTP RESPONSE
    public static HttpCallback onResponse_getAllSlogan =  new HttpCallback()
    {
        //!?????????????????????????????????????????????????????????????????????????????????????????
        @Override  public void onRequestStart()  {  super.onRequestStart();  }
        @Override  public void onRequestFinish() {  super.onRequestFinish(); }
        //!?????????????????????????????????????????????????????????????????????????????????????????
        @Override public void onSuccess(String response)
        {
            if (Globals.DialogOnSuccess_IsEnabled)
                Utils.showAlert("[Slogan]", response, null, "OK");

            try
            {
                JSONObject thisObject = new JSONObject(response);  if (thisObject == null) return;
                JSONArray thisArray  = thisObject.getJSONArray("result");

                for (int i = 0; i < thisArray.length(); i++)
                {
                    JSONObject currentObject = thisArray.getJSONObject(i);
                    if (currentObject != null)  updateData(currentObject);
                }
            }
            catch ( JSONException e)     {  e.printStackTrace();  Log.e(TAG, e.getMessage());          }
        };
    };
    //!---------------------------------------------------------------------------------------------
    //GET - HTTP RESPONSE
    public static HttpCallback onResponse_getSlogan = new HttpCallback()
    {
        //!?????????????????????????????????????????????????????????????????????????????????????????
        @Override  public void onSuccess(String response)
        {
            if (Globals.DialogOnSuccess_IsEnabled)
                Utils.showAlert("[Slogan]", response, null, "OK");

            try
            {
                JSONObject thisObject = new JSONObject(response);   if (thisObject == null) return;
                JSONArray   thisArray  = thisObject.getJSONArray("result");

                for (int i = 0; i < thisArray.length(); i++)
                {
                    JSONObject currentObject = thisArray.getJSONObject(i);
                    if (currentObject != null)  updateData(currentObject);
                }
            }
            catch ( JSONException e)  {   e.printStackTrace();  Log.e(TAG, e.getMessage());  }
        };
        //!?????????????????????????????????????????????????????????????????????????????????????????

    };
    //!---------------------------------------------------------------------------------------------
    public static  void updateData(JSONObject currentObject) throws JSONException
    {
        if (currentObject != null)
        {
            String id = currentObject.getString("id");
            String title = currentObject.getString("title");
            String slogan = currentObject.getString("slogan");
            String interest = currentObject.getString("interest");
            String date_created = currentObject.getString("date_created");
            String last_update = currentObject.getString("last_update");

            Slogan thisSlogan = Models.getSlogan(UUID.fromString(id));
            if (thisSlogan == null)
            {    //new entity
                Slogan newSlogan =   Slogan.Create(
                        id,      title,     slogan,      interest,   date_created,    last_update );

                Log.i(TAG,  "CREATED CLIENT SLOGAN -> " + newSlogan.getTitle());
            }
            else
            {  //update data
                LocalDateTime Server_last_update =  LocalDateTime.parse(last_update);
                LocalDateTime current_last_update = LocalDateTime.parse(thisSlogan.getLast_update());

                if (current_last_update.isBefore(Server_last_update))
                {

                    Log.i(TAG, "UPDATING CLIENT SLOGAN" + thisSlogan.getTitle() + " -> Server last_updated  est plus recent ");
                    thisSlogan.setId(UUID.fromString(id));
                    thisSlogan.setTitle(title);
                    thisSlogan.setSlogan(slogan);
                    thisSlogan.setInterest(Integer.valueOf(interest));
                    thisSlogan.setDate_created(date_created);
                    thisSlogan.setLast_update(last_update);
                }
                else
                if (current_last_update.isAfter(Server_last_update))
                        Log.e(TAG,  "!!! TO-DO !!! UPDATING SERVER SLOGAN ->" + thisSlogan.getTitle() + " -> Current last_updated " + thisSlogan.getLast_update() +" est plus recent que "+ last_update);
                else    Log.i(TAG, "Current last_updated = Server_last_update ->" + thisSlogan.getTitle());

            }


        }
    }


}