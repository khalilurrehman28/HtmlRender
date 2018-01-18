package com.dupleit.kotlin.htmlre;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.util.Base64;
import android.util.Log;
import android.webkit.WebView;
import android.widget.TextView;

public class Base64Activity extends AppCompatActivity {

    TextView textView;
    WebView userWebview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base64);
        textView = findViewById(R.id.textView);
        userWebview = findViewById(R.id.userWebview);

        String htmlText = "Goku Is Best <img src=\"data:image/gif;base64,R0lGODlhEAANAPAAAAAAAAAAACH5BAEAAAAALAAAAAAQAA0AAAIfhI+pu+HmXpIBVHtPlnCibHkQCGLdxWlUxLTuC8dJAQA7\">";
        /*textView.setText(Html.fromHtml(htmlText, new Html.ImageGetter() {
            @Override
            public Drawable getDrawable(String source) {
                String base_64_source = source.replaceAll("data:image.*;base64", "");
                //Log.d("userData",base_64_source.trim());

                byte[] data = Base64.decode(base_64_source, Base64.DEFAULT);
                Bitmap bitmap = BitmapFactory.decodeByteArray(data, 0, data.length);
                Drawable image = new BitmapDrawable(getApplicationContext().getResources(), bitmap);

                *//*byte[] data = Base64.decode(base_64_source, Base64.DEFAULT);
                Bitmap bitmap = BitmapFactory.decodeByteArray(data, 0, data.length);
                return new BitmapDrawable(getResources(), bitmap);*//*
                image.setBounds(0, 0, 200, 200);
                return image;
            }
        }, null));*/
        //userWebview.set
        userWebview.loadData(htmlText, "text/html; charset=utf-8", "UTF-8");
    }
}
