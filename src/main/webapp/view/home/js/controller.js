var classes = {
    "doc": "demo-pli-file-word text-info",
    "docx": "demo-pli-file-word text-info",
    "txt": "demo-pli-file-txt text-pink",
    "xls": "demo-pli-file-excel text-success",
    "xlsx": "demo-pli-file-excel text-success",
    "csv": "demo-pli-file-csv text-mint",
    "html": "demo-pli-file-html text-purple",
    "jpg": "demo-pli-file-jpg text-warning",
    "zip": "demo-pli-file-zip text-pink",
    "mp4": "demo-pli-file-video text-warning",
    "mp3": "demo-pli-file-music text-purple",
    "other": "demo-pli-file"
};

app.controller("frontpageBeforeLoginCtrl", function($scope, homeService){
    $scope.goto = function(where){
        window.location.href = where;
    }

    var params = {};
    homeService.allCourses(params, function(allCoursesList, userCountList){
        console.log(allCoursesList);
        console.log(userCountList);
        var colors = ["bg-warning", "bg-success", "bg-pink", "bg-info", "bg-mint", "bg-danger", "bg-purple"];
        var coursesList = [];
        for(var i =0; i < allCoursesList.length; i++) {
            var course = {
                "name": allCoursesList[i],
                "userCount": userCountList[i],
                "color": colors[i]
            };
            coursesList.push(course);
        }
        $scope.coursesList = coursesList;
    });

    homeService.allResources(params, function(data){
        console.log(data);
        var resourceList = [];
        for(var i = 0; i < data.length; i++){
            var tags = data[i]["tag"].split(",");
            tags.pop();
            var resource = {
                "resourceid": data[i]["resourceid"],
                "name": data[i]["name"],
                "type": classes[data[i]["type"]],
                "time": data[i]["time"],
                "userid": data[i]["userid"],
                "tags": tags,
                "details": data[i]["details"]
            };
            resourceList.push(resource);
        }
        $scope.resourceList = resourceList;
    })
}).controller("loginCtrl", function($scope, $cookies, homeService){
    // 页面跳转
    $scope.goto = function(where){
        window.location.href = where;
    }

    $scope.email = "";
    $scope.password = "";
    $scope.remember = "";

    // 获取cookies内容
    $scope.getInfo = function() {
        $scope.email = $cookies.get("email");
        $scope.password = $cookies.get("password");
        $scope.remember = $cookies.get("remember") == "true" ? true : false;
        console.log("$scope.email", $scope.email);
        console.log("$scope.password", $scope.password);
        console.log("$scope.remember", $scope.remember);
    }
    $scope.getInfo();

    // 用户登录
    $scope.login = function(){
        var params = {
            "email" : $scope.email,
            "password" : $scope.password,
            "remember" : $scope.remember
        };
        console.log("params", params);
        //设置cookies
        if($scope.remember) {
            var expireDate = new Date();
            expireDate.setDate(expireDate.getDate() + 7);
            $cookies.put("email",$scope.email,{'expires': expireDate});
            $cookies.put("password",$scope.password,{'expires': expireDate});
            $cookies.put("remember",$scope.remember,{'expires': expireDate});
        } else {
            $cookies.remove("email");
            $cookies.remove("password");
            $cookies.remove("remember");
        }
        homeService.login(params, function (data) {
            console.log("data",data);
            if(data == "success") {
                /*var param={};
                 $loginService.getUser(param,function(user) {
                 alert(user.name);
                 })*/
                window.location.href="../../../view/home/frontpage.html";
            } else if(data == "wrongPassword") {
                alert("密码错误，请重新登陆！")
                //window.location.href="http://localhost:8080/login/login.html";
            } else if(data == "userDoesNotExist") {
                alert("用户名不存在，请重新登陆！")
                //window.location.href="http://localhost:8080/login/login.html";
            } else {

            }
        });
    }
}).controller("registerCtrl", function($scope){
    $scope.goto = function(where){
        window.location.href = where;
    }
}).controller("frontpageCtrl", function($scope, homeService){
    $scope.goto = function(where){
        window.location.href = where;
    }

    var params = {};
    homeService.allCourses(params, function(allCoursesList, userCountList){
        console.log(allCoursesList);
        console.log(userCountList);
        var colors = ["bg-warning", "bg-success", "bg-pink", "bg-info", "bg-mint", "bg-danger", "bg-purple"];
        var coursesList = [];
        for(var i =0; i < allCoursesList.length; i++) {
            var course = {
                "name": allCoursesList[i],
                "userCount": userCountList[i],
                "color": colors[i]
            };
            coursesList.push(course);
        }
        $scope.coursesList = coursesList;
    });

    homeService.allResources(params, function(data){
        console.log(data);
        var resourceList = [];
        for(var i = 0; i < data.length; i++){
            var tags = data[i]["tag"].split(",");
            tags.pop();
            var resource = {
                "resourceid": data[i]["resourceid"],
                "name": data[i]["name"],
                "type": classes[data[i]["type"]],
                "time": data[i]["time"],
                "userid": data[i]["userid"],
                "tags": tags,
                "details": data[i]["details"]
            };
            resourceList.push(resource);
        }
        $scope.resourceList = resourceList;
    })

    homeService.getApplyMessage(params, function(friendApplyList, resourceApplyList){
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