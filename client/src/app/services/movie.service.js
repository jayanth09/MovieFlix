(function() {

    'use strict';

    angular.module('movieflix')
        .service('MovieService', MovieService);

    MovieService.$inject = ['$http', '$q', 'CONFIG'];
    function MovieService($http, $q, CONFIG) {
        var self = this;
        self.getMovies = getMovies;
        self.getById = getById;
        self.getSeries = getSeries;
        self.getTopRatedMovies = getTopRatedMovies;
        self.getTopRatedSeries = getTopRatedSeries;

        function getMovies() {
            return $http.get(CONFIG.API_HOST +'/movies/type/movie')
                .then(function(response) {
                    return response.data;
                }, function(response) {
                    return $q.reject('ERROR: ' + response.statusText);
                });
        }
        function getSeries() {
            return $http.get(CONFIG.API_HOST +'/movies/type/series')
                .then(function(response) {
                    return response.data;
                }, function(response) {
                    return $q.reject('ERROR: ' + response.statusText);
                });
        }

        function getById(id) {
            return $http.get(CONFIG.API_HOST + '/movies/' + id)
                .then(function (response) {
                    console.log("movie by id:"+response.data);
                    return response.data;
                }, function(response) {
                    return $q.reject('ERROR: ' + response.statusText);
                });
        }

        function getTopRatedMovies() {
            return $http.get(CONFIG.API_HOST + '/movies/topMovies')
                .then(function (response) {
                    console.log("Top rated movies");
                    return response.data;
                }, function(response) {
                    return $q.reject('ERROR: ' + response.statusText);
                });
        }

        function getTopRatedSeries() {
            return $http.get(CONFIG.API_HOST + '/movies/topSeries')
                .then(function (response) {
                    console.log("Top rated tv shows");
                    return response.data;
                }, function(response) {
                    return $q.reject('ERROR: ' + response.statusText);
                });
        }

    }
})();