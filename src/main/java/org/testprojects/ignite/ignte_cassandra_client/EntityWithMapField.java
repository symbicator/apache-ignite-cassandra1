package org.testprojects.ignite.ignte_cassandra_client;/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import org.apache.ignite.cache.query.annotations.QuerySqlField;

/**
 * Simple POJO without getters/setters which could be stored as a value in Ignite cache
 */
public class EntityWithMapField implements Serializable {
    /** */
    private static final long serialVersionUID = 0L;

    /** */
    @QuerySqlField(name = "attributes")
    private Map<String, String> attrs;

    /** */
    @SuppressWarnings("UnusedDeclaration")
    public EntityWithMapField() {
    }

    /** */
    public EntityWithMapField(EntityWithMapField entityWithMapField) {
        attrs = new HashMap<>(entityWithMapField.attrs);
    }

    /** */
    public EntityWithMapField(Map<String, String> attrs) {
        this.attrs = new HashMap<>(attrs);
    }

    public Map<String, String> getAttrs() {
        return attrs;
    }

    public void setAttrs(Map<String, String> attrs) {
        this.attrs = new HashMap<>(attrs);
    }

    /** {@inheritDoc} *//*
    @Override public void writeExternal(ObjectOutput out) throws IOException {
        out.writeObject(attrs);
    }

    *//** {@inheritDoc} *//*
    @SuppressWarnings("unchecked")
    @Override public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        attrs = (Map<String, String>)in.readObject();
    }*/

    /** {@inheritDoc} */
    @SuppressWarnings("SimplifiableIfStatement")
    @Override public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof EntityWithMapField))
            return false;

        EntityWithMapField entityWithMapField = (EntityWithMapField)obj;

        if ((attrs != null && !attrs.equals(entityWithMapField.attrs)) ||
            (entityWithMapField.attrs != null && !entityWithMapField.attrs.equals(attrs)))
            return false;

        return true;
    }

    /** */
    @SuppressWarnings("SimplifiableIfStatement")
    public boolean equalsPrimitiveFields(Object obj) {
        if (obj == null || !(obj instanceof EntityWithMapField))
            return false;

        EntityWithMapField entityWithMapField = (EntityWithMapField)obj;

        return attrs != null && attrs.equals(entityWithMapField.attrs);
    }

    @Override public String toString() {
        return "org.testprojects.ignite.ignte_cassandra_client.EntityWithMapField{" +
            "attrs=" + attrs +
            '}';
    }
}
