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
 * Service which defines the WatchSession class.
 */
angular.module('rest').factory('WatchSession', [function defineWatchSession() {

    /**
     * The object returned by REST API calls when representing the data
     * associated with a watchable session.
     *
     * @constructor
     * @param {WatchSession|Object} [template={}]
     *     The object whose properties should be copied within the new
     *     WatchSession.
     */
    var WatchSession = function WatchSession(template) {

        // Use empty object by default
        template = template || {};

        /**
         * The identifier which uniquely identifies this specific
         * watchable session.
         *
         * @type String
         */
        this.identifier = template.identifier;

        /**
         * The username of the user associated with the watchable
         * session, if known.
         *
         * @type String
         */
        this.username = template.username;

        /**
         * The connection name of this watchable session.
         * 
         * @type String
         */
        this.connection = template.connection;

        /**
         * Whether this session can be joined with or without
         * restrictions.
         *
         * @type Boolean
         */
        this.restriction = template.restriction;

        /**
         * The link that grants access to this watchable session.
         *
         * @type String
         */
        this.link = template.link;

    };

    return WatchSession;

}]);