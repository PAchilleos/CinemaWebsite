"use strict";

(function () {

    angular.module('cinema').config(function ($stateProvider, $urlRouterProvider) {
        $urlRouterProvider.otherwise("/Home");

        $stateProvider.state("about", {
            url: "/About",
            templateUrl: "app/feature/About/about.html"
        }).state("home", {
            url: "/Home",
            templateUrl: "app/feature/Home/home.html"
        }).state("login", {
            url: "/Login",
            templateUrl: "app/feature/Login/login.html"
        }).state("meettheteam", {
            url: "/Meettheteam",
            templateUrl: "app/feature/Meettheteam/meettheteam.html"
        }).state("BuyTicket", {
            url: "/BuyTicket",
            templateUrl: "app/feature/BuyTicket/buyTicket.html"


        }).state("profile", {
            url: "/Profile",
            templateUrl: "app/feature/Profile/profile.html"


        })
    });
}());