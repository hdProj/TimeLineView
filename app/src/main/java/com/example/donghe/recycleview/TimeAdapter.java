package com.example.donghe.recycleview;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import com.example.donghe.recycleview.timelineview.TimelineView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dong.he on 2016/11/17.
 */

public class TimeAdapter extends RecyclerView.Adapter {

    private Context mContext;
    private List<TimeLineModel> list = new ArrayList<>();

    public TimeAdapter(Context context, List<TimeLineModel> list) {
        mContext = context;
        this.list = list;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        final View view = LayoutInflater.from(mContext).inflate(R.layout.item_node, parent, false);
        return new ItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        TimeLineModel data = list.get(position);
        if (holder instanceof ItemViewHolder) {
            ItemViewHolder viewHolder = (ItemViewHolder) holder;
            viewHolder.name.setText("name：" + data.getName() + " age：" + data.getAge());
            viewHolder.init(TimelineView.getTimeLineViewType(position, getItemCount()));
        }


    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ItemViewHolder extends RecyclerView.ViewHolder {

        TimelineView mTimelineView;
        TextView name;

        public ItemViewHolder(View itemView) {
            super(itemView);
            name = (TextView) itemView.findViewById(R.id.tx_name);
            mTimelineView = (TimelineView) itemView.findViewById(R.id.time_marker);
        }

        public void init(int viewTypeLine) {
            mTimelineView.initLine(viewTypeLine);
        }
    }

}
