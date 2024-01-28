package com.projet_integrateur.app.controller;


import static android.app.PendingIntent.getActivity;

import android.util.Log;

import com.projet_integrateur.app.model.Models;
import com.projet_integrateur.app.model.Member;
import com.projet_integrateur.utils.Utils;

public class AuthManager
{
    private static final String  TAG = "[" + AuthManager.class.getSimpleName().toUpperCase() + "]";

    private Member m_AuthMember = null;

    private static AuthManager m_Instance = null;      //SINGLETON
    public static AuthManager getInstance()   {     if (m_Instance == null) {  m_Instance = new AuthManager();    }    return m_Instance;    }

    // CONSTRUCTOR
    private AuthManager()   {    reset();   }

    public Member getAuthMember( )    {      return m_AuthMember;    }
    private void setAuthMember(Member thisMember)
    {
        m_AuthMember = thisMember;
        /* m_AuthMember.last_login = (Timestamp) Timestamp.from(Instant.now());   */;
    }

    // ?-------------------------------------------------------------------------------------------------------------------------------------------
    public void reset() { m_AuthMember = null; }

    public boolean connectMember(String thisUsername, String thisPassword)
    {
        Member thisMember = Models.getMember(thisUsername);
        if (thisMember == null )
        {
            Log.e(TAG,  "COMPTE INTROUVABLE");
            Utils.log(TAG ,  "COMPTE INTROUVABLE");
        }
        else
        {
            if (thisMember.getPassword().equals(thisPassword) )
            {
                this.setAuthMember(thisMember);
                Utils.log(TAG , "CONNEXION REUSSI");
                return true;
            }
            else     Utils.log(TAG ,"MOT DE PASSE INCORRECT");

        }
      return false;
    }


}
