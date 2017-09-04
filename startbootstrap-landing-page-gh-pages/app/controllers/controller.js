(function() {

    var MovieController =  function($scope)
    {
        $scope.sortby = 'title';
        $scope.reverse =false;

        $scope.movies = movies=[{'title': 'This is the end','genre': 'comedy'}, {'title': 'Shrek','genre': 'animation'}, {'title': 'The ring','genre': 'horror'}]

        $scope.doSort = function(propName)
        {
            $scope.sortBy= propName;
            $scope.reverse= !$scope.reverse
        };
    };
    angular.module('cinema').controller('MovieController', ['$scope', MovieController]);
}());

