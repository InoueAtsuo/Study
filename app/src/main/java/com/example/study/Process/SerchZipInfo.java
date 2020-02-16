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

/**
 * Http通信での郵便番号検索
 *   スマホアプリのHttp通信では、レスポンスにjsonデータが来ます。
 *   リクエスト送信してレスポンスjsonを解析します。
 *
 *   通常ならAPIサーバにHttp通信を行いますが、
 *   ここではフリーで公開されている郵便番号検索のリクエストで確認します。
 */
public class SerchZipInfo extends AsyncTask<String, Void, String> {

    private Activity mActivity;
    private String mZipCode;

    public SerchZipInfo(Activity activity, String zipCode) {
        mActivity = activity;
        mZipCode = zipCode;
    }

    /**
     * 非同期処理
     *
     * @param params パラメータ
     * @return 検索結果
     */
    @Override
    protected String doInBackground(String... params) {

        // ここではHttpURLConnectionを持いてリクエスト送信をします。
        // ほかにも方法はありますが、今回はこれで行きます。
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

    /**
     * 非同期連携の終了後の処理
     *
     * @param value レスポンスのjson文字列
     */
    @Override
    protected void onPostExecute(String value) {

        String zipInfoStr = "";
        try {
            // JSONObjectを利用して、jsonから郵便番号の住所情報を取得
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

        // Activityの郵便番号住所情報表示を呼び出し
        if (mActivity.getClass().equals(ConnectionActivity.class)) {
            ConnectionActivity activity = (ConnectionActivity) mActivity;
            activity.showZipInfo(zipInfoStr);
        }
    }
}
