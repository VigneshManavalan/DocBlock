package com.eshwarne.docblock;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class DoctorHome extends AppCompatActivity {
    TextView tvDocName;
    Button btnScanQR;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_home);
        tvDocName = findViewById(R.id.doctorHomeWelcomeDoctor);
        btnScanQR = findViewById(R.id.doctorHomeScanPatientQR);
        Intent intent = getIntent();
        Doctor doctor = (Doctor)intent.getSerializableExtra("Doctor");
        tvDocName.setText("Welcome Dr.\n"+doctor.getName());
        btnScanQR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(DoctorHome.this,QRPatientForDoc.class));
            }
        });

    }
}
