package com.examly.springapp.controller;

import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;
import java.sql.SQLException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;
import com.examly.springapp.service.MediaVaultService;
import com.examly.springapp.model.MediaVaultModel;
import org.springframework.web.multipart.MultipartFile;
import java.util.*;

@RestController
public class MediaVaultController {
    
    @Autowired
    private MediaVaultService mediaVaultService;

    @RequestMapping(value="/media", method = RequestMethod.GET)	
	public List<MediaVaultModel> getMediaInfo(@RequestParam("email")  String email)throws SQLException{
        return mediaVaultService.getMediaInfo(email);
    }

    @RequestMapping(value="/mediaInfoById", method = RequestMethod.GET)	
	public MediaVaultModel mediaInfoById(@RequestParam("id")  String id)throws SQLException{
        return mediaVaultService.mediaInfoById(id);
    }

    @RequestMapping(value="/mediaInfoSave", method = RequestMethod.POST)	
	public Boolean mediaInfoSave(@RequestBody MediaVaultModel data)throws SQLException, IOException{
                // if(data != null)
                // {
                //     byte[] bytes = file.getBytes();
                //     data.setImage(bytes);
                // }
                return mediaVaultService.mediaInfoSave(data);
    }

    @RequestMapping(value="/mediaInfoEditSave", method = RequestMethod.PUT)	
	public Boolean mediaInfoEditSave(@RequestBody MediaVaultModel data)throws SQLException{
        
        return mediaVaultService.mediaInfoEditSave(data);
    }

    @RequestMapping(value="/mediaInfoDelete", method = RequestMethod.DELETE)	
	public Boolean mediaInfoDelete(@RequestParam("id") String id){
        return mediaVaultService.mediaInfoDelete(id);
    }
}
