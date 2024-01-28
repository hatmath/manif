package  com.projet_integrateur.base;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;

import com.projet_integrateur.R;
import com.projet_integrateur.Globals;


import java.util.ArrayList;
import java.util.List;

public abstract class BaseActivity extends AppCompatActivity
{
    @Override protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);    setContentView(getLayout());
        Globals.CURRENT_CONTEXT = this; Globals.CURRENT_ACTIVTY = this;
        onPreInit();       onInit(savedInstanceState);       onPostInit();
    }

    protected      void         onPreInit() { }
    protected abstract void             onInit(Bundle savedInstanceState);
    protected      void         onPostInit() { }
    protected abstract int              getLayout();
    protected <T extends View> T        getWidget(int id)               {  return (T) this.findViewById(id);  }
    protected void                      setFragment(Fragment thisFragment)
    {

        if (thisFragment != null)
        {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment, thisFragment).commit();
        }
    }

    protected void                      setActivity( Class<?> thisClass)
    {
        Intent intent = new Intent(this, thisClass);    startActivity(intent);
    }

    protected static class Adapter extends FragmentPagerAdapter
    {
        private final List<Fragment> mFragments = new ArrayList<>();
        private final List<String> mFragmentTitles = new ArrayList<>();

        public Adapter(androidx.fragment.app.FragmentManager fm) {
            super(fm);
        }

        public void addFragment(Fragment fragment, String title) { mFragments.add(fragment);  mFragmentTitles.add(title); }

        @Override public Fragment getItem(int position) {
            return mFragments.get(position);
        }
        @Override    public int getCount() {
            return mFragments.size();
        }
        @Override   public CharSequence getPageTitle(int position) {    return mFragmentTitles.get(position);   }
    }

}
