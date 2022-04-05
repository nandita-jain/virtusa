package com.examly.springapp.model;
import org.springframework.stereotype.Component;

@Component
public class BankVaultModel {
    private String vaultId;
    private Long accountNumber;
    private String accountName;
    private String ifsc;
    private String userName;
    private String password;
    private UserModel userId;


    public UserModel getUserId() {
        return userId;
    }
    public void setUserId(UserModel userId) {
        this.userId = userId;
    }
    public String getVaultId() {
        return vaultId;
    }
    public void setVaultId(String vaultId) {
        this.vaultId = vaultId;
    }
    public Long getAccountNumber() {
        return accountNumber;
    }
    public void setAccountNumber(Long accountNumber) {
        this.accountNumber = accountNumber;
    }
    public String getAccountName() {
        return accountName;
    }
    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }
    public String getIFSC() {
        return ifsc;
    }
    public void setIFSC(String ifsc) {
        this.ifsc = ifsc;
    }
    public String getUserName() {
        return userName;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
}
