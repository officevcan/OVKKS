package in.co.officevcan.stg1.ovkksapp;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
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

import Modal.WageRevisionModal;
import adapter.WageRevisionRecyclerAdapter;


public class WageRevisionFragment extends Fragment {

    ArrayList<WageRevisionModal> lstwageRevisionModal;
    WageRevisionRecyclerAdapter adapter;
    RecyclerView rvDisplay;
    Context mContext;

   LinearLayoutManager llm;
    String GET_JSON_DATA_HTTP_URL = "http://www.stg1.officevcan.co.in/Android/KKSWebService/demo.json";
    String JSON_NAME = "name";

    JsonArrayRequest jsonArrayRequest;

    RequestQueue requestQueue;

    public WageRevisionFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_wage_revision, container, false);

        lstwageRevisionModal = new ArrayList<>();

        rvDisplay = (RecyclerView) view.findViewById(R.id.rvDisplay);
        rvDisplay.setHasFixedSize(true);
        llm = new LinearLayoutManager(getActivity());
        rvDisplay.setLayoutManager(llm);

        JSON_DATA_WEB_CALL();
        return view;
    }

    public void JSON_DATA_WEB_CALL() {

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

                        requestQueue = Volley.newRequestQueue(getActivity());

                        requestQueue.add(jsonArrayRequest);
                    }
                });

    }

    public void JSON_PARSE_DATA_AFTER_WEBCALL(JSONArray array) {

        for (int i = 0; i < array.length(); i++) {

            WageRevisionModal GetDataAdapter2 = new WageRevisionModal();

            JSONObject json = null;
            try {
                json = array.getJSONObject(i);

                GetDataAdapter2.setName(json.getString(JSON_NAME));

            } catch (JSONException e) {

                e.printStackTrace();
            }
            lstwageRevisionModal.add(GetDataAdapter2);
        }

        adapter = new WageRevisionRecyclerAdapter(lstwageRevisionModal, getActivity());

        rvDisplay.setAdapter(adapter);

    }
}

