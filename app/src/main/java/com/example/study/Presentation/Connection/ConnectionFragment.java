package com.example.study.Presentation.Connection;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.study.Presentation.Common.ParentFragment;
import com.example.study.R;

public class ConnectionFragment extends ParentFragment {

    public interface ConnectionFragmentListener {
        void searchZipCode(String str1, String str2);
    };

    private ConnectionFragmentListener mListener = null;
    private EditText zipCode1;
    private EditText zipCode2;
    private Button searchButton;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof ConnectionFragmentListener) {
            mListener = (ConnectionFragmentListener) context;
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    public static ConnectionFragment newInstance() {
        return new ConnectionFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.connection_fragment, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        zipCode1 = view.findViewById(R.id.zip_code1);
        zipCode2 = view.findViewById(R.id.zip_code2);
        searchButton = view.findViewById(R.id.search_button);
        searchButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                String str1 = zipCode1.getText().toString();
                String str2 = zipCode2.getText().toString();
                mListener.searchZipCode(str1, str2);
            }
        });

    }
}
