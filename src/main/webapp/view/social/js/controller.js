app.controller("blogCtrl", function($scope, socialService){
    $scope.goto = function(where){
        window.location.href = where;
    }

    var params = {};
    socialService.getApplyMessage(params, function(friendApplyList, resourceApplyList){
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
}).controller("friendCtrl", function($scope, socialService){
    $scope.goto = function(where){
        window.location.href = where;
    }

    var params = {};
    socialService.friendByUid(params, function(studentInfoList, friendList){
        var friendInfoList = [];
        for(var i = 0; i < friendList.length; i++){
            var img = Math.ceil(Math.random()*10);  // 取0~10的随机数，取0概率极小
            img = (img == 0)? 1 : img;
            var friendInfo = {
                "img": img,
                "id_student": studentInfoList[i]["id_student"],
                "gender": studentInfoList[i]["gender"],
                "region": studentInfoList[i]["region"],
                "highest_education": studentInfoList[i]["highest_education"],
                "imd_band": studentInfoList[i]["imd_band"],
                "age_band": studentInfoList[i]["age_band"],
                "trust": friendList[i]["trust"]
            };
            friendInfoList.push(friendInfo);
        }
        console.log(friendInfoList);
        $scope.friendInfoList = friendInfoList;
    });

    socialService.getApplyMessage(params, function(friendApplyList, resourceApplyList){
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
}).controller("groupCtrl", function($scope, socialService){
    $scope.goto = function(where){
        window.location.href = where;
    }

    var params = {};
    socialService.getApplyMessage(params, function(friendApplyList, resourceApplyList){
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
}).controller("resourceSharePrivateCtrl", function($scope, socialService){
    $scope.goto = function(where){
        window.location.href = where;
    }

    var params = {};
    socialService.getApplyMessage(params, function(friendApplyList, resourceApplyList){
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