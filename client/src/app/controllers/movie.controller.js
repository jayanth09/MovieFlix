(function() {

    'use strict';

    angular
        .module('movieflix')
        .controller('MovieController', MovieController);

    MovieController.$inject = ['MovieService'];
    function MovieController(MovieService) {
        var moviesVm = this;
        init();

        function init() {
            console.log("List of Movies");
        }

        MovieService
            .getMovies()
            .then(function(movies) {
                moviesVm.movies= movies;
                console.log(moviesVm.movies);
            }, function(error) {
                console.log(error);
            });
    }
})();