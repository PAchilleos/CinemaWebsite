(function () {

    var SortService = function () {

        this.sortBooks = function () {
            this.sortby = 'Title';
            this.reverse = !this.reverse
        };
    };

    angular.module('bookStore').service('sortService', [SortService]);
}());