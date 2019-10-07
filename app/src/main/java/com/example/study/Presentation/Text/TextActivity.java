package com.example.study.Presentation.Text;

import android.os.Bundle;

import androidx.fragment.app.FragmentTransaction;

import com.example.study.Presentation.Common.ParentActivity;
import com.example.study.R;

public class TextActivity extends ParentActivity implements TextFragment.TextFragmentListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.text_activity);

        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.commit();

        super.setHeaderTextView(R.string.explanation_text);
        super.setButtonReturnView();
    }
}
