(function () {

    var filmcontroller = function ($scope, $http, myService) {

        console.log(myService.get());
        let movie = myService.get();

        $scope.filmToDisp = JSON.parse(movie);

        $http.get('https://raw.githubusercontent.com/PAchilleos/CinemaWebsite/Developer/films.json')
            .then(function (result) {
                $scope.movies = result.data;

            });

    };

    angular.module('cinema').controller('filmcontroller', ['$scope', '$http', 'myService', filmcontroller]);
}());