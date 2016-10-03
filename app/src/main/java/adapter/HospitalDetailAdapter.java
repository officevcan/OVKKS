package adapter;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.rey.material.widget.TextView;

import java.util.List;

import Modal.HospitalDetailModal;
import in.co.officevcan.stg1.ovkksapp.R;

/**
 * Created by admin on 9/26/2016.
 */
public class HospitalDetailAdapter extends RecyclerView.Adapter<HospitalDetailAdapter.HospitalViewHolder> {
    List<HospitalDetailModal> lstHospitalDetail;
    Context context;

    public HospitalDetailAdapter(List<HospitalDetailModal> lstHospitalDetail, Context context) {
        this.lstHospitalDetail = lstHospitalDetail;
        this.context = context;
    }

    @Override
    public HospitalViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.raw_hospital_info, parent, false);
        HospitalViewHolder wvh = new HospitalViewHolder(v);
        return wvh;
    }

    @Override
    public void onBindViewHolder(HospitalViewHolder holder, int position) {
        holder.txtHospitalName.setText(lstHospitalDetail.get(position).getHospitalName());
        holder.txtAddress.setText(lstHospitalDetail.get(position).getAddress());
        holder.txtEmail.setText(lstHospitalDetail.get(position).getEmail());
        holder.txtConactNo.setText(lstHospitalDetail.get(position).getContactNo());
    }

    @Override
    public int getItemCount() {
        return lstHospitalDetail.size();
    }

    public static class HospitalViewHolder extends RecyclerView.ViewHolder {
        CardView cv;
        TextView txtAddress, txtEmail, txtConactNo, txtHospitalName;
        ImageView imgAddress, imgEmail, imgContactNo;

        HospitalViewHolder(View itemView) {
            super(itemView);
            cv = (CardView) itemView.findViewById(R.id.hospital_card_view);
            txtHospitalName = (TextView) itemView.findViewById(R.id.tvHospitalName);
            txtEmail = (TextView) itemView.findViewById(R.id.tvEmail);
            txtConactNo = (TextView) itemView.findViewById(R.id.tvContact);
            txtAddress = (TextView) itemView.findViewById(R.id.tvAddress);

            imgAddress = (ImageView) itemView.findViewById(R.id.imgAddress);
            imgContactNo = (ImageView) itemView.findViewById(R.id.imgContact);
            imgEmail = (ImageView) itemView.findViewById(R.id.imgemail);
        }
    }
}
