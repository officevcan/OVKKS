package in.co.officevcan.stg1.ovkksapp;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.rey.material.app.ThemeManager;

public class GravienceAndSuggestionActivity extends AppCompatActivity
{
    Toolbar app_bar;
    Context context;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gravience_and_suggestion);
        ThemeManager.init(this, 1, 0, null);

        context = getApplicationContext();

        app_bar = (Toolbar) findViewById(R.id.app_bar);
        app_bar.setTitle("Gravience / Suggestion");

        setSupportActionBar(app_bar);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent ii = new Intent(getApplicationContext(), UserDashboardActivity.class);
        startActivity(ii);
        return super.onOptionsItemSelected(item);
    }
}
