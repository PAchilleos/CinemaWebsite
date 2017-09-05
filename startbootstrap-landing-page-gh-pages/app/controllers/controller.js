(function () {

    var MovieController = function ($scope, $http) {
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
    };
    angular.module('cinema').controller('MovieController', ['$scope', '$http', MovieController]);
}());