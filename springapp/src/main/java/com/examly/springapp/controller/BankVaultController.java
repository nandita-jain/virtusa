package com.examly.springapp.controller;

import org.springframework.stereotype.Controller;
import com.examly.springapp.service.BankVaultService;
import com.examly.springapp.model.BankVaultModel;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import com.examly.springapp.controller.BankVaultController;
import java.util.*;


@RestController
public class BankVaultController {

    @Autowired
    private BankVaultService bankVaultService;
    

    @RequestMapping(value="/bank", method = RequestMethod.GET)	
	public List<BankVaultModel> getBankInfo(@RequestParam("email")  String email){
        return bankVaultService.getBankInfo(email);
    }

    @RequestMapping(value="/bankInfoById", method = RequestMethod.GET)	
	public BankVaultModel bankInfoById(@RequestParam("id")  String id){
        return bankVaultService.bankInfoById(id);
    }

    @RequestMapping(value="/bankInfoSave", method = RequestMethod.POST)	
	public Boolean bankInfoSave(@RequestBody BankVaultModel data){
        return bankVaultService.bankInfoSave(data);
    }

    @RequestMapping(value="/bankInfoEditSave", method = RequestMethod.PUT)	
	public Boolean bankInfoEditSave(@RequestBody BankVaultModel data){
        return bankVaultService.bankInfoEditSave(data);
    }

    @RequestMapping(value="/bankInfoDelete", method = RequestMethod.DELETE)	
	public Boolean bankInfoDelete(@RequestParam("id") String id){
        return bankVaultService.bankInfoDelete(id);
    }
}
