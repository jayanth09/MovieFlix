(function() {
    'use strict';

    angular.module('movieflix')
        .controller('LoginController', LoginController);

    LoginController.$inject = ['userService','$location', 'Notification', 'navigationService'];
    function LoginController(userService, $location, Notification, navigationService) {
        var loginVm = this;
        init();
        loginVm.login = login;
        loginVm.setTabValue =  setTabValue;
        function init() {
            console.log("Login check");
        }
        function login() {
            console.log("inside login function");
            userService.checkUser(loginVm.email, loginVm.password)
                .then(function (user) {
                    loginVm.setTabValue();
                    loginVm.userData = user;
                    console.log(loginVm.userData);
                    $location.path('/movies');
                    Notification.success("You've logged in successfully");
                }, function (error) {
                    console.log(error);
                    $location.path('/login');
                    Notification.error("Email ID and password did not match, please try again.");
                });
        }
        function setTabValue() {
            navigationService.values.displayLoginTab =false;
            navigationService.values.displayRegisterTab =false;
            navigationService.values.displayMoviesTab =true;
            navigationService.values.displaySeriesTab = true;
            navigationService.values.displayTopMoviesTab = true;
            navigationService.values.displayTopShowsTab = true;
            navigationService.values.displaySearchTab = true;
        }

    }
})();