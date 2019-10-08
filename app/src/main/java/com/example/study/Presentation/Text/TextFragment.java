package com.example.study.Presentation.Text;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;

import android.text.Html;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
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
    private TextView textColor1;
    private TextView textColor2;

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
        textColor1 = view.findViewById(R.id.text_color_1);
        textColor2 = view.findViewById(R.id.text_color_2);

        bookZero.setText(getResources().getQuantityString(R.plurals.plural_book, 0, 0));
        bookOne.setText(getResources().getQuantityString(R.plurals.plural_book, 1, 1));
        bookOther.setText(getResources().getQuantityString(R.plurals.plural_book, 2,2));

        // textの一部をHTML表示で文字色変換
        String text1 = getResources().getString(R.string.text_color_1);
        text1 = text1.replace("Color", "<font color=\"red\">"+"Color"+"</font>");
        textColor1.setText(Html.fromHtml(text1));

        // textの一部をSpannableStringBuilderで文字色変換
        //  この方法は文字色だけでなく、文字の大きさなどスタイルを自由に設定可能です。
        String text2 = getResources().getString(R.string.text_color_2);
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(text2);
        spannableStringBuilder.setSpan(new ForegroundColorSpan(Color.RED), 4, 9, 0);
        textColor2.setText(spannableStringBuilder.subSequence(0, spannableStringBuilder.length()));
    }
}
