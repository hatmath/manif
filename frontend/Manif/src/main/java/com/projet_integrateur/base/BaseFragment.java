package  com.projet_integrateur.base;

import androidx.fragment.app.Fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import com.projet_integrateur.Globals;


public abstract class BaseFragment extends Fragment
{
    private View m_View = null;

    @Override  public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        if (m_View == null)
        {
            m_View = onGetLayoutInflater(savedInstanceState).inflate(getLayout(), null);
            onPreInit();   onInit(savedInstanceState);  onPostInit();
        }
        return m_View;
    }

    @Override  public void onAttach(Context context) {    super.onAttach(context);      onPostInit();   }

    protected      void         onPreInit() {}
    protected abstract     void         onInit(Bundle savedInstanceState);
    protected      void         onPostInit() {}
    protected abstract int              getLayout();


    protected <T extends View> T        getWidget(int id)   {  return (T) this.m_View.findViewById(id);  }

    protected void setFragment(Fragment thisFragment)
    {
        if (thisFragment != null)
            getActivity().getSupportFragmentManager().beginTransaction().replace(this.getId(), thisFragment).commit();
    }

    protected void setActivity( Class<?> thisClass)
    {
        Intent intent = new Intent( Globals.CURRENT_CONTEXT, thisClass);    startActivity(intent);
    }

}

