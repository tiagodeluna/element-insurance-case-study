(function () {
    'use strict';

    angular.module('registration', [])
        .controller('InsuranceController', function ($scope, $http) {

            $scope.insurance = {clientName: '', tariff: 0, modules: []};
            $scope.insurances = [];

            $http.get('api/insurance/new').then(function (response) {
                $scope.insurance = response.data;
            });
            //NEW
            //$http.get('api/insurance').then(function (response) {
            //    $scope.insurances = response.data;
            //});

            //OLD
            //$scope.save = function () {
            //    $http.post('api/user', $scope.user).then(function (response) {
            //        $scope.users.push(response.data);
            //    });

            //    $scope.user = {username: '', password: ''};
            //    $scope.statusPassword = {};
            //};

            $scope.save = function () {
                $http.post('api/insurance', $scope.insurance).then(function (response) {
                    //$scope.insurances.push(response.data);
                	$scope.insurance = response.data;
                });
            };

            $scope.calculateTariff = function () {
            	$http.post('api/insurance/calculate', $scope.insurance).then(function (response) {
            		$scope.insurance = response.data;
                });

            };
        });

})();

