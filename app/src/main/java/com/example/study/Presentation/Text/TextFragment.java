package com.example.study.Presentation.Text;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.study.Presentation.Common.ParentFragment;
import com.example.study.R;

public class TextFragment extends ParentFragment {

    public interface TextFragmentListener {

    };

    private TextFragmentListener mListener = null;
    private TextView bookZero;
    private TextView bookOne;
    private TextView bookOther;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof TextFragmentListener) {
            mListener = (TextFragmentListener) context;
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    public static TextFragment newInstance() {
        return new TextFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.text_fragment, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        bookZero = view.findViewById(R.id.book_zero);
        bookOne = view.findViewById(R.id.book_one);
        bookOther = view.findViewById(R.id.book_other);

        bookZero.setText(getResources().getQuantityString(R.plurals.plural_book, 0, 0));
        bookOne.setText(getResources().getQuantityString(R.plurals.plural_book, 1, 1));
        bookOther.setText(getResources().getQuantityString(R.plurals.plural_book, 2,2));
    }
}
