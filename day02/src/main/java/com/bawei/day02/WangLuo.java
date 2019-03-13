package com.bawei.day02;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * @Author：魏恒炜
 * @E-mail：
 * @Date：2019/3/13 19:03
 * @Description：描述信息
 */
public class WangLuo {
//    public interface getsas {
//        void getsa(String s);
//    }
//
//    public static void getasd(String sd, final getsas gets) {
//        new AsyncTask<String, Void, String>() {
//
//            @Override
//            protected String doInBackground(String... strings) {
//                return qing(strings[0]);
//            }
//
//            @Override
//            protected void onPostExecute(String s) {
//                super.onPostExecute(s);
//                gets.getsa(s);
//            }
//        }.execute(sd);
//    }
    public interface getda {
        void getdaa(String s);
    }

    public static void dasfw(final String sf, final getda get) {
        new AsyncTask<String, Void, String>() {

            @Override
            protected String doInBackground(String... strings) {
                return qing(strings[0]);
            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                get.getdaa(s);
            }
        }.execute(sf);
    }

    public static boolean pan(Context context) {
        if (context != null) {
            ConnectivityManager manager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);

            NetworkInfo info = manager.getActiveNetworkInfo();
            if (info != null) {
                return info.isAvailable();
            }
        }

        return false;
    }

    public static String qing(String ds) {
        try {
            URL url = new URL(ds);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setConnectTimeout(5000);
            connection.setReadTimeout(5000);
            connection.setRequestMethod("GET");
            if (connection.getResponseCode() == 200) {
                InputStream inputStream = connection.getInputStream();
                InputStreamReader streamReader = new InputStreamReader(inputStream);
                BufferedReader reader = new BufferedReader(streamReader);


                StringBuffer buffer = new StringBuffer();
                String sfd = "";
                while ((sfd = reader.readLine()) != null) {
                    buffer.append(sfd);
                }
                return buffer.toString();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }
}
