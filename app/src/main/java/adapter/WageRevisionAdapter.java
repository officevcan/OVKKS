package adapter;

import android.content.Context;
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
 * Created by admin on 9/28/2016.
 */

public class WageRevisionAdapter extends RecyclerView.Adapter<WageRevisionAdapter.PersonViewHolder> {
    List<WageRevisionModal> persons;
    Context context;

    public WageRevisionAdapter(List<WageRevisionModal> persons, Context context) {
        this.persons = persons;
        this.context=context;
    }

    @Override
    public PersonViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.raw_wage, parent, false);
        PersonViewHolder pvh = new PersonViewHolder(v);
        return pvh;
    }

    @Override
    public void onBindViewHolder(PersonViewHolder holder, int position) {
        holder.personName.setText(persons.get(position).name);
    }

    @Override
    public int getItemCount() {
        if (persons != null) {
            return persons.size();
        }
        return 0;
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    public static class PersonViewHolder extends RecyclerView.ViewHolder {
        CardView cv;
        TextView personName;

        PersonViewHolder(View itemView) {
            super(itemView);
            cv = (CardView) itemView.findViewById(R.id.wagecard_view);
            personName = (TextView) itemView.findViewById(R.id.person_name);
        }
    }
}