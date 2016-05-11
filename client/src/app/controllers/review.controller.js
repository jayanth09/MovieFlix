(function () {
    'use strict';

    angular
        .module('movieflix')
        .controller('ReviewController', ReviewController);

    ReviewController.$inject = ['reviewService','$routeParams'];

    function ReviewController(reviewService, $routeParams) {
        var reviewVm = this;
        reviewVm.review = {};
        reviewVm.getAllComments = getAllComments;
        
        function getAllComments() {
            reviewService
                .getAllComments($routeParams.id)
                .then(function (comments) {
                    reviewVm.comments = comments;
                }, function (error) {
                    console.log(error);
                });
        }
        
        function createComment() {
            reviewService
                .createComment(review)
                .then(function (response) {
                    console.log(response);
                }, function (error) {
                    console.log(error);
                });
        }

    }

})();