package com.zjh.administrat.zhaojunhui1211.util;

import android.annotation.SuppressLint;
import android.os.AsyncTask;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class OkHttpUtil {

    public static interface CallBack<T>{
        void OnSuccess(T data);
    }

    @SuppressLint("StaticFieldLeak")
    public static void getRequest(final String url, final Class clazz, final CallBack callBack){
        new AsyncTask<String, Void, Object>(){
            @Override
            protected Object doInBackground(String... strings) {
                return getRequest(strings[0],clazz);
            }

            @Override
            protected void onPostExecute(Object o) {
                callBack.OnSuccess(o);
            }
        }.execute(url);
    }

    public static <T> T getRequest(String url, Class clazz){
        return (T) new Gson().fromJson(getRequest(url),clazz);
    }

    public static String getRequest(String url){
        String result = "";
        try {
            URL url1 = new URL(url);
            HttpURLConnection urlConnection = (HttpURLConnection) url1.openConnection();
            urlConnection.setRequestMethod("GET");
            urlConnection.setConnectTimeout(5000);
            urlConnection.setReadTimeout(5000);
            if (urlConnection.getResponseCode() == 200){
                result = stream2String(urlConnection.getInputStream());
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    private static String stream2String(InputStream inputStream) throws IOException {
        StringBuilder stringBuilder = new StringBuilder();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        for (String temp = bufferedReader.readLine(); temp != null; temp = bufferedReader.readLine()){
            stringBuilder.append(temp);
        }
        return stringBuilder.toString();
    }


}
