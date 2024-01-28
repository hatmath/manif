package com.projet_integrateur.app.view.IU05;

import android.os.Bundle;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.projet_integrateur.R;

import com.projet_integrateur.app.model.Manif;
import com.projet_integrateur.app.model.Models;
import  com.projet_integrateur.base.BaseFragment;
import  com.projet_integrateur.base.BaseRVAdapter;

import java.util.ArrayList;
import java.util.List;

public class ConsulterManifestationFragment extends BaseFragment     implements    BaseRVAdapter.OnItemClickListener<String>
{
    private final String  TAG = "[" + getClass().getSimpleName().toUpperCase() + "]";

    private RecyclerView m_View;
    private ConsulterManifestationAdapter m_Adapter;


    public static ConsulterManifestationFragment Create() {   return new ConsulterManifestationFragment();    }


    @Override  protected int getLayout() {     return R.layout.fragment_consulter_manifestation;  }



    @Override  protected void onPreInit()
    {
        List<String> UUID_list = new ArrayList<>();
        for ( int i = 0; i < Models.getManifsCount(); i++)
        {
            String thisUUID = ""; Manif thisManif= Models.getManifs().get(i);
            if (thisManif != null)
            {
                thisManif.refresh();
                UUID_list.add(thisManif.getId().toString());
            }


        }


       m_Adapter = new ConsulterManifestationAdapter(UUID_list);

        m_View = getWidget(R.id.RecyclerView);
        m_View.setLayoutManager(new LinearLayoutManager(getActivity()));
        m_View.setAdapter(m_Adapter);

        m_Adapter.setOnItemClickListener(this);
    //    m_Adapter.setOnLongClickListener(this);

    }
    @Override protected      void         onInit(Bundle savedInstanceState){}
    @Override protected     void         onPostInit() {}

    @Override public void onItemClick(int position, String Item)
    {
        switch (position)
        {
            default:    break;
        }
    }


}
