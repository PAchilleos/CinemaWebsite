(function () {

    var BookController = function (bookService, sortService) {
        var vm = this;

        vm.reverse = false;

        vm.doSort = function () {
            sortService.sortBooks();
        }

        function init() {
            bookService.getBooks().then(function (results) {
                console.log("In book controller about to return data to the client with results " + results);
                vm.books = results;
            }, function (error) {
                vm.error = true;
                vm.errorMessage = error;
            });
        }

        init();
    };
    angular.module('bookStore').controller('BookController', ['bookService', 'sortService', BookController]);
}());