(function () {




    var PickSeats = function ($scope, $compile) {

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

    }


    angular.module('cinema').controller('PickSeats', ['$scope', '$compile', PickSeats]);
}());