(function() {

    var GetMovieController =  function(movieService)
    {
        var vm = this;

        vm.reverse =false;

        vm.doSort = function()
        {
            vm.sortby = 'Title';
            vm.reverse= !vm.reverse
        };

        function init() {
            movieService.getMovies().then(function (results) {
                console.log("get movie " + results);
                vm.movies  = results;
            }, function (error) {
                vm.error = true;
                vm.errorMessage = error;
            });
        }

        init();
    };
    angular.module('cinema').controller('GetMovieController', ['movieService', GetMovieController]);
}());