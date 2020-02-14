package com.example.study.Presentation.Connection;

import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.text.TextUtils;

import com.example.study.Presentation.Common.ParentActivity;
import com.example.study.Process.SerchZipInfo;
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
            String zipCode = str1 + "-" + str2;

            // 郵便番号検索を非同期で呼び出し
          new SerchZipInfo(this, zipCode).execute();
        }
    }

    // 郵便番号非同期検索のレスポンス受け取り後の処理
    public void showZipInfo (String zipInfoStr) {
        mFragment.showZipInfo(zipInfoStr);
    }
}
