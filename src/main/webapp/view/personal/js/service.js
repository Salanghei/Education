app.service("personalService", function($http){
    this.passResourcesByUser = function(params, callback){
        $http({
            method: "Get",
            url: "/resource/passResourcesByUser"
        }).then(function success(response){
            var data = response.data.passResourcesList;// 这个data是将要传到controller.js中去的
            if (callback) {
                callback(data);// 这样就把data传到controller.js中去了
            }
        }, function error(response){
            // 请求失败执行代码
        });
    }

    this.toPassResourcesByUser = function(params, callback){
        $http({
            method: "Get",
            url: "/resource/toPassResourcesByUser"
        }).then(function success(response){
            var data = response.data.toPassResourceList;// 这个data是将要传到controller.js中去的
            if (callback) {
                callback(data);// 这样就把data传到controller.js中去了
            }
        }, function error(response){
            // 请求失败执行代码
        });
    }

    this.notPassResourcesByUser = function(params, callback){
        $http({
            method: "Get",
            url: "/resource/notPassResourcesByUser"
        }).then(function success(response){
            var data = response.data.notPassResourceList;// 这个data是将要传到controller.js中去的
            if (callback) {
                callback(data);// 这样就把data传到controller.js中去了
            }
        }, function error(response){
            // 请求失败执行代码
        });
    }

    this.resourcesByAuth = function(params, callback){
        $http({
            method: "Get",
            url: "/resource/resourcesByAuth"
        }).then(function success(response){
            var data = response.data.authResourceList;// 这个data是将要传到controller.js中去的
            if (callback) {
                callback(data);// 这样就把data传到controller.js中去了
            }
        }, function error(response){
            // 请求失败执行代码
        });
    }

    this.getStudentScore = function(params, callback){
        $http({
            method: "Get",
            url: "/user/studentScore"
        }).then(function success(response){
            var courseList = response.data.courseList;
            var scoreList = response.data.scoreList;// 这个data是将要传到controller.js中去的
            var learnLength = response.data.learnLength;
            if (callback) {
                callback(courseList, scoreList, learnLength);// 这样就把data传到controller.js中去了
            }
        }, function error(response){
            // 请求失败执行代码
        });
    }

    this.getStudentOtherInfo = function (params, callback) {
        $http({
            method: "Get",
            url: "/user/studentOtherInfo"
        }).then(function success(response){
            var resourceCount = response.data.resourceCount;
            var resourceClick = response.data.resourceClick;// 这个data是将要传到controller.js中去的
            var friendCount = response.data.friendCount;
            var userid = response.data.userid;
            if (callback) {
                callback(resourceCount, resourceClick, friendCount, userid);// 这样就把data传到controller.js中去了
            }
        }, function error(response){
            // 请求失败执行代码
        });
    }

    this.getApplyMessage = function(params, callback){
        $http({
            method: 'GET',
            url: '/user/applyMessage'
        }).then(function success(response) {
            var friendApplyList = response.data.friendApplyList;// 这个data是将要传到controller.js中去的
            var resourceApplyList = response.data.resourceApplyList;
            if (callback) {
                callback(friendApplyList, resourceApplyList);// 这样就把data传到controller.js中去了
            }
        }, function error(response) {
            // 请求失败执行代码
        });
    }
});