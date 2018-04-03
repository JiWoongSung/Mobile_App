package com.example.jiwoong.homework91;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Handler;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.webkit.JavascriptInterface;
import android.webkit.JsResult;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;

import java.net.URL;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    WebView webView;
    EditText editText;
    LinearLayout linearLayout;
    Animation anim1;
    ListView listView;
    ArrayList<UrlData> urlData = new ArrayList<UrlData>();
    Adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        listView=(ListView)findViewById(R.id.listview);
        linearLayout=(LinearLayout)findViewById(R.id.linearLayout);
        editText = (EditText) findViewById(R.id.editText);
        webView = (WebView) findViewById(R.id.webview);
        webView.getSettings().setJavaScriptEnabled(true); //웹뷰에서 자바스크립트 실행 가능하게 하기
        webView.addJavascriptInterface(new JavaScriptMethods() ,"myApp" ); //웹뷰에서 브릿지 연결
        adapter = new Adapter(urlData);



        //final ArrayAdapter adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, urlData);

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() { //짧은클릭
            @Override
            public void onItemClick(AdapterView<?> parent, final View view,final int position, long id) {
                linearLayout.setVisibility(View.VISIBLE);
                webView.setVisibility(View.VISIBLE);
                listView.setVisibility(View.GONE);
                webView.loadUrl("http://"+urlData.get(position).getAddress());

            }
        });


        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(final AdapterView<?> parent, final View view, final int position, long id) {  //롱클릭으로 삭제

                AlertDialog.Builder dlg = new AlertDialog.Builder(MainActivity.this);
                dlg.setTitle("삭제확인");
                // dlg.setIcon(R.drawable.a);
                dlg.setMessage("선택한 주소를 정말 삭제하시겠습니까?");
                dlg.setNegativeButton("취소", null);
                dlg.setPositiveButton("삭제", new DialogInterface.OnClickListener() {
                    @Override
                    //리스트 삭제
                    public void onClick(DialogInterface dialog, int which) {
                        adapter.removeItem(position);

                    }
                });
                dlg.show();
                return true;
            }
        });




        webView.setWebViewClient(new WebViewClient() {



            @Override
            public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
                return super.shouldOverrideUrlLoading(view, request);
            }
        });

        webView.loadUrl("http://www.naver.com");



        webView.setWebViewClient(new WebViewClient() {  //새로운 URL로드
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
                return super.shouldOverrideUrlLoading(view, request);
            }

            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
                editText.setText(url);
            }
        });


        webView.setWebChromeClient(new WebChromeClient() {
            @Override
            public void onProgressChanged(WebView view, int newProgress) {
                super.onProgressChanged(view, newProgress);
            }

            @Override
            public boolean onJsAlert(WebView view, String url, String message, JsResult result) {
                result.confirm();
                return super.onJsAlert(view, url, message, result);
            }
        });


        final ProgressDialog dialog; // loading 대화상자
        dialog = new ProgressDialog(this);

        webView.setWebViewClient(new WebViewClient() {
            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                super.onPageStarted(view, url, favicon);
                dialog.setMessage("Loading...");
                dialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
                dialog.show();
            }

        });


        webView.setWebChromeClient(new WebChromeClient() {
            @Override
            public void onProgressChanged(WebView view, int newProgress) {
                super.onProgressChanged(view, newProgress);
                if (newProgress >= 100) dialog.dismiss();
            }

        });



    }


    public void onClick(View v){

        if(v.getId()==R.id.gobutton){
            webView.loadUrl("http://"+editText.getText());

        }

    }




    public boolean onCreateOptionsMenu(Menu menu) {    //즐겨찾기 메뉴

        menu.add(0,1,0 ,"즐겨찾기추가");
        menu.add(0,2,0 ,"즐겨찾기목록");

        return super.onCreateOptionsMenu(menu);
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId() == 1){  //즐겨찾기 추가했을때
            linearLayout.setVisibility(View.VISIBLE);
            webView.setVisibility(View.VISIBLE);
            listView.setVisibility(View.GONE);

            webView.loadUrl("file:///android_asset/urladd.html");
            anim1 = AnimationUtils.loadAnimation(this, R.anim.translate_top);
            anim1.setAnimationListener(new Animation.AnimationListener() {
                @Override
                public void onAnimationStart(Animation animation) {

                }

                @Override
                public void onAnimationEnd(Animation animation) {
                    linearLayout.setVisibility(View.GONE);
                }

                @Override
                public void onAnimationRepeat(Animation animation) {

                }
            });
            linearLayout.setAnimation(anim1);
            anim1.start();

        }

        else if(item.getItemId() == 2){
            linearLayout.setVisibility(View.GONE);
            webView.setVisibility(View.GONE);
            listView.setVisibility(View.VISIBLE);


        }

        return super.onOptionsItemSelected(item);
    }


    private final Handler handler = new Handler();

    private class JavaScriptMethods {

        JavaScriptMethods() {}

        @JavascriptInterface
        public void viewurl() { // must be final

            handler.post(new Runnable() {

                @Override

                public void run() {

                    linearLayout.setVisibility(View.VISIBLE);

                }

            });

        }

        @JavascriptInterface
        public void listadd(final String sitename, final String url) {

            handler.post(new Runnable() {
                @Override
                public void run() {

                    if(adapter.getCount()==0){
                        adapter.addItem(url,sitename);
                        Toast.makeText(getApplicationContext(), "목록이 추가되었습니다"  , Toast.LENGTH_SHORT).show();
                        webView.loadUrl("javascript: blank()");
                    }
                    else {
                        if(!adapter.findItem(url)){
                            adapter.addItem(url,sitename);
                            Toast.makeText(getApplicationContext(), "목록이 추가되었습니다" , Toast.LENGTH_SHORT).show();
                            webView.loadUrl("javascript: blank()");
                        }
                        else{
                            webView.loadUrl("javascript: displayMsg()");
                        }

                    }

                }

            });

        }






    }






}


