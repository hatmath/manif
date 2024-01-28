package com.projet_integrateur.app.view.IU03;

import android.view.View;

import  com.projet_integrateur.base.BaseViewHolder;
import com.projet_integrateur.R;


import java.util.List;

import  com.projet_integrateur.base.BaseRVAdapter;


public class PreferencesAdapter extends BaseRVAdapter<String>
{
    private final String  TAG = "[" + getClass().getSimpleName().toUpperCase() + "]";
    public PreferencesAdapter(List<String> Items) {        super(Items);    }



    @Override
    protected int getLayout() {   return R.layout.item_interet;   }

    @Override
    protected void onBind(BaseViewHolder holder, int position, String Item)
    {
        holder.setTextView(R.id.TextView_Title, Item);
       if (holder.getCheckBox(R.id.CheckBox_Interet) != null ) holder.getCheckBox(R.id.CheckBox_Interet).setChecked(true);
    }
}
