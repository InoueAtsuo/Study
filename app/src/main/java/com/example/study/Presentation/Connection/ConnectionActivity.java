package com.example.study.Presentation.Connection;

import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

import com.example.study.Presentation.Common.ParentActivity;
import com.example.study.Process.SerchZipInfo;
import com.example.study.R;

/**
 * ConnectionActivity
 *   Http通信
 *   非同期連携
 *
 *   業務用アプリではHttp通信での処理は必須です。
 *   Http通信は非同期連携で実施する必要があります。
 */
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

    /**
     * 郵便番号検索
     *
     * @param zipCode 郵便番号
     */
    @Override
    public void searchZipCode(String zipCode) {
        // 郵便番号検索を非同期で呼び出し
        new SerchZipInfo(this, zipCode).execute();
    }

    /**
     * 郵便番号住所情報表示
     *
     * @param zipInfoStr 郵便番号住所情報
     */
    public void showZipInfo (String zipInfoStr) {
        mFragment.showZipInfo(zipInfoStr);
    }
}
