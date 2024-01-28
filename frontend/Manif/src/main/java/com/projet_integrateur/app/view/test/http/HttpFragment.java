package com.projet_integrateur.app.view.test.http;


import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.projet_integrateur.R;
import com.projet_integrateur.Globals;

import com.projet_integrateur.app.controller.http.callback.HttpCallback;

import com.projet_integrateur.base.BaseFragment;
import com.projet_integrateur.base.BaseRVAdapter;
import com.projet_integrateur.utils.Utils;
import com.projet_integrateur.app.controller.http.HttpClient;
import com.projet_integrateur.app.controller.http.internal.PersistentCookieStore;
import com.projet_integrateur.app.controller.http.internal.RequestParams;

import java.util.ArrayList;
import java.util.List;

public class HttpFragment extends BaseFragment implements View.OnClickListener, BaseRVAdapter.OnItemClickListener<String>
{

    private final String  TAG = "[" + getClass().getSimpleName().toUpperCase() + "]";

    private EditText m_EdiText_Url;
    private Button m_Button_Get;
	private Button m_Button_Post;
	private TextView m_TextView_Result;

private RecyclerView m_RecyclerView_Routes;
    private RoutesAdapter m_RoutesAdapter;

    List<String> m_RoutesItems = new ArrayList<>();

    public static HttpFragment Create() {   return new HttpFragment();    }

    HttpCallback m_StringCallback = new HttpCallback()
    {

        @Override  public void onRequestStart()
        {
            Utils.Dialog_InProgress_Show("LOADING...");
        }

        @Override  public void onRequestFinish() {   Utils.Dialog_InProgress_Dismiss();}

        @Override public void onFailure(int statusCode)
        {
            Log.e(TAG, "Error code =" + statusCode);
            Toast.makeText(Globals.CURRENT_CONTEXT, "Error code =" + statusCode,  Toast.LENGTH_SHORT).show();
        }

        @Override public void onSuccess(String response)
        {
            m_TextView_Result.setText(response);     Log.i(TAG, response);
            Utils.showAlert("HTTP REQUEST", response, null, "OK");

        }
    };

    @Override protected int getLayout()     {  return R.layout.fragment_http;  }
    @Override   protected void onPreInit()
    {

        m_EdiText_Url       = getWidget(R.id.EditText_Url);
        m_TextView_Result   = getWidget(R.id.TextView_Result);
        m_Button_Get        = getWidget(R.id.Button_Get);       m_Button_Get.setOnClickListener(this);
        m_Button_Post       = getWidget(R.id.Button_Post);      m_Button_Post.setOnClickListener(this);

        m_EdiText_Url.setText(Globals.Network.TEST_URL);

        HttpClient.setCookieHandler(new PersistentCookieStore(this.getContext()));

        m_RoutesItems = new ArrayList<>();
        for(int i=0;i<Globals.Network.SERVER_EXPRESS_GETALL_URLS.length;i++ )
            m_RoutesItems.add(Globals.Network.SERVER_EXPRESS_GETALL_URLS[i]);

        for(int i=0;i<Globals.Network.SERVER_EXPRESS_GET_URLS.length;i++ )
            m_RoutesItems.add(Globals.Network.SERVER_EXPRESS_GET_URLS[i]);


        m_RoutesAdapter = new RoutesAdapter( m_RoutesItems );
        m_RecyclerView_Routes = getWidget(R.id.RecyclerView_Routes);
        if (m_RecyclerView_Routes != null) {
            m_RecyclerView_Routes.setLayoutManager(new LinearLayoutManager(getActivity()));
            if (m_RoutesAdapter != null) m_RecyclerView_Routes.setAdapter(m_RoutesAdapter);
            m_RoutesAdapter.setOnItemClickListener(this);
        }
    }
    @Override  protected void  onInit(Bundle savedInstanceState) {    }


    @Override public void onClick(View v)
    {
            if (v.getId() == R.id.Button_Get)
            {
                m_TextView_Result.setText("");

                RequestParams params = new RequestParams();
                params.put("", "");       //     params.put("idArticle", "2");
                 HttpClient.get(m_EdiText_Url.getText().toString().trim(), params,
                                    m_StringCallback);


            }

            if (v.getId() == R.id.Button_Post)
            {
                m_TextView_Result.setText("");

                RequestParams params = new RequestParams();
                //http://192.168.68.103:5283/api/auth/login
                params.put("username", "john_doe");params.put("password", "hashed_password");

                HttpClient.post(m_EdiText_Url.getText().toString().trim(), params,
                        m_StringCallback);
            }

    }

    @Override  public void onItemClick(int position, String appInfo)
    {
        m_EdiText_Url.setText(Globals.Network.SERVER_EXPRESS_GETALL_URLS[position]);
        switch(position)
        {
            case 0:  {           }; break;


        }


    }
}