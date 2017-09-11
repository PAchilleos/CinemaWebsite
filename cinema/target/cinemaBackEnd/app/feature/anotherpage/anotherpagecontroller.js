(function () {

    var AnotherPageController = function () {
        vm = this;
        vm.myString = "This came from javascript";
    };

    angular.module('bookStore').controller('AnotherPageController', [AnotherPageController]);
}());