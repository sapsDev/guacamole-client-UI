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

package org.apache.guacamole.net.auth;

/**
 * WatchSession implementation which simply delegates all function calls to an
 * underlying WatchSession.
 */
public class DelegatingWatchSession implements WatchSession {

    /**
     * The wrapped WatchSession.
     */
    private final WatchSession watchSession;

    /**
     * Wraps the given WatchSession such that all function calls against this
     * DelegatingWatchSession will be delegated to it.
     *
     * @param watchSession
     *     The WatchSession to wrap.
     */
    public DelegatingWatchSession(WatchSession watchSession) {
        this.watchSession = watchSession;
    }

    /**
     * Returns the underlying WatchSession wrapped by this
     * DelegatingWatchSession.
     *
     * @return
     *     The WatchSession wrapped by this DelegatingWatchSession.
     */
    protected WatchSession getDelegateWatchSession() {
        return watchSession;
    }

    @Override
    public String getIdentifier() {
        return watchSession.getIdentifier();
    }

    @Override
    public void setIdentifier(String identifier) {
        watchSession.setIdentifier(identifier);
    }

    @Override
    public String getUsername() {
        return watchSession.getUsername();
    }

    @Override
    public void setUsername(String username) {
        watchSession.setUsername(username);
    }
    
    @Override
    public String getConnection() {
        return watchSession.getConnection();
    }

    @Override
    public void setConnection(String connection) {
        watchSession.setConnection(connection);
    }
    
    @Override
    public String getUUID() {
        return watchSession.getUUID();
    }
    
    @Override
    public void setUUID(String uuid) {
        watchSession.setUUID(uuid);
    }

    @Override
    public boolean getRestriction() {
        return watchSession.getRestriction();
    }

    @Override
    public void setRestriction(boolean restriction) {
        watchSession.setRestriction(restriction);
    }

    @Override
    public String getLink() {
        return watchSession.getLink();
    }

    @Override
    public void setLink(String link) {
        watchSession.setLink(link);
    }

}
