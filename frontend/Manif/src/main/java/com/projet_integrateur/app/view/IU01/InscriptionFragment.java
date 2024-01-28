package com.projet_integrateur.app.view.IU01;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.projet_integrateur.R;
import com.projet_integrateur.app.ApplicationActivity;
import com.projet_integrateur.Globals;

import com.projet_integrateur.app.MainActivity;
import com.projet_integrateur.app.SplashActivity;
import com.projet_integrateur.app.controller.AuthManager;
import com.projet_integrateur.app.controller.HttpController;
import com.projet_integrateur.app.model.Member;
import com.projet_integrateur.app.model.Models;
import com.projet_integrateur.app.view.IU02.OuvertureSessionFragment;
import  com.projet_integrateur.base.BaseDialogFragment;
import com.projet_integrateur.utils.Utils;

import androidx.appcompat.app.AlertDialog;



public class InscriptionFragment extends BaseDialogFragment implements View.OnClickListener
{
    private final String  TAG = "[" + getClass().getSimpleName().toUpperCase() + "]";


    private String m_Username = "";
    private String m_Password = "";
    private String m_ConfirmPassword = "";

    private     EditText                m_EditText_Username;
    private     EditText                m_EditText_Password;
    private     EditText                m_EditText_Confirm_Password;
    private     Button                  m_Button_Annuler;
    private     Button                  m_Button_Soumettre;

    public static InscriptionFragment Create() {   return new InscriptionFragment();    }

    @Override  protected int getLayout()   {  return R.layout.fragment_inscription;  }
    @Override  public void onAttach(Context context) {   super.onAttach(context);  }

    public AlertDialog getDialog()
    {
        m_View   =   getRootView(getLayout());
        if (m_View != null)
        {
            m_Dialog = new AlertDialog.Builder(getActivity()).setTitle("INSCRIPTION").setView(m_View).create();
            if (m_Dialog != null)
            {
                m_EditText_Username             =   getWidget(R.id.EditText_Username);
                m_EditText_Password             =   getWidget(R.id.EditText_Password);
                m_EditText_Confirm_Password     =   getWidget(R.id.EditText_Confirm_Password);

                m_Button_Annuler                =   getWidget(R.id.Button_Annuler);
                m_Button_Soumettre              =   getWidget(R.id.Button_Soumettre);

                if (m_Button_Annuler != null)       m_Button_Annuler.setOnClickListener(this);
                if (m_Button_Soumettre != null)     m_Button_Soumettre.setOnClickListener(this);
            }
        }
        Models.logMembers();
        return m_Dialog;
    }

    @Override  public void onClick(View v)
    {
        if (v.getId() == R.id.Button_Annuler)
        {
            OuvertureSessionFragment.Create().show(getActivity().getSupportFragmentManager(), TAG); close();
        }

        if (v.getId() == R.id.Button_Soumettre)
        {
            if (ValidateInput(true))
            {
                if (m_EditText_Username != null)            m_Username        = m_EditText_Username.getText().toString().trim();
                if (m_EditText_Password != null)            m_Password        = m_EditText_Password.getText().toString().trim();
                if (m_EditText_Confirm_Password != null)    m_ConfirmPassword = m_EditText_Confirm_Password.getText().toString().trim();

                if (RegisterMember(m_Username, m_Username, m_Password))
                {
                    setActivity(MainActivity.class);
                    //AuthManager.getInstance().connectMember(m_Username, m_Password);
                   // if (AuthManager.getInstance().getAuthMember() != null) setActivity(ApplicationActivity.class); close();
                 //   OuvertureSessionFragment.Create().show(getActivity().getSupportFragmentManager(), TAG); close();
                }
            }           
        }
    }

    private Boolean ValidateInput(Boolean showMessage)
    { 
        if (m_EditText_Username != null)            m_Username        = m_EditText_Username.getText().toString().trim();
        if (m_EditText_Password != null)            m_Password        = m_EditText_Password.getText().toString().trim();
        if (m_EditText_Confirm_Password != null)    m_ConfirmPassword = m_EditText_Confirm_Password.getText().toString().trim();

        String Message = "";
        if (m_Username.isEmpty())                             Message += "IDENTIFIANT EST VIDE\n";
        if (m_Password.isEmpty())                             Message += "MOT DE PASSE EST VIDE\n"; else
        if (m_Password.length() < 8)                          Message += "MOT DE PASSE DOIT CONTENIR AU MOINS 8 CARACTERES\n";

        if (m_ConfirmPassword.isEmpty())                      Message += "CONFIRMER LE MOT DE PASSE EST VIDE\n"; else


        if (m_ConfirmPassword.equals(m_Password) == false)    Message += "CONFIRMER VOTRE MOT DE PASSE";

        if (Message.isEmpty()) return true;
        else
        {
            if (showMessage)
            {
                Utils.showAlert( "INSCRIPTION", Message,null, "OK");
            }
        }
        return false;
    }

    private Boolean RegisterMember(String thisFullname, String thisUsername, String thisPassword)
    {
        Member newMember = Member.Create(thisUsername, thisPassword);

        if (newMember != null)
        {
            Utils.log( TAG, thisUsername + " EST INSCRIT");     newMember.logInfo();

            //todo !!! TO-DO !!! NEED TO POST TO SERVER -> [NEW MEMBER] !!! TO-DO !!!
            Log.e(TAG,  "!!! TO-DO !!! NEED TO POST TO SERVER -> [NEW MEMBER] name: " + newMember.getUsername()  );
            HttpController.getInstance().Request_register(newMember.getId().toString());
            return true;
        }
        return false;
    }



}
