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
 * The controller for the general watch page.
 */
angular.module('watch').controller('watchController', ['$scope', '$injector',
        function watchController($scope, $injector) {

    // Required services
    var $routeParams    = $injector.get('$routeParams');
    var userPageService = $injector.get('userPageService');
        
    /**
     * The array of watch pages available to the current user, or null if
     * not yet known.
     *
     * @type Page[]
     */
    $scope.watchPages = null;

    /**
     * The currently-selected watch tab. At the moment there is only one 
     * watch page available: 'sessions'
     *
     * @type String
     */
    $scope.activeTab = $routeParams.tab;

    // Retrieve watch pages
    userPageService.getWatchPages()
    .then(function watchPagesRetrieved(pages) {
        $scope.watchPages = pages;
    });
    
}]);