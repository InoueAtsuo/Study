package com.example.study.Presentation.Recycler;

import android.os.Bundle;

import com.example.study.Presentation.Common.ParentActivity;
import com.example.study.Process.SearchUserInfo;
import com.example.study.R;

import java.util.List;

import androidx.fragment.app.FragmentTransaction;

/**
 * RecyclerActivity
 *   リストデータを画面表示するRecyclerViewの説明
 *
 *   履歴一覧、SNSでの会話一覧などアプリで一覧表示することは多くあります。
 *   Android端末は画像サイズの問題から、1画面中に全データ表示できないことも多いです。
 *   その際にRecyclerViewを利用すれば、表示可能になります。
 *   少し癖が強いですが、非常に重要な機能です。
 */
public class RecyclerActivity extends ParentActivity implements RecyclerFragment.RecycleFragmentListener {

    private RecyclerFragment mFragment;

    private int mNum = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recycler_activity);

        mFragment = RecyclerFragment.newInstance();
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.add(R.id.recycle_fragment, mFragment);
        transaction.commit();

        super.setHeaderTextView(R.string.explanation_recycle);
        super.setButtonReturnView();
    }

    @Override
    public void searchMoreUser() {
        // ユーザ情報検索
        new SearchUserInfo(this, mNum).execute();
    }

    // ユーザ情報追加
    public void addUserInfo(List<UserItemDto> itemDtoList) {
        mFragment.addUserInfo(itemDtoList);
        mNum = mNum + itemDtoList.size();
    }
}
