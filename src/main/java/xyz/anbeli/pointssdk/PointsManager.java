package xyz.anbeli.pointssdk;

import android.os.Handler;
import android.os.Looper;
import android.util.Log;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by anthonylipscomb on 10/8/16.
 */

public class PointsManager {
    private static final String TAG = PointsManager.class.getCanonicalName();
    private static PointsManager pointsManager;

    private PointsManager() {

    }

    public static PointsManager getInstance() {
        if (pointsManager == null) {
            pointsManager = new PointsManager();
        }
        return pointsManager;
    }

    public void search(final String q, final PointsCallback<List<DancerName>> callback) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                String url = "http://wsdc-points.us-west-2.elasticbeanstalk.com/lookup/find";

                try {
                    URL urlObject = new URL(url);
                    HttpURLConnection connection = (HttpURLConnection) urlObject.openConnection();

                    connection.setRequestMethod("POST");

                    connection.setDoOutput(true);
                    String params = "q=" + q;
                    byte[] output = params.getBytes("UTF-8");
                    OutputStream stream = connection.getOutputStream();

                    stream.write(output);
                    stream.close();

                    int responseCode = connection.getResponseCode();
                    Log.d(TAG, "\nSending 'GET' request to URL : " + url);
                    Log.d(TAG, "Response Code : " + responseCode);

                    BufferedReader in = new BufferedReader(
                            new InputStreamReader(connection.getInputStream()));
                    String inputLine;
                    StringBuffer response = new StringBuffer();

                    while ((inputLine = in.readLine()) != null) {
                        response.append(inputLine);
                    }
                    in.close();

                    Log.d(TAG, "Response: " + response);
                    FindResponse findResponse = new Gson().fromJson(response.toString(), FindResponse.class);
                    final ArrayList<DancerName> itemList = new ArrayList<>();
                    Collections.addAll(itemList, findResponse.getNames());

                    new Handler(Looper.getMainLooper()).post(new Runnable() {
                        @Override
                        public void run() {
                            callback.success(itemList);
                        }
                    });
                } catch (final Exception e) {
                    Log.d(PointsManager.class.getCanonicalName(), "search", e);
                    new Handler(Looper.getMainLooper()).post(new Runnable() {
                        @Override
                        public void run() {
                            callback.error(e);
                        }
                    });
                }
            }
        }).start();
    }

    public void getDancer(final int id, final PointsCallback<Dancer> callback) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                String url = "http://wsdc-points.us-west-2.elasticbeanstalk.com/lookup/find";

                try {
                    URL urlObject = new URL(url);
                    HttpURLConnection connection = (HttpURLConnection) urlObject.openConnection();

                    connection.setRequestMethod("POST");

                    connection.setDoOutput(true);
                    String params = "num=" + id;
                    byte[] output = params.getBytes("UTF-8");
                    OutputStream stream = connection.getOutputStream();

                    stream.write(output);
                    stream.close();

                    int responseCode = connection.getResponseCode();
                    Log.d(TAG, "\nSending 'GET' request to URL : " + url);
                    Log.d(TAG, "Response Code : " + responseCode);

                    BufferedReader in = new BufferedReader(
                            new InputStreamReader(connection.getInputStream()));
                    String inputLine;
                    StringBuffer response = new StringBuffer();

                    while ((inputLine = in.readLine()) != null) {
                        response.append(inputLine);
                    }
                    in.close();

                    Log.d(TAG, "Response: " + response);
                    final Dancer dancer = new Gson().fromJson(response.toString(), Dancer.class);

                    new Handler(Looper.getMainLooper()).post(new Runnable() {
                        @Override
                        public void run() {
                            callback.success(dancer);
                        }
                    });
                } catch (final Exception e) {
                    Log.d(PointsManager.class.getCanonicalName(), "search", e);
                    new Handler(Looper.getMainLooper()).post(new Runnable() {
                        @Override
                        public void run() {
                            callback.error(e);
                        }
                    });
                }
            }
        }).start();
    }
}
