package com.example.hp.dynmapp;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import java.util.ArrayList;
import java.util.Arrays;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity implements OnFragmentInteractionListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fm.beginTransaction();
        NewFragment f1 = new NewFragment();
        fragmentTransaction.replace(android.R.id.content, f1).add(R.id.container,NewFragment.newInstance("",""));
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();


    }
    @Override
    public void onFragmentInteraction(String fragmentName) {
        if (fragmentName.equalsIgnoreCase("fragment2")) {

            FragmentManager fm = getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fm.beginTransaction();
            NewFragment2 f2 = new NewFragment2();
            fragmentTransaction.replace(android.R.id.content, f2).replace(R.id.container,NewFragment2.newInstance("",""));
            fragmentTransaction.addToBackStack(null);
            fragmentTransaction.commit();

            //getSupportFragmentManager().beginTransaction().replace(R.id.container, NewFragment2.newInstance("", "")).commit();

        }


            else if (fragmentName.equalsIgnoreCase("fragment4")) {

            FragmentManager fm = getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fm.beginTransaction();
            NewFragment4 f4 = new NewFragment4();
            fragmentTransaction.replace(android.R.id.content, f4).replace(R.id.container,NewFragment4.newInstance("",""));
            fragmentTransaction.addToBackStack(null);
            fragmentTransaction.commit();
           // getSupportFragmentManager().beginTransaction().replace(R.id.container, NewFragment4.newInstance("", "")).commit();



        }
         else
        {
            FragmentManager fm = getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fm.beginTransaction();
            NewFragment3 f3 = new NewFragment3();
            fragmentTransaction.replace(android.R.id.content, f3).replace(R.id.container,NewFragment3.newInstance("",""));
            fragmentTransaction.addToBackStack(null);
            fragmentTransaction.commit();
            //getSupportFragmentManager().beginTransaction().replace(R.id.container,NewFragment3.newInstance("","")).commit();
            //getSupportFragmentManager().popBackStack();
        }
        }
    @Override
    public void onBackPressed() {
        if (getSupportFragmentManager().getBackStackEntryCount() > 0) {
            getSupportFragmentManager().popBackStack();
        } else {
            super.onBackPressed();
        }
    }
    }



