package  com.projet_integrateur.base;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;


public abstract class BaseRVAdapter<T> extends RecyclerView.Adapter<BaseViewHolder> {

    protected List<T> mData;
    private OnItemClickListener<T> onItemClickListener = null;

    private OnLongClickListener<T> onLongClickListener = null;

    protected BaseRVAdapter(List<T> mData) {
        this.mData = mData;
    }

    public void setOnItemClickListener(OnItemClickListener<T> onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    public void setOnLongClickListener(OnLongClickListener<T> onLongClickListener) {
        this.onLongClickListener = onLongClickListener;
    }

    public void addAll(List<T> data) {
        if (mData != null && data != null) {
            mData.addAll(data);
            notifyDataSetChanged();
        }
    }



    public void clearAll() {
        if (mData != null) {
            mData.clear();
            notifyDataSetChanged();
        }
    }

    @Override
    public BaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new BaseViewHolder(LayoutInflater.from(parent.getContext()).inflate(getLayout(), parent, false));
    }

    @Override
    public void onBindViewHolder(BaseViewHolder holder, @SuppressLint("RecyclerView") final int position) {
        onBind(holder, position, mData.get(position));
        if (onItemClickListener != null) {
            holder.itemView.setOnClickListener(view -> onItemClickListener.onItemClick(position, mData.get(position)));
        }
        if (onLongClickListener != null) {
            holder.itemView.setOnLongClickListener(v -> {
                onLongClickListener.onLongClick(position, mData.get(position));
                return true;
            });
        }
    }

    protected abstract int getLayout();


    protected abstract void onBind(BaseViewHolder holder, int position, T t);

    @Override
    public int getItemCount() {
        return mData == null ? 0 : mData.size();
    }

    public interface OnItemClickListener<T> {
        void onItemClick(int position, T appInfo);
    }

    public interface OnLongClickListener<T> {
        void onLongClick(int position, T appInfo);
    }
}
