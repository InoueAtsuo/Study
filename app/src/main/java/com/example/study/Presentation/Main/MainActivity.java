package com.example.study.Presentation.Main;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;

import com.example.study.Presentation.BottomSheet.BottomSheetActivity;
import com.example.study.Presentation.Connection.ConnectionActivity;
import com.example.study.Presentation.Loading.LoadingActivity;
import com.example.study.Presentation.Text.TextActivity;
import com.example.study.R;

public class MainActivity extends AppCompatActivity implements MainFragment.MainFragmentListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);

        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.commit();
    }

    @Override
    public void onClickBottomSheet() {
        Intent intent = new Intent(MainActivity.this, BottomSheetActivity.class);
        startActivity(intent);
    }

    @Override
    public void onClickConnection() {
        Intent intent = new Intent(MainActivity.this, ConnectionActivity.class);
        startActivity(intent);
    }

    @Override
    public void onClickLoading() {
        Intent intent = new Intent(MainActivity.this, LoadingActivity.class);
        startActivity(intent);
    }

    @Override
    public void onClickText() {
        Intent intent = new Intent(MainActivity.this, TextActivity.class);
        startActivity(intent);
    }
}
