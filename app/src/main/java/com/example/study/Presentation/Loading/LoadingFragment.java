package com.example.study.Presentation.Loading;


import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.study.R;

public class LoadingFragment extends Fragment {

    public interface LoadingFragmentListener {
        void onCickReturn();
    };

    private LoadingFragmentListener mListener = null;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof LoadingFragmentListener) {
            mListener = (LoadingFragmentListener) context;
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    private Button buttonReturn;

    public static LoadingFragment newInstance() {
        return new LoadingFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.loading_fragment, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        buttonReturn = view.findViewById(R.id.button_return);
        buttonReturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mListener.onCickReturn();
            }
        });
    }
}
