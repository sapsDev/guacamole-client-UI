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

/**
 * Service for operating on watchable sessions via the REST API.
 */
angular.module('rest').factory('watchSessionService', ['$injector',
    function watchSessionService($injector) {

        // Required services
        var requestService        = $injector.get('requestService');
        var authenticationService = $injector.get('authenticationService');

        // Required types
        var WatchSession = $injector.get('WatchSession');

        var service = {};

        /**
         * Makes a request to the REST API to get a single watch session,
         * returning a promise that provides the corresponding @link{WatchSession}
         * if successful.
         *
         * @param {String} id The ID of the watch session.
         *
         * @returns {Promise.<WatchSession>}
         *     A promise which will resolve with a @link{WatchSession} upon
         *     success.
         */
        service.getWatchSession = function getWatchSession(dataSource, id) {

            // Retrieve watch session
            return authenticationService.request({
                method  : 'GET',
                url     : 'api/session/data/' + encodeURIComponent(dataSource) + '/watchSessions/' + encodeURIComponent(id)
            });

        };

        /**
         * Makes a request to the REST API to get the list of watch sessions
         * returning a promise that provides a map of @link{WatchSessions}
         * objects if successful.
         *
         * @param {String[]} [permissionTypes]
         *     The set of permissions to filter with. A user must have one or more
         *     of these permissions for a watch session to appear in the result
         *     If null, no filtering will be performed. Valid values are listed
         *     within PermissionSet.ObjectType.
         *
         * @returns {Promise.<Object.<String, WatchSession>>}
         *     A promise which will resolve with a map of @link{WatchSession}
         *     objects, where each key is the identifier of the corresponding
         *     watch session.
         */
        service.getWatchSessions = function getWatchSessions(dataSource, permissionTypes) {

            // Add permission filter if specified
            var httpParameters = {};
            if (permissionTypes)
                httpParameters.permission = permissionTypes;

            // Retrieve watch sessions
            return authenticationService.request({
                method  : 'GET',
                url     : 'api/session/data/' + encodeURIComponent(dataSource) + '/watchSessions',
                params  : httpParameters
            });

        };

        /**
         * Makes a request to the REST API to delete a watch session, returning a promise
         * that can be used for processing the results of the call.
         *
         * @param {String} dataSource
         *     The unique identifier of the data source containing the watch session 
         *     to be deleted. This identifier corresponds to an AuthenticationProvider
         *     within the Guacamole web application.
         *
         * @param {WatchSession} watchSession
         *     The watch session to delete.
         *
         * @returns {Promise}
         *     A promise for the HTTP call which will succeed if and only if the
         *     delete operation is successful.
         */
        service.deleteWatchSession = function deleteWatchSession(dataSource, watchSession) {

            // Delete watch session
            return authenticationService.request({
                method  : 'DELETE',
                url     : 'api/session/data/' + encodeURIComponent(dataSource) + '/watchSessions/' + encodeURIComponent(watchSession.identifier)
            })
            
        };

        /**
         * Makes a request to the REST API to create a watch session, returning
         * a promise that can be used for processing the results of the call.
         *
         * @param {String} dataSource
         *     The unique identifier of the data source in which the watch session
         *     should be created. This identifier corresponds to an 
         *     AuthenticationProvider within the Guacamole web application.
         *
         * @param {WatchSession} watchSession
         *     The watch session to create.
         *
         * @returns {Promise}
         *     A promise for the HTTP call which will succeed if and only if the
         *     create operation is successful.
         */
        service.createWatchSession = function createWatchSession(dataSource, watchSession) {

            // Create watch session
            return authenticationService.request({
                method  : 'POST',
                url     : 'api/session/data/' + encodeURIComponent(dataSource) + '/watchSessions',
                data    : watchSession
            })
            
        };

        /**
         * Makes a request to the REST API to save a watch session, returning a promise
         * that can be used for processing the results of the call.
         *
         * @param {String} dataSource
         *     The unique identifier of the data source containing the watch session to
         *     be updated. This identifier corresponds to an AuthenticationProvider
         *     within the Guacamole web application.
         *
         * @param {WatchSession} watchSession
         *     The watch session to update.
         *
         * @returns {Promise}
         *     A promise for the HTTP call which will succeed if and only if the
         *     save operation is successful.
         */
        service.saveWatchSession = function saveWatchSession(dataSource, watchSession) {

            // Update watch session
            return authenticationService.request({
                method  : 'PUT',
                url     : 'api/session/data/' + encodeURIComponent(dataSource) + '/watchSessions/' + encodeURIComponent(watchSession.identifier),
                data    : watchSession
            })

        };

        return service;

    }]);
