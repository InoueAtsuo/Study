package com.example.study.Presentation.Connection;

import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.text.TextUtils;

import java.util.HashMap;
import java.util.Map;

import com.example.study.Presentation.Common.ParentActivity;
import com.example.study.Process.AsyncHttpRequest;
import com.example.study.R;

public class ConnectionActivity extends ParentActivity implements ConnectionFragment.ConnectionFragmentListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.connection_activity);

        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.commit();

        super.setHeaderTextView(R.string.explanation_connection);
        super.setButtonReturnView();
    }

    @Override
    public void searchZipCode(String str1, String str2) {
        if (!TextUtils.isEmpty(str1) && !TextUtils.isEmpty(str2)) {
            String zipInfo = str1 + "-" + str2;
            Map<String, String> params = new HashMap<String, String>();
            params.put(AsyncHttpRequest.PARAM_ZIP_CODE, zipInfo);
            new AsyncHttpRequest(this, AsyncHttpRequest.SEARCH_ZIP_URL, params).execute();
        }
    }
}
