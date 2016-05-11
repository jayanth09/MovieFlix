(function () {
    'use strict';

    angular
        .module('movieflix')
        .service('navigationService',navigationService );
    
    function navigationService() {
        var nav = this;
        nav.values = {};
        init();
        nav.getValues = getValues;
        function init() {
        
        }

        function getValues() {
            return nav.values;
        }


    }
})();