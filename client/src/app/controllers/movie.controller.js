(function() {

    'use strict';

    angular
        .module('movieflix')
        .controller('MovieController', MovieController);

    MovieController.$inject = ['MovieService', '$routeParams'];
    function MovieController(MovieService, $routeParams) {
        var moviesVm = this;
        init();

        moviesVm.changeSort = changeSort;
        moviesVm.getMovies = getMovies;
        moviesVm.getSeries = getSeries;
        moviesVm.getById = getById;
        moviesVm.getTopRatedMovies = getTopRatedMovies;
        moviesVm.getTopRatedSeries = getTopRatedSeries;

        function init() {
            console.log("List of Movies");
        }

        moviesVm.sorter = {
            by: 'year',
            reverse: false
        }
        
        function changeSort(prop) {
            moviesVm.sorter.by = prop;
            moviesVm.sorter.reverse = !moviesVm.sorter.reverse;
        }
        function getMovies() {
            MovieService
                .getMovies()
                .then(function(movies) {
                    moviesVm.movies= movies;
                    console.log(moviesVm.movies);
                }, function(error) {
                    console.log(error);
                });
        }

        function getSeries() {
            MovieService
                .getSeries()
                .then(function (series) {
                    moviesVm.series = series;
                    console.log(moviesVm.series);
                }, function (error) {
                    console.log(error);
                })
        }

        function getById() {
            MovieService
                .getById($routeParams.id)
                .then(function (movie){
                    moviesVm.movie = movie;
                }, function (error) {
                    console.log(error);
                });
        }

        function getTopRatedMovies() {
            MovieService
                .getTopRatedMovies()
                .then(function (movies){
                    moviesVm.movies = movies;
                }, function (error) {
                    console.log(error);
                });
        }

        function getTopRatedSeries() {
            MovieService
                .getTopRatedSeries()
                .then(function (series){
                    moviesVm.series = series;
                }, function (error) {
                    console.log(error);
                });
        }

    }
})();