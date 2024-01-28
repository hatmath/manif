package com.projet_integrateur.app.view.IU05;

import androidx.annotation.ColorInt;

import com.projet_integrateur.R;
import com.projet_integrateur.app.model.Member;
import com.projet_integrateur.app.model.Models;
import com.projet_integrateur.base.BaseRVAdapter;
import com.projet_integrateur.base.BaseViewHolder;

import java.util.List;


public class MembersAdapter extends BaseRVAdapter<String>
{

    public MembersAdapter(List<String> Items) {        super(Items);    }



    @Override    protected int getLayout() {   return R.layout.item_members_by_manif;   }

    @Override
    protected void onBind(BaseViewHolder holder, int position, String Item)
    {
        holder.setTextView(R.id.TextView_Member_Name, Item);
        Member thisMember = Models.getMember(Item);
        if (thisMember != null)
        {
            if (thisMember.getIsPresent())
            {
               holder.setTextView(R.id.TextView_Member_is_present, "PRESENT");
                holder.setTextColor(R.id.TextView_Member_Name, R.color.colorBlack);
                holder.setTextColor(R.id.TextView_Member_is_present, R.color.colorGreen);
            }
            else
            {
                holder.setTextView(R.id.TextView_Member_is_present, "ABSENT");
                holder.setTextColor(R.id.TextView_Member_Name, R.color.colorBlack);
                holder.setTextColor(R.id.TextView_Member_is_present, R.color.colorRed);
            }
        }
    }

}
