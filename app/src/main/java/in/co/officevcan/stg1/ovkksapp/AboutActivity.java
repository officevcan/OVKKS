package in.co.officevcan.stg1.ovkksapp;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.webkit.WebView;

/**
 * Created by admin on 23-Sep-16.
 */
public class AboutActivity extends AppCompatActivity
{
    Toolbar app_bar;
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

        app_bar = (Toolbar) findViewById(R.id.app_bar);
        app_bar.setTitle("About Us");

        setSupportActionBar(app_bar);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent ii = new Intent(getApplicationContext(), WelcomeActivity.class);
        startActivity(ii);
        return super.onOptionsItemSelected(item);
    }
}
