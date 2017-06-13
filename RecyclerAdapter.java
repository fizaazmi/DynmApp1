package com.example.hp.dynmapp;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
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

        private List<String> listData = new ArrayList<>();
        private Context context;

        public RecyclerAdapter(List<String> listData, Context context) {
            this.listData = listData;
            this.context = context;
            notifyDataSetChanged();
        }


        @Override
        public RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            LayoutInflater inflater = LayoutInflater.from(parent.getContext());
            View itemView = inflater.inflate(R.layout.layout_recycler, parent, false);

            return new RecyclerViewHolder(itemView);


        }


        @Override
        public void onBindViewHolder(RecyclerViewHolder holder, int position) {
            holder.txt_Sub.setText(listData.get(position));
            holder.setItemClickListener(new ItemClickListener() {


                @Override
                public void onClick(View view, int position, boolean isLongClick) {

                    if (isLongClick) {
                        Toast.makeText(context, "Long Click: " + listData.get(position), Toast.LENGTH_SHORT).show();
                    } else {
                            FragmentManager fm = ((AppCompatActivity)context).getSupportFragmentManager();
                            FragmentTransaction fragmentTransaction = fm.beginTransaction();

                                Fragment2 f2 = Fragment2.newInstance(listData.get(position));
                                fragmentTransaction.replace(R.id.container, f2);
                                fragmentTransaction.addToBackStack(null);
                                fragmentTransaction.commit();

                        //intent = new Intent(context, MainActivity.class);
                        //context.startActivity(intent);


                        //Fetch data from API to display on the same activity

                        //Toast.makeText(context, " " + listData.get(position), Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }




        @Override
        public int getItemCount() {
            return listData.size();
        }


    }


