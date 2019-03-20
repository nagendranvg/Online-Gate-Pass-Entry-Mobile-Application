package com.android_examples.firebaseinsertdata_android_examplescom;

/**
 * Created by Juned on 7/25/2017.
 */

public class StudentDetails {


    private String name;
    private String phoneNumber;
    private String department;
    private String purpose;
    private String meetwhom;
    private String date;
    private String chooseTime;

    public StudentDetails() {
        // This is default constructor.
    }

    public String getStudentName() {

        return name;
    }

    public void setStudentName(String name) {

        this.name = name;
    }

    public String getStudentPhoneNumber() {

        return phoneNumber;
    }

    public void setStudentPhoneNumber(String phonenumber) {

        this.phoneNumber = phonenumber;
    }
    public String getDepartment() {

        return department;
    }

    public void setDepartment(String department) {

        this.department = department;
    }
    public String getPurpose() {

        return purpose;
    }

    public void setPurpose(String purpose) {

        this.purpose = purpose;
    }
    public String getMeetwhom() {

        return meetwhom;
    }

    public void setMeetwhom(String meetwhom) {

        this.meetwhom = meetwhom;
    }
    public String getDate() {

        return date;
    }

    public void setDate(String date) {

        this.date = date;
    }
    public String getChooseTime() {

        return chooseTime;
    }

    public void setChooseTime(String chooseTime) {

        this.chooseTime = chooseTime;
    }
}