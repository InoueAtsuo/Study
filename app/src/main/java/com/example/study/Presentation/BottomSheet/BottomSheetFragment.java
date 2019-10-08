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

public class BottomSheetFragment extends ParentFragment {

    public interface BottomSheetFragmentFragmentListener {
        void showBottomSheet();
    };

    private BottomSheetFragmentFragmentListener mListener = null;
    private Button showBottomSheet_button;

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
        showBottomSheet_button = view.findViewById(R.id.show_bottom_sheet_button);
        showBottomSheet_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mListener.showBottomSheet();
            }
        });
    }
}
