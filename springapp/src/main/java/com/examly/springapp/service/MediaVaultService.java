package com.examly.springapp.service;


import java.io.IOException;
import java.sql.Blob;
import java.util.*;
import java.sql.SQLException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.examly.springapp.model.MediaVaultModel;
import com.examly.springapp.entity.Media;
import com.examly.springapp.entity.User;
import com.examly.springapp.dao.MediaVaultRepository;
import com.examly.springapp.dao.LoginRepository;
import javax.sql.rowset.serial.SerialBlob;
import javax.sql.rowset.serial.SerialException;


@Service
public class MediaVaultService {

    @Autowired
    private MediaVaultRepository mediaVaultRepository;

    @Autowired
    private LoginRepository loginRepository;

    public List<MediaVaultModel> getMediaInfo(String email) throws SQLException{
       List<Media> mediaList =  mediaVaultRepository.findByUser_Email(email);

        return mapMediaEntityToModel(mediaList);
    }

    public MediaVaultModel mediaInfoById(String id) throws SQLException{
        Optional<Media> mediaList =  mediaVaultRepository.findById(Integer.parseInt(id));
        if(mediaList.isPresent())
        {
            Media media = mediaList.get();
            MediaVaultModel vaultModel = new MediaVaultModel();
            vaultModel.setVaultId(((Integer)media.getVaultId()).toString());
            vaultModel.setMediaName(media.getMediaName());
            vaultModel.setImage(media.getImage());
            vaultModel.setAudio(media.getAudio());
            vaultModel.setVideo(media.getVideo());
            vaultModel.setEmail(media.getUser().getEmail());
            //System.out.println(vaultModel.toString());
            return vaultModel;
        }else{
            return null;
        }
    }
//............................................................................
    private List<MediaVaultModel> mapMediaEntityToModel(List<Media> mediaList) throws SQLException
    {
        List<MediaVaultModel> mediaVaultModelList = new ArrayList<MediaVaultModel>();

        for(Media media:mediaList)
        {
            MediaVaultModel vaultModel = new MediaVaultModel();
            vaultModel.setVaultId(((Integer)media.getVaultId()).toString());
            vaultModel.setMediaName(media.getMediaName());
            vaultModel.setImage(media.getImage());
            vaultModel.setAudio(media.getAudio());
            vaultModel.setVideo(media.getVideo());
            vaultModel.setEmail(media.getUser().getEmail());
            mediaVaultModelList.add(vaultModel);
        }
        return mediaVaultModelList;
    }
//.............................................................
public Boolean mediaInfoSave(String mediaName,String email,MultipartFile image,MultipartFile audio,MultipartFile video) throws IOException{
        
    Media media = new Media();
    User userModel=loginRepository.findByEmail(email.trim());
    media.setMediaName(mediaName);
    media.setImage(Base64.getEncoder().encodeToString(image.getBytes()));
    media.setVideo(Base64.getEncoder().encodeToString(video.getBytes()));
    media.setAudio(Base64.getEncoder().encodeToString(audio.getBytes()));
    media.setUser(userModel);
    mediaVaultRepository.save(media);
    
    
    return true;
}
//......................................................................
public Boolean mediaInfoEditSave(String mediaName,String email,MultipartFile image,MultipartFile audio,MultipartFile video,String vaultId) throws IOException{
            
    Optional<Media> mediaList =  mediaVaultRepository.findById(Integer.parseInt(vaultId));
    if(mediaList.isPresent())
    {
        Media media = new Media();
    User userModel=loginRepository.findByEmail(email.trim());
    media.setMediaName(mediaName);
    media.setImage(Base64.getEncoder().encodeToString(image.getBytes()));
    media.setVideo(Base64.getEncoder().encodeToString(video.getBytes()));
    media.setAudio(Base64.getEncoder().encodeToString(audio.getBytes()));
    media.setUser(userModel);
    mediaVaultRepository.save(media);
    }
    
    
    return true;
}
//..........................................................................
public Boolean mediaInfoDelete(String id){
            mediaVaultRepository.deleteById(Integer.parseInt(id));
            return true;
}
}


