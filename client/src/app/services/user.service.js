(function () {
    'use strict';

    angular.module('movieflix')
        .service('userService', userService);

    userService.$inject = ['$http', '$q'];
    function userService($http, $q) {
        var self = this;
            
        self.checkUser = checkUser;
        self.createUser = createUser;
        function checkUser(email, pwd) {
            return $http.get('http://localhost:8080/MovieFlix/api/users/'+ email + '/'+pwd)
                .then(function (response) {
                    return response.data;
                }, function(response) {
                    return $q.reject('ERROR: ' + response.statusText);
                });
        }
        
         function createUser(user) {
            return $http.post('http://localhost:8080/MovieFlix/api/users/', user)
                .then(function (response) {
                    return response.data;
                }, function(response) {
                    return $q.reject('ERROR: ' + response.statusText);
                });
        }
    }
})();