(function () {

    var MovieController = function ($scope, $http, myService) {
        $scope.sortby = 'title';
        $scope.reverse = false;

        $http.get('https://raw.githubusercontent.com/PAchilleos/CinemaWebsite/Developer/films.json')
            .then(function (result) {
                $scope.movies = result.data;

            });

        $scope.doSort = function (propName) {
            $scope.sortBy = propName;
            $scope.reverse = !$scope.reverse
        };

        $scope.dispMovies = function (event) {
            myService.set(event.target.id);

        }

    };

    angular.module('cinema').controller('MovieController', ['$scope', '$http', 'myService', MovieController]);
}());