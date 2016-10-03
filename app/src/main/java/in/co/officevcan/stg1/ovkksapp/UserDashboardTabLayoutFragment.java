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
public class UserDashboardTabLayoutFragment extends Fragment {
    public static TabLayout tabLayout;
    public static ViewPager viewPager;

    public UserDashboardTabLayoutFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_user_dashboard_tab_layout, container, false);

        viewPager = (ViewPager) view.findViewById(R.id.viewpager);
        setupViewPager(viewPager);

        tabLayout = (TabLayout) view.findViewById(R.id.UserDashboardTabLayout);
        tabLayout.setupWithViewPager(viewPager);
        return view;
    }
    private void setupViewPager(ViewPager viewPager)
    {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getFragmentManager());
        adapter.addFragment(new DashboardFragment(), "Dashboard");
        adapter.addFragment(new EditProfileFragment(), "Edit Profile");
        adapter.addFragment(new ChangePasswordFragment(), "Change Password");
        viewPager.setAdapter(adapter);

    }
}
