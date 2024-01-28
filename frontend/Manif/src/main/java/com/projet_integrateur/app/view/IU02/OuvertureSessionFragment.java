package com.projet_integrateur.app.view.IU02;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.projet_integrateur.R;
import com.projet_integrateur.app.controller.AuthManager;
import  com.projet_integrateur.base.BaseDialogFragment;
import com.projet_integrateur.app.ApplicationActivity;
import com.projet_integrateur.app.view.IU01.InscriptionFragment;
import com.projet_integrateur.utils.Utils;

import androidx.appcompat.app.AlertDialog;



public class OuvertureSessionFragment extends BaseDialogFragment implements View.OnClickListener
{


    private final String  TAG = "[" + getClass().getSimpleName().toUpperCase() + "]";

    protected   View                    m_View = null;
    protected   AlertDialog             m_AlertDialog = null;


    private String m_Username = "";
    private String m_Password = "";
    private String m_ConfirmPassword = "";

    private     EditText                m_EditText_Username;
    private     EditText                m_EditText_Password;
        private Button m_Button_Connexion;
        private Button m_Button_Inscription;

    public static OuvertureSessionFragment Create() {   return new OuvertureSessionFragment();    }

    @Override  public Dialog onCreateDialog(Bundle savedInstanceState) {   setCancelable(getCancelable());    return getDialog();   }

    @Override  protected int getLayout()   {  return R.layout.fragment_ouverture_session;  }
    protected <T extends View> T getWidget(int id) {     return (T) m_View.findViewById(id);   }


    @Override  public void onAttach(Context context) {   super.onAttach(context);  }


    public AlertDialog getDialog()
    {
        m_View = getRootView(getLayout());
        m_AlertDialog = new AlertDialog.Builder(getActivity()).setTitle("Ouverture de session").setView(m_View).create();
        m_Button_Connexion = getWidget(R.id.Button_Connexion);

        m_Button_Inscription = getWidget(R.id.Button_Inscription);

        m_EditText_Username = getWidget(R.id.EditText_Username);
        m_EditText_Password = getWidget(R.id.EditText_Password);

        m_Button_Connexion.setOnClickListener(this);
        m_Button_Inscription.setOnClickListener(this);
        return m_AlertDialog;
    }


    protected boolean getCancelable() {  return false;   }

    @Override  public void onClick(View v)
    {
        if (v.getId() == R.id.Button_Connexion)
        {
            if (ValidateInput(true))
            {

                String thisUsername = "";        String thisPassword = "";
                if (m_EditText_Username != null)    thisUsername = m_EditText_Username.getText().toString().trim();
                if (m_EditText_Password != null)    thisPassword = m_EditText_Password.getText().toString().trim();

                if ( AuthManager.getInstance().connectMember(thisUsername, thisPassword))
                {
                    m_AlertDialog.dismiss();    setActivity(ApplicationActivity.class);
                }

            }
        }
        else if (v.getId() == R.id.Button_Inscription)
        {
            m_AlertDialog.dismiss();

           InscriptionFragment.Create().show(getActivity().getSupportFragmentManager(), "InscriptionFragment");

            // setFragment(InscriptionFragment.Create());
        }

    }

    private Boolean ValidateInput(Boolean showMessage)
    {
        if (m_EditText_Username != null)            m_Username        = m_EditText_Username.getText().toString().trim();
        if (m_EditText_Password != null)            m_Password        = m_EditText_Password.getText().toString().trim();

        String Message = "";
        if (m_Username.isEmpty())                             Message += "IDENTIFIANT EST VIDE\n";
        if (m_Password.isEmpty())                             Message += "MOT DE PASSE EST VIDE\n"; else
        if (m_Password.length() < 8)                          Message += "MOT DE PASSE DOIT CONTENIR AU MOINS 8 CARACTERES\n";

        if (Message.isEmpty()) return true;
        else
        {
            if (showMessage)
            {
                Utils.showAlert( "OUVERTURE DE SESSION", Message,null, "OK");
            }

        }
        return false;
    }


}
