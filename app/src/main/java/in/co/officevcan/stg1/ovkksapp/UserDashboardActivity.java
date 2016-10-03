package in.co.officevcan.stg1.ovkksapp;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

public class UserDashboardActivity extends AppCompatActivity
{
    Toolbar app_bar;
    Context context;
    FragmentManager mFragmentManager;
    FragmentTransaction mFragmentTransaction;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_dashboard);

        mFragmentManager = getSupportFragmentManager();
        mFragmentTransaction = mFragmentManager.beginTransaction();
        mFragmentTransaction.replace(R.id.containerView, new UserDashboardTabLayoutFragment()).commit();


        app_bar = (Toolbar) findViewById(R.id.app_bar);
        app_bar.setTitle("User Dashboard");

        setSupportActionBar(app_bar);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent ii = new Intent(getApplicationContext(), LoginActivity.class);
        startActivity(ii);
        return super.onOptionsItemSelected(item);
    }
}
