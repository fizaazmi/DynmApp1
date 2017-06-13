package com.example.hp.dynmapp;


import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import static com.example.hp.dynmapp.R.id.recyclerView;
import android.support.v7.widget.LinearLayoutManager;


/**
 * Created by hp on 09-06-2017.
 */

public class Fragment2 extends Fragment {

    private RecyclerView.LayoutManager layoutManager ;
    private List<String> chapters = new ArrayList<>();
    private String subject;

    public Fragment2() {
    }

    public static Fragment2 newInstance(String subject) {

        Bundle args = new Bundle();
        args.putString("subject", subject);

        Fragment2 fragment = new Fragment2();
        fragment.setArguments(args);
        return fragment;
    }



    public View onCreateView(LayoutInflater inflater, ViewGroup vg,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.activity_main, vg, false);


    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
         subject = getArguments().getString("subject");
        setupList1();

        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        layoutManager=new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);
        RecyclerAdapter adapter=new RecyclerAdapter(chapters,getContext());
        recyclerView.setAdapter(adapter);

    }

        private void setupList1()
        {
            if (subject.equalsIgnoreCase("physics")){
            chapters.add("Vectors");
            chapters.add("Kinematics");
            chapters.add("Sound");
            chapters.add("Light");
            chapters.add("Current electricity");
            chapters.add("Electromagnetism");
            }

        }






    }


