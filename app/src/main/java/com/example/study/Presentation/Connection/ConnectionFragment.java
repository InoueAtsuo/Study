package com.example.study.Presentation.Connection;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.study.Presentation.Common.ParentFragment;
import com.example.study.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ConnectionFragment extends ParentFragment {

    public interface ConnectionFragmentListener {
        void searchZipCode(String str1, String str2);
    };

    private ConnectionFragmentListener mListener = null;
    private EditText zipCode1;
    private EditText zipCode2;
    private Button searchButton;
    private TextView zipInfo;

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
        zipInfo = view.findViewById(R.id.zip_info);
        searchButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                String str1 = zipCode1.getText().toString();
                String str2 = zipCode2.getText().toString();
                mListener.searchZipCode(str1, str2);
            }
        });
    }

    public void showZipInfo(String zipInfoJson) {
        try {
            JSONObject json = new JSONObject(zipInfoJson);
            JSONArray results = json.getJSONArray("results");
            String zipInfoStr = "";
            if (results.length() > 0) {
                if (results.getJSONObject(0).has("address1")) {
                    zipInfoStr = zipInfoStr + results.getJSONObject(0).getString("address1");
                }
                if (results.getJSONObject(0).has("address2")) {
                    zipInfoStr = zipInfoStr + results.getJSONObject(0).getString("address2");
                }
                if (results.getJSONObject(0).has("address3")) {
                    zipInfoStr = zipInfoStr + results.getJSONObject(0).getString("address3");
                }
            }
            zipInfo.setText(zipInfoStr);
        }
        catch (JSONException e) {

        }
    }
}
