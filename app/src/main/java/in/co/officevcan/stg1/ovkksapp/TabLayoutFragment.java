package in.co.officevcan.stg1.ovkksapp;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import adapter.ViewPagerAdapter;


public class TabLayoutFragment extends Fragment {

    public static TabLayout tabLayout;
    public static ViewPager viewPager;


    public TabLayoutFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_tab_layout, container, false);

        viewPager = (ViewPager) view.findViewById(R.id.viewpager);
        setupViewPager(viewPager);

        tabLayout = (TabLayout) view.findViewById(R.id.TabLayout);
        tabLayout.setupWithViewPager(viewPager);
        return view;
    }

    //region SetUpViewPager Method
    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getFragmentManager());
        adapter.addFragment(new WageRevisionFragment(), "Wage rivision");
        adapter.addFragment(new EmpGravienceFragment(), "Empl.Gravience");
        adapter.addFragment(new KKSFragment(), "KKS Today");
        adapter.addFragment(new OurDemandFragment(), "Our Demand");
        viewPager.setAdapter(adapter);
    }
    //endregion


}
