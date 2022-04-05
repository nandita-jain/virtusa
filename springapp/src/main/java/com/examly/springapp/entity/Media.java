package com.examly.springapp.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import com.examly.springapp.entity.User;
import java.sql.Blob;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Entity
@Table(name = "media")
public class Media {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
        private int mediaVaultId;
        private String mediaName;
        private Blob image;
        private Blob video;
        private Blob audio;
        @ManyToOne
        private User user;
    
    
        public User getUser() {
            return user;
        }
        public void setUser(User user) {
            this.user = user;
        }
        public int getVaultId() {     
            return mediaVaultId;
        }
        public void setVaultId(int mediaVaultId) {
            this.mediaVaultId = mediaVaultId;
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
