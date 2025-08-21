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

package org.apache.guacamole.rest.watchsession;

import org.apache.guacamole.net.auth.WatchSession;

/**
 * Wrapper for APIWatchSession which provides a WatchSession interface.
 * Changes to the underlying APIWatchSession are reflected immediately in the
 * values exposed by the WatchSession interface, and changes made through the
 * WatchSession interface immediately affect the underlying APIWatchSession.
 */
public class APIWatchSessionWrapper implements WatchSession {

    /**
     * The wrapped APIWatchSession.
     */
    private final APIWatchSession apiWatchSession;

    /**
     * Creates a new APIWatchSessionWrapper which is backed by the given
     * APIWatchSession.
     *
     * @param apiWatchSession
     *     The APIWatchSession to wrap.
     */
    public APIWatchSessionWrapper(APIWatchSession apiWatchSession) {
        this.apiWatchSession = apiWatchSession;
    }

    @Override
    public String getIdentifier() {
        return apiWatchSession.getIdentifier();
    }

    @Override
    public void setIdentifier(String identifier) {
        apiWatchSession.setIdentifier(identifier);
    }

    @Override
    public String getUsername() {
        return apiWatchSession.getUsername();
    }

    @Override
    public void setUsername(String name) {
        apiWatchSession.setUsername(name);
    }
    
    @Override
    public String getConnection() {
        return apiWatchSession.getConnection();
    }

    @Override
    public void setConnection(String connection) {
        apiWatchSession.setConnection(connection);
    }    

    @Override
    public boolean getRestriction() {
        return apiWatchSession.getRestriction();
    }

    @Override
    public void setRestriction(boolean restriction) {
        apiWatchSession.setRestriction(restriction);
    }

    @Override
    public String getLink() {
        return apiWatchSession.getLink();
    }

    @Override
    public void setLink(String link) {
        apiWatchSession.setLink(link);
    }

}
