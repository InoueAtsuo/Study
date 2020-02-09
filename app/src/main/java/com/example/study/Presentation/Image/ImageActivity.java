package com.example.study.Presentation.Image;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;

import com.example.study.Common.Constant;
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

    @Override
    public void clickCamera() {
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivityForResult(intent, Constant.RESULT_CAMERA);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent intent) {
        super.onActivityResult(requestCode, resultCode, intent);
        if (requestCode == Constant.RESULT_CAMERA) {
            if (intent.getExtras() != null) {
                Bitmap bitmap = (Bitmap) intent.getExtras().get("data");
                mFragment.setCameraData(bitmap);
            }
        }
    }
}
