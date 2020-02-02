package com.example.study.Presentation.Recycle;

import android.os.Bundle;

import com.example.study.Presentation.Common.ParentActivity;
import com.example.study.Process.SearchUserInfo;
import com.example.study.R;

import java.util.List;

import androidx.fragment.app.FragmentTransaction;

public class RecycleActivity extends ParentActivity implements RecycleFragment.RecycleFragmentListener {

    private RecycleFragment mFragment;

    private int mNum = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recycle_activity);

        mFragment = new RecycleFragment();
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.add(R.id.recycle_fragment, mFragment);
        transaction.commit();

        super.setHeaderTextView(R.string.explanation_recycle);
        super.setButtonReturnView();

        new SearchUserInfo(this, mNum).execute();
    }

    public void addUserInfo(List<RecycleItemDto> itemDtoList) {
        mFragment.addUserInfo(itemDtoList);
        mNum = mNum + itemDtoList.size();
    }
}
