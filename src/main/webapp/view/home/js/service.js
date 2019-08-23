app.service("homeService", function($http){

    this.login = function(params, callback) {
        $http({
            method: 'GET',
            url: '/user/login?'+'email='+params.email+'&password='+params.password
        }).then(function success(response) {
            var data = response.data.message;// 这个data是将要传到controller.js中去的
            if (callback) {
                callback(data);// 这样就把data传到controller.js中去了
            }
        }, function error(response) {
            // 请求失败执行代码
        });
    }

    this.allCourses = function(params, callback){
        $http({
            method: 'GET',
            url: '/course/allCourses'
        }).then(function success(response) {
            var allCoursesList = response.data.allCoursesList;// 这个data是将要传到controller.js中去的
            var userCountList = response.data.userCountList;
            if (callback) {
                callback(allCoursesList, userCountList);// 这样就把data传到controller.js中去了
            }
        }, function error(response) {
            // 请求失败执行代码
        });
    }

    this.allResources = function(params, callback){
        $http({
            method: 'GET',
            url: '/resource/allPassResources'
        }).then(function success(response) {
            var passResourcesList = response.data.passResourcesList;// 这个data是将要传到controller.js中去的
            if (callback) {
                callback(passResourcesList);// 这样就把data传到controller.js中去了
            }
        }, function error(response) {
            // 请求失败执行代码
        });
    }
});