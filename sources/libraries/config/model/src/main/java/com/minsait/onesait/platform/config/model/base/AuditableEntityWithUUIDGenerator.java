/**
 * Copyright Indra Soluciones Tecnologías de la Información, S.L.U.
 * 2013-2019 SPAIN
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *      http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.minsait.onesait.platform.config.model.base;

import java.io.Serializable;

import org.hibernate.engine.spi.SessionImplementor;
import org.hibernate.id.UUIDGenerator;

public class AuditableEntityWithUUIDGenerator extends UUIDGenerator {  
    
	private static final String ENTITY_NAME = "AuditableEntityWithUUID";
	
    @Override
    public Serializable generate(SessionImplementor session, Object obj) {  
    	Serializable id = session
                .getEntityPersister(ENTITY_NAME, obj)
                .getIdentifier(obj, session);
    	
    	if (id == null || "".equals(id)) {  
    		return super.generate(session, obj);
    	} else {
    		return id;    		 
    	}  
    }
}  