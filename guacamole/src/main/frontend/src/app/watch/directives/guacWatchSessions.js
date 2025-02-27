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
 * A directive for managing all watchable Guacamole sessions.
 */
angular.module('watch').directive('guacWatchSessions', [function guacWatchSessions() {

    return {
        // Element only
        restrict: 'E',
        replace: true,

        scope: {
        },

        templateUrl: 'app/watch/templates/watchSessions.html',
        controller: ['$scope', '$injector', function watchSessionsController($scope, $injector) {

            // Required types
            var WatchSessionWrapper     = $injector.get('WatchSessionWrapper');
            var SortOrder               = $injector.get('SortOrder');

            // Required services
            var watchSessionService     = $injector.get('watchSessionService');
            var authenticationService   = $injector.get('authenticationService');
            var dataSourceService       = $injector.get('dataSourceService');
            var requestService          = $injector.get('requestService');

            /**
             * The identifiers of all data sources accessible by the current
             * user.
             *
             * @type String[]
             */
            var dataSources = authenticationService.getAvailableDataSources();

            /**
             * The WatchSessionWrappers of all watchable sessions accessible
             * by the current user, or null if the watchable sessions have not yet
             * been loaded.
             *
             * @type WatchSessionWrapper[]
             */
            $scope.wrappers = null;

            /**
             * SortOrder instance which maintains the sort order of the visible
             * connection wrappers.
             *
             * @type SortOrder
             */
            $scope.wrapperOrder = new SortOrder([
                'username',
                'restriction',
                'link'
            ]);

            /**
             * Array of all wrapper properties that are filterable.
             *
             * @type String[]
             */
            $scope.filteredWrapperProperties = [
                'username',
                'restriction',
                'link'
            ];

            /**
             * All watchable sessions, if known, grouped by corresponding data
             * source identifier, or null if watchable sessions have not yet
             * been loaded.
             *
             * @type Object.<String, Object.<String, WatchSession>>
             */
            var allWatchSessions = null;

            /**
             * Wraps all loaded watchable sessions, storing the resulting array
             * within the scope. If required data has not yet finished loading,
             * this function has no effect.
             */
            var wrapAllWatchableSessions = function wrapAllWatchableSessions() {

                // Abort if required data is not available
                if (!allWatchSessions)
                    return;

                // Wrap all watchable sessions for sake of display
                $scope.wrappers = [];
                angular.forEach(allWatchSessions, function wrapWatchSessions(watchSessions, dataSource) {
                    angular.forEach(watchSessions, function wrapWatchSession(watchSession, identifier) {

                        // Add wrapper
                        if (watchableSession.username !== null) {
                            $scope.wrappers.push(new WatchSessionWrapper({
                                dataSource       : dataSource,
                                username         : watchSession.username,
                                restriction      : watchSession.restriction,
                                link             : watchSession.link
                            }));
                        }

                    });
                });

            };

            // TODO: Remove Test
            // Query watchable sessions
            dataSourceService.apply(
                watchSessionService.getWatchSessionsTest,
                dataSources
            )
                .then(function sessionsRetrieved(retrievedWatchSessions) {

                    // Store received map of watchable sessions
                    allWatchSessions = retrievedWatchSessions;

                    // Attempt to produce wrapped list of watchable sessions
                    wrapAllWatchableSessions();

                }, requestService.DIE);

            /**
             * Returns whether critical data has completed being loaded.
             *
             * @returns {Boolean}
             *     true if enough data has been loaded for the user interface
             *     to be useful, false otherwise.
             */
            $scope.isLoaded = function isLoaded() {
                return $scope.wrappers !== null;
            };


        }]
    };

}]);