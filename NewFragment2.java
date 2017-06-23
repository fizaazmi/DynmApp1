package com.example.hp.dynmapp;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class NewFragment2 extends Fragment implements RecyclerAdapter.CallMethod {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private LinearLayoutManager layoutManager ;
    RecyclerView recyclerView;
    private ArrayList<AndroidVer> listData= new ArrayList<>();
   // private List<String> listData;
    //private List<String> listData = new ArrayList<>();

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public NewFragment2() {
        // Required empty public constructor
    }

    // TODO: Rename and change types and number of parameters
    public static NewFragment2 newInstance(String param1, String param2) {
        NewFragment2 fragment = new NewFragment2();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
       // return inflater.inflate(R.layout.fragment_new_fragment2, container, false);
        View view = inflater.inflate(R.layout.fragment_new_fragment2, container, false);
        //setupList1();
        recyclerView = (RecyclerView)view.findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(getActivity(),LinearLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(layoutManager);
        //RecyclerAdapter adapter = new RecyclerAdapter(listData, getActivity(),this);
        //recyclerView.setAdapter(adapter);
        loadJSON();
        return view;
    }

    private void loadJSON() {
        Retrofit retrofit = new Retrofit.Builder().baseUrl("https://toppr.com").addConverterFactory(GsonConverterFactory.create()).build();
        Client request = retrofit.create(Client.class);
        
        Call<JSONResponse> call = request.getJSON("physics");

        call.enqueue(new Callback<JSONResponse>() {
            @Override
            public void onResponse(Call<JSONResponse> call, Response<JSONResponse> response) {

                JSONResponse jsonResponse = response.body();
                RecyclerAdapter adapter = new RecyclerAdapter(jsonResponse.getData().getAndroid(), getActivity(), NewFragment2.this);
                recyclerView.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<JSONResponse> call, Throwable t) {
                Log.d("Error", t.getMessage());
            }
        });
    }
        @Override
        public void onAttach(Context context) {
            super.onAttach(context);
            if (context instanceof OnFragmentInteractionListener) {
                mListener = (OnFragmentInteractionListener) context;
            } else {
                throw new RuntimeException(context.toString()
                        + " must implement OnFragmentInteractionListener");
            }
        }

        @Override
        public void onDetach() {
            super.onDetach();
            mListener = null;
        }

        @Override
        public void callback(int position) {
//            Toast.makeText(getContext(), " Click: " + listData.get(position), Toast.LENGTH_SHORT).show();
            mListener.onFragmentInteraction("fragment3");
        }



    }


/*
    private void setupList1()
    {
        listData.add("Vectors");
        listData.add("Kinematics");
        listData.add("Gravitation");
        listData.add("Sound");
        listData.add("Light");
        listData.add("Electromagnetism");
        listData.add("Current Electricity");
        listData.add("Semiconductors");
        listData.add("Wave Optics");


    }
*/


    // TODO: Rename method, update argument and hook method into UI event
//    public void onButtonPressed(Uri uri) {
//        if (mListener != null) {
//            mListener.onFragmentInteraction();
//        }
//    }

