package adapter;

import android.content.Context;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.rey.material.widget.TextView;

import java.util.List;

import Modal.CircularModal;
import Modal.DashboardModal;
import in.co.officevcan.stg1.ovkksapp.R;

/**
 * Created by admin on 03-Oct-16.
 */
public class DashboardRecyclerAdapter extends RecyclerView.Adapter<DashboardRecyclerAdapter.ViewHolder>
{
    Context context;
    List<DashboardModal> getDataAdapter;

    public DashboardRecyclerAdapter(List<DashboardModal> getDataAdapter1,Context context)
    {
        this.getDataAdapter =getDataAdapter1;
        this.context=context;
    }

    @Override
    public DashboardRecyclerAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.raw_dashboardinfo, parent, false);
        ViewHolder ViewHolder = new ViewHolder(v);
        return ViewHolder;
    }

    @Override
    public void onBindViewHolder(DashboardRecyclerAdapter.ViewHolder holder, int position) {
        DashboardModal getDataAdapter1 =  getDataAdapter.get(position);

        holder.txttitle.setText(getDataAdapter1.getStrtitle());

    }

    @Override
    public int getItemCount() {
        return getDataAdapter.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder
    {
        CardView cv;
        public TextView txttitle;
        public ViewHolder(View itemView) {
            super(itemView);
            cv = (CardView) itemView.findViewById(R.id.dashboardcard_view);
            txttitle = (TextView) itemView.findViewById(R.id.textlink);

        }
    }

}
