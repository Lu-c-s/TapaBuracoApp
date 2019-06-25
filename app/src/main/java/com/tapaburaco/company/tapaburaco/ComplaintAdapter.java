package com.tapaburaco.company.tapaburaco;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class ComplaintAdapter extends BaseAdapter {
    private final List<Complaint> complaints;
    private final Activity act;

    public ComplaintAdapter(List<Complaint> complaints, Activity act){
        this.complaints = complaints;
        this.act = act;
    }

    @Override
    public int getCount() {
        return complaints.size();
    }

    @Override
    public Object getItem(int position) {
        return complaints.get(position);
    }

    @Override
    public long getItemId(int position) {
        return complaints.get(position).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = act.getLayoutInflater().inflate(R.layout.complaint_layout, parent ,false);

        Complaint actualComplaint = complaints.get(position);

        TextView complaintLocation = view.findViewById(R.id.lista_complaint_location);
        TextView complaintDescription = view.findViewById(R.id.lista_complaint_description);
        ImageView complaintImg = view.findViewById(R.id.lista_complaint_img);

        complaintLocation.setText(actualComplaint.getLocationString());
        complaintDescription.setText(actualComplaint.getDescription());
        complaintImg.setImageResource(R.drawable.ic_launcher_background);

        return view;
    }
}
