package adapter;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.rey.material.widget.TextView;

import java.util.List;

import Modal.CircularModal;
import in.co.officevcan.stg1.ovkksapp.R;

/**
 * Created by admin on 28-Sep-16.
 */
public class CircularRecyclerAdapter extends RecyclerView.Adapter<CircularRecyclerAdapter.ViewHolder>
{
    Context context;
    List<CircularModal> getDataAdapter;

    public CircularRecyclerAdapter(List<CircularModal> getDataAdapter, Context context){

        super();

        this.getDataAdapter = getDataAdapter;
        this.context = context;
    }


    @Override
    public CircularRecyclerAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.raw_circularinfo, parent, false);
        ViewHolder ViewHolder = new ViewHolder(v);
        return ViewHolder;
    }

    @Override
    public void onBindViewHolder(CircularRecyclerAdapter.ViewHolder holder, int position) {
       CircularModal getDataAdapter1 =  getDataAdapter.get(position);

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
            cv = (CardView) itemView.findViewById(R.id.circularcard_view);
           txttitle = (TextView) itemView.findViewById(R.id.textlink) ;

        }
    }
}
