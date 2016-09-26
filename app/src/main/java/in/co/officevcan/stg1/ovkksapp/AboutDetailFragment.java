package in.co.officevcan.stg1.ovkksapp;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;


/**
 * A simple {@link Fragment} subclass.
 */
public class AboutDetailFragment extends Fragment
{
    WebView webview1;

    public AboutDetailFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_about_detail, container, false);
        webview1=(WebView)view.findViewById(R.id.webview1);
        webview1.getSettings().setJavaScriptEnabled(true);

        // uri loding in webview
        webview1.loadUrl("file:///android_asset/about.html");
        return view;
    }

}
