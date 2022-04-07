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

    // This method helps the User to fetch their all Media information from the
    // database.
    @RequestMapping(value = "/media", method = RequestMethod.GET)
    public List<MediaVaultModel> getMediaInfo(@RequestParam("email") String email) throws SQLException {
        return mediaVaultService.getMediaInfo(email);
    }

    // This method helps to retrieve a Media information from the database based on
    // the valut id.
    @RequestMapping(value = "/mediaInfoById", method = RequestMethod.GET)
    public MediaVaultModel mediaInfoById(@RequestParam("id") String id) throws SQLException {
        return mediaVaultService.mediaInfoById(id);
    }

    @RequestMapping(value = "/mediaInfoSave", method = RequestMethod.POST)
    public Boolean mediaInfoSave(@RequestParam("mediaName") String mediaName, @RequestParam("email") String email,
            @RequestParam("audio") MultipartFile audio, @RequestParam("image") MultipartFile image,
            @RequestParam("video") MultipartFile video) throws SQLException, IOException {
        // if(data != null)
        // {
        // byte[] bytes = file.getBytes();
        // data.setImage(bytes);
        // }
        return mediaVaultService.mediaInfoSave(mediaName, email, image, audio, video);
    }

    @RequestMapping("/mediapage")
    public String mediaPage() {
        return "mediainsert.html";
    }

    // This method helps to edit a Media information and save it to the database.
    @RequestMapping(value = "/mediaInfoEditSave", method = RequestMethod.PUT)
    public Boolean mediaInfoEditSave(@RequestParam("mediaName") String mediaName, @RequestParam("email") String email,
            @RequestParam("audio") MultipartFile audio, @RequestParam("image") MultipartFile image,
            @RequestParam("video") MultipartFile video, @RequestParam("vaultId") String vaultId)
            throws SQLException, IOException {

        return mediaVaultService.mediaInfoEditSave(mediaName, email, image, audio, video, vaultId);
    }

    // This method helps to delete a Media information from the database*/
    @RequestMapping(value = "/mediaInfoDelete", method = RequestMethod.DELETE)
    public Boolean mediaInfoDelete(@RequestParam("id") String id) {
        return mediaVaultService.mediaInfoDelete(id);
    }
}
