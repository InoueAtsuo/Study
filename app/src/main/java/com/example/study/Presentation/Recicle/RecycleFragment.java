package com.example.study.Presentation.Recicle;


import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

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

    public interface RecycleFragmentListener {

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


        List<RecycleItemDto> itemDtoList = new ArrayList<>();

        for (int i = 0; i < 40; i++) {
            RecycleItemDto itemDto = new RecycleItemDto();
            String str = String.valueOf(i);
            itemDto.setFamilyName("a" + str);
            itemDto.setFirstName("b" + str);
            if (i % 2 == 0) {
                itemDto.setSex(Kbn.SEX.SEX_MAN);
            } else {
                itemDto.setSex(Kbn.SEX.SEX_WOMAN);
            }
            itemDtoList.add(itemDto);
        }

        mAdapter = new RecycleAdapter(itemDtoList);
        mRecyclerView.setAdapter(mAdapter);
    }
}
