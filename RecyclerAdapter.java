package com.example.hp.dynmapp;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by hp on 07-06-2017.
 */

class RecyclerViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener,View.OnLongClickListener {

    public TextView txt_Sub;
    private ItemClickListener itemClickListener;
    public RecyclerViewHolder(View itemView) {
        super(itemView);
        txt_Sub = (TextView) itemView.findViewById(R.id.txtSub);
        itemView.setOnClickListener(this);
        itemView.setOnLongClickListener(this);
    }
    public void setItemClickListener(ItemClickListener itemClickListener) {
        this.itemClickListener = itemClickListener;
    }
    @Override
    public void onClick(View v) {
        itemClickListener.onClick(v, getAdapterPosition(), false);

    }
    @Override
    public boolean onLongClick(View v) {
        itemClickListener.onClick(v, getAdapterPosition(), true);
        return true;
    }
}

    public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerViewHolder> {
        private ArrayList<AndroidVer> listData;
        //  private List<String> chapters;
        //private List<String> listData = new ArrayList<>();
        private Context context;
    private CallMethod callMethod;

        public interface CallMethod{
            void callback(int position);
        }

        public RecyclerAdapter(List<AndroidVer> listData, Context context, CallMethod callMethod) {
            this.listData= (ArrayList<AndroidVer>) listData;
            this.context = context;
            this.callMethod=callMethod;
            notifyDataSetChanged();
        }


       /* public RecyclerAdapter(List<String> listData, Context context, CallMethod callMethod) {

            this.listData = listData;
            this.context = context;
            this.callMethod=callMethod;
            notifyDataSetChanged();
        }
*/

        @Override
        public RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            LayoutInflater inflater = LayoutInflater.from(parent.getContext());
            View itemView = inflater.inflate(R.layout.layout_recycler, parent, false);
            final RecyclerViewHolder holder=new RecyclerViewHolder(itemView);

            holder.setItemClickListener(new ItemClickListener() {


                @Override
                public void onClick(View view, int position, boolean isLongClick) {

                    if (isLongClick) {
                        Toast.makeText(context, "Long Click: " + listData.get(position), Toast.LENGTH_SHORT).show();
                    } else {


                        callMethod.callback(position);

                       //int position = holder.getAdapterPosition();



                    }
                }
            });


            return holder;

        }


        @Override
        public void onBindViewHolder(RecyclerViewHolder holder, int position) {
            holder.txt_Sub.setText(listData.get(position).getName());
            //holder.txt_Sub.setText(listData.get(position));
        }

        @Override
        public int getItemCount() {
            //return 0;
            return  listData.size();
        }
    }





