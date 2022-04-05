package com.examly.springapp.model;

import java.sql.Blob;

import org.springframework.stereotype.Component;

@Component
public class MediaVaultModel {
    private String vaultId;
    private String mediaName;
    private byte[] image;
    private byte[] video;
    private byte[] audio;
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
    public byte[]  getImage() {
        return image;
    }
    public void setImage(byte[]  image) {
        this.image = image;
    }
    public byte[]  getVideo() {
        return video;
    }
    public void setVideo(byte[]  video) {
        this.video = video;
    }
    public byte[]  getAudio() {
        return audio;
    }
    public void  setAudio(byte[]  audio) {
        this.audio = audio;
    }
}