app.controller("learnSpaceCtrl", function($scope){
    $scope.goto = function(where){
        window.location.href = where;
    }
});