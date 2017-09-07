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
        })
    });
}());