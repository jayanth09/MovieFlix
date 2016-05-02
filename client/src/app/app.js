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
            .when('/login', {
                templateUrl: 'app/views/login.tmpl.html',
                controller: 'LoginController',
                controllerAs: 'loginVm'
            })
            .otherwise({
                redirectTo: '/login'
            });
    }
})();