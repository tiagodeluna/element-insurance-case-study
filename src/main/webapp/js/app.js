(function () {
    'use strict';

    angular.module('registration', [])
        .controller('InsuranceController', function ($scope, $http) {

        	//Prepare alert properties
        	$scope.alert = {type: '', strong: '', msg: ''};
        	$scope.showAlert = false;

        	//Close alert message
        	$scope.closeAlert = function() {
        	   $scope.showAlert = false;
        	};
        	
            //Update the status of each module
            $scope.setStatus = function (modules) {
                for (var i = 0, len = modules.length; i < len; i++) {
                	$scope.changeModuleStatus(modules[i], modules[i].active);
                }
            };

            //Turn module active/inactive
            $scope.changeModuleStatus = function (module, status) {
            	module.active = status;
            	if (status) {
                    module.icon = 'glyphicon-ok';
                }else {
                	module.icon = 'glyphicon-remove';
                }
            	
            	$scope.calculateTariff();
            };
            
            //Open form with a new insurance
            $http.get('api/new').then(function (response) {
                $scope.insurance = response.data;
                $scope.setStatus($scope.insurance.modules);
            });
            
            //Persist the insurance
            $scope.save = function () {
                if ($scope.insurance.tariff > 0) {
                	//Save insurance
	                $http.post('api', $scope.insurance).then(function (response) {
                    	//Prepare a new insurance to be registered
                    	$scope.insurance = response.data;
                        $scope.setStatus($scope.insurance.modules);
                	});
	                //Prepare success message
                	$scope.alert = {type: 'alert-success', strong: 'Done!',
                			msg: 'Insurance has been successfully registered.'};
                } else {
                	//Prepare error message
                	$scope.alert = {type: 'alert-danger', strong: 'Oops!',
                			msg: 'Tariff must be greater than $0.'};
                }
                
            	$scope.showAlert=true;
            };

            //Calculate tariff
            $scope.calculateTariff = function () {
            	$http.post('api/calculate', $scope.insurance).then(function (response) {
            		$scope.insurance.tariff = response.data.tariff;
                });
            };

            //Get all insurances
            $scope.list = function () {
	            $http.get('api').then(function (response) {
	                $scope.insurances = response.data;
	            });
            };

            //Delete all insurances
            $scope.clear = function () {
            	$http.delete('api').then(function (response) {
            		$scope.list();
                });
            };
        });

})();

