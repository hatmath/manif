package com.projet_integrateur.app;

import android.content.DialogInterface;
import android.os.Bundle;

import com.projet_integrateur.Globals;
import com.projet_integrateur.R;
import com.projet_integrateur.app.controller.HttpController;
import com.projet_integrateur.app.controller.TestController;
import com.projet_integrateur.app.model.Models;

import  com.projet_integrateur.base.BaseActivity;
import com.projet_integrateur.utils.Utils;


public class SplashActivity extends BaseActivity implements DialogInterface.OnDismissListener
{
    private final String  TAG = "[" + getClass().getSimpleName().toUpperCase() + "]";


    @Override protected int getLayout()     {  return R.layout.activity_main;   }

    @Override protected   void  onPreInit()
    {
        Globals.DialogOnSuccess_IsEnabled = false;       Globals.DialogOnFailure_IsEnabled = false;

        if (Globals.TESTS_ENABLED)   {    TestController.getInstance().EXECUTE_TESTS();       Globals.TESTS_ENABLED = false;       }



    }
    @Override  protected void onInit(Bundle savedInstanceState)
    {
        DownloadFromServer();
        if (Globals.LOGIN_REQUIRED == false) setActivity(MainActivity.class);
    }

    private void DownloadFromServer()
    {
        Utils.Dialog_InProgress_Show("DOWNLOADING FROM SERVER");

        HttpController.getInstance().Request_getAll();    Models.seeds_temporaryData();

       if(Globals.DEBUG_INFO) Utils.showAlert("Information","Les donnees du server ont ete charger en memoire", null,"OK").setOnDismissListener(this);

    }

    @Override    public void onDismiss(DialogInterface dialog)  {   setActivity(MainActivity.class);    }
}
