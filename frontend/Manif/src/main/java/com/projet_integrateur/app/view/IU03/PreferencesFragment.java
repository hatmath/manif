package com.projet_integrateur.app.view.IU03;

import com.projet_integrateur.Globals;
import com.projet_integrateur.app.controller.HttpController;
import com.projet_integrateur.app.model.Models;
import com.projet_integrateur.app.view.IU03.PreferencesAdapter;
import  com.projet_integrateur.base.BaseFragment;

import com.projet_integrateur.R;

import android.os.Bundle;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class PreferencesFragment extends BaseFragment
{

    private final String  TAG = "[" + getClass().getSimpleName().toUpperCase() + "]";

    private RecyclerView m_RecycleView;
    private PreferencesAdapter m_Adapter;

    public static PreferencesFragment Create() {   return new PreferencesFragment();    }

    //----------------------------------------------------------------------------------------

    @Override protected int getLayout()     {  return R.layout.fragment_preferences;  }
    @Override   protected void onPreInit()
    {
        HttpController.getInstance().Request_getAllInterest();
        List<String> InterestList = new ArrayList<>();
        for (int i = 0; i < Models.getInterestsCount(); i++)
            InterestList.add(Models.getInterests().get(i).getName());

        m_Adapter = new PreferencesAdapter(InterestList);
        m_RecycleView = getWidget(R.id.RecycleView_interets);
        m_RecycleView.setLayoutManager(new LinearLayoutManager(getActivity()));
        m_RecycleView.setAdapter(m_Adapter);



    }
    @Override  protected void  onInit(Bundle savedInstanceState)    {       }
    @Override  protected void onPostInit()     {   }

}
