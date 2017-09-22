(function () {


    var myService = function ($scope) {

        var savedData = [];

        function set(data) {
            savedData = data;
        }

        function get() {
            return savedData;
        }

        return {
            set: set,
            get: get
        }

    };

    angular.module('cinema').service('myService', [myService]);
}());