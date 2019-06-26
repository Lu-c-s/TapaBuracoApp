package com.tapaburaco.company.tapaburaco;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ListView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.List;

public class HomeActivity extends AppCompatActivity {
    private ListView mComplaintsListView;
    private List<Complaint> mComplaintList;
    private DatabaseReference mDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        mComplaintsListView = findViewById(R.id.mListView);
        mDatabase = FirebaseDatabase.getInstance().getReference();

        //get the compliants list
        //mComplaintList = getComplaints();

        //ComplaintAdapter complaintAdapter = new ComplaintAdapter(mComplaintList, this);

        //mComplaintsListView.setAdapter(complaintAdapter);
    }


    //Get a list of complaints in firebase and return it
    public List<Complaint> getComplaints() {
        return null;
    }

}
