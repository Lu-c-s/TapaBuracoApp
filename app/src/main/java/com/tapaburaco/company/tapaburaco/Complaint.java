package com.tapaburaco.company.tapaburaco;

import android.graphics.Bitmap;
import android.location.Location;

import java.io.File;

public class Complaint {
    private long id;
    private String userEmail;
    private String locationString;
    private Bitmap complaintPhoto;
    private String description;

    public Complaint() {}

    public Complaint(long id, String userEmail, String locationString, Bitmap complaintPhoto, String description) {
        this.id = id;
        this.userEmail = userEmail;
        this.locationString = locationString;
        this.complaintPhoto = complaintPhoto;
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLocationString() {
        return locationString;
    }

    public void setLocationString(String locationString) {
        this.locationString = locationString;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public Bitmap getComplaintPhoto() {
        return complaintPhoto;
    }

    public void setComplaintPhoto(Bitmap complaintPhoto) {
        this.complaintPhoto = complaintPhoto;
    }

    @Override
    public String toString() {
        return "Complaint{" +
                "id=" + id +
                ", userEmail='" + userEmail + '\'' +
                ", locationString='" + locationString + '\'' +
                ", complaintPhoto=" + complaintPhoto +
                ", description='" + description + '\'' +
                '}';
    }
}
