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

import Modal.PanelDocterDetailModal;
import adapter.PanelWiseDoctorDetailAdapter;


/**
 * A simple {@link Fragment} subclass.
 */
public class PanelDoctorDetailFragment extends Fragment {

    RecyclerView rvDisplay;
    List<PanelDocterDetailModal> lstPanelDoctorDetail;
    LinearLayoutManager llm;
    private String urlJsonArry = "http://www.stg1.officevcan.co.in/Android/KKSWebService/PanelWiseDoctorDetail.json";
    private ProgressDialog pDialog;

    public PanelDoctorDetailFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_panel_doctor_detail, container, false);

        lstPanelDoctorDetail = new ArrayList<>();

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


    private void makeJsonArrayRequest() {
        pDialog.show();
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
                                PanelDocterDetailModal objPanelDocterDetailModal = new PanelDocterDetailModal();
                                if (!jsonObject.isNull("Hospitalname")) {
                                    objPanelDocterDetailModal.setHospitalName(jsonObject.getString("Hospitalname"));
                                }
                                if (!jsonObject.isNull("Doctorname")) {
                                    objPanelDocterDetailModal.setDoctorName(jsonObject.getString("Doctorname"));
                                }
                                if (!jsonObject.isNull("Address")) {
                                    objPanelDocterDetailModal.setAddress(jsonObject.getString("Address"));
                                }
                                if (!jsonObject.isNull("Email")) {
                                    objPanelDocterDetailModal.setEmail(jsonObject.getString("Email"));
                                }
                                if (!jsonObject.isNull("ContactNo")) {
                                    objPanelDocterDetailModal.setContactNo(jsonObject.getString("ContactNo"));
                                }

                                lstPanelDoctorDetail.add(i, objPanelDocterDetailModal);

                            }

                            PanelWiseDoctorDetailAdapter panelWiseDoctorDetailAdapter = new PanelWiseDoctorDetailAdapter(lstPanelDoctorDetail, getActivity());
                            rvDisplay.setAdapter(panelWiseDoctorDetailAdapter);

                        } catch (JSONException e) {
                            e.printStackTrace();
                            Toast.makeText(getActivity(),
                                    "Error: " + e.getMessage(),
                                    Toast.LENGTH_LONG).show();
                        }

                        pDialog.dismiss();
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                VolleyLog.d("VolleyError", "Error: " + error.getMessage());
                Toast.makeText(getActivity(),
                        error.getMessage(), Toast.LENGTH_SHORT).show();
                pDialog.dismiss();
            }
        });

        // Adding request to request queue
        AppController.getInstance().addToRequestQueue(req);
    }
}
