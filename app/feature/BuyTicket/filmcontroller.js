(function () {

    var filmcontroller = function ($scope, $http, myService) {

        console.log(myService.get());
        $scope.movtit = myService.get();

        // var movietitle = function () {
        //     console.log(myService.get());
        //     return myService.get();
        // }
    };

    angular.module('cinema').controller('filmcontroller', ['$scope', '$http', 'myService', filmcontroller]);
}());