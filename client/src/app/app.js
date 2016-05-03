(function () {
    'use strict';

    angular.module('movieflix', ['ngRoute','ngMessages', 'ui-notification'])
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
            .when('/register', {
                templateUrl: 'app/views/register.tmpl.html',
                controller: 'RegisterController',
                controllerAs: 'regVm'
            })
            .otherwise({
                redirectTo: '/login'
            });
    }
})();