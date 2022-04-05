package com.examly.springapp.service;


import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.examly.springapp.model.MediaVaultModel;
import com.examly.springapp.entity.Media;
import com.examly.springapp.dao.MediaVaultRepository;


@Service
public class MediaVaultService {

    @Autowired
    private MediaVaultRepository mediaVaultRepository;

    public List<MediaVaultModel> getMediaInfo(String email){
       List<Media> mediaList =  mediaVaultRepository.findByUser_Email(email);

        return mapMediaEntityToModel(mediaList);
    }

    public MediaVaultModel mediaInfoById(String id){
        Optional<Media> mediaList =  mediaVaultRepository.findById(id);
        if(mediaList.isPresent())
        {
            Media media = mediaList.get();
            MediaVaultModel vaultModel = new MediaVaultModel();
            vaultModel.setVaultId(media.getVaultId());
            vaultModel.setMediaName(media.getMediaName());
            vaultModel.setImage(media.getImage());
            vaultModel.setAudio(media.getAudio());
            vaultModel.setEmail(media.getUser().getEmail());
            return vaultModel;
        }else{
            return null;
        }
    }
//............................................................................
    private List<MediaVaultModel> mapMediaEntityToModel(List<Media> mediaList)
    {
        List<MediaVaultModel> mediaVaultModelList = new ArrayList<MediaVaultModel>();

        for(Media media:mediaList)
        {
            MediaVaultModel vaultModel = new MediaVaultModel();
            vaultModel.setVaultId(media.getVaultId());
            vaultModel.setMediaName(media.getMediaName());
            vaultModel.setImage(media.getImage());
            vaultModel.setAudio(media.getAudio());
            vaultModel.setEmail(media.getUser().getEmail());
            mediaVaultModelList.add(vaultModel);
        }
        return mediaVaultModelList;
    }
}
