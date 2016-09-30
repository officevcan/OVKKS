package in.co.officevcan.stg1.ovkksapp;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import Modal.CircularModal;
import adapter.CircularRecyclerAdapter;

/**
 * Created by admin on 28-Sep-16.
 */
public class CircularActivity extends AppCompatActivity {
    Toolbar app_bar;
    Context context;
    List<CircularModal> GetDataAdapter1;
    RecyclerView recyclerView;
    RecyclerView.LayoutManager recyclerViewlayoutManager;
    RecyclerView.Adapter recyclerViewadapter;
    private ProgressDialog pDialog;
    JsonArrayRequest jsonArrayRequest;
    RequestQueue requestQueue;

    String GET_JSON_DATA_HTTP_URL = "http://www.stg1.officevcan.co.in/Android/KKSWebService/demo.json";
    String JSON_NAME = "name";

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_circular);

        app_bar = (Toolbar) findViewById(R.id.app_bar);
        app_bar.setTitle("Circular");

        setSupportActionBar(app_bar);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }

        GetDataAdapter1 = new ArrayList<>();
        recyclerView = (RecyclerView) findViewById(R.id.rvDisplay);
        pDialog = new ProgressDialog(CircularActivity.this);
        pDialog.setMessage("Please wait...");
        pDialog.setCancelable(false);
        recyclerView.setHasFixedSize(true);
        recyclerViewlayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(recyclerViewlayoutManager);


        JSON_DATA_WEB_CALL();

    }
    private void showpDialog() {
        if (!pDialog.isShowing())
            pDialog.show();
    }

    private void hidepDialog() {
        if (pDialog.isShowing())
            pDialog.dismiss();
    }


    public void JSON_DATA_WEB_CALL()
    {
        showpDialog();
        jsonArrayRequest = new JsonArrayRequest(GET_JSON_DATA_HTTP_URL,

                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {



                        JSON_PARSE_DATA_AFTER_WEBCALL(response);
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                });

        requestQueue = Volley.newRequestQueue(this);

        requestQueue.add(jsonArrayRequest);

    }

    public void JSON_PARSE_DATA_AFTER_WEBCALL(JSONArray array)
    {
        showpDialog();
        for (int i = 0; i < array.length(); i++) {

            CircularModal GetDataAdapter2 = new CircularModal();

            JSONObject json = null;
            try {
                json = array.getJSONObject(i);


                GetDataAdapter2.setStrtitle(json.getString(JSON_NAME));


            } catch (JSONException e) {

                e.printStackTrace();
            }
            GetDataAdapter1.add(GetDataAdapter2);
        }

        recyclerViewadapter = new CircularRecyclerAdapter(GetDataAdapter1, this);

        recyclerView.setAdapter(recyclerViewadapter);
        hidepDialog();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent ii = new Intent(CircularActivity.this, NavigationActivity.class);
        startActivity(ii);
        return super.onOptionsItemSelected(item);
    }
}
