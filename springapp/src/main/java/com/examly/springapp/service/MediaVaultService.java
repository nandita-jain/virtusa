package com.examly.springapp.service;


import java.sql.Blob;
import java.util.*;
import java.sql.SQLException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
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
            vaultModel.setImage(blobToByte(media.getImage()));
            vaultModel.setAudio(blobToByte(media.getAudio()));
            vaultModel.setVideo(blobToByte(media.getVideo()));
            vaultModel.setEmail(media.getUser().getEmail());
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
            vaultModel.setImage(blobToByte(media.getImage()));
            vaultModel.setAudio(blobToByte(media.getAudio()));
            vaultModel.setVideo(blobToByte(media.getVideo()));
            vaultModel.setEmail(media.getUser().getEmail());
            mediaVaultModelList.add(vaultModel);
        }
        return mediaVaultModelList;
    }
//.............................................................
public Boolean mediaInfoSave(MediaVaultModel mediaModel) throws SQLException{
        
    Media media = new Media();
    User userModel=loginRepository.findByEmail(mediaModel.getEmail().trim());
    media.setMediaName(mediaModel.getMediaName());
    media.setImage(byteToBlob(mediaModel.getImage()));
    media.setVideo(byteToBlob(mediaModel.getVideo()));
    media.setAudio(byteToBlob(mediaModel.getAudio()));
    media.setUser(userModel);
    mediaVaultRepository.save(media);
    
    
    return true;
}
//......................................................................
public Boolean mediaInfoEditSave(MediaVaultModel mediaModel) throws SQLException{
            
    Optional<Media> mediaList =  mediaVaultRepository.findById(Integer.parseInt(mediaModel.getVaultId()));
    if(mediaList.isPresent())
    {
        Media media = mediaList.get();
        User userModel=loginRepository.findByEmail(mediaModel.getEmail().trim()); 
        media.setMediaName(mediaModel.getMediaName());
        media.setImage(byteToBlob(mediaModel.getImage()));
        media.setVideo(byteToBlob(mediaModel.getVideo()));
        media.setAudio(byteToBlob(mediaModel.getAudio()));
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
private Blob byteToBlob(byte[] obj)throws SQLException{
    if(obj == null)
        return null;
    else{
        return new SerialBlob(obj);
    }
}
private byte[] blobToByte(Blob blob)throws SQLException{
    if(blob == null)
        return new byte[0];
    else{
        int blobLength = (int) blob.length();
        return blob.getBytes(1, blobLength);
    }
    
}
}


