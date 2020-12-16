package com.eshwarne.docblock;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class DoctorLogin extends AppCompatActivity {
    EditText etEmpID;
    EditText etPassword;
    Button btnLogin;
    Doctor doctor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_login);
        final DatabaseReference doctorReference = FirebaseDatabase.getInstance().getReference("Doctors");
        etEmpID = findViewById(R.id.doctorLoginEtEmpID);
        etPassword = findViewById(R.id.doctorLoginEtPassword);
        btnLogin = findViewById(R.id.doctorLoginBtnLogin);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(etEmpID.getText().toString().isEmpty()){
                    etEmpID.setError("Please Enter Your 4 Digit EMP ID");
                    etEmpID.requestFocus();
                    return;
                }
                else if(etPassword.getText().toString().isEmpty()){
                    etPassword.setError("Please Enter Password");
                    etPassword.requestFocus();
                    return;
                }
                else
                {
                    doctorReference.child(etEmpID.getText().toString()).addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            doctor = (Doctor)dataSnapshot.getValue(Doctor.class);
                            if(doctor==null){
                                etPassword.setError("Check Your Credentials");
                                etPassword.requestFocus();
                                return;
                            }
                            if (!doctor.getPassword().equals(etPassword.getText().toString()) ||
                                    !doctor.getEmpid().equals(etEmpID.getText().toString())){
                                etPassword.setError("Check Your Credentials");
                                etPassword.requestFocus();
                                return;

                            }

                            else{
                                Intent intent = new Intent(DoctorLogin.this,DoctorHome.class);
                                intent.putExtra("Doctor", doctor);
                                startActivity(intent);
                            }
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {
                            return;
                        }
                    });
                }
            }
        });
    }
}
