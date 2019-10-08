package com.example.study.Presentation.BottomSheet;

import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.widget.LinearLayout;

import com.example.study.Presentation.Common.ParentActivity;
import com.example.study.R;
import com.google.android.material.bottomsheet.BottomSheetBehavior;

public class BottomSheetActivity extends ParentActivity implements BottomSheetFragment.BottomSheetFragmentFragmentListener {

    private LinearLayout bottomSheet;
    private BottomSheetBehavior behavior;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bottom_sheet_activity);

        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.commit();

        super.setHeaderTextView(R.string.explanation_bottom_sheet);
        super.setButtonReturnView();

        bottomSheet = findViewById(R.id.bottom_sheet);
        behavior = BottomSheetBehavior.from(bottomSheet);
    }

    @Override
    public void showBottomSheet() {
        behavior.setState(BottomSheetBehavior.STATE_EXPANDED);
    }
}
