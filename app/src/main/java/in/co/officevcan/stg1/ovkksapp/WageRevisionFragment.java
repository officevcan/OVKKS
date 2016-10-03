package in.co.officevcan.stg1.ovkksapp;


import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.JsonArrayRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import Modal.WageRevisionModal;
import adapter.WageRevisionAdapter;


public class WageRevisionFragment extends Fragment {

    RecyclerView rvDisplay;
    List<WageRevisionModal> lstwage;
    LinearLayoutManager llm;
    private String urlJsonArry = "http://www.stg1.officevcan.co.in/Android/KKSWebService/demo.json";
    private ProgressDialog pDialog;

    public WageRevisionFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_wage_revision, container, false);

        lstwage = new ArrayList<>();

        pDialog = new ProgressDialog(getActivity());
        pDialog.setMessage("Please wait...");
        pDialog.setCancelable(false);

        rvDisplay = (RecyclerView) view.findViewById(R.id.rvDisplay);
        rvDisplay.setHasFixedSize(true);
        llm = new LinearLayoutManager(getActivity());
        rvDisplay.setLayoutManager(llm);
        makeJsonArrayRequest();
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

    private void makeJsonArrayRequest() {

        showpDialog();

        JsonArrayRequest req = new JsonArrayRequest(urlJsonArry,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        Log.d("OnResponse", response.toString());

                        try {
                            // Parsing json array response
                            // loop through each json object
                            for (int i = 0; i < response.length(); i++) {

                                JSONObject jsonObject = response.getJSONObject(i);
                                WageRevisionModal person = new WageRevisionModal();
                                if (!jsonObject.isNull("name")) {
                                    person.name = jsonObject.getString("name");
                                }
                                lstwage.add(i, person);

                            }

                            WageRevisionAdapter wageRevisionAdapter = new WageRevisionAdapter(lstwage, getActivity());
                            rvDisplay.setAdapter(wageRevisionAdapter);

                        } catch (JSONException e) {
                            e.printStackTrace();
                            Toast.makeText(getActivity(),
                                    "Error: " + e.getMessage(),
                                    Toast.LENGTH_LONG).show();
                        }

                        hidepDialog();
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                VolleyLog.d("VolleyError", "Error: " + error.getMessage());
                Toast.makeText(getActivity(),
                        error.getMessage(), Toast.LENGTH_SHORT).show();
                hidepDialog();
            }
        });

        // Adding request to request queue
        AppController.getInstance().addToRequestQueue(req);
    }

    //region cOMMENT CODE
    // List<WageRevisionModal> persons;
  /*  private List<WageRevisionModal> listSuperHeroes;

    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private WageRevisionAdapter adapter;

    public static final String DATA_URL = "http://www.stg1.officevcan.co.in/Android/KKSWebService/demo.json";
    public static final String TAG_NAME = "name";*/

   /* public void JSON_DATA_WEB_CALL() {

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

    }*/

      /* persons = new ArrayList<>();

        final RecyclerView rv = (RecyclerView) view.findViewById(R.id.rvDisplay);
        rv.setHasFixedSize(true);

        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        rv.setLayoutManager(llm);

        RequestQueue requestQueue = Volley.newRequestQueue(getContext());
        String url = "http://www.stg1.officevcan.co.in/Android/KKSWebService/demo.json";

        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(url, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                try {
                    if (response.length() > 0) {
                        // personList.clear();
                        for (int i = 0; i < response.length(); i++) {
                            JSONObject jsonObject = response.getJSONObject(i);
                            WageRevisionModal person = new WageRevisionModal();
                            if (!jsonObject.isNull("name")) {
                                person.name = jsonObject.getString("name");
                            }
                            persons.add(i, person);
                        }
                        WageRevisionAdapter wageRevisionAdapter = new WageRevisionAdapter(persons, getActivity());
                        rv.setAdapter(wageRevisionAdapter);

                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                // do something
            }
        });

        requestQueue.add(jsonArrayRequest);
*/
    //  JSON_DATA_WEB_CALL();

   /* private void getData() {
        //Showing a progress dialog
        final ProgressDialog loading = ProgressDialog.show(getActivity(), "Loading Data", "Please wait...", false, false);

        //Creating a json array request
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(DATA_URL,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        //Dismissing progress dialog
                        loading.dismiss();

                        //calling method to parse json array
                        parseData(response);
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                });

        //Creating request queue
        RequestQueue requestQueue = Volley.newRequestQueue(getActivity());

        //Adding request to the queue
        requestQueue.add(jsonArrayRequest);
    }

    private void parseData(JSONArray array) {
        for (int i = 0; i < array.length(); i++) {
            WageRevisionModal superHero = new WageRevisionModal();
            JSONObject json = null;
            try {
                json = array.getJSONObject(i);
                superHero.setName(json.getString(TAG_NAME));

            } catch (JSONException e) {
                e.printStackTrace();
            }
            listSuperHeroes.add(superHero);
        }

        //Finally initializing our adapter
        adapter = new WageRevisionAdapter(listSuperHeroes, getActivity());

        //Adding adapter to recyclerview
        recyclerView.setAdapter(adapter);
    }

    recyclerView = (RecyclerView) view.findViewById(R.id.rvDisplay);
    recyclerView.setHasFixedSize(true);
    layoutManager = new LinearLayoutManager(getActivity());
    recyclerView.setLayoutManager(layoutManager);*/

    //endregion
}

