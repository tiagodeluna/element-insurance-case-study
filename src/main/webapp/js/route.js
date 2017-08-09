angular.module('ngViewExample', ['ngRoute', 'ngAnimate'])
.config(['$routeProvider', '$locationProvider',
  function($routeProvider, $locationProvider) {
    $routeProvider
      .when('ListI', {
        templateUrl: 'resources/list.html',
        controller: 'ListCtrl'
      })
      .when('NewI', {
        templateUrl: 'resources/new.html',
        controller: 'NewCtrl'
      });

    $locationProvider.html5Mode(true);
}])
.controller('MainCtrl', ['$route', '$routeParams', '$location',
  function MainCtrl($route, $routeParams, $location) {
    this.$route = $route;
    this.$location = $location;
    this.$routeParams = $routeParams;
}])
.controller('NewCtrl', ['$routeParams', function NewCtrl($routeParams) {
  this.name = 'NewCtrl';
  this.params = $routeParams;
}])
.controller('ListCtrl', ['$routeParams', function ListCtrl($routeParams) {
  this.name = 'ListCtrl';
  this.params = $routeParams;
}]);