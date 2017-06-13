package com.example.hp.dynmapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;
import android.support.v7.app.ActionBarActivity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.view.Display;
import android.view.Menu;
import android.view.MenuItem;
import android.view.WindowManager;



public class MainActivity extends AppCompatActivity {

    private RecyclerView.LayoutManager layoutManager;
    private List<String> listData = new ArrayList<>();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        FragmentManager fm = getFragmentManager();
//        FragmentTransaction fragmentTransaction = fm.beginTransaction();
//        Fragment1 f1 = new Fragment1();
//        fragmentTransaction.replace(android.R.id.content, f1);
//        fragmentTransaction.commit();

        setupList();

        RecyclerView recyclerView = (RecyclerView)findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        layoutManager=new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        RecyclerAdapter adapter=new RecyclerAdapter(listData,this);
        recyclerView.setAdapter(adapter);

    }





private void setupList()
{
   listData.add("Physics");
   listData.add("Chemistry");
    listData.add("Maths");
    listData.add("Biology");
    listData.add("English");


}



}

