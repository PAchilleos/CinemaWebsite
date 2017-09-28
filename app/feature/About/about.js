(function () {

    var FormController = function ($scope) {
        vm = $scope;

        vm.addUser = function () {

                console.log("running");
                var data = {

                    "firstName": vm.fName,
                    "lastName": vm.lName,
                    "email": vm.email,
                    "subject": vm.selecta,
                    "mess": vm.mess
                };
                //post to database user details
                fetch('http://localhost:8081/form', {
                    method: 'POST',
                    mode: 'no-cors',
                    body: JSON.stringify(data)
                }).then(function (response) {
                    console.log("worked!!");
                    console.log(JSON.stringify(data))

                });
                vm.fName = null;
                vm.lName = null;
                vm.email = null;
                vm.selecta = null;
                vm.mess = null;
        }
    };


    angular.module('cinema').controller('form', ['$scope', FormController]);
}());