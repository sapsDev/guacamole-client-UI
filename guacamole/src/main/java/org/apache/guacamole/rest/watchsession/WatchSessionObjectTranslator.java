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

import org.apache.guacamole.GuacamoleException;
import org.apache.guacamole.net.auth.WatchSession;
import org.apache.guacamole.net.auth.UserContext;
import org.apache.guacamole.rest.directory.DirectoryObjectTranslator;

/**
 * Translator which converts between WatchSession objects and
 * APIWatchSession objects.
 */
public class WatchSessionObjectTranslator
        extends DirectoryObjectTranslator<WatchSession, APIWatchSession> {

    @Override
    public APIWatchSession toExternalObject(WatchSession object)
            throws GuacamoleException {
        return new APIWatchSession(object);
    }

    @Override
    public WatchSession toInternalObject(APIWatchSession object) {
        return new APIWatchSessionWrapper(object);
    }

    @Override
    public void applyExternalChanges(WatchSession existingObject,
                                     APIWatchSession object) {

        // Update the watch session
        existingObject.setUsername(object.getUsername());
        existingObject.setConnection(object.getConnection());
        existingObject.setRestriction(object.getRestriction());
        existingObject.setLink(object.getLink());

    }

    @Override
    public void filterExternalObject(UserContext userContext,
                                     APIWatchSession object) throws GuacamoleException {

        // Nothing to filter on ActiveConnections (no attributes)

    }

}