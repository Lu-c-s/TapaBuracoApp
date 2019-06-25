package com.tapaburaco.company.tapaburaco;

import android.location.Location;

import java.io.File;

public class Complaint {
    private long id;
    private String userEmail;
    private Location complaintPhotoLocation;
    private String locationString;
    private File complaintPhoto;
    private String description;

    public Complaint() {}

    public Complaint(long id, String userEmail, Location complaintPhotoLocation, String locationString, File complaintPhoto, String description) {
        this.id = id;
        this.userEmail = userEmail;
        this.complaintPhotoLocation = complaintPhotoLocation;
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

    public Location getComplaintPhotoLocation() {
        return complaintPhotoLocation;
    }

    public void setComplaintPhotoLocation(Location complaintPhotoLocation) {
        this.complaintPhotoLocation = complaintPhotoLocation;
    }

    public File getComplaintPhoto() {
        return complaintPhoto;
    }

    public void setComplaintPhoto(File complaintPhoto) {
        this.complaintPhoto = complaintPhoto;
    }
}
