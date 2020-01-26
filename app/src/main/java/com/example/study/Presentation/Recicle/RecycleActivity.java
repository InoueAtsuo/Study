package com.example.study.Presentation.Recicle;

import android.os.Bundle;

import com.example.study.Presentation.Common.ParentActivity;
import com.example.study.R;

import androidx.fragment.app.FragmentTransaction;

public class RecycleActivity extends ParentActivity implements RecycleFragment.RecycleFragmentListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recycle_activity);

        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.commit();

        super.setHeaderTextView(R.string.explanation_recycle);
        super.setButtonReturnView();
    }
}
