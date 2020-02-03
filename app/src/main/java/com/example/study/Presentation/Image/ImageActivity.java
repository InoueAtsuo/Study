package com.example.study.Presentation.Image;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

import com.example.study.Presentation.Common.ParentActivity;
import com.example.study.R;

public class ImageActivity extends ParentActivity implements ImageFragment.ImageFragmentListener  {

    private ImageFragment mFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.image_activity);

        mFragment = new ImageFragment();
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.add(R.id.image_fragment, mFragment);
        transaction.commit();

        super.setHeaderTextView(R.string.explanation_image);
        super.setButtonReturnView();
    }
}
