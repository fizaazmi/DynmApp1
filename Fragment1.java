package com.example.hp.dynmapp;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * Created by hp on 09-06-2017.
 */

public class Fragment1 extends Fragment{


        public View onCreateView(LayoutInflater inflater, ViewGroup vg,
                                 Bundle savedInstanceState) {
            return inflater.inflate(R.layout.layout_recycler, vg, false);
        }
    }

