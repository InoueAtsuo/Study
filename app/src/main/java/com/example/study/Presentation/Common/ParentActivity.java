package com.example.study.Presentation.Common;

import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.study.R;

import androidx.appcompat.app.AppCompatActivity;

public class ParentActivity extends AppCompatActivity {

    private TextView headerText = null;
    private Button returnButton = null;

    protected void setHeaderTextView(int text) {
        headerText = findViewById(R.id.header_text);
        if (headerText != null) {
            headerText.setText(text);
        }
    }

    // 戻るボタン押下事
    protected void setButtonReturnView() {
        returnButton = findViewById(R.id.return_button);
        if (returnButton != null) {
            returnButton.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View view) {
                    // fininshで画面を閉じる
                    finish();
                }
            });
        }
    }
}
