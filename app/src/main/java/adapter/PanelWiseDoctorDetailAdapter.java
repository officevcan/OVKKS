package adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import Modal.PanelDocterDetailModal;

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
        return null;
    }

    @Override
    public void onBindViewHolder(PanelWiseDoctorViewHolder holder, int position) {

    }


    @Override
    public int getItemCount() {
        return 0;
    }

    public class PanelWiseDoctorViewHolder extends RecyclerView.ViewHolder {
        public PanelWiseDoctorViewHolder(View itemView) {
            super(itemView);
        }
    }
}
