(function() {
    'use strict';

    angular.module('movieflix')
        .controller('LoginController', LoginController);

    LoginController.$inject = ['userService','$location', 'Notification'];
    function LoginController(userService, $location, Notification) {
        var loginVm = this;
        init();
        loginVm.login = login;
        function init() {
            console.log("Login check");
        }
        function login() {
            console.log("inside login function");
            userService.checkUser(loginVm.email, loginVm.password)
                .then(function (user) {
                    loginVm.userData = user;
                    console.log(loginVm.userData);
                    $location.path('/movies');
                    Notification.success("You've logged in successfully");
                }, function (error) {
                    console.log(error);
                    $location.path('/login');
                    Notification.error("Email ID and password did not match, please try again.");
                });
        };

    }
})();