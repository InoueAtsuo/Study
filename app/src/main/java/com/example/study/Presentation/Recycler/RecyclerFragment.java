package com.example.study.Presentation.Recycler;


import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.study.Presentation.Common.ParentFragment;
import com.example.study.R;

import java.util.List;

/**
 * RecyclerFragment
 *   リストデータを画面表示するRecyclerViewの説明
 */
public class RecyclerFragment extends ParentFragment {

    private RecyclerView mRecyclerView = null;
    private RecyclerAdapter mAdapter = null;
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

    public static RecyclerFragment newInstance() {
        return new RecyclerFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.recycler_fragment, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mRecyclerView = view.findViewById(R.id.recycler_view);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        // リサイクル表示時に枠線を追加
        RecyclerView.ItemDecoration itemDecoration = new DividerItemDecoration(getActivity(), DividerItemDecoration.VERTICAL);
        mRecyclerView.addItemDecoration(itemDecoration);

        // リサイクル表示するAdapterを指定
        mAdapter = new RecyclerAdapter();
        mRecyclerView.setAdapter(mAdapter);

        // スクロール判定
        mRecyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);

                // 一番下まで来た際の判定
                if (!recyclerView.canScrollVertically(1)) {
                    // 追加データ検索
                    searchUser();
                }
            }
        });

        // 初期データ検索
        searchUser();
    }

    /**
     * データ検索
     */
    private void searchUser() {
        // ロード中は、追加検索をしない
        if (!mLoading) {

            // ロード中をtrueに設定
            mLoading = true;

            // Loading表示を追加
            mAdapter.addLoading();

            // ユーザ情報初期検索
            mListener.searchMoreUser();
        }
    }

    /**
     * 追加情報表示
     *
     * @param itemDtoList
     */
    public void addUserInfo(List<UserItemDto> itemDtoList) {

        // Loading表示を削除
        mAdapter.removeLoading();

        if (itemDtoList != null && !itemDtoList.isEmpty()) {
            // ユーザ情報を表示
            mAdapter.addUserInfo(itemDtoList);
        }

        // ロード中をfalseに設定
        mLoading = false;
    }
}
