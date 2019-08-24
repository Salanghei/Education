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
});