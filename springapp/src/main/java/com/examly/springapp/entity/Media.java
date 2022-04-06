package com.examly.springapp.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Lob;
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
        @Lob
        @Column(columnDefinition = "MEDIUMBLOB")
        private String image;
        @Lob
        @Column(columnDefinition = "MEDIUMBLOB")
        private String video;
        @Lob
        @Column(columnDefinition = "MEDIUMBLOB")
        private String audio;
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
        public String getImage() {
            return image;
        }
        public void setImage(String image) {
            this.image = image;
        }
        public String getVideo() {
            return video;
        }
        public void setVideo(String video) {
            this.video = video;
        }
        public String getAudio() {
            return audio;
        }
        public void setAudio(String audio) {
            this.audio = audio;
        }
    }
