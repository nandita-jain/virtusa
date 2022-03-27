package com.examly.springapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;
import com.examly.springapp.service.MediaVaultService;
import com.examly.springapp.model.MediaVaultModel;
import java.util.*;

@RestController
public class MediaVaultController {
    
    @Autowired
    private MediaVaultService mediaVaultService;

    @RequestMapping(value="/media", method = RequestMethod.GET)	
	public List<MediaVaultModel> getMediaInfo(@RequestParam("email")  String email){
        return mediaVaultService.getMediaInfo(email);
    }
}
