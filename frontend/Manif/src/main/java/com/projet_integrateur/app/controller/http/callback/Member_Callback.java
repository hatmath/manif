package com.projet_integrateur.app.controller.http.callback;

import android.util.Log;

import com.projet_integrateur.Globals;
import com.projet_integrateur.app.ApplicationActivity;
import com.projet_integrateur.app.controller.AuthManager;
import com.projet_integrateur.app.model.Member;
import com.projet_integrateur.app.model.Models;
import com.projet_integrateur.utils.Utils;
import com.squareup.okhttp.Request;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.UUID;

public class Member_Callback
{
    public static String  TAG = Member_Callback.class.getSimpleName().toUpperCase();
    public static HttpCallback onResponse_register =  new HttpCallback()
    {
        //!?????????????????????????????????????????????????????????????????????????????????????????
        @Override  public void onRequestStart()  {  super.onRequestStart();  }
        @Override  public void onRequestFinish() {  super.onRequestFinish(); }
        //!?????????????????????????????????????????????????????????????????????????????????????????
        @Override public void onSuccess(String response)
        {
            Log.e(TAG, "[onResponse_register.onSuccess] response: "+ response);
            if (Globals.DialogOnSuccess_IsEnabled)
                Utils.showAlert("[onResponse_register.onSuccess]", response, null, "OK");

            response = response.trim();

            if (response.equals("onSuccess"))
            {
                    Log.i(TAG, "Membre enregistrer dans la base de données");
            }
            else
            {
                Utils.log(TAG, "Erreur de données");
                 Member thisMember =   Models.getMember(UUID.fromString(response));
               if ( thisMember != null) Models.getMembers().remove(Models.getMembers().indexOf(thisMember));
            }
          /*  try
            {
                JSONObject thisObject = new JSONObject(response);   if (thisObject == null) return;
                JSONArray thisArray  = thisObject.getJSONArray("result");

                for (int i = 0; i < thisArray.length(); i++)
                {
                    JSONObject currentObject = thisArray.getJSONObject(i);

                    updateData(currentObject);
                }
            }
            catch ( JSONException e)  {   e.printStackTrace();  Log.e(TAG, e.getMessage());  }*/
        }
    };
    public static HttpCallback onResponse_getAllMember =  new HttpCallback()
    {
        //!?????????????????????????????????????????????????????????????????????????????????????????
        @Override  public void onRequestStart()  {  super.onRequestStart();  }
        @Override  public void onRequestFinish() {  super.onRequestFinish(); }
        //!?????????????????????????????????????????????????????????????????????????????????????????
        public void onFailure(Request request, IOException e)
        {
          super.onFailure(request, e);

        }
        @Override public void onSuccess(String response)
        {
            if (Globals.DialogOnSuccess_IsEnabled)
                Utils.showAlert("[Members]", response, null, "OK");

            try
            {
                JSONObject thisObject = new JSONObject(response);   if (thisObject == null) return;
                JSONArray thisArray  = thisObject.getJSONArray("result");

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
    //GET - HTTP RESPONSE
    public static HttpCallback onResponse_getMember = new HttpCallback()
    {
        //!?????????????????????????????????????????????????????????????????????????????????????????
        @Override  public void onSuccess(String response)
        {
            if (Globals.DialogOnSuccess_IsEnabled)
                Utils.showAlert("[Members]", response, null, "OK");

            try
            {
                JSONObject thisObject = new JSONObject(response);   if (thisObject == null) return;
                JSONArray   thisArray  = thisObject.getJSONArray("result");

                for (int i = 0; i < thisArray.length(); i++)
                {
                    JSONObject currentObject = thisArray.getJSONObject(i);

                    Member_Callback.updateData(currentObject);
                }
            } catch (JSONException ex) {  throw new RuntimeException(ex);       }

        };
    };
        //!?????????????????????????????????????????????????????????????????????????????????????????
        public static void updateData(JSONObject currentObject) throws JSONException
        {
            if (currentObject != null) {
                String id = currentObject.getString("id");
                String username = currentObject.getString("username");
                String password = currentObject.getString("password");
                String salt = currentObject.getString("salt");
                String description = currentObject.getString("description");
                String avatar = currentObject.getString("avatar");
                String mail = currentObject.getString("mail");
                String phone = currentObject.getString("phone");
                String date_created = currentObject.getString("date_created");
                String last_update = currentObject.getString("last_update");
                String last_login = currentObject.getString("last_login");

                Member thisMember = Models.getMember(username);
                if (thisMember == null) {    //new entity
                    Member newMember = Member.Create(id,
                            username, password, salt, description, avatar,
                            mail, phone, last_login, date_created, last_update);

                    Log.i(TAG,  "CREATED CLIENT MEMBER -> " + newMember.getUsername());
                } else
                {  //update data
                    LocalDateTime Server_last_update =  LocalDateTime.parse(last_update);
                    LocalDateTime current_last_update = LocalDateTime.parse(thisMember.getLast_update());

                    if (current_last_update.isBefore(Server_last_update))
                    {
                        Log.i(TAG, "UPDATING CLIENT MEMBER" + thisMember.getUsername() + " -> Server last_updated  est plus recent ");

                        thisMember.setId(UUID.fromString(id));
                        thisMember.setUsername(username);
                        thisMember.setPassword(password);
                        thisMember.setSalt(salt);
                        thisMember.setDescription(description);
                        thisMember.setAvatar(Integer.valueOf(avatar));
                        thisMember.setMail(mail);
                        thisMember.setPhone(phone);
                        thisMember.setMail(mail);
                        thisMember.setLast_update(last_update);
                        thisMember.setLast_login(last_login);
                    }
                    else
                    if (current_last_update.isAfter(Server_last_update))
                        Log.e(TAG,  "!!! TO-DO !!! UPDATING SERVER MEMBER ->" + thisMember.getUsername() + " -> Current last_updated " + thisMember.getLast_update() +" est plus recent que "+ last_update);
                    else    Log.i(TAG, "Current last_updated = Server_last_update ->" + thisMember.getUsername());

                }


            }
        }

    //!---------------------------------------------------------------------------------------------


}
