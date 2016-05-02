(function() {
    'use strict';

    angular.module('movieflix')
        .controller('LoginController', LoginController);

    LoginController.$inject = ['loginService'];
    function LoginController(loginService) {
        var loginVm = this;
        init();
        
        function init() {
            console.log("Login check");
        }

        loginService.checkUer()
    }
})();