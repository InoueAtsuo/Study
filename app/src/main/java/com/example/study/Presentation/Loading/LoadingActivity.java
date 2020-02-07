package com.example.study.Presentation.Loading;

import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

import com.example.study.Presentation.Common.ParentActivity;
import com.example.study.R;

public class LoadingActivity extends ParentActivity implements LoadingFragment.LoadingFragmentListener {

    private LoadingFragment mFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.loading_activity);

        mFragment = LoadingFragment.newInstance();
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.add(R.id.loading_fragment, mFragment);
        transaction.commit();

        super.setHeaderTextView(R.string.explanation_loading);
        super.setButtonReturnView();
    }
}
