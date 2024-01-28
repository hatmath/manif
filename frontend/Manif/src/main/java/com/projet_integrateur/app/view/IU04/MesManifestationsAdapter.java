package com.projet_integrateur.app.view.IU04;

import  com.projet_integrateur.base.BaseViewHolder;
import com.projet_integrateur.R;


import java.util.List;

import  com.projet_integrateur.base.BaseRVAdapter;


public class MesManifestationsAdapter extends BaseRVAdapter<String>
{

    public MesManifestationsAdapter(List<String> Items) {        super(Items);    }



    @Override
    protected int getLayout() {   return R.layout.item_manifestation;   }

    @Override
    protected void onBind(BaseViewHolder holder, int position, String Item)
    {
        if (Item.indexOf("OWNER") > 0 ) holder.setTextColor(R.id.TextView_Label, R.color.colorRed);
        holder.setTextView(R.id.TextView_Label, Item);
    }
}
