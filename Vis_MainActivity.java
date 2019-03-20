package com.android_examples.firebaseinsertdata_android_examplescom;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;
import android.widget.Toast;
import com.firebase.client.Firebase;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Calendar;

public class Vis_MainActivity extends AppCompatActivity {

    Button SubmitButton ;
    private EditText date,chooseTime;
    DatePickerDialog datePickerDialog;
    EditText NameEditText, PhoneNumberEditText,depte,purpose,meet_whom;

    // Declaring String variable ( In which we are storing firebase server URL ).
    public static final String Firebase_Server_URL = "https://insertdata-android-examples.firebaseio.com/";

    // Declaring String variables to store name & phone number get from EditText.
    String NameHolder, NumberHolder,DepartmentHolder,PurposeHolder,Meet_whomHolder,TimeHolder,DateHolder;

    Firebase firebase;

    DatabaseReference databaseReference;

    // Root Database Name for Firebase Database.
    String Database_Path = "Student_Details_Database";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vis_main);

        Firebase.setAndroidContext(Vis_MainActivity.this);

        firebase = new Firebase(Firebase_Server_URL);

        databaseReference = FirebaseDatabase.getInstance().getReference(Database_Path);

        SubmitButton = (Button)findViewById(R.id.submit);

        NameEditText = (EditText)findViewById(R.id.name);

        PhoneNumberEditText = (EditText)findViewById(R.id.phone_number);
        depte=(EditText)findViewById(R.id.dept);
        purpose=(EditText)findViewById(R.id.purpose);
        meet_whom=(EditText)findViewById(R.id.meet_who);
        //Date start code
        date=(EditText)findViewById(R.id.date);
        date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar calendar=Calendar.getInstance();
                int year=calendar.get(Calendar.YEAR);
                int month=calendar.get(Calendar.MONTH);
                final int day=calendar.get(Calendar.DAY_OF_MONTH);

                datePickerDialog=new DatePickerDialog(Vis_MainActivity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        date.setText(day+"-"+(month+1)+"-"+year);
                    }
                },year,month,day);
                datePickerDialog.show();
            }
        });
        //date end code
        //temes tart code
        chooseTime =(EditText) findViewById(R.id.time);
        chooseTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar calendar = Calendar.getInstance();
                int currentHour = calendar.get(Calendar.HOUR_OF_DAY);
                int currentMinute = calendar.get(Calendar.MINUTE);

                TimePickerDialog timePickerDialog = new TimePickerDialog(Vis_MainActivity.this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker timePicker, int hourOfDay, int minutes) {
                        String amPm;
                        if (hourOfDay >= 12) {
                            amPm = "PM";
                        } else {
                            amPm = "AM";
                        }
                        chooseTime.setText(String.format("%02d:%02d", hourOfDay, minutes) + amPm);
                        chooseTime.setText(String.format("%02d:%02d", hourOfDay, minutes));
                        chooseTime.setText(hourOfDay + ":" + minutes);
                    }
                }, currentHour, currentMinute, false);
                timePickerDialog.show();
            }
        });
        //time end code

        SubmitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                StudentDetails studentDetails = new StudentDetails();

                GetDataFromEditText();

                // Adding name into class function object.
                studentDetails.setStudentName(NameHolder);

                // Adding phone number into class function object.
                studentDetails.setStudentPhoneNumber(NumberHolder);

                studentDetails.setDepartment(DepartmentHolder);
                studentDetails.setPurpose(PurposeHolder);
                studentDetails.setMeetwhom(Meet_whomHolder);
                studentDetails.setChooseTime(TimeHolder);
                studentDetails.setDate(DateHolder);
                // Getting the ID from firebase database.
                String StudentRecordIDFromServer = databaseReference.push().getKey();

                // Adding the both name and number values using student details class object using ID.
                databaseReference.child(StudentRecordIDFromServer).setValue(studentDetails);

                // Showing Toast message after successfully data submit.
                Toast.makeText(Vis_MainActivity.this,"Data Inserted Successfully", Toast.LENGTH_LONG).show();
                Intent dbf=new Intent(Vis_MainActivity.this,LogoutActivity.class);
                startActivity(dbf);
            }
        });

    }

    public void GetDataFromEditText(){

        NameHolder = NameEditText.getText().toString().trim();

        NumberHolder = PhoneNumberEditText.getText().toString().trim();
        DepartmentHolder=depte.getText().toString().trim();
        PurposeHolder=purpose.getText().toString().trim();
        Meet_whomHolder=meet_whom.getText().toString().trim();
        TimeHolder=chooseTime.getText().toString().trim();
        DateHolder=date.getText().toString().trim();
    }
}