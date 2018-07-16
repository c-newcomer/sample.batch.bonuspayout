package com.ibm.websphere.samples.batch.beans;

import java.io.Serializable;

import javax.persistence.Column;

 
    public class AccountId implements Serializable {
        
        @Column(name = "ACCTNUM", nullable = false)
        int accountNumber; 

        @Column(name = "INSTANCEID", nullable = false)
        long instanceId;

        public int hashCode() {
            return (int)this.instanceId * this.accountNumber;
        }
    
        public boolean equals(Object obj) {
            if (obj == this) return true;
            if (!(obj instanceof AccountId)) return false;
            AccountId pk = (AccountId) obj;
            return pk.instanceId == this.instanceId && pk.accountNumber ==this.accountNumber;
        }
    }