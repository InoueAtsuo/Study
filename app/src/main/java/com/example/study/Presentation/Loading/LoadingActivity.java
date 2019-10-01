package com.example.study.Presentation.Loading;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

import com.example.study.R;

public class LoadingActivity extends AppCompatActivity implements LoadingFragment.LoadingFragmentListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.loading_activity);

        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.commit();
    }

    @Override
    public void onCickReturn() {
        finish();
    }
}
