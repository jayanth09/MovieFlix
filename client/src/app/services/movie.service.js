(function() {

    'use strict';

    angular.module('movieflix')
        .service('MovieService', MovieService);

    MovieService.$inject = ['$http', '$q', 'CONFIG'];
    function MovieService($http, $q, CONFIG) {
        var self = this;
        self.getMovies = getMovies;
        self.getMovieById = getMovieById;

        function getMovies() {
            return $http.get(CONFIG.API_HOST +'/movies')
                .then(function(response) {
                    return response.data;
                }, function(response) {
                    return $q.reject('ERROR: ' + response.statusText);
                });
        }

        function getMovieById(id) {
            return $http.get(CONFIG.API_HOST + '/movies/' + id)
                .then(function (response) {
                    console.log("movie by id:"+response.data);
                    return response.data;
                }, function(response) {
                    return $q.reject('ERROR: ' + response.statusText);
                });
        }

    }
})();