package com.eshwarne.docblock;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class PatientDetailsForDoctor extends AppCompatActivity {

    TextView tvName;
    TextView tvAge;
    TextView tvSex;
    TextView tvID;
    Button btnSymptoms;
    Button btnHOP;
    Button btnPescribe;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patient_details_for_doctor);
        tvName = findViewById(R.id.patientDetailsForDocTvName);
        tvAge = findViewById(R.id.patientDetailsForDocTvAge);
        tvSex = findViewById(R.id.patientDetailsForDocTvSex);
        tvID = findViewById(R.id.patientDetailsForDocTvID);
        btnHOP = findViewById(R.id.patientDetailsForDocBtnHop);
        btnPescribe = findViewById(R.id.patientDetailsForDocBtnPescribe);
        btnSymptoms = findViewById(R.id.patientDetailsForDocBtnSymptoms);
        Intent intent = getIntent();
        final Patient patient = (Patient) intent.getSerializableExtra("Patient");
        tvName.setText(tvName.getText()+" "+patient.getName());
        tvAge.setText(tvAge.getText()+" "+patient.getAge());
        tvID.setText(tvID.getText()+" "+patient.getid());
        tvSex.setText(tvSex.getText()+" "+patient.getSex());
        btnSymptoms.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(PatientDetailsForDoctor.this,PatientConstants.getSymptoms(patient.getCurrentSymptoms()),Toast.LENGTH_LONG).show();
            }
        });
        btnPescribe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(PatientDetailsForDoctor.this,PrescribeDoctor.class));
            }
        });
    }
}
