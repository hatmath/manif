package com.projet_integrateur.app.controller;

import com.projet_integrateur.Globals.Network.E_SERVER_TYPE;

import static com.projet_integrateur.Globals.Network.CURRENT_SERVER_TYPE;
import static com.projet_integrateur.Globals.Network.E_SERVER_TYPE.E_SERVER_APACHE;
import static com.projet_integrateur.Globals.Network.E_SERVER_TYPE.E_SERVER_EXPRESS;
import static com.projet_integrateur.app.model.Models.E_MODELS.E_INTEREST;
import static com.projet_integrateur.app.model.Models.E_MODELS.E_INTERESTS_MEMBER;
import static com.projet_integrateur.app.model.Models.E_MODELS.E_MANIF;
import static com.projet_integrateur.app.model.Models.E_MODELS.E_MEMBER;
import static com.projet_integrateur.app.model.Models.E_MODELS.E_MEMBERS_MANIF;
import static com.projet_integrateur.app.model.Models.E_MODELS.E_SLOGAN;

import android.util.Log;

import com.projet_integrateur.Globals;
import com.projet_integrateur.app.controller.http.HttpClient;
import com.projet_integrateur.app.controller.http.callback.InterestsByMember_Callback;
import com.projet_integrateur.app.controller.http.callback.Manif_Callback;
import com.projet_integrateur.app.controller.http.callback.Member_Callback;
import com.projet_integrateur.app.controller.http.callback.MembersByManif_Callback;
import com.projet_integrateur.app.controller.http.callback.Interest_Callback;
import com.projet_integrateur.app.controller.http.callback.Slogan_Callback;
import com.projet_integrateur.app.controller.http.internal.PersistentCookieStore;
import com.projet_integrateur.app.controller.http.internal.RequestParams;
import com.projet_integrateur.app.model.Member;
import com.projet_integrateur.app.model.Models;
import com.projet_integrateur.utils.Utils;

import java.util.UUID;

public class HttpController
{
    private static final String  TAG = "[" + HttpController.class.getSimpleName().toUpperCase() + "]";

    private static HttpController m_Instance = null;      //SINGLETON
    public static HttpController getInstance()   {     if (m_Instance == null) {  m_Instance = new HttpController();    }    return m_Instance;    }

    public Boolean          m_DebugInfo         = Globals.DEBUG_INFO;




    //!------------------------------------------------------------------------------------------------------------
    public void Request_getAll()
    {
         Utils.log(TAG, "Connecting to URL: " + Globals.Network.SERVER_URL_PREFIX);

        Request_getAllInterest();
        Request_getAllMember();
        Request_getAllSlogan();
        Request_getAllManif();
        Request_getAllMembersByManif();
        Request_getAllInterestsByMember();

    }
    //!------------------------------------------------------------------------------------------------------------
    public void Request_getAllInterest()
    {
        String RequestUrl = Globals.Network.SERVER_GETALL_URLS[E_INTEREST.ordinal()];;
        if (CURRENT_SERVER_TYPE.equals(E_SERVER_EXPRESS))
                RequestUrl =  Globals.Network.SERVER_EXPRESS_GETALL_URLS[E_INTEREST.ordinal()];

        RequestParams params = new RequestParams();    params.put("", "");
        Log.e(TAG, RequestUrl + params.toString());
        HttpClient.get(RequestUrl, params, Interest_Callback.onResponse_getAllInterest);
    }
    //!------------------------------------------------------------------------------------------------------------
    public void Request_getInterest(Integer id)
    {
        Log.i(TAG, Globals.Network.SERVER_GET_URLS[E_INTEREST.ordinal()]);
        RequestParams params = new RequestParams();   params.put("id", "id");
               HttpClient.get( Globals.Network.SERVER_GET_URLS[E_INTEREST.ordinal()]+ params.toString(),
                       params, Interest_Callback.onResponse_getInterest);
    }
    //!------------------------------------------------------------------------------------------------------------
    public void Request_getAllMember()
    {
        RequestParams params = new RequestParams(); params.put("", "");
        String REQUEST_URL = Globals.Network.SERVER_GETALL_URLS[E_MEMBER.ordinal()]+ params.toString();
        Log.i(TAG, "Request_getAllMember: " + REQUEST_URL );
        HttpClient.get( REQUEST_URL,  params,  Member_Callback.onResponse_getAllMember);
    }
    //!------------------------------------------------------------------------------------------------------------
    public void Request_getMember(String id)
    {
        RequestParams params = new RequestParams(); params.put("id", "id");
        String REQUEST_URL = Globals.Network.SERVER_GET_URLS[E_MEMBER.ordinal()]+ params.toString();
        Log.i(TAG, "Request_getMember: " + REQUEST_URL );
        HttpClient.get( REQUEST_URL,  params,  Member_Callback.onResponse_getMember);
    }
    //!------------------------------------------------------------------------------------------------------------
    public void Request_register(String thisId)
    {
        Member newMember = Models.getMember(UUID.fromString(thisId));
        if (newMember != null)
        {
            String id           = newMember.getId().toString();
            String username     = newMember.getUsername();
            String password     = newMember.getPassword();

            String salt         = newMember.getSalt();
            String description  = newMember.getDescription();
            String avatar       = newMember.getAvatar().toString();
            String mail         = newMember.getMail();
            String phone        = newMember.getPhone();
            String last_login   = newMember.getLast_login();
            String date_created = newMember.getDate_created();
            String last_update  = newMember.getLast_update();

            RequestParams params = new RequestParams();
            params.put("id", id);
            params.put("username", username);
            params.put("password", password);
            params.put("salt", salt);
            params.put("description", description);
            params.put("avatar", avatar);
            params.put("mail", mail);
            params.put("phone", phone);
            params.put("last_login", last_login);
            params.put("date_created", date_created);
            params.put("last_update", last_update);

            String REQUEST_URL = Globals.Network.SERVER_CREATE_URLS[E_MEMBER.ordinal()];
            if (CURRENT_SERVER_TYPE.equals(E_SERVER_EXPRESS))
                REQUEST_URL =  Globals.Network.SERVER_EXPRESS_CREATE_URLS[E_MEMBER.ordinal()];


            Log.i(TAG, "Request_register: " + REQUEST_URL + params.toString());
            HttpClient.post( REQUEST_URL,  params,  Member_Callback.onResponse_register);
        }
    }
    public void Request_getAllSlogan()
    {
        RequestParams params = new RequestParams(); params.put("", "");
        String REQUEST_URL = Globals.Network.SERVER_GETALL_URLS[E_SLOGAN.ordinal()]+ params.toString();
        Log.i(TAG, "Request_getAllSlogan: " + REQUEST_URL );
        HttpClient.get( REQUEST_URL,  params,  Slogan_Callback.onResponse_getAllSlogan);
    }
    //!------------------------------------------------------------------------------------------------------------
    public void Request_getSlogan(String id)
    {
        RequestParams params = new RequestParams(); params.put("id", "id");
        String REQUEST_URL = Globals.Network.SERVER_GET_URLS[E_SLOGAN.ordinal()] + params.toString();
        Log.i(TAG, "Request_getSlogan: " + REQUEST_URL);
        HttpClient.get( REQUEST_URL, params,   Slogan_Callback.onResponse_getSlogan);
    }
    //!------------------------------------------------------------------------------------------------------------
    public void Request_getAllManif()
    {
        RequestParams params = new RequestParams(); params.put("", "");
        String REQUEST_URL = Globals.Network.SERVER_GETALL_URLS[E_MANIF.ordinal()] + params.toString();
        Log.i(TAG, "Request_getAllManif: " + REQUEST_URL);
        HttpClient.get( REQUEST_URL,  params, Manif_Callback.onResponse_getAllManif);
    }

    //!------------------------------------------------------------------------------------------------------------
    public void Request_getManif(String id)
    {
        RequestParams params = new RequestParams(); params.put("id", "id");
        String REQUEST_URL = Globals.Network.SERVER_GET_URLS[E_MANIF.ordinal()] + params.toString();
        Log.i(TAG, "Request_getManif: " + REQUEST_URL);
        HttpClient.get( REQUEST_URL,  params, Manif_Callback.onResponse_getManif);
    }
    //!------------------------------------------------------------------------------------------------------------
    public void Request_getAllMembersByManif()
    {
        RequestParams params = new RequestParams(); params.put("", "");
        String REQUEST_URL = Globals.Network.SERVER_GETALL_URLS[E_MEMBERS_MANIF.ordinal()]+ params.toString();
        Log.i(TAG, "Request_getAllMembersByManif: " + REQUEST_URL );
        HttpClient.get( REQUEST_URL,  params,  MembersByManif_Callback.onResponse_getAllMembersByManif);
    }
    //!------------------------------------------------------------------------------------------------------------
    public void Request_getMembersByManif(String id)
    {
        RequestParams params = new RequestParams(); params.put("id", "id");
        String REQUEST_URL = Globals.Network.SERVER_GET_URLS[E_MEMBERS_MANIF.ordinal()]+ params.toString();
        Log.i(TAG, "Request_getMembersByManif: " + REQUEST_URL );
        HttpClient.get( REQUEST_URL,  params,  MembersByManif_Callback.onResponse_getMembersByManif);
    }
    //!------------------------------------------------------------------------------------------------------------


    //!------------------------------------------------------------------------------------------------------------
    public void  Request_getAllInterestsByMember()
    {
        RequestParams params = new RequestParams(); params.put("", "");
        String REQUEST_URL = Globals.Network.SERVER_GETALL_URLS[E_INTERESTS_MEMBER.ordinal()]+ params.toString();
        Log.i(TAG, "Request_getAllInterestsByMember: " + REQUEST_URL );
        HttpClient.get( REQUEST_URL,  params,  InterestsByMember_Callback.onResponse_getAllInterestsByMember);
    }
    //!------------------------------------------------------------------------------------------------------------
    public void Request_getInterestsByMember(String id)
    {
        RequestParams params = new RequestParams(); params.put("id", "id");
        String REQUEST_URL = Globals.Network.SERVER_GET_URLS[E_INTERESTS_MEMBER.ordinal()]+ params.toString();
        Log.i(TAG, "Request_getInterestsByMember: " + REQUEST_URL );
        HttpClient.get( REQUEST_URL,  params,  InterestsByMember_Callback.onResponse_getInterestsByMember);
    }
    //!------------------------------------------------------------------------------------------------------------
    public void setCookieHandlerEnabled()  { HttpClient.setCookieHandler(new PersistentCookieStore(Globals.CURRENT_CONTEXT));  }
    //!------------------------------------------------------------------------------------------------------------


}
