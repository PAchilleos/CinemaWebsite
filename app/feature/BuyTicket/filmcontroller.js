(function () {

    var filmcontroller = function ($scope, $http, myService, $compile) {
        $scope.sortby = 'title';
        $scope.reverse = false;

        console.log(myService.get());
        let movie = myService.get();

        $scope.filmToDisp = JSON.parse(movie);

        $http.get('https://raw.githubusercontent.com/PAchilleos/CinemaWebsite/adam/screening.json')
            .then(function (result) {
                $scope.screenings = result.data;
                console.log($scope.screenings);
            });

        $scope.doSort = function (propName) {
            $scope.sortBy = propName;
            $scope.reverse = !$scope.reverse
        };


        //ticket bit
        vm = $scope;

        vm.adultCount = 0;
        vm.teenCount = 0;
        vm.studentCount = 0;
        vm.childCount = 0;

        let max = 20;
        vm.adultPrice = 7.00;
        vm.teenPrice = 6.00;
        vm.studentPrice = 5.00;
        vm.childPrice = 4.00;


        //adult 
        vm.addAdult = function () {
            if (vm.adultCount >= max);
            vm.adultCount++;
        };
        vm.subtractAdult = function () {
            vm.adultCount--;
            if (vm.adultCount < 0) {
                vm.adultCount = 0;
            }
        };


        //teen
        vm.addTeen = function () {
            if (vm.teenCount >= max);
            vm.teenCount++;
        };
        vm.subtractTeen = function () {
            vm.teenCount--;
            if (vm.teenCount < 0) {
                vm.teenCount = 0;
            }
        };


        //student
        vm.addStudent = function () {
            if (vm.studentCount >= max);
            vm.studentCount++;
        };
        vm.subtractStudent = function () {
            vm.studentCount--;
            if (vm.studentCount < 0) {
                vm.studentCount = 0;
            }
        };


        //child
        vm.addChild = function () {
            if (vm.childCount >= max);
            vm.childCount++;
        };
        vm.subtractChild = function () {
            vm.childCount--;
            if (vm.childCount < 0) {
                vm.childCount = 0;
            }
        };


        //seat map bit


        $scope.screen = 14;

        //$scope.alreadyBooked = [$scope.screen + 'A1', $scope.screen + 'C8', $scope.screen + 'D7']; //need to pull this from database


        $scope.makeButtons = function (row) {
            var cond = 1;
            var max = Math.floor(Math.random() * 6) + 5;
            console.log(max);

            while (cond < max) {
                var tableElement = document.createElement("td");
                var buttonElement = document.createElement("button");
                buttonElement.setAttribute('class', "seat");
                buttonElement.setAttribute("id", $scope.screen + row + cond);
                buttonElement.setAttribute('ng-click', "setColour($event)");
                buttonElement.innerHTML = row + cond;
                var temp = $compile(buttonElement)($scope);
                angular.element(tableElement).append(temp);
                document.getElementById(row).appendChild(tableElement);
                cond++;
            }

        }

        $scope.init = function () {
            for (i = 0; i < $scope.alreadyBooked.length; i++) {
                var bookedSeat = document.getElementById($scope.alreadyBooked[i]);
                bookedSeat.style.backgroundColor = "red";
                bookedSeat.style.color = "white";
                bookedSeat.style.boxShadow = "none";
                bookedSeat.disabled = true;
            }
        }


        $scope.seats = [];


        $scope.setColour = function (event) {
            id = event.target.id;

            var property = document.getElementById(id);

            if (property.style.backgroundColor === "rgb(127, 255, 0)") {
                property.style.backgroundColor = "#FFFFFF";
                $scope.condition = !$scope.condition;
                $scope.seats.splice($scope.seats.indexOf(id), 1);
            } else {
                property.style.backgroundColor = "#7FFF00";
                $scope.condition = !$scope.condition;
                $scope.seats.push(id);
            }

        }

        $scope.saveSeats = function () {

            for (i = 0; i < $scope.seats.length; i++) {
                var bookedSeat = document.getElementById($scope.seats[i]);
                bookedSeat.style.backgroundColor = "red";
                bookedSeat.style.color = "white";
                bookedSeat.style.boxShadow = "none";
                bookedSeat.disabled = true;
                $scope.seats[i] = $scope.screen + $scope.seats[i];
            }
            // dostuff with java and database
            $scope.seats = [];
        }

    };




    angular.module('cinema').controller('filmcontroller', ['$scope', '$http', 'myService', '$compile', filmcontroller]);
}());