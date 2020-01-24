package com.example.study.Process;

import android.app.Activity;
import android.net.Uri;
import android.os.AsyncTask;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;

public class AsyncHttpRequest extends AsyncTask<String, Void, String> {

    private Activity mActivity;
    private String mUrl;
    private Map<String, String> mParams;

    public static final String SEARCH_ZIP_URL = "http://zipcloud.ibsnet.co.jp/api/search";
    public static final String PARAM_ZIP_CODE = "zipcode";

    public AsyncHttpRequest(Activity activity, String url, Map<String, String> params) {
        this.mActivity = activity;
        this.mUrl = url;
        this.mParams = params;
    }

    @Override
    protected String doInBackground(String... params) {
        HttpURLConnection conn = null;
        String value = null;
        try {
            Uri.Builder builder = new Uri.Builder();
            if (mParams != null && !mParams.isEmpty()) {
                for (String key : mParams.keySet()) {
                    builder.appendQueryParameter(key, mParams.get(key));
                }
            }
            URL url = new URL(mUrl + builder.toString());
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
                value = stream.toString();
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

    }
}
