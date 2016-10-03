package in.co.officevcan.stg1.ovkksapp;


import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

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
import Modal.DashboardModal;
import adapter.CircularRecyclerAdapter;
import adapter.DashboardRecyclerAdapter;


/**
 * A simple {@link Fragment} subclass.
 */
public class DashboardFragment extends Fragment
{
    Toolbar app_bar;
    Context context;
    List<DashboardModal> GetDataAdapter1;
    RecyclerView recyclerView;
    RecyclerView.LayoutManager recyclerViewlayoutManager;
    RecyclerView.Adapter recyclerViewadapter;
    private ProgressDialog pDialog;
    JsonArrayRequest jsonArrayRequest;
    RequestQueue requestQueue;

    String GET_JSON_DATA_HTTP_URL = "http://www.stg1.officevcan.co.in/Android/KKSWebService/DashboardDetail.json";
    String JSON_NAME = "name";

    public DashboardFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_dashboard, container, false);
        GetDataAdapter1 = new ArrayList<>();
        recyclerView = (RecyclerView) view.findViewById(R.id.rvDisplay);
        pDialog = new ProgressDialog(getActivity());
        pDialog.setMessage("Please wait...");
        pDialog.setCancelable(false);
        recyclerView.setHasFixedSize(true);
        recyclerViewlayoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(recyclerViewlayoutManager);


        JSON_DATA_WEB_CALL();
        return view;
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

        requestQueue = Volley.newRequestQueue(getActivity());

        requestQueue.add(jsonArrayRequest);

    }

    public void JSON_PARSE_DATA_AFTER_WEBCALL(JSONArray array)
    {
        showpDialog();
        for (int i = 0; i < array.length(); i++) {

            DashboardModal GetDataAdapter2 = new DashboardModal();

            JSONObject json = null;
            try {
                json = array.getJSONObject(i);


                GetDataAdapter2.setStrtitle(json.getString(JSON_NAME));


            } catch (JSONException e) {

                e.printStackTrace();
            }
            GetDataAdapter1.add(GetDataAdapter2);
        }

        recyclerViewadapter = new DashboardRecyclerAdapter(GetDataAdapter1,getActivity());

        recyclerView.setAdapter(recyclerViewadapter);
        hidepDialog();
    }


}
