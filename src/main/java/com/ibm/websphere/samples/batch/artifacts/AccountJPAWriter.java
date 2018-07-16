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
package com.ibm.websphere.samples.batch.artifacts;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;
import java.util.logging.Logger;

import javax.batch.api.BatchProperty;
import javax.batch.api.chunk.AbstractItemWriter;
import javax.batch.api.chunk.ItemWriter;
import javax.batch.runtime.context.JobContext;
import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import javax.sql.DataSource;

import com.ibm.websphere.samples.batch.beans.AccountDataObject;
import com.ibm.websphere.samples.batch.util.BonusPayoutConstants;
import com.ibm.websphere.samples.batch.util.BonusPayoutUtils;

import javax.persistence.PersistenceContext;
import javax.persistence.EntityManager;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 * Loops through the items list building and finally executing a batch insert.
 * 
 * Follow get-use-close pattern with JDBC Connection.
 */
@PersistenceContext(unitName = "bonuspayoutpersistenceunit", name = "persistence/em")
@Dependent
public class AccountJPAWriter extends AbstractItemWriter implements ItemWriter, BonusPayoutConstants {

    private final static Logger logger = Logger.getLogger(BONUS_PAYOUT_LOGGER);

    private EntityManager em;

    @Inject
    private JobContext jobCtx;

    @Override
    public void open(Serializable checkpoint) {
        try {
            InitialContext ic = new InitialContext();
            em = (EntityManager) ic.lookup("java:comp/env/persistence/em"); // edit
        } catch (NamingException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void writeItems(List<Object> items) throws Exception {
        for (Object o : items) {
            AccountDataObject ado = (AccountDataObject)o;
            ado.setInstanceId(jobCtx.getInstanceId());
            em.persist(ado); 
        }
    }
}
