package com.projet_integrateur.app.controller.http.callback;

import android.util.Log;

import com.projet_integrateur.Globals;
import com.projet_integrateur.app.model.Members_by_Manif;
import com.projet_integrateur.app.model.Models;
import com.projet_integrateur.utils.Utils;
import com.squareup.okhttp.Request;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.UUID;

public class MembersByManif_Callback
{
    public static String  TAG = MembersByManif_Callback.class.getSimpleName().toUpperCase();
    //!---------------------------------------------------------------------------------------------
    //GET ALL- HTTP RESPONSE
    public static HttpCallback onResponse_getAllMembersByManif =  new HttpCallback()
    {
        //!?????????????????????????????????????????????????????????????????????????????????????????
        @Override  public void onRequestStart()  {  super.onRequestStart();  }
        @Override  public void onRequestFinish() {  super.onRequestFinish(); }
        //!?????????????????????????????????????????????????????????????????????????????????????????
        @Override public void onSuccess(String response)
        {
            if (Globals.DialogOnSuccess_IsEnabled)
                Utils.showAlert("[Members_By_Manif]", response, null, "OK");

            try
            {
                JSONObject thisObject = new JSONObject(response);  if (thisObject == null) return;
                JSONArray thisArray  = thisObject.getJSONArray("result");

                for (int i = 0; i < thisArray.length(); i++)
                {
                    JSONObject currentObject = thisArray.getJSONObject(i);
                    updateData(currentObject);

                }
            }
            catch ( JSONException e)     {  e.printStackTrace();  Log.e(TAG, e.getMessage());          }
        };
    };
    //!---------------------------------------------------------------------------------------------
    //GET - HTTP RESPONSE
    public static HttpCallback onResponse_getMembersByManif = new HttpCallback()
    {

        //!?????????????????????????????????????????????????????????????????????????????????????????
        @Override  public void onSuccess(String response)
        {
            if (Globals.DialogOnSuccess_IsEnabled)
                Utils.showAlert("[Members_By_Manif]", response, null, "OK");

            try
            {
                JSONObject thisObject = new JSONObject(response);   if (thisObject == null) return;
                JSONArray   thisArray  = thisObject.getJSONArray("result");

                for (int i = 0; i < thisArray.length(); i++)
                {
                    JSONObject currentObject = thisArray.getJSONObject(i);
                    updateData(currentObject);
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
            String manif = currentObject.getString("manif");
            String member = currentObject.getString("member");
            String is_present = currentObject.getString("is_present");
            String rating = currentObject.getString("rating");
            String date_created = currentObject.getString("date_created");
            String last_update = currentObject.getString("last_update");

            Members_by_Manif thisMembers_by_Manif = Models.getMembers_by_Manif(Integer.valueOf(id));

            if (thisMembers_by_Manif == null)
            {    //new entity
                Members_by_Manif newMembers_by_Manif =  Members_by_Manif.Create(
                        id,  manif,  member,  is_present, rating,  date_created,   last_update );

                Log.i(TAG,  "CREATED CLIENT MEMBERS_BY_MANIF -> member: " + newMembers_by_Manif.getMember() +
                                                                   ", manif: " + newMembers_by_Manif.getManif());
            }
            else
            {  //update data
                LocalDateTime Server_last_update =  LocalDateTime.parse(last_update);
                LocalDateTime current_last_update = LocalDateTime.parse(thisMembers_by_Manif.getLast_update());

                if (current_last_update.isBefore(Server_last_update))
                {
                    Log.i(TAG, "UPDATING CLIENT MEMBERS_BY_MANIF -> member: " + thisMembers_by_Manif.getMember()+
                                                                      ", manif: "  + thisMembers_by_Manif.getManif() + " -> Server last_updated  est plus recent ");
                    thisMembers_by_Manif.setId(Integer.valueOf(id));
                    thisMembers_by_Manif.setManif(UUID.fromString(manif));
                    thisMembers_by_Manif.setMember(UUID.fromString(member));
                    thisMembers_by_Manif.setPresent(Boolean.valueOf(is_present));
                    thisMembers_by_Manif.setRating(Integer.valueOf(rating));
                    thisMembers_by_Manif.setDate_created(date_created);
                    thisMembers_by_Manif.setLast_update(last_update);
                }
                else
                if (current_last_update.isAfter(Server_last_update))
                    Log.e(TAG,  "!!! TO-DO !!! UPDATING SERVER MEMBERS_BY_MANIF -> id:" + thisMembers_by_Manif.getId() + " -> Current last_updated " + thisMembers_by_Manif.getLast_update() +" est plus recent que "+ last_update);
                else    Log.i(TAG, "Current last_updated = Server_last_update ->" + thisMembers_by_Manif.getId());

            }


        }
    }

}