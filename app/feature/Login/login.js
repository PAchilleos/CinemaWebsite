(function () {

   var LoginController = function ($scope,$http, $rootScope,$state) {
       vm = $scope;



       $rootScope.changeLoginNav = function(){
           $rootScope.obj.condition = !$rootScope.obj.condition;
           console.log($rootScope.obj.condition);
       };

       vm.addUser = function () {

           if (vm.pass === vm.pass2) {
               console.log("running");
               var data = {
                   "userName": vm.uName,
                   "firstName": vm.fName,
                   "lastName": vm.lName,
                   "email": vm.email,
                   "pass": vm.pass

               };
               //post to database user details
               fetch('http://localhost:8081/addUser', {
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
               vm.pass = null;
               vm.pass2 = null;
               vm.uName = null;
           }
           else {
               alert("Passwords do not match please entereth again Bitch!!");
               vm.pass = null;
               vm.pass2 = null;
           }


       };


       vm.loginUser = function () {


               let userName=vm.userLogin;
               let password=vm.userPassword;


        /*   fetch('http://localhost:8081/login?un=aaron', {
               method: 'GET',
               mode: 'cors',
               headers:{
                   'Access-Control-Allow-Origin':'*'
               }

           }).then(function (response) {
               console.log('response sent back');
               $scope.user123=response;
           });*/

           $http.get('http://localhost:8081/login?un='+userName+'&pass='+password)
               .then(function (result) {
                   console.log('response sent back');
                   vm.user123 = result.data;
                    if (vm.user123[0]) {
                        $state.go('profile');
                        $rootScope.user=vm.user123[0];
                        $rootScope.changeLoginNav();
                    }
                    else{

                        alert('woah wrong credentials, try again!!');
                    }
               });

       };

      vm.cleardeets = function(){
           $rootScope.user=null;
           $rootScope.changeLoginNav();
       }

   };

    angular.module('cinema').controller('login', ['$scope','$http', '$rootScope','$state', LoginController]);
}());