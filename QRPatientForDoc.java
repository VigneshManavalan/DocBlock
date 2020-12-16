package com.eshwarne.docblock;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.ml.vision.FirebaseVision;
import com.google.firebase.ml.vision.barcode.FirebaseVisionBarcode;
import com.google.firebase.ml.vision.barcode.FirebaseVisionBarcodeDetector;
import com.google.firebase.ml.vision.common.FirebaseVisionImage;

import java.util.List;

public class QRPatientForDoc extends AppCompatActivity {

    static final int REQUEST_TAKE_PHOTO = 8;



    Button btnCamera;
    ImageView qrSample;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qrpatientfordoc);
        btnCamera = findViewById(R.id.qrPatientForDocBtnCamera);
        qrSample = findViewById(R.id.qrCodeSample);
//        final Animation fadeIn = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.fade_in_repeat);
//        qrSample.startAnimation(fadeIn);
        YoYo.with(Techniques.Tada)
                .duration(700)
                .repeat(YoYo.INFINITE)
                .playOn(qrSample);
        btnCamera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                qrSample.clearAnimation();
//                fadeIn.cancel();
//                fadeIn.reset();
                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(intent,REQUEST_TAKE_PHOTO);


            }
        });



    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == REQUEST_TAKE_PHOTO){
            Bitmap barcodePhoto = (Bitmap)data.getExtras().get("data");
            barcodeRecognize(barcodePhoto);
        }
    }

    private void barcodeRecognize(Bitmap barcodePhoto) {
        FirebaseVisionImage image = FirebaseVisionImage.fromBitmap(barcodePhoto);
        FirebaseVisionBarcodeDetector detector = FirebaseVision.getInstance().getVisionBarcodeDetector();
        Task<List<FirebaseVisionBarcode>> result = detector.detectInImage(image)
                .addOnSuccessListener(new OnSuccessListener<List<FirebaseVisionBarcode>>() {
                    @Override
                    public void onSuccess(List<FirebaseVisionBarcode> barcodes) {
                        for (FirebaseVisionBarcode barcode: barcodes) {
                            Rect bounds = barcode.getBoundingBox();
                            Point[] corners = barcode.getCornerPoints();

                            String rawValue = barcode.getRawValue();
                            String[] lines = rawValue.split("\n");
                            String[]  patientValue = new String[6];
                            int counter = 0;
                            for(String line : lines){
                                patientValue[counter] = line.split(":")[1];
                                counter +=1;
                                        //name id sex age passHash

                            }

                            String patientID = patientValue[1];
                            DatabaseReference patientRef = FirebaseDatabase.getInstance().getReference("Patients");
                            patientRef.child(patientID).addValueEventListener(new ValueEventListener() {
                                @Override
                                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                                    Patient patient = dataSnapshot.getValue(Patient.class);
                                    Intent intent = new Intent(QRPatientForDoc.this,PatientDetailsForDoctor.class);
                                    intent.putExtra("Patient",patient);
                                    startActivity(intent);
                                }

                                @Override
                                public void onCancelled(@NonNull DatabaseError databaseError) {

                                }
                            });


                            int valueType = barcode.getValueType();
                            // See API reference for complete list of supported types
                            switch (valueType) {
                                case FirebaseVisionBarcode.TYPE_WIFI:
                                    String ssid = barcode.getWifi().getSsid();
                                    String password = barcode.getWifi().getPassword();
                                    int type = barcode.getWifi().getEncryptionType();
                                    break;
                                case FirebaseVisionBarcode.TYPE_URL:
                                    String title = barcode.getUrl().getTitle();
                                    String url = barcode.getUrl().getUrl();
                                    break;
                            }
                        }

                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        // Task failed with an exception
                        // ...
                    }
                });
    }
}
