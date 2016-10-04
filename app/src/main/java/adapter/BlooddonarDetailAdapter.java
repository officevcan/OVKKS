package adapter;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.rey.material.widget.TextView;

import java.util.List;

import Modal.BloodDonarModal;
import in.co.officevcan.stg1.ovkksapp.R;

/**
 * Created by admin on 10/4/2016.
 */
public class BlooddonarDetailAdapter extends RecyclerView.Adapter<BlooddonarDetailAdapter.BloodDonarViewHolder> {

    List<BloodDonarModal> lstBloodDetail;
    Context context;

    public BlooddonarDetailAdapter(List<BloodDonarModal> lstBloodDetail, Context context) {
        this.lstBloodDetail = lstBloodDetail;
        this.context = context;
    }

    @Override
    public BloodDonarViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.raw_blood_donar, parent, false);
        BloodDonarViewHolder objBloodDonarViewHolder = new BloodDonarViewHolder(v);
        return objBloodDonarViewHolder;
    }

    @Override
    public void onBindViewHolder(BloodDonarViewHolder holder, int position) {
        holder.txtPersonName.setText(lstBloodDetail.get(position).getPersonName());
        holder.txtPersonBloodGroup.setText(lstBloodDetail.get(position).getBloodGroup());
        holder.txtpersonContactNo.setText(lstBloodDetail.get(position).getContactNo());
        holder.txtpersonContactNo1.setText(lstBloodDetail.get(position).getContactNo1());
    }


    @Override
    public int getItemCount() {
        return lstBloodDetail.size();
    }

    public class BloodDonarViewHolder extends RecyclerView.ViewHolder {

        CardView Blood_card_view;
        TextView txtPersonName, txtPersonBloodGroup, txtpersonContactNo, txtpersonContactNo1;
        //   ImageView imgBloodIcon,imgContactIcon;

        public BloodDonarViewHolder(View itemView) {
            super(itemView);

            Blood_card_view = (CardView) itemView.findViewById(R.id.Blood_card_view);

            txtPersonName = (TextView) itemView.findViewById(R.id.txtPersonName);
            txtPersonBloodGroup = (TextView) itemView.findViewById(R.id.txtPersonBloodGroup);
            txtpersonContactNo = (TextView) itemView.findViewById(R.id.txtPersonContactNo);
            txtpersonContactNo1 = (TextView) itemView.findViewById(R.id.txtPersonContactNo2);
        }
    }
}
