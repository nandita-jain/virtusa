package com.examly.springapp.service;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.examly.springapp.entity.User;
import com.examly.springapp.dao.BankVaultRepository;
import com.examly.springapp.dao.LoginRepository;
import com.examly.springapp.model.BankVaultModel;
import com.examly.springapp.model.UserModel;
import com.examly.springapp.entity.Bank;





@Service
public class BankVaultService {
 
    @Autowired
    private BankVaultRepository bankVaultRepository;

    @Autowired
    private LoginRepository loginRepository;
    
    
    public List<BankVaultModel> getBankInfo(String email){
        List<Bank> bankList =  bankVaultRepository.findByUser_Email(email);
 
         return mapBankEntityToModel(bankList);
     }

     private List<BankVaultModel> mapBankEntityToModel(List<Bank> bankList)
    {
        List<BankVaultModel> bankVaultModelList = new ArrayList<BankVaultModel>();

        for(Bank bank:bankList)
        {
            BankVaultModel vaultModel = new BankVaultModel();
            vaultModel.setVaultId(((Integer)bank.getVaultId()).toString());
            vaultModel.setAccountNumber(bank.getAccountNumber());
            vaultModel.setAccountName(bank.getAccountName());
            vaultModel.setIFSC(bank.getIFSC());
            vaultModel.setUserName(bank.getUserName());
            vaultModel.setPassword(bank.getPassword());
            vaultModel.setUserId(mapUserEntityToModel(bank.getUser()));
            bankVaultModelList.add(vaultModel);
        }
        return bankVaultModelList;
    }

    private UserModel mapUserEntityToModel(User user)
    {
        UserModel userModel = new UserModel();
        userModel.setEmail(user.getEmail());
        userModel.setMobileNumber(user.getMobileNumber());
        userModel.setRole(user.getRole());
        return userModel;
    }

//........................................................................................................
public BankVaultModel bankInfoById(String id){
    Optional<Bank> bankList =  bankVaultRepository.findById(Integer.parseInt(id));
    if(bankList.isPresent())
    {
        Bank bank = bankList.get();
        BankVaultModel vaultModel = new BankVaultModel();
        vaultModel.setVaultId(((Integer)bank.getVaultId()).toString());
            vaultModel.setAccountNumber(bank.getAccountNumber());
            vaultModel.setAccountName(bank.getAccountName());
            vaultModel.setIFSC(bank.getIFSC());
            vaultModel.setUserName(bank.getUserName());
            vaultModel.setPassword(bank.getPassword());
            vaultModel.setUserId(mapUserEntityToModel(bank.getUser()));
        return vaultModel;
    }else{
        return null;
    }
}
//...............................................................................
public Boolean bankInfoSave(BankVaultModel bankModel){
        
    Bank bank = new Bank();
    User userModel=loginRepository.findByEmail(bankModel.getUserId().getEmail().trim());
    bank.setAccountNumber(bankModel.getAccountNumber());
    bank.setAccountName(bankModel.getAccountName());
    bank.setIFSC(bankModel.getIFSC());
    bank.setUserName(bankModel.getUserName());
    bank.setPassword(bankModel.getPassword());
    bank.setUser(userModel);

    bankVaultRepository.save(bank);
    
    
    return true;
}
//......................................................................
public Boolean bankInfoEditSave(BankVaultModel bankModel){
        
    Optional<Bank> bankList =  bankVaultRepository.findById(Integer.parseInt(bankModel.getVaultId()));
    if(bankList.isPresent())
    {
        Bank bank = bankList.get();
        User userModel=loginRepository.findByEmail(bankModel.getUserId().getEmail().trim()); 
        bank.setAccountNumber(bankModel.getAccountNumber());
        bank.setAccountName(bankModel.getAccountName());
        bank.setIFSC(bankModel.getIFSC());
        bank.setUserName(bankModel.getUserName());
        bank.setPassword(bankModel.getPassword());
        bank.setUser(userModel);

        bankVaultRepository.save(bank);
    
    }
    
    
    return true;
}
//...........................................,,,...................................
public Boolean bankInfoDelete(String id){
    bankVaultRepository.deleteById(Integer.parseInt(id));
    return true;
}
}
