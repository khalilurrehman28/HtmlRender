package com.dupleit.kotlin.htmlre;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class MainActivity extends AppCompatActivity {
    TextView testingId;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        testingId = findViewById(R.id.testingId);
        if (android.os.Build.VERSION.SDK_INT > 9) {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
        }

        String htmlText = "Goku Is Best <img src=\"https://dw9to29mmj727.cloudfront.net/misc/newsletter-naruto3.png\"> Fighter in dbz universe <img src=\"https://www.cadcorp.com/images/uploads/product-images/cadcorp_developer_200x200.png\">";

        testingId.setText(Html.fromHtml(htmlText, new Html.ImageGetter() {

            @Override
            public Drawable getDrawable(String source) {
                //int resourceId = getResources().getIdentifier(source, "drawable",getPackageName());
                //Drawable drawable = getResources().getDrawable(resourceId);
                Drawable drawable = null;
                try {
                    drawable = drawableFromUrl(source);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
                return drawable;
            }
        }, null));


    }

    public static Drawable drawableFromUrl(String url) throws IOException {
        Bitmap x;

        HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();
        connection.connect();
        InputStream input = connection.getInputStream();

        x = BitmapFactory.decodeStream(input);
        return new BitmapDrawable(x);
    }
}
