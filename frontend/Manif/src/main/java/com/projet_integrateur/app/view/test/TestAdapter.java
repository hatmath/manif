package com.projet_integrateur.app.view.test;

import  com.projet_integrateur.base.BaseViewHolder;
import com.projet_integrateur.R;


import java.util.List;

import  com.projet_integrateur.base.BaseRVAdapter;


public class TestAdapter extends BaseRVAdapter<String>
{

    public TestAdapter(List<String> Items) {        super(Items);    }


    @Override    protected int getLayout() {   return R.layout.item_test;   }

    @Override    protected void onBind(BaseViewHolder holder, int position, String Item)
    {
        holder.setTextView(R.id.TextView_Label, Item);
    }
}
