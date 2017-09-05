(function() {

    var MovieController =  function($scope)
    {
        $scope.sortby = 'title';
        $scope.reverse =false;

        $scope.movies = movies=[
            {'title': 'This is the end','genre': 'comedy', 'img': 'https://images-na.ssl-images-amazon.com/images/M/MV5BMTQxODE3NjM1Ml5BMl5BanBnXkFtZTcwMzkzNjc4OA@@._V1_UX182_CR0,0,182,268_AL_.jpg'
            , 'description' : 'Another Seth Rogan movie', 'rating' : '5 outta 5', 'age' : '15'
            },

            {'title': 'Shrek','genre': 'animation', 'img': 'http://t2.gstatic.com/images?q=tbn:ANd9GcS_OkJKQ6ZpDV_xhC0L9zyHEcKMlV9x3Q30LF6MOE0nV1U6r09p'
                ,'description' : 'SOMEBODY ONCE TOLD ME', 'rating' : '5 outta 5', 'age' : 'pg'
            },

            {'title': 'The ring','genre': 'horror', 'img' : 'https://upload.wikimedia.org/wikipedia/en/thumb/3/37/Theringpostere.jpg/220px-Theringpostere.jpg'
                ,'description' : '#2spooky4me', 'rating' : '3 outta 5', 'age' : '18'
            }]

        $scope.doSort = function(propName)
        {
            $scope.sortBy= propName;
            $scope.reverse= !$scope.reverse
        };
    };
    angular.module('cinema').controller('MovieController', ['$scope', MovieController]);
}());

