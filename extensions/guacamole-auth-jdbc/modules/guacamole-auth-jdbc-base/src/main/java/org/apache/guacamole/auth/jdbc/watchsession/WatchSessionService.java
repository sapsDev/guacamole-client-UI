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
import com.google.inject.Provider;
import org.apache.guacamole.auth.jdbc.base.ModeledDirectoryObjectMapper;
import org.apache.guacamole.auth.jdbc.user.ModeledAuthenticatedUser;
import org.apache.guacamole.GuacamoleException;
import org.apache.guacamole.auth.jdbc.base.ModeledDirectoryObjectService;
import org.apache.guacamole.auth.jdbc.permission.WatchSessionPermissionMapper;
import org.apache.guacamole.auth.jdbc.permission.ObjectPermissionMapper;
import org.apache.guacamole.net.auth.WatchSession;
import org.apache.guacamole.net.auth.permission.ObjectPermissionSet;
import org.apache.guacamole.net.auth.permission.SystemPermission;
import org.apache.guacamole.net.auth.permission.SystemPermissionSet;

/**
 * Service which provides convenience methods for creating, retrieving, and
 * manipulating watch sessions.
 */
public class WatchSessionService
        extends ModeledDirectoryObjectService<ModeledWatchSession,
        WatchSession, WatchSessionModel> {

    /**
     * Mapper for accessing watch sessions.
     */
    @Inject
    private WatchSessionMapper watchSessionMapper;

    /**
     * Mapper for manipulating watch session permissions.
     */
    @Inject
    private WatchSessionPermissionMapper watchSessionPermissionMapper;

    /**
     * Provider for creating watch sessions.
     */
    @Inject
    private Provider<ModeledWatchSession> watchSessionProvider;

    @Override
    protected ModeledDirectoryObjectMapper<WatchSessionModel> getObjectMapper() {
        return watchSessionMapper;
    }

    @Override
    protected ObjectPermissionMapper getPermissionMapper() {
        return watchSessionPermissionMapper;
    }

    @Override
    protected ModeledWatchSession getObjectInstance(ModeledAuthenticatedUser currentUser,
                                                      WatchSessionModel model) {
        ModeledWatchSession watchSession = watchSessionProvider.get();
        watchSession.init(currentUser, model);
        return watchSession;
    }

    @Override
    protected WatchSessionModel getModelInstance(ModeledAuthenticatedUser currentUser,
                                                   final WatchSession object) {

        // Create new ModeledWatchSession backed by blank model
        WatchSessionModel model = new WatchSessionModel();
        ModeledWatchSession watchSession = getObjectInstance(currentUser, model);

        // Set model contents through ModeledWatchSession, copying the
        // provided watch session
        watchSession.setUsername(object.getUsername());
        watchSession.setConnection(object.getConnection());
        watchSession.setUUID(object.setUUID());
        watchSession.setRestriction(object.getRestriction());
        watchSession.setLink(object.getLink());

        return model;

    }

    @Override
    protected boolean hasCreatePermission(ModeledAuthenticatedUser user)
            throws GuacamoleException {

        // Return whether user has explicit watch session creation permission
        SystemPermissionSet permissionSet = user.getUser().getEffectivePermissions().getSystemPermissions();
        return permissionSet.hasPermission(SystemPermission.Type.CREATE_WATCH_SESSION);

    }

    @Override
    protected ObjectPermissionSet getEffectivePermissionSet(ModeledAuthenticatedUser user)
            throws GuacamoleException {

        // Return permissions related to watch sessions
        return user.getUser().getEffectivePermissions().getWatchSessionPermissions();

    }

    @Override
    protected void beforeCreate(ModeledAuthenticatedUser user,
                                WatchSession object, WatchSessionModel model)
            throws GuacamoleException {

        super.beforeCreate(user, object, model);

    }

    @Override
    protected void beforeUpdate(ModeledAuthenticatedUser user,
                                ModeledWatchSession object, WatchSessionModel model)
            throws GuacamoleException {

        super.beforeUpdate(user, object, model);

    }

    @Override
    public ModeledWatchSession createObject(ModeledAuthenticatedUser user, WatchSession object)
            throws GuacamoleException {

        // Create watch session
        return super.createObject(user, object);

    }

    @Override
    public void updateObject(ModeledAuthenticatedUser user, ModeledWatchSession object)
            throws GuacamoleException {

        // Update watch session
        super.updateObject(user, object);

    }

}
