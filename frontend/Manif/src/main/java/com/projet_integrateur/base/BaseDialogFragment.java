package  com.projet_integrateur.base;


import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;

import com.projet_integrateur.Globals;


public abstract class BaseDialogFragment extends DialogFragment
{
    protected View m_View = null;
    protected AlertDialog m_Dialog = null;

    @Override  public Dialog onCreateDialog(Bundle savedInstanceState) {   return getDialog();  }

    protected <T extends View> T getWidget(int id) {   return (T) m_View.findViewById(id);    }
    public View getRootView(int id)    {  return View.inflate(getActivity(), id, null);    }

    public      abstract AlertDialog getDialog();
    protected   abstract int         getLayout();

    protected void setActivity( Class<?> thisClass) { Intent intent = new Intent( Globals.CURRENT_CONTEXT, thisClass);    startActivity(intent);   }
    protected void close() { if (m_Dialog != null) m_Dialog.dismiss(); }

}
