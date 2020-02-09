package com.example.study.Presentation.Image;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Environment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import com.example.study.Common.ImageUtils;
import com.example.study.Presentation.Common.ParentFragment;
import com.example.study.R;

import java.io.File;

public class ImageFragment extends ParentFragment {

    private ImageView mImage2;
    private ImageView mImage3;
    private ImageView mImage4;
    private Button mCamera;

    public interface ImageFragmentListener {
        void clickCamera();
    };

    private ImageFragmentListener mListener = null;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof ImageFragmentListener) {
            mListener = (ImageFragmentListener) context;
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    public static ImageFragment newInstance() {
        return new ImageFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.image_fragment, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        mImage2 = view.findViewById(R.id.image2);
        mImage3 = view.findViewById(R.id.image3);
        mImage4 = view.findViewById(R.id.image4);
        mCamera = view.findViewById(R.id.camera_button);

        mCamera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mListener.clickCamera();
            }
        });

        mImage2.setImageResource(R.mipmap.image_android);

        String image3Str = "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";
        Bitmap image3Bitmap = ImageUtils.decodeImage(image3Str);
        mImage3.setImageBitmap(image3Bitmap);
    }

    public void setCameraData(Bitmap bitmap) {
        mImage4.setImageBitmap(bitmap);
    }
}