var app = angular.module('app', []);
app.controller('myCtrl', function ($scope, $http) {
    $http.get('https://raw.githubusercontent.com/PAchilleos/CinemaWebsite/QACT1-22/films.json')
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


    };

});