package in.co.officevcan.stg1.ovkksapp;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebView;

/**
 * Created by admin on 23-Sep-16.
 */
public class AboutActivity extends AppCompatActivity
{
    Context context;
    WebView webview1;
    protected void onCreate(Bundle savedInstanceSate)
    {
        super.onCreate(savedInstanceSate);
        setContentView(R.layout.activity_about);


        webview1=(WebView)findViewById(R.id.webview1);
        webview1.getSettings().setJavaScriptEnabled(true);

        // uri loding in webview
        webview1.loadUrl("file:///android_asset/about.html");

        context = getApplicationContext();
    }
}
