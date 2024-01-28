package com.projet_integrateur.app.view.test.http;

import com.projet_integrateur.R;
import com.projet_integrateur.base.BaseRVAdapter;
import com.projet_integrateur.base.BaseViewHolder;

import java.util.List;


    public class RoutesAdapter extends BaseRVAdapter<String>
    {

        public RoutesAdapter(List<String> Items) {        super(Items);    }


        @Override    protected int getLayout() {   return R.layout.item_routes;   }

        @Override    protected void onBind(BaseViewHolder holder, int position, String Item)
        {
            holder.setTextView(R.id.TextView_Label, Item);
        }
    }


