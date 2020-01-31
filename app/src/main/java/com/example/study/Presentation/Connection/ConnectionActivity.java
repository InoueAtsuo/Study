package com.example.study.Presentation.Connection;

import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.text.TextUtils;

import java.util.HashMap;
import java.util.Map;

import com.example.study.Common.Constant;
import com.example.study.Presentation.Common.ParentActivity;
import com.example.study.Process.AsyncHttpRequest;
import com.example.study.R;

public class ConnectionActivity extends ParentActivity implements ConnectionFragment.ConnectionFragmentListener {

    private ConnectionFragment mFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.connection_activity);

        mFragment = new ConnectionFragment();
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.add(R.id.connection_fragment, mFragment);
        transaction.commit();

        super.setHeaderTextView(R.string.explanation_connection);
        super.setButtonReturnView();
    }

    @Override
    public void searchZipCode(String str1, String str2) {
        if (!TextUtils.isEmpty(str1) && !TextUtils.isEmpty(str2)) {
            String zipInfo = str1 + "-" + str2;
            Map<String, String> params = new HashMap<String, String>();
            params.put(Constant.PARAM_ZIP_CODE, zipInfo);
            new AsyncHttpRequest(this, Constant.SEARCH_ZIP_URL, params).execute();
        }
    }

    public void showZipInfo (String zipInfoStr) {
        mFragment.showZipInfo(zipInfoStr);
    }
}
