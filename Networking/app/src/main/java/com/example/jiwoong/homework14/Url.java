package com.example.jiwoong.homework14;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

public class Url extends AppCompatActivity {

    TextView t1;
    EditText e1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_url);

        t1 = (TextView) findViewById(R.id.textView);
        e1 = (EditText) findViewById(R.id.editText);


    }

    public void onClick(View v) {

        thread.start();


    }

    Handler handler = new Handler();
    Thread thread = new Thread() {
        @Override
        public void run() {
            try {
                String urlstr = e1.getText().toString();

                URL url = new URL(urlstr);
                HttpURLConnection urlConnection =
                        (HttpURLConnection) url.openConnection();
                if (urlConnection.getResponseCode() == HttpURLConnection.HTTP_OK) {
                    final String data = readData(urlConnection.getInputStream());
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            t1.setText(data);
                        }
                    });
                    urlConnection.disconnect();
                }
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }


        }

        private String readData(InputStream inputStream) {

            String data = "";
            Scanner s = new Scanner(inputStream);
            while (s.hasNext()) data += s.nextLine() + "\n";
            s.close();
            return data;

        }


    };
}