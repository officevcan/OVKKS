package adapter;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.rey.material.widget.TextView;

import in.co.officevcan.stg1.ovkksapp.R;

/**
 * Created by admin on 9/26/2016.
 */
public class HospitalDetailAdapter extends RecyclerView.Adapter<HospitalDetailAdapter.HospitalViewHolder> {
Context context;

    public HospitalDetailAdapter(Context context) {
        this.context=context;
    }

    @Override
    public HospitalViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.raw_hospital_info, parent, false);
        HospitalViewHolder wvh = new HospitalViewHolder(v);
        return wvh;
    }

    @Override
    public void onBindViewHolder(HospitalViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public static class HospitalViewHolder extends RecyclerView.ViewHolder {
        CardView cv;
        TextView tvAddress, tvEmail, tvConactNo, tvHospitalName;
        ImageView imgAddress, imgEmail, imgContactNo;


        HospitalViewHolder(View itemView) {
            super(itemView);
            cv = (CardView) itemView.findViewById(R.id.hospital_card_view);
            tvHospitalName = (TextView) itemView.findViewById(R.id.tvHospitalName);
            tvEmail = (TextView) itemView.findViewById(R.id.tvEmail);
            tvConactNo = (TextView) itemView.findViewById(R.id.tvContact);
            tvAddress = (TextView) itemView.findViewById(R.id.tvAddress);

            imgAddress = (ImageView) itemView.findViewById(R.id.imgAddress);
            imgContactNo = (ImageView) itemView.findViewById(R.id.imgContact);
            imgEmail = (ImageView) itemView.findViewById(R.id.imgemail);
        }
    }
}
