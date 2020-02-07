package com.example.study.Presentation.Text;

import android.os.Bundle;

import androidx.fragment.app.FragmentTransaction;

import com.example.study.Presentation.Common.ParentActivity;
import com.example.study.R;

public class TextActivity extends ParentActivity implements TextFragment.TextFragmentListener {

    private TextFragment mFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.text_activity);

        mFragment = TextFragment.newInstance();
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.add(R.id.text_fragment, mFragment);
        transaction.commit();

        super.setHeaderTextView(R.string.explanation_text);
        super.setButtonReturnView();
    }
}
