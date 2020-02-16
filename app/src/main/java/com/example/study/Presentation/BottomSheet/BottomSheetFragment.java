package com.example.study.Presentation.BottomSheet;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.study.Presentation.Common.ParentFragment;
import com.example.study.R;

/**
 * BottomSheetFragment
 *   ボトムシートの表示
 */
public class BottomSheetFragment extends ParentFragment {

    public interface BottomSheetFragmentFragmentListener {
        void showBottomSheet();
        void hideBottomSheet();
    };

    private BottomSheetFragmentFragmentListener mListener = null;
    private Button showBottomSheetButton;
    private Button hideBottomSheetButton;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof BottomSheetFragmentFragmentListener) {
            mListener = (BottomSheetFragmentFragmentListener) context;
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    public static BottomSheetFragment newInstance() {
        return new BottomSheetFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.bottom_sheet_fragment, container, false);
    }

    public void onViewCreated(View view, Bundle savedInstanceState) {
        showBottomSheetButton = view.findViewById(R.id.show_bottom_sheet_button);
        hideBottomSheetButton = view.findViewById(R.id.hide_bottom_sheet_button);

        // ボトムシート表示のクリック処理
        showBottomSheetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mListener.showBottomSheet();
            }
        });

        // ボトムシート非表示のクリック処理
        hideBottomSheetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mListener.hideBottomSheet();
            }
        });
    }
}
