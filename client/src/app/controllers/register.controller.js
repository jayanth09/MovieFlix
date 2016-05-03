(function() {
    'use strict';

    angular.module('movieflix')
        .controller('RegisterController', RegisterController);

    RegisterController.$inject = ['userService','$location', 'Notification'];
    function RegisterController(userService, $location, Notification) {
        var regVm = this;
        regVm.user = {};
        init();
        regVm.register = register;
        function init() {
            console.log("Register check");
        }
        function register() {
            console.log("inside register function");
            userService.createUser(regVm.user)
                .then(function (response) {
                    regVm.userData = response;
                    console.log(regVm.userData);
                    $location.path('/login');
                    Notification.success("You've registered in successfully! Please log in to continue");
                }, function (error) {
                    console.log(error);
                    $location.path('/register');
                    Notification.error("Error registering the user. Please try again");
                });
        };

    }
})();