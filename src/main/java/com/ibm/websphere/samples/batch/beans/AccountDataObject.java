/*
 * Copyright 2014 International Business Machines Corp.
 * 
 * See the NOTICE file distributed with this work for additional information
 * regarding copyright ownership. Licensed under the Apache License, 
 * Version 2.0 (the "License"); you may not use this file except in compliance
 * with the License. You may obtain a copy of the License at
 * 
 *   http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.ibm.websphere.samples.batch.beans;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.IdClass;
import javax.persistence.Transient;

@Entity
@IdClass(AccountId.class)
@Table(name = "ACCOUNT", schema = "BONUSPAYOUT")
public class AccountDataObject {
    private static final long serialVersionUID = 1L;

    @Column(name = "BALANCE", nullable = false)
    private int balance;

    @Column(name = "ACCTCODE")
    private String accountCode;

    @Column(name = "ACCTNUM", nullable = false)
    @Id
    private int accountNumber;

    @Column(name = "INSTANCEID", nullable = false)
    @Id
    private long instanceId;

    // private AccountId accountId = new AccountId();
    @Transient
    private AccountDataObject compareToDataObject;

    public AccountDataObject() {
    }

    /**
     * @param accountNumber
     * @param balance
     * @param accountCode
     */
    public AccountDataObject(int accountNumber, int balance, String accountCode) {
        super();
        this.balance = balance;
        this.accountCode = accountCode;
        this.accountNumber = accountNumber;

    }

    /**
     * @return the accountNumber
     */
    public int getAccountNumber() {
        return accountNumber;
    }

    /**
     * @param accountNumber the accountNumber to set
     */
    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    /**
     * @return the balance
     */
    public int getBalance() {
        return balance;
    }

    /**
     * @param balance the balance to set
     */
    public void setBalance(int balance) {
        this.balance = balance;
    }

    /**
     * @return the accountCode
     */
    public String getAccountCode() {
        return accountCode;
    }

    /**
     * @param accountCode the accountCode to set
     */
    public void setAccountCode(String accountCode) {
        this.accountCode = accountCode;
    }

    public long getInstanceID() {
        return this.instanceId;
    }

    public void setInstanceId(long newInstanceId) {
        this.instanceId = newInstanceId;
    }

    /**
     * @return the compareToDataObject
     */
    public AccountDataObject getCompareToDataObject() {
        return compareToDataObject;
    }

    /**
     * @param compareToDataObject
     */
    public void setCompareToDataObject(AccountDataObject compareToDataObject) {
        this.compareToDataObject = compareToDataObject;
    }

}
