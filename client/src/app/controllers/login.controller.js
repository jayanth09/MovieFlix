(function() {
    'use strict';

    angular.module('movieflix')
        .controller('LoginController', LoginController);

    LoginController.$inject = ['loginService','$location'];
    function LoginController(loginService, $location) {
        var loginVm = this;
        init();
        loginVm.login = login;
        function init() {
            console.log("Login check");
        }
        function login() {
            console.log("inside login function");
            loginService.checkUser(loginVm.email, loginVm.password)
                .then(function (user) {
                    loginVm.userData = user;
                    console.log(loginVm.userData);
                    $location.path('/movies');
                }, function (error) {
                    console.log(error);
                });
        };

    }
})();