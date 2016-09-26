package adapter;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.rey.material.widget.TextView;

import java.util.List;

import Modal.WageRevisionModal;
import in.co.officevcan.stg1.ovkksapp.R;

/**
 * Created by admin on 9/26/2016.
 */
public class WageRevisionRecyclerAdapter extends RecyclerView.Adapter<WageRevisionRecyclerAdapter.WageViewHolder> {
    List<WageRevisionModal> wageRevisionModal;

    public WageRevisionRecyclerAdapter(List<WageRevisionModal> lstwageRevisionModal) {
        this.wageRevisionModal = lstwageRevisionModal;
    }


    @Override
    public WageViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.wage_cardview, parent, false);
        WageViewHolder wvh = new WageViewHolder(v);
        return wvh;

    }

    @Override
    public void onBindViewHolder(WageViewHolder holder, int position) {
        holder.Name.setText(wageRevisionModal.get(position).name);
    }

    @Override
    public int getItemCount() {
        if (wageRevisionModal != null) {
            return wageRevisionModal.size();
        }
        return 0;
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    public static class WageViewHolder extends RecyclerView.ViewHolder {
        CardView cv;
        TextView Name;


        WageViewHolder(View itemView) {
            super(itemView);
            cv = (CardView) itemView.findViewById(R.id.wagecard_view);
            Name = (TextView) itemView.findViewById(R.id.txtName);
        }
    }
}
