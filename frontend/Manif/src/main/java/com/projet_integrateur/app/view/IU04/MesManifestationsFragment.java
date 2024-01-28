package com.projet_integrateur.app.view.IU04;

import android.os.Bundle;
import android.view.View;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.projet_integrateur.Globals;

import com.projet_integrateur.app.controller.AuthManager;
import com.projet_integrateur.app.model.Manif;
import com.projet_integrateur.app.model.Models;
import  com.projet_integrateur.base.BaseFragment;

import com.projet_integrateur.R;

import java.util.ArrayList;
import java.util.List;

import  com.projet_integrateur.base.BaseRVAdapter;

public class MesManifestationsFragment extends BaseFragment     implements View.OnClickListener,    BaseRVAdapter.OnItemClickListener<String>
{
    private final String  TAG = "[" + getClass().getSimpleName().toUpperCase() + "]";


    private RecyclerView m_View;
    private FloatingActionButton m_FloatingActionButton_Ajouter;
    private MesManifestationsAdapter m_Adapter;
    private List<Manif> m_Manifs_list = new ArrayList<>();

    @Override    protected int getLayout() {
        return R.layout.fragment_mes_manifestations;
    }
    public static MesManifestationsFragment Create() {   return new MesManifestationsFragment();    }
    @Override  protected     void         onPreInit()
    {

        m_Manifs_list = Models.getManifs_for_AuthMember();
        List<String> adapter_list = new ArrayList<>();
        for (int i=0; i<m_Manifs_list.size();i++)
        {
            String listItem = m_Manifs_list.get(i).getName();
            if (m_Manifs_list.get(i).getOwner().equals(AuthManager.getInstance().getAuthMember().getId()))   listItem += "\t(OWNER)";
            else   listItem += "\t\t(" + Models.getMember(m_Manifs_list.get(i).getOwner()).getUsername() + ")";
            adapter_list.add(listItem);
        }


        m_Adapter = new MesManifestationsAdapter( adapter_list );

        m_View = getWidget(R.id.RecyclerView);
        m_View.setLayoutManager(new LinearLayoutManager(getActivity()));
        m_View.setAdapter(m_Adapter);

        m_Adapter.setOnItemClickListener(this);

        m_FloatingActionButton_Ajouter         = getWidget(R.id.FloatingActionButton_Ajouter);
        m_FloatingActionButton_Ajouter.setOnClickListener(this);
    //----------------------------------------------------------------------------------------

}
    @Override protected      void         onInit(Bundle savedInstanceState){  }
    @Override protected     void         onPostInit() {}



    @Override public void onItemClick(int position, String Item)
    {
        switch (position)
        {
            default:
                Globals.CURRENT_MANIF = m_Manifs_list.get(position);

                setFragment(ManifestationCardFragment.Create());

                break;
        }
    }


    @Override public void onClick(View v)
    {
        if (v.getId() == R.id.FloatingActionButton_Ajouter)
        {
            Globals.CURRENT_MANIF = null;
            setFragment(ManifestationFormFragment.Create());
        }
    }
}
