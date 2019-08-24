app.controller("blogCtrl", function($scope){
    $scope.goto = function(where){
        window.location.href = where;
    }
}).controller("friendCtrl", function($scope, learnSpaceService){
    $scope.goto = function(where){
        window.location.href = where;
    }

    var params = {};
    learnSpaceService.friendByUid(params, function(studentInfoList, friendList){
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
}).controller("groupCtrl", function($scope){
    $scope.goto = function(where){
        window.location.href = where;
    }
}).controller("resourceSharePrivateCtrl", function($scope){
    $scope.goto = function(where){
        window.location.href = where;
    }
});