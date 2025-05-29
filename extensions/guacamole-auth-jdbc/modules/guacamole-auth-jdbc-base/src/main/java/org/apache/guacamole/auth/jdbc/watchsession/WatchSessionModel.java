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

import org.apache.guacamole.auth.jdbc.base.ChildObjectModel;

/**
 * Object representation of a Guacamole watch session, as represented in the
 * database.
 */
public class WatchSessionModel extends ChildObjectModel {

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

    /**
     * Creates a new, empty watch session.
     */
    public WatchSessionModel() {
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
     * Sets the username of the user associated with this watchable session.
     *
     * @param username
     *     The name of the user associated with this watchable session.
     */
    public void setUsername(String username) {
        this.username = username;
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

    @Override
    public String getIdentifier() {

        // If no associated ID, then no associated identifier
        Integer id = getObjectID();
        if (id == null)
            return null;

        // Otherwise, the identifier is the ID as a string
        return id.toString();

    }

    @Override
    public void setIdentifier(String identifier) {
        throw new UnsupportedOperationException("Watch session identifiers "
                + "are derived from IDs. They cannot be set.");
    }

}