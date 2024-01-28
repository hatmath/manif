package  com.projet_integrateur.base;

import android.content.Context;
import android.util.SparseArray;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RatingBar;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.appcompat.widget.AppCompatCheckBox;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.projet_integrateur.R;


public class BaseViewHolder extends RecyclerView.ViewHolder
{

    public BaseViewHolder(View itemView) {
        super(itemView);
    }

    public <T extends View> T getView(int id)
    {
        @SuppressWarnings("unchecked") SparseArray<View> viewSparseArray = (SparseArray<View>) itemView.getTag();
        if (null == viewSparseArray) {
            viewSparseArray = new SparseArray<>();
            itemView.setTag(viewSparseArray);
        }
        View childView = viewSparseArray.get(id);
        if (null == childView) {
            childView = itemView.findViewById(id);
            viewSparseArray.put(id, childView);
        }
        //noinspection unchecked
        return (T) childView;
    }


    public Context getContext() {
        return itemView.getContext();
    }

    public RelativeLayout getRelativeLayout(int id) {
        return getView(id);
    }

    public LinearLayout getLinearLayout(int id) {
        return getView(id);
    }

    public FrameLayout getFrameLayout(int id) {
        return getView(id);
    }

    public Button getButton(int id) {
        return getView(id);
    }

    public void setButtonText(int id, String text) {
        getTextView(id).setText(text);
    }

    public void setButtonColor(int id, int color) {
        getButton(id).setTextColor(ContextCompat.getColor(getContext(), color));
    }

    public RadioButton getRadioButton(int id) {
        return getView(id);
    }

    public CheckBox getCheckBox(int id) {
        return getView(id);
    }

    public AppCompatCheckBox getAppCompatCheckBox(int id) {
        return getView(id);
    }

    public ProgressBar getProgressBar(int id) {
        return getView(id);
    }

    public SeekBar getSeekBar(int id) {
        return getView(id);
    }

    public RatingBar getRatingBar(int id) {
        return getView(id);
    }

    public GridLayout getGridLayout(int id) {
        return getView(id);
    }

    public RadioGroup getRadioGroup(int id) {
        return getView(id);
    }

    public ImageView getImageView(int id) {
        return getView(id);
    }

    public TextView getTextView(int id) {  return getView(id);   }
    public EditText getEditText(int id) {  return getView(id);   }

    public AppCompatTextView getAppCompatTextView(int id) {
        return getView(id);
    }


    public void setCheckBox(int id, CharSequence charSequence) {    getCheckBox(id).setText(charSequence); }
    public void setTextView(int id, CharSequence charSequence) {   getTextView(id).setText(charSequence);   }
    public void setImageView(int id, CharSequence charSequence) {   getImageView(id).setImageResource(R.drawable.ic_save);  }

    public void setTextColor(int id, int color) {  getTextView(id).setTextColor(ContextCompat.getColor(getContext(), color));    }

    public void setTextSize(int id, float size) {
        getTextView(id).setTextSize(size);
    }


    public String getString(int id) {
        return getContext().getString(id);
    }

    public void setBackgroundColor(View view, int color) {
        view.setBackgroundColor(ContextCompat.getColor(getContext(), color));
    }
}
