package com.example.study.Presentation.Text;

import android.os.Bundle;

import androidx.fragment.app.FragmentTransaction;

import com.example.study.Presentation.Common.ParentActivity;
import com.example.study.R;

/**
 * TextActibity
 *   多言語対応でのテキスト表示
 *
 *   Androidは多言語対応がされており、Android端末の言語に応じて、テキスト表示が切り変わります。
 *   アプリを海外展開する場合などに必須です。
 *
 *   以下のディレクトリにそれぞれstrings.xmlを配置
 *     src/main/res/values-ja
 *     src/main/res/values
 */
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
