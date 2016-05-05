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
            .when('/series', {
                templateUrl: 'app/views/series.tmpl.html',
                controller: 'MovieController',
                controllerAs: 'moviesVm'
            })
            .when('/movies/:id', {
                templateUrl: 'app/views/movie-detail.tmpl.html',
                controller: 'MovieController',
                controllerAs: 'moviesVm'
            })
            .when('/series/:id', {
                templateUrl: 'app/views/series-detail.tmpl.html',
                controller: 'MovieController',
                controllerAs: 'moviesVm'
            })
            .when('/topMovies', {
                templateUrl: 'app/views/top-movies.tmpl.html',
                controller: 'MovieController',
                controllerAs: 'moviesVm'
            })
            .when('/topSeries', {
                templateUrl: 'app/views/top-series.tmpl.html',
                controller: 'MovieController',
                controllerAs: 'moviesVm'
            })
            .when('/imdbRating', {
                templateUrl: 'app/views/movies.tmpl.html',
                controller: 'MovieController',
                controllerAs: 'moviesVm'
            })
            .when('/comments', {
                templateUrl: 'app/views/comments.tmpl.html',
                controller: 'MovieController',
                controllerAs: 'moviesVm'
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