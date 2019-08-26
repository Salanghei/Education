app.service("learnSpaceService", function($http){
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