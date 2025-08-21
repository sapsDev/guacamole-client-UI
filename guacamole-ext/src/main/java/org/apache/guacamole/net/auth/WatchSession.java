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
 * Represents a watchable session that can be used by an instructor.
 */
public interface WatchSession extends Identifiable {

    /**
     * Returns the username of the user associated with this watchable session.
     *
     * @return
     *     The name of the user associated with this watchable session.
     */
    public String getUsername();

    /**
     * Sets the username of the user associated with this watchable session.
     *
     * @param username
     *     The name of the user associated with this watchable session.
     */
    public void setUsername(String username);
    
    /**
     * Returns the connection name of this watchable session.
     *
     * @return
     *     The connection name of this watchable session.
     */
    public String getConnection();

    /**
     * Sets the connection name of this watchable session.
     *
     * @param connection
     *     The connection name of this watchable session.
     */
    public void setConnection(String connection);

    /**
     * Returns whether this session can be joined with or without restrictions.
     *
     * @return
     *     If this session can be joined with or without restrictions.
     */
    public boolean getRestriction();

    /**
     * Sets whether this session can be joined with or without restrictions.
     *
     * @param restriction
     *     If this session can be joined with or without restrictions.
     */
    public void setRestriction(boolean restriction);

    /**
     * Returns the link that grants access to this watchable session.
     *
     * @return
     *     The link that grants access to this watchable session.
     */
    public String getLink();

    /**
     * Sets the link that grants access to this watchable session.
     *
     * @param link
     *     The link that grants access to this watchable session.
     */
    public void setLink(String link);

}
