package com.examly.springapp.model;

import java.sql.Blob;

import org.springframework.stereotype.Component;

@Component
public class MediaVaultModel {
    private String vaultId;
    private String mediaName;
    private Blob image;
    private Blob video;
    private Blob audio;
    private UserModel userId; 
    private String email;

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public UserModel getUserId() {
        return userId;
    }
    public void setUserId(UserModel userId) {
        this.userId = userId;
    }
    public String getVaultId() {
        return vaultId;
    }
    public void setVaultId(String vaultId) {
        this.vaultId = vaultId;
    }
    public String getMediaName() {
        return mediaName;
    }
    public void setMediaName(String mediaName) {
        this.mediaName = mediaName;
    }
    public Blob getImage() {
        return image;
    }
    public void setImage(Blob image) {
        this.image = image;
    }
    public Blob getVideo() {
        return video;
    }
    public void setVideo(Blob video) {
        this.video = video;
    }
    public Blob getAudio() {
        return audio;
    }
    public void setAudio(Blob audio) {
        this.audio = audio;
    }
}