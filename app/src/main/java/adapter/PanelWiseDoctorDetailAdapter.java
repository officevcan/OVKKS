package adapter;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.rey.material.widget.TextView;

import java.util.List;

import Modal.PanelDocterDetailModal;
import in.co.officevcan.stg1.ovkksapp.R;

/**
 * Created by admin on 10/4/2016.
 */
public class PanelWiseDoctorDetailAdapter extends RecyclerView.Adapter<PanelWiseDoctorDetailAdapter.PanelWiseDoctorViewHolder> {

    List<PanelDocterDetailModal> lstPanelDoctorDetail;
    Context context;

    public PanelWiseDoctorDetailAdapter(List<PanelDocterDetailModal> lstPanelDoctorDetail, Context context) {
        this.lstPanelDoctorDetail = lstPanelDoctorDetail;
        this.context = context;
    }

    @Override
    public PanelWiseDoctorViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.raw_panel_wise_doctor_detail, parent, false);
        PanelWiseDoctorViewHolder ObjPanelWiseDoctorViewHolder = new PanelWiseDoctorViewHolder(v);
        return ObjPanelWiseDoctorViewHolder;
    }

    @Override
    public void onBindViewHolder(PanelWiseDoctorViewHolder holder, int position) {
        holder.txtHospitalName.setText(lstPanelDoctorDetail.get(position).getHospitalName());
        holder.txtDoctorname.setText(lstPanelDoctorDetail.get(position).getDoctorName());
        holder.txtAddress.setText(lstPanelDoctorDetail.get(position).getAddress());
        holder.txtEmail.setText(lstPanelDoctorDetail.get(position).getEmail());
        holder.txtContactNo.setText(lstPanelDoctorDetail.get(position).getContactNo());
    }


    @Override
    public int getItemCount() {
        return lstPanelDoctorDetail.size();
    }

    public class PanelWiseDoctorViewHolder extends RecyclerView.ViewHolder {
        CardView cv;
        TextView txtDoctorname, txtEmail, txtContactNo, txtHospitalName, txtAddress;
        // ImageView imgAddress, imgEmail, imgContactNo;

        public PanelWiseDoctorViewHolder(View itemView) {
            super(itemView);
            cv = (CardView) itemView.findViewById(R.id.cvPanel);
            txtHospitalName = (TextView) itemView.findViewById(R.id.txtHospitalName);
            txtDoctorname = (TextView) itemView.findViewById(R.id.txtDoctorName);
            txtEmail = (TextView) itemView.findViewById(R.id.txtEmail);
            txtContactNo = (TextView) itemView.findViewById(R.id.txtContact);
            txtAddress = (TextView) itemView.findViewById(R.id.txtAddress);
        }
    }
}
