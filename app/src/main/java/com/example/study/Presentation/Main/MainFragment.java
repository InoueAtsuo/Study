package com.example.study.Presentation.Main;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.study.R;

public class MainFragment extends Fragment {

    public interface MainFragmentListener {
        void onClickConnection();
        void onClickLoading();
    };

    private MainFragmentListener mListener;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof MainFragmentListener) {
            mListener = (MainFragmentListener) context;
        }
    }
    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    private Button moveConnection;
    private Button moveLoading;

    public static MainFragment newInstance() {
        return new MainFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        return inflater.inflate(R.layout.main_fragment, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        moveConnection = view.findViewById(R.id.move_connection);
        moveLoading = view.findViewById(R.id.move_loading);

        moveConnection.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mListener.onClickConnection();
            }
        });

        moveLoading.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mListener.onClickLoading();
            }
        });
    }
}
