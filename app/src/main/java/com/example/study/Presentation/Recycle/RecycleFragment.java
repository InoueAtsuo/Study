package com.example.study.Presentation.Recycle;


import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.study.Common.Kbn;
import com.example.study.Presentation.Common.ParentFragment;
import com.example.study.R;

import java.util.ArrayList;
import java.util.List;

public class RecycleFragment extends ParentFragment {

    private RecyclerView mRecyclerView = null;
    private RecycleAdapter mAdapter = null;
    private boolean mLoading = false;

    public interface RecycleFragmentListener {
        void searchMoreUser();
    };

    private RecycleFragmentListener mListener = null;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof RecycleFragmentListener) {
            mListener = (RecycleFragmentListener) context;
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    public static RecycleFragment newInstance() {
        return new RecycleFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.recycle_fragment, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        mRecyclerView = view.findViewById(R.id.recycler_view);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        RecyclerView.ItemDecoration itemDecoration = new DividerItemDecoration(getActivity(), DividerItemDecoration.VERTICAL);
        mRecyclerView.addItemDecoration(itemDecoration);

        mAdapter = new RecycleAdapter();
        mRecyclerView.setAdapter(mAdapter);

        // スクロール判定
        mRecyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);

                // 一番下まで来た際の判定
                if (!recyclerView.canScrollVertically(1)) {
                    if (!mLoading) {
                        mLoading = true;

                        // 追加でユーザ情報を検索
                        mListener.searchMoreUser();
                    }
                }
            }
        });
    }

    public void addUserInfo(List<RecycleItemDto> itemDtoList) {
        mAdapter.addUserInfo(itemDtoList);
        mLoading = false;
    }
}
