package com.example.study.Presentation.Image;

import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;

import com.example.study.Common.Constant;
import com.example.study.Presentation.Common.ParentActivity;
import com.example.study.R;

/**
 * ImageActivity
 *   イメージ表示
 *   カメラ撮影も実施
 *
 *   ・画像表示方法1
 *   イメージ画像をあらかじめアプリに保存して表示する。
 *     画像ファイルはAndroid端末の解像度に応じて複数用意します。
 *     アイコンなどの表示によく利用されます。
 *
 *   ・画像表示方法2
 *   イメージ画像をhttpリクエストから取得する。
 *     画像ファイルデータをBase64で変換された文字列で取得します。
 *     それをBase64で画像に戻して、画面に表示します。
 *     画像投稿可能なアプリでよく利用されます。
 *
 *   ・画像表示方法3
 *     カメラ撮影する。
 *     Androidのカメラ機能を用いて撮影します。
 *     撮影された画像を表示します。
 *     SNSなどでよく利用されます。
 *
 *   注)ほかにもあります。
 */
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

    /**
     * カメラクリック時の処理
     */
    @Override
    public void clickCamera() {
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if (intent.resolveActivity(getPackageManager()) != null) {
            // カメラ処理を呼び出し
            //   リザルトコードにカメラを指定
            startActivityForResult(intent, Constant.RESULT_CAMERA);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent intent) {
        super.onActivityResult(requestCode, resultCode, intent);

        // リザルトコードがカメラの場合
        if (requestCode == Constant.RESULT_CAMERA) {
            if (intent.getExtras() != null) {
                // データからBitmap画像を取得
                Bitmap bitmap = (Bitmap) intent.getExtras().get("data");
                mFragment.setCameraData(bitmap);
            }
        }
    }
}
