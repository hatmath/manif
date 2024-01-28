package com.projet_integrateur.app.view.IU05;

import android.annotation.SuppressLint;
import android.view.View;
import android.widget.Button;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.projet_integrateur.R;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.projet_integrateur.Globals;
import com.projet_integrateur.app.controller.AuthManager;
import com.projet_integrateur.app.model.Manif;
import com.projet_integrateur.app.model.Member;
import com.projet_integrateur.app.model.Members_by_Manif;
import com.projet_integrateur.app.model.Models;
import com.projet_integrateur.app.model.Slogan;
import com.projet_integrateur.app.view.IU04.MesManifestationsFragment;
import  com.projet_integrateur.base.BaseRVAdapter;
import  com.projet_integrateur.base.BaseViewHolder;
import com.projet_integrateur.utils.Utils;


public class ConsulterManifestationAdapter extends BaseRVAdapter<String> implements View.OnClickListener
{
    private final String  TAG = "[" + getClass().getSimpleName().toUpperCase() + "]";

    private Button m_Button_Suivre;
    private MembersAdapter m_MembersAdapter;
    private RecyclerView m_RecycleView_Members;

    public ConsulterManifestationAdapter(List<String> Items) {   super(Items);    }

    @Override  protected int getLayout() {   return R.layout.item_manifestation_card;   }

    @Override   protected void onBind(BaseViewHolder holder, int position, String Item)
    {

        Manif thisManif  = Models.getManifs().get(position);
        if (thisManif != null)
        {

            holder.getTextView(R.id.TextView_Name).setText(thisManif.getName());
            holder.getTextView(R.id.TextView_Description).setText(thisManif.getDescription());
            holder.getTextView(R.id.TextView_City).setText(thisManif.getCity());
            holder.getTextView(R.id.TextView_Meeting).setText(thisManif.getMeeting());
            holder.getTextView(R.id.TextView_Start_date).setText(thisManif.getStart_date());
            holder.getTextView(R.id.TextView_End_Date).setText(thisManif.getEnd_date());

            holder.getTextView(R.id.TextView_Interet).setText( Models.getInterests().get(thisManif.getInterest()).getName());

            Slogan thisSlogan = Models.getSlogan(thisManif.getSlogan());
            if (thisSlogan != null)
            {
                thisSlogan.setInterest(thisManif.getInterest());
                holder.getTextView(R.id.TextView_Slogan_Title).setText(thisSlogan.getTitle());
                holder.getTextView(R.id.TextView_Slogan_Description).setText(thisSlogan.getSlogan());
            }
            Member MemberOwwer = Models.getMember(thisManif.getOwner());
            List<Member> MembersList = Models.getMembers_From_Manif(UUID.fromString(Item));
            List<String> AdapterList = new ArrayList<>();
            for (int i = 0; i < MembersList.size(); i++)
                AdapterList.add(MembersList.get(i).getUsername());

            m_MembersAdapter = new MembersAdapter(AdapterList);

            m_RecycleView_Members = holder.getView(R.id.RecyclerView_Members);
            m_RecycleView_Members.setLayoutManager(new LinearLayoutManager(Globals.CURRENT_CONTEXT));
            m_RecycleView_Members.setAdapter(m_MembersAdapter);

            m_Button_Suivre = holder.getButton(R.id.Button_Suivre);
            m_Button_Suivre.setTag(Item);
            m_Button_Suivre.setOnClickListener(this);

            Member AuthMember = AuthManager.getInstance().getAuthMember();
            if (thisManif.getOwner().equals(AuthMember.getId()))
            {
                m_Button_Suivre.setText("RETIRER CETTE MANIFESTATION");
            }
            else
            {
                m_Button_Suivre.setText("SUIVRE CETTE MANIFESTATION");
                for (int i =0; i < MembersList.size(); i++)
                {
                    if (MembersList.get(i).equals(AuthMember))
                        m_Button_Suivre.setText("NE PLUS SUIVRE CETTE MANIFESTATION");
                }
            }





        }

    }


    @Override    public void onClick(View v)
    {
        if (v == null) return;
        if (v.getId() == R.id.Button_Suivre)
        {
            Suivre(v, UUID.fromString(v.getTag().toString()));
        }


    }


    @SuppressLint("SuspiciousIndentation")
    public void Suivre(View v, UUID thisUUID)
    {
        if (thisUUID == null) return ;
        Manif thisManif = Models.getManif(thisUUID);
        if (thisManif != null)
        {
            List<Member> MembersList = Models.getMembers_From_Manif(thisManif.getId());
            List<String> AdapterList = new ArrayList<>();
            for (int i = 0; i < MembersList.size(); i++)
            {
                if (MembersList.get(i).getUsername().equals(AuthManager.getInstance().getAuthMember().getUsername()) == false)
                {
                    AdapterList.add(MembersList.get(i).getUsername());

                }
                else
                {

                    Utils.showAlert("Suivre " + thisManif.getName() , "Vous etes deja inscrit" , null, "OK");
                    return;
                }
            }


            if (Members_by_Manif.Create(    thisManif.getId().toString(),
                    AuthManager.getInstance().getAuthMember().getId().toString(),
                    "true", "0",
                    Utils.updateTime_Now(),
                    Utils.updateTime_Now()) != null)
            thisManif.addMember(AuthManager.getInstance().getAuthMember());

            Globals.CURRENT_ACTIVTY.getSupportFragmentManager().beginTransaction().replace(R.id.fragment, MesManifestationsFragment.Create()).commit();

        }


    }
}
