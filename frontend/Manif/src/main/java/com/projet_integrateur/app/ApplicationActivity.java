package com.projet_integrateur.app;

import com.google.android.material.snackbar.Snackbar;


import com.projet_integrateur.R;
import com.projet_integrateur.app.controller.AuthManager;

import com.projet_integrateur.app.view.IU03.PreferencesFragment;
import com.projet_integrateur.app.view.IU04.MesManifestationsFragment;
import com.projet_integrateur.app.view.IU05.ConsulterManifestationFragment;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;

import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.navigation.NavigationView;




import de.hdodenhof.circleimageview.CircleImageView;

import com.projet_integrateur.app.view.test.TestFragment;
import com.projet_integrateur.app.view.test.http.HttpFragment;
import  com.projet_integrateur.base.BaseActivity;


public class ApplicationActivity extends BaseActivity      implements  NavigationView.OnNavigationItemSelectedListener
{
    private final String  TAG = "[" + getClass().getSimpleName().toUpperCase() + "]";



    private Toolbar m_Toolbar;
    private DrawerLayout m_DrawerLayout;
    private NavigationView m_NavigationView;

    private CircleImageView m_Member_Avatar;
    private TextView m_Member_Username;


    private DrawerLayout mDrawerLayout;
    private Toolbar mToolbar;
    private ActionBarDrawerToggle mDrawerToggle;
    //----------------------------------------------------------------------------------------

    @Override protected int getLayout()     {  return R.layout.activity_application;   }
    @Override   protected void onPreInit()
    {



        if (AuthManager.getInstance().getAuthMember() == null )   SignOut();

        m_DrawerLayout = getWidget(R.id.application_activity);

        m_Toolbar = getWidget(R.id.toolbar);
        m_Toolbar.setNavigationIcon(R.drawable.ic_menu_black_24dp);
        m_Toolbar.setNavigationOnClickListener(v -> m_DrawerLayout.openDrawer(GravityCompat.START));

        m_NavigationView = getWidget(R.id.navigationview);
        m_NavigationView.setNavigationItemSelectedListener(this);

        if (AuthManager.getInstance().getAuthMember() != null)
        {
            m_Member_Avatar = m_NavigationView.getHeaderView(0).findViewById(R.id.member_avatar);


            m_Member_Avatar.setImageResource(R.drawable.img_avatar_default);


            m_Member_Username = m_NavigationView.getHeaderView(0).findViewById(R.id.member_name);

            m_Member_Username.setText(AuthManager.getInstance().getAuthMember().getUsername());
        }

    }
    @Override  protected void onInit(Bundle savedInstanceState)
    {
        m_DrawerLayout.openDrawer(GravityCompat.START);

          setFragment(ConsulterManifestationFragment.Create());
    }
    @Override   protected void onPostInit()   {   m_DrawerLayout.closeDrawers(); }

    @Override   public boolean onNavigationItemSelected(@NonNull final MenuItem item)
    {

        m_Toolbar.setTitle(item.getTitle());
        m_NavigationView.getMenu().findItem(item.getItemId()).setChecked(true);


         if (item.getItemId() == R.id.MenuItem_CU05)                { setFragment(ConsulterManifestationFragment.Create());        }
         else if (item.getItemId() == R.id.MenuItem_CU04)           { setFragment(MesManifestationsFragment.Create());  }
         else if (item.getItemId() == R.id.MenuItem_test)           { setFragment(TestFragment.Create()); }
         else if (item.getItemId() == R.id.MenuItem_CU03)           { setFragment(PreferencesFragment.Create()); }
         else if (item.getItemId() == R.id.MenuItem_Deconnecter)    { SignOut() ; }

             m_DrawerLayout.close();
        return true;
    }

    @Override  protected void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == RESULT_CANCELED && resultCode == Activity.RESULT_OK && data != null)       {        }
    }

    public void NotifyMessage(String message) {
    Snackbar mySnackbar = Snackbar.make(findViewById(R.id.fragment),        message , Snackbar.LENGTH_LONG);
            mySnackbar.setAction("VOIR LES DETAILS", new NotificationListener());
            mySnackbar.show();
    }

    public class NotificationListener implements View.OnClickListener {

        @Override
        public void onClick(View v) {


        }
    }

    @Override public void onBackPressed()    {      if (m_DrawerLayout.isDrawerOpen(GravityCompat.START)) {   m_DrawerLayout.closeDrawers();  }     else {  m_DrawerLayout.open();   }   }

    public void SignOut()
    {

        AuthManager.getInstance().reset();
        setActivity(MainActivity.class);
    }


}
