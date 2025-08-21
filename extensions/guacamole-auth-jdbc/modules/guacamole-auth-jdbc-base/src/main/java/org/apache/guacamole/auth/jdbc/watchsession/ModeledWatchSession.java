/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package org.apache.guacamole.auth.jdbc.watchsession;

import com.google.inject.Inject;
import java.util.Collection;
import java.util.Collections;
import org.apache.guacamole.auth.jdbc.base.ModeledChildDirectoryObject;
import org.apache.guacamole.form.Form;
import org.apache.guacamole.net.auth.WatchSession;

/**
 * An implementation of the WatchSession object which is backed by a database
 * model.
 */
public class ModeledWatchSession
        extends ModeledChildDirectoryObject<WatchSessionModel>
        implements WatchSession {

    /**
     * All possible attributes of watch session objects organized as
     * individual, logical forms. Currently, there are no such attributes.
     */
    public static final Collection<Form> ATTRIBUTES = Collections.<Form>emptyList();

    /**
     * Service for managing watch sessions.
     */
    @Inject
    private WatchSessionService watchSessionService;

    /**
     * Creates a new, empty ModeledWatchSession.
     */
    public ModeledWatchSession() {
    }

    @Override
    public String getUsername() {
        return getModel().getUsername();
    }

    @Override
    public void setUsername(String username) {
        getModel().setUsername(username);
    }
    
    @Override
    public String getConnection() {
        return getModel().getConnection();
    }

    @Override
    public void setConnection(String connection) {
        getModel().setConnection(connection);
    }

    @Override
    public boolean getRestriction() {
        return getModel().getRestriction();
    }

    @Override
    public void setRestriction(boolean restriction) {
        getModel().setRestriction(restriction);
    }

    @Override
    public String getLink() {
        return getModel().getLink();
    }

    @Override
    public void setLink(String link) {
        getModel().setLink(link);
    }

}
