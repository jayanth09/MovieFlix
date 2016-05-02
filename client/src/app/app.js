(function () {
    'use strict';

    angular.module('movieflix', ['ngRoute'])
        .config(moduleConfig);

    function moduleConfig($routeProvider) {

        $routeProvider
            .when('/movies', {
                templateUrl: 'app/views/movies.tmpl.html',
                controller: 'MovieController',
                controllerAs: 'moviesVm'
            })
            .when('/movies/:id', {
                templateUrl: 'app/views/movie-detail.tmpl.html',
                controller: 'MovieDetailController',
                controllerAs: 'movieDetailsVm'
            })
            .when('/resources', {
                templateUrl: 'app/views/resources.tmpl.html',
                controller: 'ResourcesController',
                controllerAs: 'resourcesVm'
            })
            .otherwise({
                redirectTo: '/movies'
            });
    }
})();