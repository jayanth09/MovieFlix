(function () {
    'use strict';

    angular
        .module('movieflix')
        .service('navigationService',navigationService );
    
    function navigationService() {
        var nav = this;
        nav.values = {};
        nav.values.displayLoginTab = true;
        nav.values.displayRegisterTab = true;
        nav.values.displayMoviesTab = false;
        nav.values.displaySeriesTab = false;
        nav.values.displayTopMoviesTab = false;
        nav.values.displayTopShowsTab = false;
        nav.displaySearchTab = false;

        nav.getValues = getValues;

        function getValues() {
            return nav.values;
        }


    }
})();