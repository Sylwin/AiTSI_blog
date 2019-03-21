/**
 * Created by Syl on 2017-11-18.
 */
var app = angular.module('app', []);

app.controller('postController', function($scope, $http, $location) {
    $scope.submitForm = function() {
        var url = $location.absUrl() + "/adduser";

        var config = {
            headers: {
                'Content-Type': 'application/json;charset=utf-8;'
            }
        }

        var data = {
            role: "user",
            blogTitle: $scope.blogTitle,
            username: $scope.username,
            email: $scope.email,
            password: $scope.password,
        };


        $http.post(url, data, config).then(function (response) {
            $scope.postResultMessage = "Successful!";
        }, function (response) {
            $scope.postResultMessage = "Fail!";
        });

        $scope.role = "";
        $scope.blogTitle = "";
        $scope.username = "";
        $scope.email = "";
        $scope.password = "";

        window.location = "/confirmation";
    }
});

app.controller('loginController', function($scope, $http, $location) {
    $scope.submitForm = function() {
        var url = $location.absUrl() + "login";

        var config = {
            headers: {
                'Content-Type': 'application/json;charset=utf-8;'
            }
        }

        var data = {
            role: "user",
            username: $scope.username,
            password: $scope.password
        };

        if( $scope.userForm.$valid ) {
            $http.post(url, data, config).then(function (response) {
                $scope.postResultMessage = "Successful!";
            }, function (response) {
                $scope.postResultMessage = "Fail!";
            });
        }
        $scope.role = "";
        $scope.username = "";
        $scope.email = "";
        $scope.password = "";

        window.location = "/confirmation";
    }

});

app.controller('getallusersController', function($scope, $http, $location) {

    $scope.showAllUsers = false;

    $scope.getAllUsers = function() {
        var url = $location.absUrl() + "all";

        var config = {
            headers : {
                'Content-Type' : 'application/json;charset=utf-8;'
            }
        }

        $http.get(url, config).then(function(response) {

            if (response.data.status == "Done") {
                $scope.allusers = response.data;
                $scope.showAllUsers = true;

            } else {
                $scope.getResultMessage = "get All Users Data Error!";
            }

        }, function(response) {
            $scope.getResultMessage = "Fail!";
        });

    }
});

app.controller('getuserController', function($scope, $http, $location) {

    $scope.showUser = false;

    $scope.getUser = function() {
        var url = $location.absUrl() + "user/" + $scope.userId;

        var config = {
            headers : {
                'Content-Type' : 'application/json;charset=utf-8;'
            }
        }

        $http.get(url, config).then(function(response) {

            if (response.data.status == "Done") {
                $scope.user = response.data;
                $scope.showUser = true;

            } else {
                $scope.getResultMessage = "User Data Error!";
            }

        }, function(response) {
            $scope.getResultMessage = "Fail!";
        });

    }
});

app.controller('getusersbyusernameController', function($scope, $http, $location) {

    $scope.showUsersByUsername = false;

    $scope.getUsersByUsername = function() {
        var url = $location.absUrl() + "findbyusername";

        var config = {
            headers : {	'Content-Type' : 'application/json;charset=utf-8;' },

            params: { 'username' : $scope.userName }
        }

        $http.get(url, config).then(function(response) {

            if (response.data.status == "Done") {
                $scope.allusersbyusername = response.data;
                $scope.showUsersByUsername = true;

            } else {
                $scope.getResultMessage = "Customer Data Error!";
            }

        }, function(response) {
            $scope.getResultMessage = "Fail!";
        });

    }
});
