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

    RecyclerView rvDisplay;
    Context mContext;
    ArrayList<WageRevisionModal> lstwageRevisionModal;


    public WageRevisionFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_wage_revision, container, false);

        rvDisplay = (RecyclerView) view.findViewById(R.id.rvDisplay);
        rvDisplay.setHasFixedSize(true);

        LinearLayoutManager llm = new LinearLayoutManager(mContext);
        rvDisplay.setLayoutManager(llm);

        final WageRevisionRecyclerAdapter objwageAdapter = new WageRevisionRecyclerAdapter(lstwageRevisionModal);
        rvDisplay.setAdapter(objwageAdapter);
        MakeJSONObjectRequest();
        return view;
    }

    private void MakeJSONObjectRequest() {
        RequestQueue requestQueue = Volley.newRequestQueue(getContext());
        String url = "http://www.stg1.officevcan.co.in/Android/KKSWebService/demo.json";

        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(url, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                try {
                    if (response.length() > 0) {
                        for (int i = 0; i < response.length(); i++) {
                            JSONObject jsonObject = response.getJSONObject(i);
                            WageRevisionModal wageRevisionModal = new WageRevisionModal();
                            if (!jsonObject.isNull("name")) {
                                wageRevisionModal.name = jsonObject.getString("name");
                            }

                            lstwageRevisionModal.add(i, wageRevisionModal);
                        }


                        //  objwageAdapter.notifyDataSetChanged();
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                System.out.println(error.getMessage());
            }
        });

        requestQueue.add(jsonArrayRequest);
    }

}