package com.tapaburaco.company.tapaburaco;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.location.Location;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;

import static com.tapaburaco.company.tapaburaco.R.color.colorAccent;

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
        Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        myToolbar.setTitle("Suas reclamações");
        myToolbar.setTitleTextColor(getResources().getColor(colorAccent));
        setSupportActionBar(myToolbar);

        //get the compliants list
        mComplaintList = getComplaints();

        ComplaintAdapter complaintAdapter = new ComplaintAdapter(mComplaintList, this);

        mComplaintsListView.setAdapter(complaintAdapter);
    }


    //Get a list of complaints in firebase and return it
    public List<Complaint> getComplaints() {
        Location lot = new Location("");
        lot.setLatitude(4325252);
        lot.setLongitude(46464566);
        Bitmap image = BitmapFactory.decodeResource(this.getResources(), R.mipmap.logo);
        Bitmap image2 = BitmapFactory.decodeResource(this.getResources(), R.drawable.download);

        Complaint c = new Complaint();
        c.setId(131311);
        c.setComplaintPhotoLocation(lot);
        c.setDescription("Buraco na pista");
        c.setUserEmail("lucsa@email.com");
        c.setComplaintPhoto(image);
        c.setLocationString("Brasilia-DF");

        Complaint c1 = new Complaint();
        c1.setId(1313511);
        c1.setComplaintPhotoLocation(lot);
        c1.setDescription("Parada zuada");
        c1.setUserEmail("lucsa@email.com");
        c1.setComplaintPhoto(image2);
        c1.setLocationString("Brasilia-DF");

        Complaint c2 = new Complaint();
        c2.setId(131316561);
        c2.setComplaintPhotoLocation(lot);
        c2.setDescription("Putas demais na rua");
        c2.setUserEmail("lucsa@email.com");
        c2.setComplaintPhoto(image);
        c2.setLocationString("Brasilia-DF");

        List<Complaint> mComplaintList = new ArrayList<>();

        mComplaintList.add(c);
        mComplaintList.add(c1);
        mComplaintList.add(c2);

        return mComplaintList;
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_complaint) {
            Toast.makeText(getApplicationContext(), "Chamar activity nova reclamação", Toast.LENGTH_LONG).show();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


}
