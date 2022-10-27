package com.if31.pahlawan;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView rvPahlawan;
    private ArrayList<MODEL_PAHLAWAN> data = new ArrayList<>();

    private int nView = 0;
    static final String State_Mode = "Mode_View";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rvPahlawan = findViewById(R.id.rv_pahlawan);
        rvPahlawan.setHasFixedSize(true);


        data.addAll(DATA_PAHLAWAN.ambildatapahlawan());
        if (savedInstanceState != null){
            nView=savedInstanceState.getInt(State_Mode);
            if (nView == 0){
                tampilandatacard();
            }else{
                tampildataGrid();
            }
        }else {

            tampilandatacard();
        }
    }
    private void tampilandatacard (){
        nView = 0;
        rvPahlawan.setLayoutManager(new LinearLayoutManager(this));
        adapterCard adapterCard = new adapterCard(data);
        rvPahlawan.setAdapter(adapterCard);

    }
    private void tampildataGrid(){
        nView =1;
        rvPahlawan.setLayoutManager(new GridLayoutManager(this,2));
        adapterGrid adapterGrid = new adapterGrid(data);
        rvPahlawan.setAdapter(adapterGrid);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_tampilan,menu);
        int nightmode = AppCompatDelegate.getDefaultNightMode();
        if (nightmode==AppCompatDelegate.MODE_NIGHT_YES){
            menu.findItem(R.id.menu_night).setTitle("Mode Day");
        }else{
            menu.findItem(R.id.menu_night).setTitle("Mode Night");
        }

        return super.onCreateOptionsMenu(menu);

    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.menu_card:
                setTitle("MODE CARD VIEW");
                tampilandatacard();
                break;
            case R.id.menu_grid:
                setTitle("MODE GRID VIEW");
                tampildataGrid();
                break;
            case R.id.menu_night:
                setTitle("MODE Night VIEW");
                int nightmode = AppCompatDelegate.getDefaultNightMode();
                if (nightmode==AppCompatDelegate.MODE_NIGHT_YES){
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
                }else{
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
                }
                recreate();
                break;
            case R.id.menu_help:
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel : 62711376400"));


        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        outState.putInt(State_Mode, nView);

        super.onSaveInstanceState(outState);
    }
}