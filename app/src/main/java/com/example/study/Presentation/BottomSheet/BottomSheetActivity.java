package com.example.study.Presentation.BottomSheet;

import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import com.example.study.Presentation.Common.ParentActivity;
import com.example.study.R;
import com.google.android.material.bottomsheet.BottomSheetBehavior;

/**
 * BottomSheetActivity
 *   ボトムシートの表示
 *
 *   Androidではボトムシートが標準に備わっています。
 *   それの表示などを説明します。
 */
public class BottomSheetActivity extends ParentActivity implements BottomSheetFragment.BottomSheetFragmentFragmentListener {

    private BottomSheetFragment mFragment;

    private View bottomSheetActivityView;
    private LinearLayout bottomSheet;
    private BottomSheetBehavior behavior;
    private Button bottomSheetButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bottom_sheet_activity);

        mFragment = BottomSheetFragment.newInstance();
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.add(R.id.bottom_sheet_fragment, mFragment);
        transaction.commit();

        super.setHeaderTextView(R.string.explanation_bottom_sheet);
        super.setButtonReturnView();

        // ボトムシート初期設定
        bottomSheet = findViewById(R.id.bottom_sheet);
        behavior = BottomSheetBehavior.from(bottomSheet);
        bottomSheetActivityView = findViewById(R.id.bottom_sheet_activity);

        bottomSheetButton = findViewById(R.id.bottom_sheet_button);
        bottomSheetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                hideBottomSheet();
            }
        });

        // 初期状態は非表示
        //   setStateで状態を変化させられます。
        behavior.setState(BottomSheetBehavior.STATE_HIDDEN);
    }

    // 画面サイズはonCreateでは取得できないので、onWindowFocusChangedで取得
    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        // setPeekHeightでボトムシートの標準の高さを指定します。
        // ボトムシートの高さを画面サイズの2/5に設定
        int displayHeight = bottomSheetActivityView.getHeight();
        int bottomSheetHeight = displayHeight * 2 / 5;
        behavior.setPeekHeight(bottomSheetHeight);
    }

    @Override
    public void expandBottomSheet() {
        // ボトムシートを全表示
        behavior.setState(BottomSheetBehavior.STATE_EXPANDED);
    }

    @Override
    public void showBottomSheet() {
        // ボトムシートを表示
        behavior.setState(BottomSheetBehavior.STATE_COLLAPSED);
    }

    @Override
    public void hideBottomSheet() {
        // ボトムシートを非表示
        behavior.setState(BottomSheetBehavior.STATE_HIDDEN);
    }
}
