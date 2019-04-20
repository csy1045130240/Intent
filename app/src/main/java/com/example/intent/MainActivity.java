package com.example.intent;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private Button btn_go;
    private EditText et_url;
    private String urlHead="https://";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView(){
        btn_go=(Button) findViewById(R.id.btn_go);
        et_url=(EditText) findViewById(R.id.et_url);
        btn_go.setOnClickListener(this);
    }

    @Override
    public void onClick(View view){
        switch (view.getId()){
            case R.id.btn_go:
                Intent intent=new Intent();
                intent.setAction("android.intent.action.VIEW");
                intent.putExtra("uri",et_url.getText().toString());
                //intent.setClass(MainActivity.this, MyWebView.class);
                Intent choose=Intent.createChooser(intent,"选择一个浏览器");
                startActivity(choose);
                break;

        }
    }
}
