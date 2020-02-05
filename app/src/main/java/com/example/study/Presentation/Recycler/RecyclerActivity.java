package com.example.study.Presentation.Recycler;

import android.os.Bundle;

import com.example.study.Presentation.Common.ParentActivity;
import com.example.study.Process.SearchUserInfo;
import com.example.study.R;

import java.util.List;

import androidx.fragment.app.FragmentTransaction;

public class RecyclerActivity extends ParentActivity implements RecyclerFragment.RecycleFragmentListener {

    private RecyclerFragment mFragment;

    private int mNum = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recycler_activity);

        mFragment = new RecyclerFragment();
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.add(R.id.recycle_fragment, mFragment);
        transaction.commit();

        super.setHeaderTextView(R.string.explanation_recycle);
        super.setButtonReturnView();

        new SearchUserInfo(this, mNum).execute();
    }

    public void addUserInfo(List<UserItemDto> itemDtoList) {
        mFragment.addUserInfo(itemDtoList);
        mNum = mNum + itemDtoList.size();
    }

    @Override
    public void searchMoreUser() {
        new SearchUserInfo(this, mNum).execute();
    }
}
