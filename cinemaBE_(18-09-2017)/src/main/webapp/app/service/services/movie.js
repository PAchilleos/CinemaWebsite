(function() {

    var MovieService =  function(cinemaDal) {

        this.getMovies = function()
        {
            return cinemaDal.getMovies();
        };

        this.saveMovie = function()
        {
            return cinemaDal.saveMovie();
        };
    };

    angular.module('cinema').service('movieService', ['cinemaDal', MovieService]);
}());