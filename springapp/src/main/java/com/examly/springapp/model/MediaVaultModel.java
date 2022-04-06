package com.examly.springapp.model;

import java.sql.Blob;

import org.springframework.stereotype.Component;

@Component
public class MediaVaultModel {
    private String vaultId;
    private String mediaName;
    private String image;
    private String video;
    private String audio;
    private UserModel userId; 
    private String email;
    
    @Override
    public String toString() {
        return "MediaVaultModel [audio=" + audio + ", email=" + email + ", image=" + image + ", mediaName=" + mediaName
                + ", userId=" + userId + ", vaultId=" + vaultId + ", video=" + video + "]";
    }
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
    public String  getImage() {
        return image;
    }
    public void setImage(String  image) {
        this.image = image;
    }
    public String  getVideo() {
        return video;
    }
    public void setVideo(String  video) {
        this.video = video;
    }
    public String  getAudio() {
        return audio;
    }
    public void  setAudio(String  audio) {
        this.audio = audio;
    }
}