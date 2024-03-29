package com.tapaburaco.company.tapaburaco;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.io.ByteArrayOutputStream;
import java.io.File;

public class NewComplaintActivity extends AppCompatActivity {
    private StorageReference mStorageRef;
    private DatabaseReference mDatabase;
    private FirebaseAuth mAuth;

    String userId;
    ImageView imageViewFoto;
    Bitmap imagem;
    EditText _localizacao;
    EditText _descricao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_complaint);

        mStorageRef = FirebaseStorage.getInstance().getReference();
        mDatabase = FirebaseDatabase.getInstance().getReference("complaints");
        mAuth = FirebaseAuth.getInstance();
        userId = mAuth.getCurrentUser().getUid();
        _localizacao = (EditText) findViewById(R.id.localizacao);
        _descricao  = (EditText) findViewById(R.id.descricao);

        if(ActivityCompat.checkSelfPermission(this, Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.CAMERA}, 0);
        }

        imageViewFoto = (ImageView) findViewById(R.id.imageView);
        findViewById(R.id.imageView).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tirarFoto();
            }
        });


        findViewById(R.id.enviarDados).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Complaint comp = new Complaint();
                comp.setComplaintPhoto(imagem);
                comp.setDescription(_descricao.getText().toString());
                comp.setLocationString(_localizacao.getText().toString());
                comp.setUserEmail(mAuth.getCurrentUser().getEmail());

                String id = mDatabase.push().getKey();

                ByteArrayOutputStream baos = new ByteArrayOutputStream();
                imagem.compress(Bitmap.CompressFormat.PNG, 100, baos);
                String imageEncoded = Base64.encodeToString(baos.toByteArray(), Base64.DEFAULT);

                Log.d("Sent Obj",comp.toString());

                mDatabase.child(id).setValue(comp);
                mDatabase.child(id).child("imageUrl").setValue(imageEncoded);
                finish();
            }
        });
    }

    public void tirarFoto() {
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(intent, 1);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if (requestCode == 1 && resultCode == RESULT_OK) {
            Bundle extras = data.getExtras();
            imagem =  (Bitmap) extras.get("data");
            imageViewFoto.setImageBitmap(imagem);
        }
        super.onActivityResult(requestCode, resultCode, data);
    }

}
