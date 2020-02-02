package com.example.study.Process;

import android.app.Activity;
import android.os.AsyncTask;

import com.example.study.Common.Kbn;
import com.example.study.Presentation.Recycle.RecycleActivity;
import com.example.study.Presentation.Recycle.RecycleItemDto;

import java.util.ArrayList;
import java.util.List;

public class SearchUserInfo extends AsyncTask<String, Void, String> {

    private Activity mActivity;
    private int mNum;

    public SearchUserInfo(Activity activity, int num) {
        this.mActivity = activity;
        this.mNum = num;
    }

    @Override
    protected String doInBackground(String... params) {
        return String.valueOf(mNum);
    }

    @Override
    protected void onPostExecute(String value) {

        int num = Integer.valueOf(value);

        List<RecycleItemDto> itemDtoList = new ArrayList<>();

        if (num < 30) {
            for (int i = 0; i < 10; i++) {
                RecycleItemDto itemDto = new RecycleItemDto();
                String str = String.valueOf(num);
                itemDto.setFamilyName("a" + str);
                itemDto.setFirstName("b" + str);
                if (num % 2 == 0) {
                    itemDto.setSex(Kbn.SEX.SEX_MAN);
                } else {
                    itemDto.setSex(Kbn.SEX.SEX_WOMAN);
                }
                itemDtoList.add(itemDto);
                num++;
            }
        }

        if (mActivity.getClass().equals(RecycleActivity.class)) {
            RecycleActivity activity = (RecycleActivity) mActivity;
            activity.addUserInfo(itemDtoList);
        }
    }
}
