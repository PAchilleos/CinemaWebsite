(function () {

    var controller = function ($scope, $http, myService) {
        $http.get('https://raw.githubusercontent.com/PAchilleos/CinemaWebsite/Developer/films.json')
            .then(function (result) {
                $scope.films = result.data;
            });
        $scope.search = function (row) {
            if ($scope.query) {
                let e = document.getElementById("filterBy");
                let strUser = e.options[e.selectedIndex].text;
                if (strUser === "Title") {
                    return !!((row.title.toLowerCase().indexOf($scope.query.toLowerCase() || '') !== -1));
                } else if (strUser === "Genre") {
                    return !!((row.genre.toLowerCase().indexOf($scope.query.toLowerCase() || '') !== -1));
                } else {
                    return !!((row.title.toLowerCase().indexOf($scope.query.toLowerCase() || '') !== -1 || row.genre.toLowerCase().indexOf($scope.query.toLowerCase() || '') !== -1));
                }

            }

            $scope.dispMovies = function (event) {
                myService.set(event.target.id);
                console.log(myService.get());
            }


        };

    };
    angular.module('cinema').controller('myCtrl', ['$scope', '$http', 'myService', controller]);
}());