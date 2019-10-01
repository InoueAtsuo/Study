package com.example.study.Presentation.Common;

import android.content.Context;

import androidx.fragment.app.Fragment;

public class ParentFragment extends Fragment {

    public interface ParentFragmentListener {
        void onClickReturn();
    };

    protected ParentFragmentListener mParentListener;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof ParentFragmentListener) {
            mParentListener = (ParentFragmentListener) context;
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mParentListener = null;
    }
}
