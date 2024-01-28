package com.projet_integrateur.app;

import android.os.Bundle;

import com.projet_integrateur.Globals;
import com.projet_integrateur.R;
import com.projet_integrateur.app.controller.AuthManager;
import com.projet_integrateur.app.controller.HttpController;
import  com.projet_integrateur.base.BaseActivity;
import com.projet_integrateur.app.view.IU02.OuvertureSessionFragment;


public class MainActivity extends BaseActivity
{
    private final String  TAG = "[" + getClass().getSimpleName().toUpperCase() + "]";


    @Override protected int getLayout()     {  return R.layout.activity_main;   }

    @Override   protected void onPreInit()
    {
        Globals.DialogOnSuccess_IsEnabled = false;    Globals.DialogOnFailure_IsEnabled = true;

    }

    @Override  protected void onInit(Bundle savedInstanceState)
    {

        if (Globals.LOGIN_REQUIRED) OuvertureSessionFragment.Create().show(getSupportFragmentManager(), TAG);
        else
        {

            if ( AuthManager.getInstance().connectMember("jntessier", "12345678"))
            {
                setActivity(ApplicationActivity.class);
            }
            else OuvertureSessionFragment.Create().show(getSupportFragmentManager(), TAG);

        }
    }


}
