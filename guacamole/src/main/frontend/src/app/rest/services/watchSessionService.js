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
        
        service.getWatchSessionsTest = function getWatchSessionsTest() {

            testInput = Promise.resolve({
                "session1": new WatchSession({
                    identifier: "abc123",
                    username: "testuser1",
                    restriction: true,
                    link: "https://google.com"
                }),
                "session2": new WatchSession({
                    identifier: "xyz789",
                    username: "testuser2",
                    restriction: false,
                    link: "https://youtube.com"
                })
            });
            
            return testInput;

        };

        return service;

    }]);
