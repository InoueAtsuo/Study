package com.example.study.Presentation.Common;

import android.view.View;
import android.widget.Button;

import com.example.study.R;

import androidx.appcompat.app.AppCompatActivity;

public class ParentActivity extends AppCompatActivity {

    private Button buttonReturn;

    protected void setButtonReturnView() {
        buttonReturn = findViewById(R.id.button_return);
        if (buttonReturn != null) {
            buttonReturn.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View view) {
                    finish();
                }
            });
        }
    }
}
