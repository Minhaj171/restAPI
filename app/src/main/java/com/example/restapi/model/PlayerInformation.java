package com.example.restapi.model;

import android.widget.ImageView;

import androidx.databinding.BindingAdapter;

import com.bumptech.glide.Glide;
import com.example.restapi.R;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Md Minhajul Islam on 10/6/2021.
 */
public class PlayerInformation {
    @SerializedName("resource")
    private String resourceName;
    private int id;
    @SerializedName("country_id")
    private int countryId;
    @SerializedName("firstname")
    private String firstName;
    @SerializedName("lastname")
    private String lastName;
    @SerializedName("fullname")
    private String fullName;
    @SerializedName("image_path")
    private String playerIcon;
    @SerializedName("dateofbirth")
    private String dateOfBirth;
    @SerializedName("gender")
    private String gender;
    @SerializedName("position")
    private List<Position> position;

    public PlayerInformation(String resourceName, int id, int countryId,
                             String firstName, String lastName, String fullName,
                             String playerIcon, String dateOfBirth, String gender,
                             List<Position> position)
    {
        this.resourceName = resourceName;
        this.id = id;
        this.countryId = countryId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.fullName = fullName;
        this.playerIcon = playerIcon;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.position = position;
    }

    public String getResourceName() {
        return resourceName;
    }

    public void setResourceName(String resourceName) {
        this.resourceName = resourceName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCountryId() {
        return countryId;
    }

    public void setCountryId(int countryId) {
        this.countryId = countryId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPlayerIcon() {
        return playerIcon;
    }

    public void setPlayerIcon(String playerIcon) {
        this.playerIcon = playerIcon;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public List<Position> getPosition() {
        return position;
    }

    public void setPosition(List<Position> position) {
        this.position = position;
    }

    @BindingAdapter("android:playerIcon")
    public static void loadImage(ImageView view, String imageUrl) {
        Glide.with(view)
                .load(imageUrl)
                .placeholder(R.drawable.ic_placeholder)
                .error(R.drawable.ic_error)
                .fitCenter()
                .into(view);
    }
}
