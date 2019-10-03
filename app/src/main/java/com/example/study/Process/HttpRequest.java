package com.example.study.Process;

import android.net.Uri;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class HttpRequest {

    private static final String SEARCH_ZIP_URL = "http://zipcloud.ibsnet.co.jp/api/search";
    private static final String PARAM_ZIP_CODE = "zipcode";

    public String serarchZipCode(String zipCode) {
        try {
            Uri.Builder builder = new Uri.Builder();
            builder.appendQueryParameter(PARAM_ZIP_CODE, zipCode);
            URL url = new URL(SEARCH_ZIP_URL + builder.toString());
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();

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
                String st = stream.toString();
                return st;
            }

        } catch (Exception e) {

        }

        return null;
    }
}
