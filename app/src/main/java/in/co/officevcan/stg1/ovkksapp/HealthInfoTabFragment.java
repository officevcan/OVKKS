package in.co.officevcan.stg1.ovkksapp;


import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import adapter.ViewPagerAdapter;


/**
 * A simple {@link Fragment} subclass.
 */
public class HealthInfoTabFragment extends Fragment {
    public static TabLayout HealthTabLayout;
    public static ViewPager viewPager;

    public HealthInfoTabFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_health_info_tab, container, false);

        viewPager = (ViewPager) view.findViewById(R.id.viewpager);
        setupViewPager(viewPager);

        HealthTabLayout = (TabLayout) view.findViewById(R.id.HealthTabLayout);
        HealthTabLayout.setupWithViewPager(viewPager);
        return view;
    }

    //region SetUpViewPager Method
    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getFragmentManager());
        adapter.addFragment(new HospitalDetailFragment(), "Hospital Detail");
        adapter.addFragment(new BloodDonerDetailFragment(), "Blood donor detail");
        adapter.addFragment(new PanelDoctorDetailFragment(), "Doctors detail");
        viewPager.setAdapter(adapter);
    }
    //endregion

}
