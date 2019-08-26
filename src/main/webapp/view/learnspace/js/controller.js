app.controller("learnSpaceCtrl", function($scope, learnSpaceService){
    $scope.goto = function(where){
        window.location.href = where;
    }

    var params = {};
    learnSpaceService.getApplyMessage(params, function(friendApplyList, resourceApplyList){
        var friendApplies = [];
        for(var i = 0; i < friendApplyList.length; i++){
            var img = Math.ceil(Math.random()*10);  // 取0~10的随机数，取0概率极小
            img = (img == 0)? 1 : img;
            var friendApply = {
                "img": img,
                "fid": friendApplyList[i]["fid"],
                "time": friendApplyList[i]["time"]
            };
            friendApplies.push(friendApply);
        }
        if(friendApplies.length == 0 && resourceApplyList.length == 0){
            $scope.applyFlag = true;
        }else{
            $scope.applyFlag = false;
        }
        $scope.friendApplies = friendApplies;
        $scope.resourceApplyList = resourceApplyList;
    });
});