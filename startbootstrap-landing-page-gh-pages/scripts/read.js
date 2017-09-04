var app = angular.module('app', []);
app.controller('myCtrl', function ($scope, $http) {
    $http.get('https://raw.githubusercontent.com/tamtakoe/react-example-list/master/data/films.json')
        .then(function (result) {
            $scope.films = result.data;
        });
});