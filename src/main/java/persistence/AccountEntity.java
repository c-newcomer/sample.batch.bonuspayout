// package application.servlet;
package persistence;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ACCOUNT", schema = "BONUSPAYOUT") 
public class AccountEntity implements Serializable {
    private static final long serialVersionUID = 1L; // check if needed
    @Column(name = "ACCTNUM", nullable = false)
    @Id
    private int accountNumber;

    @Column(name = "BALANCE", nullable = false)
    private int balance;

    @Column(name = "INSTANCEID", nullable = false)
    @Id
    private long instanceId;

    @Column(name = "ACCTCODE")
    private String accountCode;

    public AccountEntity() {
    }

    public int getAccountNumber() {
        return this.accountNumber;
    }

    public int getBalance() {
        return this.balance;
    }

    public long getInstanceID() {
        return this.instanceId;
    }

    public String getAccountCode() {
        return this.accountCode;
    }

    public void setAccountNumber(int newAccountNumber) {
        this.accountNumber = newAccountNumber;
    }

    public void setBalance(int newBalance) {
        this.balance = newBalance;
    }

    public void setInstanceId(long newInstanceId) {
        this.instanceId = newInstanceId;
    }

    public void setAccountCode(String newAccountCode) {
        this.accountCode = newAccountCode;
    }

    @Override
    public String toString() {
        return "AccountEntity[" + this.accountNumber + "," + this.instanceId + "]";
    }
}
