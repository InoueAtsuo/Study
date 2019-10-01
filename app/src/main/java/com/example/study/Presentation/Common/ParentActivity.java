package com.example.study.Presentation.Common;

import androidx.appcompat.app.AppCompatActivity;

public class ParentActivity extends AppCompatActivity implements ParentFragment.ParentFragmentListener {

    @Override
    public void onClickReturn() {
        finish();
    }
}
