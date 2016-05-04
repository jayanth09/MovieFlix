(function () {
    'use strict';

    angular
        .module('movieflix')
        .service('navigationService',navigationService );
    
    function navigationService() {
        var nav = this;
        nav.values = {};

        nav.getValues = getValues;

        function getValues() {
            return nav.values;
        }


    }
})();