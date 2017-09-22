(function() {

    var SortBooks =  function() {

        this.doSort = function()
        {
            this.sortby = 'Title';
            this.reverse= !this.reverse
        };
    };

    angular.module('bookStore').service('sortBooks', [SortBooks]);
}());

