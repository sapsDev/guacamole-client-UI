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
 * Base implementation watch session which can be used by an instructor
 * to join a session.
 */
public abstract class AbstractWatchSession implements WatchSession {

    /**
     * The unique identifier associated with this watch session.
     */
    private String identifier;


    /**
     * The username of the user associated with this watch session.
     */
    private String username;

    /**
     * Whether this session can be joined with or without restrictions.
     */
    private boolean restriction;

    /**
     * The link that grants access to this watchable session.
     */
    private String link;

    @Override
    public String getIdentifier() {
        return identifier;
    }

    @Override
    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public boolean getRestriction() {
        return restriction;
    }

    @Override
    public void setRestriction(boolean restriction) {
        this.restriction = restriction;
    }

    @Override
    public String getLink() {
        return link;
    }

    @Override
    public void setLink(String link) {
        this.link = link;
    }

    @Override
    public int hashCode() {
        if (identifier == null) return 0;
        return identifier.hashCode();
    }

    @Override
    public boolean equals(Object obj) {

        // Not equal if null or not an WatchSession
        if (obj == null) return false;
        if (!(obj instanceof AbstractWatchSession)) return false;

        // Get identifier
        String objIdentifier = ((AbstractWatchSession) obj).identifier;

        // If null, equal only if this identifier is null
        if (objIdentifier == null) return identifier == null;

        // Otherwise, equal only if strings are identical
        return objIdentifier.equals(identifier);

    }

}
