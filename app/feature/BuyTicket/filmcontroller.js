(function () {

    var filmcontroller = function ($scope, $http, myService) {
        $scope.sortby = 'title';
        $scope.reverse = false;

        console.log(myService.get());
        let movie = myService.get();

        $scope.filmToDisp = JSON.parse(movie);

        $http.get('https://raw.githubusercontent.com/PAchilleos/CinemaWebsite/adam/screening.json')
            .then(function (result) {
                $scope.screenings = result.data;
                console.log($scope.screenings);
            });

        $scope.doSort = function (propName) {
            $scope.sortBy = propName;
            $scope.reverse = !$scope.reverse
        };

    };

    angular.module('cinema').controller('filmcontroller', ['$scope', '$http', 'myService', filmcontroller]);
}());