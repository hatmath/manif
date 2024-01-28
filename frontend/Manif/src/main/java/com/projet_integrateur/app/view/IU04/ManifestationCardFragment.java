package com.projet_integrateur.app.view.IU04;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.projet_integrateur.Globals;
import com.projet_integrateur.app.controller.AuthManager;
import com.projet_integrateur.app.model.Manif;
import com.projet_integrateur.app.model.Member;
import com.projet_integrateur.app.model.Members_by_Manif;
import com.projet_integrateur.app.model.Models;
import com.projet_integrateur.app.model.Slogan;
import com.projet_integrateur.app.view.IU05.MembersAdapter;
import  com.projet_integrateur.base.BaseFragment;

import com.projet_integrateur.R;

import java.util.ArrayList;
import java.util.List;

public class ManifestationCardFragment extends BaseFragment   implements    View.OnClickListener
{
    private final String  TAG = "[" + getClass().getSimpleName().toUpperCase() + "]";
    private Button      m_Button_Modifier;
    private Button      m_Button_Back;
    private TextView m_TextView_Name;
    private TextView m_TextView_Description;
    private TextView m_TextView_City;
    private TextView m_TextView_Meeting;

    private TextView m_TextView_Start_date;
    private TextView m_TextView_End_Date;
    private TextView m_TextView_Interet;
    private TextView m_TextView_Slogan_Title;
    private TextView m_TextView_Slogan_Description;
    private RecyclerView m_RecycleView_Members;
    private Button          m_Button_Suivre;

    private Manif           m_Manif = null;
    private MembersAdapter  m_MembersAdapter;

    @Override    protected int getLayout() {    return R.layout.fragment_manifestation_card;    }

    public static ManifestationCardFragment Create() {   return new ManifestationCardFragment();    }
    @Override  protected     void         onPreInit()
    {

        m_Manif = Globals.CURRENT_MANIF;
        if (m_Manif == null) setFragment(MesManifestationsFragment.Create());
        else
        {


            m_TextView_Name                 = getWidget(R.id.TextView_Name);
            m_TextView_Description          = getWidget(R.id.TextView_Description);
            m_TextView_City                 = getWidget(R.id.TextView_City);
            m_TextView_Meeting              = getWidget(R.id.TextView_Meeting);

            m_TextView_Start_date           = getWidget(R.id.TextView_Start_date);
            m_TextView_End_Date             = getWidget(R.id.TextView_End_Date);
            m_TextView_Interet              = getWidget(R.id.TextView_Interet);
            m_TextView_Slogan_Title         = getWidget(R.id.TextView_Slogan_Title);
            m_TextView_Slogan_Description   = getWidget(R.id.TextView_Slogan_Description);
            m_Button_Suivre                 = getWidget(R.id.Button_Suivre);


            m_TextView_Name.setText(m_Manif.getName());
            m_TextView_Description.setText(m_Manif.getDescription());

            m_TextView_City.setText(m_Manif.getCity());
            m_TextView_Meeting.setText(m_Manif.getMeeting());

            m_TextView_Start_date.setText(m_Manif.getStart_date());
            m_TextView_End_Date.setText(m_Manif.getEnd_date());

            m_TextView_Interet.setText(Models.getInterests().get(m_Manif.getInterest()).getName());
            Slogan thisSlogan = Models.getSlogan(m_Manif.getSlogan());
            if (thisSlogan != null)
            {
                m_TextView_Slogan_Title.setText(thisSlogan.getTitle());
                m_TextView_Slogan_Description.setText(thisSlogan.getSlogan());
            }
            List<Member> MembersList = Models.getMembers_From_Manif(m_Manif.getId());
            List<String> AdapterList = new ArrayList<>();
            for (int i = 0; i < MembersList.size(); i++)
                AdapterList.add(MembersList.get(i).getUsername());
            m_MembersAdapter = new MembersAdapter(AdapterList);

            m_RecycleView_Members = getWidget(R.id.RecyclerView_Members);
            m_RecycleView_Members.setLayoutManager(new LinearLayoutManager(Globals.CURRENT_CONTEXT));
            m_RecycleView_Members.setAdapter(m_MembersAdapter);


            m_Button_Modifier = getWidget(R.id.Button_Modifier);
            m_Button_Modifier.setOnClickListener(this);





            m_Button_Back = getWidget(R.id.Button_Back);
            m_Button_Back.setOnClickListener(this);

            m_Button_Suivre = getWidget(R.id.Button_Suivre);
            m_Button_Suivre.setTag(m_Manif.getId());
            m_Button_Suivre.setOnClickListener(this);


            refresh();
        }
    }
    @Override protected      void        onInit(Bundle savedInstanceState){  }
    @Override protected     void         onPostInit()   {   }

    public void refresh()
    {

        if (m_Manif.getOwner().equals(AuthManager.getInstance().getAuthMember().getId()))
        {
            m_Button_Modifier.setVisibility(View.VISIBLE);
            m_Button_Suivre.setText("RETIRER CETTE MANIFESTATION");
        }

        else
        {
            m_Button_Modifier.setVisibility(View.GONE);
            m_Button_Suivre.setText("NE PLUS SUIVRE CETTE MANIFESTATION");
        }

    }

    @Override    public void onClick(View v)
    {
        if (v.getId() == R.id.Button_Back) { Globals.CURRENT_MANIF = null; setFragment(MesManifestationsFragment.Create()); } else
            if (v.getId() == R.id.Button_Modifier) {  setFragment(ManifestationFormFragment.Create()); } else
            if (v.getId() == R.id.Button_Suivre)     NePlusSuivre();
    }

    public void NePlusSuivre()
    {
        if (m_Manif != null)
        {
            Member AuthMember = AuthManager.getInstance().getAuthMember();
            if  (AuthMember != null)
            {
                List<Members_by_Manif> thisMembersList= Models.members_by_Manifs;

                for (int i=0;i < thisMembersList.size(); i++)
                {
                    Member currentMember = Models.getMember(thisMembersList.get(i).getMember());
                    if (currentMember != null)
                    {
                        if(currentMember.equals(AuthMember))
                        {
                            thisMembersList.remove(currentMember);

                        }
                    }
                }

                refresh();
                }
        }

    }


}