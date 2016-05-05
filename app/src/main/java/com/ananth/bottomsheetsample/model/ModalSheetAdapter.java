package com.ananth.bottomsheetsample.model;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.ananth.bottomsheetsample.R;
import java.util.List;

/**
 * Created by Babu on 5/5/2016.
 */
public class ModalSheetAdapter extends RecyclerView.Adapter<ModalSheetAdapter.ItemHolder> {
    private List<Apps> list;
    private OnItemClickListener onItemClickListener;

    public ModalSheetAdapter(List<Apps> list) {
        this.list = list;
    }

    @Override
    public ModalSheetAdapter.ItemHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.modal_sheet_item, parent, false);
        return new ItemHolder(itemView, this);
    }

    @Override
    public void onBindViewHolder(ModalSheetAdapter.ItemHolder holder, int position) {
        holder.bind(list.get(position));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        onItemClickListener = listener;
    }

    public OnItemClickListener getOnItemClickListener() {
        return onItemClickListener;
    }

    public interface OnItemClickListener {
        void onItemClick(ItemHolder item, int position);
    }

    public static class ItemHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private ModalSheetAdapter adapter;
        TextView textView;
        ImageView imageView;

        public ItemHolder(View itemView, ModalSheetAdapter parent) {
            super(itemView);
            itemView.setOnClickListener(this);
            this.adapter = parent;

            imageView = (ImageView) itemView.findViewById(R.id.imageView);
            textView = (TextView) itemView.findViewById(R.id.textView);
        }

        public void bind(Apps item) {
            textView.setText(item.getTitleId());
            imageView.setBackgroundResource(item.getImageId());
        }

        @Override
        public void onClick(View v) {
            final OnItemClickListener listener = adapter.getOnItemClickListener();
            if (listener != null) {
                listener.onItemClick(this, getAdapterPosition());
            }

        }
    }
}
