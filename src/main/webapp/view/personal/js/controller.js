app.controller("collectionCtrl", function($scope){
    $scope.goto = function(where){
        window.location.href = where;
    }
}).controller("fileCtrl", function($scope){
    $scope.goto = function(where){
        window.location.href = where;
    }
}).controller("individualCtrl", function($scope){
    $scope.goto = function(where){
        window.location.href = where;
    }
});