package com.muhammad_adi_yusuf.mywaifu.view;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.muhammad_adi_yusuf.mywaifu.R;

public class ItemSupport {
    private final RecyclerView reCyclerView;
    private OnItemClickListener onItemClick;
    private View.OnClickListener onClickList = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            RecyclerView.ViewHolder holder = reCyclerView.getChildViewHolder(v);
            onItemClick.onItemClicked(reCyclerView, holder.getAdapterPosition(), v);
        }
    };

    private ItemSupport(RecyclerView recyclerView) {
        reCyclerView = recyclerView;
        reCyclerView.setTag(R.id.ics_recycler_view, this);
        RecyclerView.OnChildAttachStateChangeListener attachListener = new RecyclerView.OnChildAttachStateChangeListener() {
            @Override
            public void onChildViewAttachedToWindow(@NonNull View view) {
                if (onItemClick != null) {
                    view.setOnClickListener(onClickList);
                }
            }

            @Override
            public void onChildViewDetachedFromWindow(@NonNull View view) {
            }
        };
        reCyclerView.addOnChildAttachStateChangeListener(attachListener);
    }

    public static ItemSupport addTo(RecyclerView view) {
        ItemSupport support = (ItemSupport) view.getTag(R.id.ics_recycler_view);
        if (support == null) {
            support = new ItemSupport(view);
        }
        return support;
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        onItemClick = listener;
    }

    public interface OnItemClickListener {
        void onItemClicked(RecyclerView recyclerView, int position, View v);
    }
}
