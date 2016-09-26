package adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by admin on 9/26/2016.
 */
public class HospitalDetailAdapter extends RecyclerView.Adapter<HospitalDetailAdapter.HospitalViewHolder> {


    @Override
    public HospitalViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(HospitalViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public static class HospitalViewHolder extends RecyclerView.ViewHolder {
     //   CardView cv;
      //  TextView Name;


        HospitalViewHolder(View itemView) {
            super(itemView);
          //  cv = (CardView) itemView.findViewById(R.id.wagecard_view);
          //  Name = (TextView) itemView.findViewById(R.id.txtName);
        }
    }
}
