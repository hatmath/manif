package com.projet_integrateur.app.view.IU04;

import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.projet_integrateur.Globals;
import com.projet_integrateur.app.controller.AuthManager;
import com.projet_integrateur.app.model.Manif;
import com.projet_integrateur.app.model.Members_by_Manif;
import com.projet_integrateur.app.model.Models;
import com.projet_integrateur.app.model.Slogan;
import  com.projet_integrateur.base.BaseFragment;

import com.projet_integrateur.R;

import com.projet_integrateur.utils.Utils;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

public class ManifestationFormFragment  extends            BaseFragment
                                        implements    View.OnClickListener,
                                                      View.OnFocusChangeListener,
                                                      View.OnKeyListener
{
    private final String  TAG = "[" + getClass().getSimpleName().toUpperCase() + "]";

    private String  m_Manif_Titre = "";
    private String  m_Manif_Description = "";
    private String  m_Manif_DateDebut = "";
    private String  m_Manif_DateFin= "";
    private String  m_Manif_HeureDebut = "";
    private String  m_Manif_HeureFin = "";
    private String  m_Manif_Ville = "";
    private String  m_Manif_Meeting = "";
    private String  m_Interet_Name = "";
    private String  m_Slogan_Titre = "";
    private String  m_Slogan_Description = "";


    private Button m_Button_BackTop;

    private EditText m_EditText_Manif_Titre;
    private EditText m_EditText_Manif_Description;

    private EditText m_EditText_Manif_DateDebut;
    private EditText m_EditText_Manif_DateFin;
    private EditText m_EditText_Manif_HeureDebut;
    private EditText m_EditText_Manif_HeureFin;
    private EditText m_EditText_Manif_Ville;;
    private EditText m_EditText_Manif_Meeting;

    private TextView m_TextView_Interet_Name;
    private Button m_Button_Interet_Modifier;

    private EditText m_EditText_Slogan_Titre;
    private EditText m_EditText_Slogan_Description;

    private Button m_Button_BackBottom;
    private Button m_Button_Enregistrer;

    private Manif m_Manif = null;


    @Override    protected int getLayout() {    return R.layout.fragment_manifestation_form;    }

    public static ManifestationFormFragment Create() {   return new ManifestationFormFragment();    }
    @Override  protected     void         onPreInit()
    {

        m_Manif = Globals.CURRENT_MANIF;

        m_Button_BackTop            = getWidget(R.id.Button_BackTop);

        m_EditText_Manif_Titre              = getWidget(R.id.EditText_Manif_Titre);
        m_EditText_Manif_Description        = getWidget(R.id.EditText_Manif_Description);

        m_EditText_Manif_DateDebut          = getWidget(R.id.EditText_Manif_DateDebut);
        m_EditText_Manif_DateFin            = getWidget(R.id.EditText_Manif_DateFin);
        m_EditText_Manif_HeureDebut         = getWidget(R.id.EditText_Manif_HeureDebut);
        m_EditText_Manif_HeureFin           = getWidget(R.id.EditText_Manif_HeureFin);
        m_EditText_Manif_Ville              = getWidget(R.id.EditText_Manif_Ville);
        m_EditText_Manif_Meeting            = getWidget(R.id.EditText_Manif_Meeting);

        m_TextView_Interet_Name             = getWidget(R.id.TextView_Interet_Name);
        m_Button_Interet_Modifier           = getWidget(R.id.Button_Interet_Modifier);

        m_EditText_Slogan_Titre             = getWidget(R.id.EditText_Slogan_Titre);
        m_EditText_Slogan_Description       = getWidget(R.id.EditText_Slogan_Description);

        m_Button_BackBottom            = getWidget(R.id.Button_BackBottom);
        m_Button_Enregistrer          = getWidget(R.id.Button_Enregistrer);

        m_EditText_Manif_DateDebut.setOnFocusChangeListener(this);
        m_EditText_Manif_DateFin.setOnFocusChangeListener(this);
        m_EditText_Manif_HeureDebut.setOnFocusChangeListener(this);
        m_EditText_Manif_HeureFin.setOnFocusChangeListener(this);

        m_EditText_Manif_DateDebut.setOnKeyListener(this);
        m_EditText_Manif_DateFin.setOnKeyListener(this);
        m_EditText_Manif_HeureDebut.setOnKeyListener(this);
        m_EditText_Manif_HeureFin.setOnKeyListener(this);

        m_Button_BackTop.setOnClickListener(this);
        m_Button_Interet_Modifier.setOnClickListener(this);
        m_Button_BackBottom.setOnClickListener(this);
        m_Button_Enregistrer.setOnClickListener(this);

        if (m_Manif != null)
        {
            m_EditText_Manif_Titre.setText(m_Manif.getName());
            m_EditText_Manif_Description.setText(m_Manif.getDescription());

            m_EditText_Manif_DateDebut.setText(m_Manif.getStart_date());
            m_EditText_Manif_DateFin.setText(m_Manif.getEnd_date());
            m_EditText_Manif_HeureDebut.setText(m_Manif.getHeureDebut());
            m_EditText_Manif_HeureFin.setText(m_Manif.getHeureFin());
            m_EditText_Manif_Ville.setText(m_Manif.getCity());
            m_EditText_Manif_Meeting.setText(m_Manif.getMeeting());

            m_TextView_Interet_Name.setText(Models.getInterests().get(m_Manif.getInterest()).getName());

            Slogan thisSlogan = Models.getSlogan(m_Manif.getSlogan());
            if (thisSlogan != null)
            {
                m_EditText_Slogan_Titre.setText(thisSlogan.getTitle());
                m_EditText_Slogan_Description.setText(thisSlogan.getSlogan());
            }

            rafresh();
        }
    }
    @Override protected      void        onInit(Bundle savedInstanceState){  }
    @Override protected     void         onPostInit()
    {



    }


    @Override    public void onClick(View v)
    {
        Globals.CURRENT_MANIF = null;

        if (v.getId() == R.id.Button_BackTop || v.getId() == R.id.Button_BackBottom)  setFragment(MesManifestationsFragment.Create());
        if (v.getId() == R.id.Button_Enregistrer)  Sauvegarder();
    }


    public void Sauvegarder()
    {
        if (ValidateInput(true))
        {
            Utils.log(TAG, "ENREGISTREMENT EN COURS...");
            if (m_Manif != null)
            {
                m_Manif.setName(m_Manif_Titre);
                m_Manif.setDescription(m_Manif_Description);
                m_Manif.setCity(m_Manif_Ville);
                m_Manif.setStart_date(m_Manif_DateDebut);
                m_Manif.setEnd_date(m_Manif_DateFin);
                m_Manif.setHeureDebut(m_Manif_HeureDebut);
                m_Manif.setHeureFin(m_Manif_HeureFin);
                m_Manif.setMeeting(m_Manif_Meeting);
                m_Manif.setInterest(Models.getInterest(m_Interet_Name).getId());
                Slogan thisSlogan = Models.getSlogan(m_Manif.getSlogan());

                if (Models.getInterest(m_Interet_Name).getId() >=0)
                    if (thisSlogan == null)
                    {
                        Slogan newSlogan = Slogan.Create(   UUID.randomUUID().toString(),
                                                            m_Slogan_Titre,
                                                            m_Slogan_Description,
                                                            m_Manif.getInterest().toString(),
                                                            Utils.updateTime_Now(),
                                                            Utils.updateTime_Now());

                       if (newSlogan != null)   m_Manif.setSlogan(newSlogan.getId());


                   }
                    else
                    {
                        thisSlogan.setTitle(m_Slogan_Titre);
                        thisSlogan.setSlogan(m_Slogan_Description);
                        thisSlogan.setInterest( m_Manif.getInterest());
                    }
                Globals.CURRENT_MANIF = m_Manif;
                setFragment(ManifestationCardFragment.Create());
            }
            else
            {
                Slogan newSlogan =  Slogan.Create(   UUID.randomUUID().toString(),
                        m_Slogan_Titre,
                        m_Slogan_Description,
                        "0",
                        Utils.updateTime_Now(),
                        Utils.updateTime_Now());
                if (newSlogan != null)
                {

                    Manif newManif =    Manif.Create(
                                        UUID.randomUUID().toString(),
                                        AuthManager.getInstance().getAuthMember().getId().toString(),
                                        m_Manif_Titre,
                                        m_Manif_Description,
                                        newSlogan.getId().toString(),
                                        m_Manif_Ville,
                                        m_Manif_Meeting,
                                        "0",
                                        m_Manif_DateDebut,
                                        m_Manif_DateFin,
                                        Utils.updateTime_Now(),
                                        Utils.updateTime_Now());
                        if (newManif != null)
                        {
                            newManif.logInfo();

                            Members_by_Manif newMembers_by_Manif =
                                    Members_by_Manif.Create(  newManif.getId().toString(),
                                    AuthManager.getInstance().getAuthMember().getId().toString(),
                                    "true", "0",
                                    Utils.updateTime_Now(),
                                    Utils.updateTime_Now());
                            if (newMembers_by_Manif != null)
                            {
                                newManif.refresh();
                                //todo !!! TO-DO !!! NEED TO POST TO SERVER DANS CETTE ORDRE -> [NEW SLOGAN], [NEW MANIF] AND [NEW MEMBER_MANIF] !!! TO-DO !!!
                                Log.e(TAG,  "!!! TO-DO !!! NEED TO POST TO SERVER -> [NEW SLOGAN]        title: " +  newSlogan.getTitle()  );
                                Log.e(TAG,  "!!! TO-DO !!! NEED TO POST TO SERVER -> [NEW MANIF]         name: " + newManif.getName() );
                                Log.e(TAG,  "!!! TO-DO !!! NEED TO POST TO SERVER -> [NEW MEMBER_MANIF]  id: " + newMembers_by_Manif.getId() );

                            }
                            Globals.CURRENT_MANIF = newManif;
                            setFragment(ManifestationCardFragment.Create());
                        }
                    } else Log.e(TAG, "Slogan erreur");
            }

        }


    }

    private void rafresh()
    {
        m_Manif_Titre               = m_EditText_Manif_Titre.getText().toString().trim();
        m_Manif_Description         = m_EditText_Manif_Description.getText().toString().trim();
        m_Manif_DateDebut           = m_EditText_Manif_DateDebut.getText().toString().trim();
        m_Manif_DateFin             = m_EditText_Manif_DateFin.getText().toString().trim();
        m_Manif_HeureDebut          = m_EditText_Manif_HeureDebut.getText().toString().trim();
        m_Manif_HeureFin            = m_EditText_Manif_HeureFin.getText().toString().trim();

        m_Manif_Ville               = m_EditText_Manif_Ville.getText().toString().trim();
        m_Manif_Meeting             = m_EditText_Manif_Meeting.getText().toString().trim();
        m_Interet_Name              = m_TextView_Interet_Name.getText().toString().trim();
        m_Slogan_Titre              = m_EditText_Slogan_Titre.getText().toString().trim();
        m_Slogan_Description        = m_EditText_Slogan_Description.getText().toString().trim();
    }

    private Boolean ValidateInput(Boolean showMessage)
    {
        rafresh();

        String Message = "";
        if (m_Manif_Titre.isEmpty())                Message += "TITRE EST VIDE\n";
        if (m_Manif_Description.isEmpty())          Message += "DESCRIPTION EST VIDE\n";
        if (m_Manif_DateDebut.isEmpty())            Message += "DATE DE DEBUT EST VIDE\n";
        if (m_Manif_DateFin.isEmpty())              Message += "DATE DE FIN EST VIDE\n";

        if (m_Manif_HeureDebut.isEmpty())           Message += "HEURE DE DEBUT EST VIDE\n";
        if (m_Manif_HeureFin.isEmpty())             Message += "HEURE DE FIN EST VIDE\n";
        if (m_Manif_Ville.isEmpty())                Message += "VILLE EST VIDE\n";
        if (m_Manif_Meeting.isEmpty())              Message += "RENDEZ-VOUS EST VIDE\n";
       // if (m_Interet_Name.isEmpty())               Message += "INTERET EST VIDE\n";
        if (m_Slogan_Titre.isEmpty())               Message += "SLOGAN TITRE EST VIDE\n";
        if (m_Slogan_Description.isEmpty())         Message += "SLOGAN DESCRIPTION EST VIDE\n";

        if (Message.isEmpty()) return true;
        else
        {
            if (showMessage)
            {
                Utils.showAlert( "ATTENTION\nNOUVELLE MANIFESTATION", Message,null, "OK");
            }
        }
        return false;
    }

    @Override public void onFocusChange(View v, boolean hasFocus)
    {


        if (hasFocus == false)
        {
           // if (v.getId() == R.id.EditText_Manif_HeureDebut)   if (!Utils.isValidTime(m_EditText_Manif_HeureDebut.getText().toString(), true))  m_EditText_Manif_HeureDebut.setText(m_Manif_HeureDebut); else
         //   if (v.getId() == R.id.EditText_Manif_HeureFin)     if (!Utils.isValidTime(m_EditText_Manif_HeureFin.getText().toString(), true))    m_EditText_Manif_HeureFin.setText(m_Manif_HeureFin);     else
         //   if (v.getId() == R.id.EditText_Manif_DateDebut)    if (!Utils.isValidDate(m_EditText_Manif_DateDebut.getText().toString(), true))   m_EditText_Manif_DateDebut.setText(m_Manif_DateDebut);   else
        //    if (v.getId() == R.id.EditText_Manif_DateFin)      if (!Utils.isValidDate(m_EditText_Manif_DateFin.getText().toString(), true))     m_EditText_Manif_DateFin.setText(m_Manif_DateFin);

        }
        else
        {
            if (v.getId() == R.id.EditText_Manif_HeureDebut)   m_EditText_Manif_HeureDebut.setText(""); else
            if (v.getId() == R.id.EditText_Manif_HeureFin)   m_EditText_Manif_HeureFin.setText(""); else
            if (v.getId() == R.id.EditText_Manif_DateDebut)   m_EditText_Manif_DateDebut.setText(""); else
            if (v.getId() == R.id.EditText_Manif_DateFin)   m_EditText_Manif_DateFin.setText("");

        }
    }

    @Override
    public boolean onKey(View v, int keyCode, KeyEvent event)
    {
        if (   v.getId() == R.id.EditText_Manif_HeureDebut)
        {   //to do , valider la saisie lors dune touche appuyer

            //0-2 = 7-10
            //7-12 = 0-5
           /* if (m_EditText_Manif_HeureDebut.getText().toString().length() == 1 )
            {
                if (keyCode < 7 || keyCode > 10)  m_EditText_Manif_HeureDebut.setText(m_Manif_HeureDebut.charAt(1));

             }
            else if (m_EditText_Manif_HeureDebut.getText().toString().length() == 3 )
            {
                if ( keyCode < 7 || keyCode >= 12)  m_EditText_Manif_HeureDebut.setText(m_EditText_Manif_HeureDebut.getText().toString() + "0");

            }
            Log.d(TAG, "keyCode: " + String.valueOf(keyCode));*/
        }

        return false;
    }
}