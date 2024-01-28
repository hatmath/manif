package com.projet_integrateur.app.controller.http.callback;

import android.util.Log;

import com.projet_integrateur.Globals;
import com.projet_integrateur.app.model.Manif;
import com.projet_integrateur.app.model.Models;
import com.projet_integrateur.utils.Utils;
import com.squareup.okhttp.Request;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.UUID;


public class Manif_Callback
{
    public static String TAG = Manif_Callback.class.getSimpleName().toUpperCase();

    //!---------------------------------------------------------------------------------------------
    //GET ALL - HTTP RESPONSE
    public static HttpCallback onResponse_getAllManif =  new HttpCallback()
    {
        //!?????????????????????????????????????????????????????????????????????????????????????????
        @Override  public void onRequestStart()  {  super.onRequestStart();  }
        @Override  public void onRequestFinish() {  super.onRequestFinish(); }
        //!?????????????????????????????????????????????????????????????????????????????????????????
        @Override public void onSuccess(String response)
        {
            if (Globals.DialogOnSuccess_IsEnabled)
                Utils.showAlert("[Manif]", response, null, "OK");

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
    public static HttpCallback onResponse_getManif = new HttpCallback() {

        //!?????????????????????????????????????????????????????????????????????????????????????????
        @Override   public void onSuccess(String response)
        {
            if (Globals.DialogOnSuccess_IsEnabled)
                Utils.showAlert("[Manif]", response, null, "OK");

            try
            {
                JSONObject thisObject = new JSONObject(response);     if (thisObject == null) return;
                JSONArray thisArray = thisObject.getJSONArray("result");

                for (int i = 0; i < thisArray.length(); i++)
                {
                    JSONObject currentObject = thisArray.getJSONObject(i);
                    updateData(currentObject);
                }
            } catch (JSONException e) {      e.printStackTrace();      Log.e(TAG, e.getMessage());       }
        }

        ;
        //!?????????????????????????????????????????????????????????????????????????????????????????
    };
        public static  void updateData(JSONObject currentObject) throws JSONException
        {
            if (currentObject != null)
            {
                String id = currentObject.getString("id");
                String owner = currentObject.getString("owner");
                String name = currentObject.getString("name");
                String description = currentObject.getString("description");
                String slogan = currentObject.getString("slogan");
                String city = currentObject.getString("city");
                String meeting = currentObject.getString("meeting");
                String interest = currentObject.getString("interest");
                String start_date = currentObject.getString("start_date");
                String end_date = currentObject.getString("end_date");
                String date_created = currentObject.getString("date_created");
                String last_update = currentObject.getString("last_update");


                Manif thisManif = Models.getManif(UUID.fromString(id));
                if (thisManif == null)
                {    //new entity
                    Manif newManif = Manif.Create(
                            id,   owner,   name,  description, slogan, city,  meeting,
                            interest,  start_date,  end_date,  date_created,  last_update );

                    Log.i(TAG,  "CREATED CLIENT MANIF -> " + newManif.getName());

                }
                else
                {  //update data
                    LocalDateTime Server_last_update =  LocalDateTime.parse(last_update);
                    LocalDateTime current_last_update = LocalDateTime.parse(thisManif.getLast_update());

                    if (current_last_update.isBefore(Server_last_update))
                    {
                        Log.i(TAG, "UPDATING CLIENT MANIF" + thisManif.getName() + " -> Server last_updated  est plus recent ");
                        thisManif.setId(UUID.fromString(id));
                        thisManif.setOwner(UUID.fromString(owner));
                        thisManif.setName(name);
                        thisManif.setDescription(description);
                        thisManif.setSlogan(UUID.fromString(slogan));
                        thisManif.setCity(city);
                        thisManif.setMeeting(meeting);
                        thisManif.setInterest(Integer.valueOf(interest));
                        thisManif.setStart_date(start_date);
                        thisManif.setEnd_date(end_date);
                        thisManif.setDate_created(date_created);
                        thisManif.setLast_update(last_update);
                    }
                    else
                    if (current_last_update.isAfter(Server_last_update))
                        Log.e(TAG,  "!!! TO-DO !!! UPDATING SERVER MANIF ->" + thisManif.getName() + " -> Current last_updated " + thisManif.getLast_update() +" est plus recent que "+ last_update);
                    else    Log.i(TAG, "Current last_updated = Server_last_update ->" + thisManif.getName());

                }


            }
        }

    //!---------------------------------------------------------------------------------------------


}