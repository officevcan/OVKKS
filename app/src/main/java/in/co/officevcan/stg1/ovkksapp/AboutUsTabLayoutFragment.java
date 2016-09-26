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
public class AboutUsTabLayoutFragment extends Fragment
{
    public static TabLayout tabLayout;
    public static ViewPager viewPager;

    public AboutUsTabLayoutFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
       // return inflater.inflate(R.layout.fragment_about_us_tab_layout, container, false);
        View view = inflater.inflate(R.layout.fragment_about_us_tab_layout, container, false);
        viewPager = (ViewPager) view.findViewById(R.id.viewpager);
        setupViewPager(viewPager);

        tabLayout = (TabLayout) view.findViewById(R.id.AboutUsTabLayout);
        tabLayout.setupWithViewPager(viewPager);
        return view;
    }
    private void setupViewPager(ViewPager viewPager)
    {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getFragmentManager());
        adapter.addFragment(new AboutDetailFragment(), "About Us");
        adapter.addFragment(new BirthOfKksFragment(), "Birth Of KKS");
        adapter.addFragment(new OurAchivementFragment(), "Ours Achivement.");
        adapter.addFragment(new OnGoingPlanFragment(), "On Going Plan");
        adapter.addFragment(new FuturePlanFragment(), "Future Plan");
        viewPager.setAdapter(adapter);

    }

}
