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
 * A service for defining the WatchSessionWrapper class.
 */
angular.module('watch').factory('WatchSessionWrapper', [
    function defineWatchSessionWrapper() {

        /**
         * Wrapper for WatchSession
         *
         * @constructor
         * @param {WatchSessionWrapper|Object} template
         *     The object whose properties should be copied within the new
         *     WatchSessionWrapper.
         */
        var WatchSessionWrapper = function WatchSessionWrapper(template) {

            /**
             * The identifier of the data source associated with the
             * WatchSession wrapped by this WatchSessionWrapper.
             *
             * @type String
             */
            this.dataSource = template.dataSource;

            /**
             * The username of this watchable user.
             *
             * @type String
             */
            this.username = template.username;
            
            /**
             * A flag that indicates whether the session can be joined
             * with or without restrictions
             *
             * @type Boolean
             */
            this.restriction = template.restriction;
            
            /**
             * The link that grants access to the session.
             *
             * @type String
             */
            this.link = template.link;

        };

        return WatchSessionWrapper;

    }]);