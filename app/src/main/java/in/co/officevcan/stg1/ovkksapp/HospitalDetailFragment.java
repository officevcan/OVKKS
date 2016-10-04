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

import Modal.HospitalDetailModal;
import adapter.HospitalDetailAdapter;


/**
 * A simple {@link Fragment} subclass.
 */
public class HospitalDetailFragment extends Fragment {
    RecyclerView rvDisplay;
    List<HospitalDetailModal> lstHospitalDetail;
    LinearLayoutManager llm;
    private String urlJsonArry = "http://www.stg1.officevcan.co.in/Android/KKSWebService/Hospital.json";
    private ProgressDialog pDialog;

    public HospitalDetailFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_hospital_detail, container, false);

        lstHospitalDetail = new ArrayList<>();

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
                                HospitalDetailModal objHospitalDetailModal = new HospitalDetailModal();
                                if (!jsonObject.isNull("Hospitalname")) {
                                    objHospitalDetailModal.setHospitalName(jsonObject.getString("Hospitalname"));
                                }
                                if (!jsonObject.isNull("Address")) {
                                    objHospitalDetailModal.setAddress(jsonObject.getString("Address"));
                                }
                                if (!jsonObject.isNull("Email")) {
                                    objHospitalDetailModal.setEmail(jsonObject.getString("Email"));
                                }
                                if (!jsonObject.isNull("ContactNo")) {
                                    objHospitalDetailModal.setContactNo(jsonObject.getString("ContactNo"));
                                }

                                lstHospitalDetail.add(i, objHospitalDetailModal);

                            }

                            HospitalDetailAdapter hospitalDetailAdapter = new HospitalDetailAdapter(lstHospitalDetail, getActivity());
                            rvDisplay.setAdapter(hospitalDetailAdapter);

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
}
