(function () {
    'use strict';

    angular.module('movieflix')
        .service('loginService', loginService);

    loginService.$inject = ['$http', '$q'];
    function loginService($http, $q) {
        var self = this;
            
        self.checkUser = checkUser;
        function checkUser(email, pwd) {
            return $http.get('http://localhost:8080/MovieFlix/api/users/'+ email + '/'+pwd)
                .then(function (response) {
                    return response.data;
                }, function(response) {
                    return $q.reject('ERROR: ' + response.statusText);
                });
        }
    }
})();