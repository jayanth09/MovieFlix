(function() {

    'use strict';

    angular
        .module('movieflix')
        .controller('MovieDetailController', MovieDetailController);

    MovieDetailController.$inject = ['MovieService', '$routeParams'];
    function MovieDetailController(MovieService, $routeParams) {
        var movieDetailsVm = this;
        init();

        function init() {
            console.log("Movie information");
        }

        
    }
})();