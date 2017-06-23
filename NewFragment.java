package com.example.hp.dynmapp;

import android.content.Context;
import android.net.Uri;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


public class NewFragment extends Fragment implements RecyclerAdapter.CallMethod {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private LinearLayoutManager layoutManager;
    RecyclerView recyclerView;
    private ArrayList<AndroidVer> listData= new ArrayList<>();
    //private ArrayList<String> listData = new ArrayList<>();


    // String server_url="https://www.toppr.com/api/v5/jee-main/practice/physics/";
    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public NewFragment() {
        // Required empty public constructor
    }

    // TODO: Rename and change types and number of parameters
    public static NewFragment newInstance(String param1, String param2) {
        NewFragment fragment = new NewFragment();
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
        View view = inflater.inflate(R.layout.fragment_new, container, false);


        //setupList();

        recyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);

        //RecyclerAdapter adapter = new RecyclerAdapter(listData, getActivity(), this);
        //recyclerView.setAdapter(adapter);
        loadJSON1();
         return view;
    }



    private void loadJSON1() {
        Retrofit retrofit = new Retrofit.Builder().baseUrl("https://toppr.com").addConverterFactory(GsonConverterFactory.create()).build();
        Client request = retrofit.create(Client.class);
        Call<JSONResponse1> call = request.getJSON1();
        call.enqueue(new Callback<JSONResponse1>() {
            @Override
            public void onResponse(Call<JSONResponse1> call, Response<JSONResponse1> response) {

                JSONResponse1 jsonResponse = response.body();
                RecyclerAdapter adapter = new RecyclerAdapter(jsonResponse.getData().getAndroid(), getActivity(), NewFragment.this);
                recyclerView.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<JSONResponse1> call, Throwable t) {
                Log.d("Error", t.getMessage());
            }
        });

    }


      /*  private void setupList()
        {
            listData.add("Physics");
            listData.add("Chemistry");
            listData.add("Maths");
            listData.add("Biology");
            listData.add("English");


        }

*/


    // TODO: Rename method, update argument and hook method into UI event

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

        mListener.onFragmentInteraction("fragment2");


    }


   // public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
     //   void onFragmentInteraction();
    //}
}
