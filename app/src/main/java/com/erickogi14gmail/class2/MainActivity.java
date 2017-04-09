package com.erickogi14gmail.class2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText _edtName,_edtAdm_No,_edtSchool,_edtDepartment,_edtYear,_edtSemister,_edtEmail,_edtPassword;
    Button _btnSave,_btnLogin;
    PrefrenceManager prefrnceManager = new PrefrenceManager();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
if(prefrnceManager.getRedistrationStatus(getApplicationContext()))
{
    startActivity(new Intent(MainActivity.this, Profile.class));
}
        _edtName=(EditText)findViewById(R.id.txt_name);
        _edtAdm_No=(EditText)findViewById(R.id.txt_adm_no);
        _edtSchool=(EditText)findViewById(R.id.txt_schoool);
        _edtDepartment=(EditText)findViewById(R.id.txt_department);
        _edtYear=(EditText)findViewById(R.id.txt_year);
        _edtSemister=(EditText)findViewById(R.id.txt_semister);
        _edtEmail=(EditText)findViewById(R.id.txt_email);
        _edtPassword=(EditText)findViewById(R.id.txt_password);

        _btnSave=(Button) findViewById(R.id.btn_save);
        _btnLogin=(Button) findViewById(R.id.btn_login);



        _btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (_edtName.getText().toString().isEmpty() || _edtSchool.getText().toString().isEmpty() || _edtDepartment.getText().toString().isEmpty()
                        || _edtYear.getText().toString().isEmpty() || _edtSemister.getText().toString().isEmpty()
                        || _edtEmail.getText().toString().isEmpty() || _edtPassword.getText().toString().isEmpty()) {


                    Toast.makeText(MainActivity.this, "ALL FIELDS MUST BE FILLED", Toast.LENGTH_LONG).show();

                } else {

                    if (editPrefrences()) {

                        startActivity(new Intent(MainActivity.this, Login.class));
                    }
                }

            }
        });

        _btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, Login.class));
            }
        });


    }
    private boolean editPrefrences() {
        boolean success= prefrnceManager.writePref(getApplicationContext(),_edtName.getText().toString(),_edtAdm_No.getText().toString(),_edtSchool.getText().toString()
        ,_edtDepartment.getText().toString(),_edtYear.getText().toString(),_edtSemister.getText().toString(),_edtEmail.getText().toString(),
                _edtPassword.getText().toString(),true);



        return success;


    }

}
