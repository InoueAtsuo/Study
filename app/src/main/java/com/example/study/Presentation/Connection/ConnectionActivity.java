package com.example.study.Presentation.Connection;

import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.text.TextUtils;

import com.example.study.Presentation.Common.ParentActivity;
import com.example.study.Process.HttpRequest;
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
            HttpRequest httpRequest = new HttpRequest();
            String zipInfo = httpRequest.serarchZipCode(str1 + "-" + str2);
            boolean a = true;
        }
    }
}
