(function() {
    'use strict';

    angular.module('movieflix')
        .controller('NavigationController', NavigationController);

    NavigationController.$inject = ['navigationService'];
    function NavigationController(navigationService) {
        var nav = this;
        init();
        function init() {
            nav.values =navigationService.getValues()
        }
    }
})();   