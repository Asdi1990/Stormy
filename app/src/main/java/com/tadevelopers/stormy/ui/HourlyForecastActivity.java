package com.tadevelopers.stormy.ui;

import android.content.Intent;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.tadevelopers.stormy.R;
import com.tadevelopers.stormy.adapters.HourAdapter;
import com.tadevelopers.stormy.weather.Day;
import com.tadevelopers.stormy.weather.Hour;

import java.util.Arrays;

public class HourlyForecastActivity extends AppCompatActivity {
    private Hour[] mHours;
    RecyclerView mRecyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hourly_forecast);
        Intent intent = getIntent();
        Parcelable[] parcelables = intent.getParcelableArrayExtra(MainActivity.HOURLY_FORECAST);
        mHours = Arrays.copyOf(parcelables,parcelables.length,Hour[].class);
        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerView);

        HourAdapter adapter = new HourAdapter(this,mHours);
        mRecyclerView.setAdapter(adapter);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(layoutManager);

        mRecyclerView.setHasFixedSize(true);

    }
}
