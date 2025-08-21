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

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import org.apache.guacamole.net.auth.WatchSession;

/**
 * The external representation used by the REST API for watch sessions.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(value=Include.NON_NULL)
public class APIWatchSession {
    
    /**
     * The unique string which identifies this watch session within its
     * containing directory.
     */
    private String identifier;
    
    /**
     * The username of the user associated with this watch session if
     * known.
     */
    private String username;
    
    /**
     * The connection name of this watchable session.
     */
    private String connection;

    /**
     * Whether this session can be joined with or without restrictions.
     */
    private boolean restriction;
    
    /**
     * The link that grants access to this watchable session.
     */
    private String link;

    /**
     * Creates an empty, uninitialized APIWatchSession. The properties of the
     * created APIWatchSession will need to be set individually as necessary
     * via their corresponding setters.
     */
    public APIWatchSession() {}
    
    /**
     * Creates a new APIWatchSession with its data populated from that of an
     * existing WatchSession.
     *
     * @param watchSession
     *     The watch session to use to populate the data of the new
     *     APIWatchSession.
     */
    public APIWatchSession(WatchSession watchSession) {

        // Set main information
        this.identifier = watchSession.getIdentifier();
        this.username = watchSession.getUsername();
        this.connection = watchSession.getConnection();
        this.restriction = watchSession.getRestriction();
        this.link = watchSession.getLink();

    }

    /**
     * Returns the unique string which identifies this watch session within
     * its containing directory.
     *
     * @return
     *     The unique string which identifies this watch session within its
     *     containing directory.
     */
    public String getIdentifier() {
        return identifier;
    }

    /**
     * Sets the unique string which identifies this watch session within
     * its containing directory.
     *
     * @param identifier
     *     The unique string which identifies this watch session within its
     *     containing directory.
     */
    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }
    
    /**
     * Returns the username of the user associated with this watchable session.
     *
     * @return
     *     The name of the user associated with this watchable session.
     */
    public String getUsername() {
        return username;
    }

    /**
     * Sets the username of the user associated with the watchable session.
     *
     * @param username
     *     The name of the user associated with the watchable session.
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Returns the connection name of this watchable session.
     *
     * @return
     *     The connection name of this watchable session.
     */
    public String getConnection() {
        return connection;
    }

    /**
     * Sets the connection name of this watchable session.
     *
     * @param connection
     *     The connection name of this watchable session.
     */
    public void setConnection(String connection) {
        this.connection = connection;
    }    
    
    /**
     * Returns whether this session can be joined with or without restrictions.
     *
     * @return
     *     If this session can be joined with or without restrictions.
     */
    public boolean getRestriction() {
        return restriction;
    }

    /**
     * Sets whether this session can be joined with or without restrictions.
     *
     * @param restriction
     *     If this session can be joined with or without restrictions.
     */
    public void setRestriction(boolean restriction) {
        this.restriction = restriction;
    }

    /**
     * Returns the link that grants access to this watchable session.
     *
     * @return
     *     The link that grants access to this watchable session.
     */
    public String getLink() {
        return link;
    }

    /**
     * Sets the link that grants access to this watchable session.
     *
     * @param link
     *     The link that grants access to this watchable session.
     */
    public void setLink(String link) {
        this.link = link;
    }

}