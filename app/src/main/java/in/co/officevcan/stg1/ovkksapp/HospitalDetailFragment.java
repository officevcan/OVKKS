package in.co.officevcan.stg1.ovkksapp;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import adapter.HospitalDetailAdapter;


/**
 * A simple {@link Fragment} subclass.
 */
public class HospitalDetailFragment extends Fragment {


    public HospitalDetailFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_hospital_detail, container, false);
        HospitalDetailAdapter adpater = new HospitalDetailAdapter(getContext());
        RecyclerView rview = (RecyclerView) v.findViewById(R.id.rvDisplay);
        rview.setAdapter(adpater);
        rview.setLayoutManager(new LinearLayoutManager(getContext()));
        return v;
    }

}
