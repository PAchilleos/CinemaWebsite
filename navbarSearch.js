(function () {

    var controller = function ($scope, $http) {
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


        };

    };
    angular.module('cinema').controller('myCtrl', ['$scope', '$http', controller]);
}());