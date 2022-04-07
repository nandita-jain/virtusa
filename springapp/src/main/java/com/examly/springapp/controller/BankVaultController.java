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

    // This method helps the User to fetch their all bank information from the
    // database.
    @RequestMapping(value = "/bank", method = RequestMethod.GET)
    public List<BankVaultModel> getBankInfo(@RequestParam("email") String email) {
        return bankVaultService.getBankInfo(email);
    }

    // This method helps to retrieve a Bank information from the database based on
    // the valut id.
    @RequestMapping(value = "/bankInfoById", method = RequestMethod.GET)
    public BankVaultModel bankInfoById(@RequestParam("id") String id) {
        return bankVaultService.bankInfoById(id);
    }

    // This method helps to edit a Bank information and save it to the database.
    @RequestMapping(value = "/bankInfoSave", method = RequestMethod.POST)
    public Boolean bankInfoSave(@RequestBody BankVaultModel data) {
        return bankVaultService.bankInfoSave(data);
    }

    // This method helps to add a new Bank information to the database.
    @RequestMapping(value = "/bankInfoEditSave", method = RequestMethod.PUT)
    public Boolean bankInfoEditSave(@RequestBody BankVaultModel data) {
        return bankVaultService.bankInfoEditSave(data);
    }

    // This method helps to delete a Bank information from the database.
    @RequestMapping(value = "/bankInfoDelete", method = RequestMethod.DELETE)
    public Boolean bankInfoDelete(@RequestParam("id") String id) {
        return bankVaultService.bankInfoDelete(id);
    }
}
