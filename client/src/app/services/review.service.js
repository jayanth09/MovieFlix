(function() {

    'use strict';

    angular.module('movieflix')
        .service('reviewService', reviewService);

    reviewService.$inject = ['$http', '$q', 'CONFIG'];
    function reviewService($http, $q, CONFIG) {
        var self = this;

        self.getAllComments = getAllComments;
        self.createComment = createComment;
        function getAllComments(id) {
            return $http.get(CONFIG.API_HOST+ '/review/findById/' + id)
                .then(function (response) {
                    console.log("getting all comments");
                    return response.data;
                }, function (response) {
                    return $q.reject('ERROR: ' + response.statusText);
                });
        }

        function createComment(review) {
            return $http.post(CONFIG.API_HOST+ '/review/', review)
                    .then(function (response) {
                        console.log("creating a commment");
                        return response.data;
                    }, function (response) {
                        return $q.reject('ERROR: ' + response.statusText);
                    })
        }

    }
})();