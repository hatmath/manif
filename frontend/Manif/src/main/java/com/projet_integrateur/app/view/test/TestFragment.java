package com.projet_integrateur.app.view.test;

import static com.projet_integrateur.Globals.Network.E_SERVER_TYPE.E_SERVER_APACHE;
import static com.projet_integrateur.Globals.Network.E_SERVER_TYPE.E_SERVER_EXPRESS;
import static com.projet_integrateur.app.model.Models.E_MODELS.E_INTEREST;
import static com.projet_integrateur.app.model.Models.E_MODELS.E_MANIF;
import static com.projet_integrateur.app.model.Models.E_MODELS.E_MEMBERS_MANIF;

import android.os.Bundle;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;

import com.projet_integrateur.R;
import com.projet_integrateur.Globals;
import com.projet_integrateur.app.controller.AuthManager;
import com.projet_integrateur.app.controller.HttpController;
import com.projet_integrateur.app.model.Members_by_Manif;
import com.projet_integrateur.app.model.Models;
import com.projet_integrateur.app.view.test.http.HttpFragment;
import com.projet_integrateur.base.BaseFragment;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.projet_integrateur.base.BaseRVAdapter;
import com.projet_integrateur.utils.Utils;

public class TestFragment extends BaseFragment    implements BaseRVAdapter.OnItemClickListener<String>
{

    private final String  TAG = "[" + getClass().getSimpleName().toUpperCase() + "]";


    private RecyclerView m_RecyclerView;
    private TestAdapter m_TestAdapter;
    List<String> m_MenuItems = new ArrayList<>();


    public static TestFragment Create() {   return new TestFragment();    }



    @Override protected int getLayout()     {  return R.layout.fragment_test;  }

    @Override  protected void  onInit(Bundle savedInstanceState)
    {
        Globals.DialogOnSuccess_IsEnabled = true;       Globals.DialogOnFailure_IsEnabled = true;

        m_MenuItems.add("0-[HTTP_FRAGMENT]");

        m_MenuItems.add("getAllInterest()");
        m_MenuItems.add("getInterest(id:2)");

        m_MenuItems.add("getAllSlogan()");
        m_MenuItems.add("getSlogan(id:\"9c94ac81-1f84-4dc4-82a2-8d2df1f0c685\")");

        m_MenuItems.add("getAllMember()");
        m_MenuItems.add("getMember(id:\"0c8c67fb-6206-4654-b10f-7ed26189ffe5\")");

        m_MenuItems.add("getAllManif()");
        m_MenuItems.add("getManif(id:\"4c1e51a3-178e-442a-9d20-9ee13d9e62d1\")");

        m_MenuItems.add("getAllMembersByManif()");
        m_MenuItems.add("getMembersByManif(id:\"868658e41d-106d-4d78-9ce5-2a2b97f7f0a858e41d-106d-4d78-9ce5-2a2b97f7f0a8\")");

      //  m_MenuItems.add("getAllInterestsByMember()");
       // m_MenuItems.add("getInterestsByMember(id:\"00000000-0000-0000-0000-000000000001\")");

        m_TestAdapter = new TestAdapter( m_MenuItems );
        m_RecyclerView = getWidget(R.id.RecyclerView);
        m_RecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        m_RecyclerView.setAdapter(m_TestAdapter);
        m_TestAdapter.setOnItemClickListener(this);


    }

    @Override   public void onItemClick(int position, String TestItem)
    {
        switch(position)
        {
            case 0:  {      HTTP_FRAGMENT();                    }; break;

            case 1 : {      HTTPCONTROLLER_getAllInterest();    }; break;
            case 2 : {      HTTPCONTROLLER_getInterest(2);   }; break;

            case 3:  {      HTTPCONTROLLER_getAllSlogan();       }; break;
            case 4 : {      HTTPCONTROLLER_getSlogan("9c94ac81-1f84-4dc4-82a2-8d2df1f0c685");    }; break;

            case 5 : {      HTTPCONTROLLER_getAllMember();    }; break;
            case 6 : {      HTTPCONTROLLER_getMember("21ab87a9-bccb-46fc-9330-1ae98f3be813");   }; break;

            case 7:  {      HTTPCONTROLLER_getAllManif();       }; break;
            case 8 : {      HTTPCONTROLLER_getManif("4c1e51a3-178e-442a-9d20-9ee13d9e62d1");    }; break;

            case 9 : {      HTTPCONTROLLER_getAllMembersByManif();    }; break;
            case 10 : {     HTTPCONTROLLER_getMembersByManif("8658e41d-106d-4d78-9ce5-2a2b97f7f0a8");   }; break;

           // case 11: {      HTTPCONTROLLER_getAllInterestsByMember();    }; break;
         //   case 12 : {     HTTPCONTROLLER_getInterestsByMember("00000000-0000-0000-0000-000000000001");   }; break;

        }


    }


    public void HTTP_FRAGMENT()                         {     setFragment(HttpFragment.Create()); }

    public void  HTTPCONTROLLER_getAllInterest()        {     HttpController.getInstance().Request_getAllInterest();    }
    public void  HTTPCONTROLLER_getInterest(Integer id) {     HttpController.getInstance().Request_getInterest(id);    }

    public void  HTTPCONTROLLER_getAllSlogan()          {     HttpController.getInstance().Request_getAllSlogan();    }
    public void  HTTPCONTROLLER_getSlogan(String id)     {     HttpController.getInstance().Request_getSlogan(id);   }

    public void  HTTPCONTROLLER_getAllMember()          {     HttpController.getInstance().Request_getAllMember();    }
    public void  HTTPCONTROLLER_getMember(String id)     {     HttpController.getInstance().Request_getMember(id);   }

    public void  HTTPCONTROLLER_getAllManif()           {     HttpController.getInstance().Request_getAllManif();    }
    public void  HTTPCONTROLLER_getManif(String id)     {     HttpController.getInstance().Request_getManif(id);   }

    public void  HTTPCONTROLLER_getAllMembersByManif()          {     HttpController.getInstance().Request_getAllMembersByManif();    }
    public void  HTTPCONTROLLER_getMembersByManif(String id)     {     HttpController.getInstance().Request_getMembersByManif(id);   }

  //  public void  HTTPCONTROLLER_getAllInterestsByMember()          {     HttpController.getInstance().Request_getAllInterestsByMember();    }
   // public void  HTTPCONTROLLER_getInterestsByMember(String id)     {     HttpController.getInstance().Request_getInterestsByMember(id);   }

}