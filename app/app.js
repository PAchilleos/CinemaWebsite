var demoApp = angular.module('cinema', ['ui.router']).run(function($rootScope) {
    $rootScope.obj = {condition:true};
    $rootScope.user;
});