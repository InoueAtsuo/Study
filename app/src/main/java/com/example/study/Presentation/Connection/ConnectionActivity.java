package com.example.study.Presentation.Connection;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

import com.example.study.R;

public class ConnectionActivity extends AppCompatActivity implements ConnectionFragment.ConnectionFragmentListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.connection_activity);

        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.commit();
    }

    @Override
    public void onCickConnection() {
        finish();
    }
}
