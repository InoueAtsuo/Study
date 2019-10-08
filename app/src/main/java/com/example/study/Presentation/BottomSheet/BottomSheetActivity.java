package com.example.study.Presentation.BottomSheet;

import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

import com.example.study.Presentation.Common.ParentActivity;
import com.example.study.R;

public class BottomSheetActivity extends ParentActivity implements BottomSheetFragment.BottomSheetFragmentFragmentListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bottom_sheet_activity);

        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.commit();

        super.setHeaderTextView(R.string.explanation_bottom_sheet);
        super.setButtonReturnView();
    }

    @Override
    public void showBottomSheet() {

    }
}
