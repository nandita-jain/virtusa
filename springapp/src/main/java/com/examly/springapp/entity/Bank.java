package com.examly.springapp.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import com.examly.springapp.entity.User;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import com.examly.springapp.model.UserModel;
import com.examly.springapp.service.BankVaultService;
import com.examly.springapp.entity.Bank;

@Entity
@Table(name="bank")
public class Bank {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int bankVaultId;
    private Long accountNumber;
    private String accountName;
    private String IFSC;
    private String userName;
    public User getUser() {
        return user;
    }
    public void setUser(User user) {
        this.user = user;
    }
    private String password;
    @ManyToOne
        private User user;
    public int getVaultId() {
        return bankVaultId;
    }
    public void setVaultId(int bankVaultId) {
        this.bankVaultId = bankVaultId;
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
        return IFSC;
    }
    public void setIFSC(String iFSC) {
        IFSC = iFSC;
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
