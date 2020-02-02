package com.example.study.Process;

import android.app.Activity;
import android.net.Uri;
import android.os.AsyncTask;

import com.example.study.Common.Constant;
import com.example.study.Common.StringUtils;
import com.example.study.Presentation.Connection.ConnectionActivity;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class SerchZipInfo extends AsyncTask<String, Void, String> {

    private Activity mActivity;
    private String mZipCode;

    public SerchZipInfo(Activity activity, String zipCode) {
        mActivity = activity;
        mZipCode = zipCode;
    }

    @Override
    protected String doInBackground(String... params) {
        HttpURLConnection conn = null;
        String value = null;
        try {
            Uri.Builder builder = new Uri.Builder();
            builder.appendQueryParameter(Constant.PARAM_ZIP_CODE, mZipCode);
            URL url = new URL(Constant.SEARCH_ZIP_URL + builder.toString());
            conn = (HttpURLConnection) url.openConnection();

            conn.setRequestMethod("GET");
            conn.connect();
            int statusCode = conn.getResponseCode();

            if (statusCode == HttpURLConnection.HTTP_OK) {
                StringBuffer sb = new StringBuffer();
                String line = "";
                InputStream stream = conn.getInputStream();
                BufferedReader br = new BufferedReader(new InputStreamReader(stream, "UTF-8"));
                while ((line = br.readLine()) != null) {
                    sb.append(line);
                }
                stream.close();
                value = sb.toString();
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (conn != null) {
                conn.disconnect();
            }
        }

        return value;
    }

    @Override
    protected void onPostExecute(String value) {

        String zipInfoStr = "";
        try {
            JSONObject json = new JSONObject(value);
            JSONArray results = json.getJSONArray("results");
            if (results.length() > 0) {
                if (results.getJSONObject(0).has("address1")) {
                    zipInfoStr = zipInfoStr + results.getJSONObject(0).getString("address1");
                }
                if (results.getJSONObject(0).has("address2")) {
                    zipInfoStr = zipInfoStr + results.getJSONObject(0).getString("address2");
                }
                if (results.getJSONObject(0).has("address3")) {
                    zipInfoStr = zipInfoStr + results.getJSONObject(0).getString("address3");
                }
            }
        } catch (JSONException e) {

        }

        if (StringUtils.isEmpty(zipInfoStr)) {
            return;
        }
        if (mActivity.getClass().equals(ConnectionActivity.class)) {
            ConnectionActivity activity = (ConnectionActivity) mActivity;
            activity.showZipInfo(zipInfoStr);
        }
    }
}
