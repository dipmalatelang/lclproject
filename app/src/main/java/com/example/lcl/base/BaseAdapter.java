package com.example.lcl.base;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;

import com.example.lcl.BR;

import java.util.List;

@SuppressWarnings("rawtypes")
public class BaseAdapter<T> extends RecyclerView.Adapter<BaseAdapter.ViewHolder> {

    private List<? extends T> mList;
    private final int mLayoutId;
    private BaseInterface mBaseInterface;

    public BaseAdapter(List<? extends T> list, int layoutId, BaseInterface baseInterface) {
        this.mList = list;
        this.mLayoutId = layoutId;
        this.mBaseInterface = baseInterface;
    }

    @NonNull
    @Override
    public BaseAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ViewDataBinding binding = DataBindingUtil.bind(LayoutInflater.from(parent.getContext()).inflate(viewType, parent, false));
        if(binding != null){
            return new ViewHolder<>(binding);
        }
        throw new AssertionError("Incompatible viewType: " + viewType);
    }

    @Override
    public void onBindViewHolder(@NonNull BaseAdapter.ViewHolder holder, int position) {
        T model = mList.get(position);
        holder.getBinding().setVariable(BR.data, model);
        holder.getBinding().setVariable(BR.position, position);
        holder.getBinding().executePendingBindings();
    }

    @Override
    public int getItemCount() {
        return mList == null ? 0 : mList.size();
    }

    @Override
    public int getItemViewType(int position) {
        return mLayoutId;
    }

    public void setData(List<T> data) {
        this.mList = data;
        notifyDataSetChanged();
    }

    public void setListener(BaseInterface baseInterface) {
        this.mBaseInterface = baseInterface;
    }

    public List<? extends T> getListInAdapter() {
        return mList;
    }

    private void updateData(List<T> nList) {

    }

    public void removeSingleItemAtPosition(int position) {
        mList.remove(position);
        notifyItemRemoved(position);
    }

    public interface BaseInterface {
        void onItemClicked(Object dataType, View view, int position);
    }

    public class ViewHolder<V extends ViewDataBinding> extends RecyclerView.ViewHolder {

        private V v;

        public ViewHolder(@NonNull V itemView) {
            super(itemView.getRoot());
            this.v = itemView;
            v.setVariable(BR.callback, mBaseInterface); //This is item Click Listener...
        }

        public V getBinding() {
            return v;
        }

    }

}
