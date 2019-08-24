app.service("learnSpaceService", function($http){
    this.friendByUid = function(params, callback){
        $http({
            method: "Get",
            url: "/friend/friendByUid"
        }).then(function success(response){
            var studentInfoList = response.data.studentInfoList;// 这个data是将要传到controller.js中去的
            var friendList = response.data.friendList;
            if (callback) {
                callback(studentInfoList, friendList);// 这样就把data传到controller.js中去了
            }
        }, function error(response){
            // 请求失败执行代码
        });
    }

    this.getTrustNetworkData = function(params, callback){
        $http({
            method: "Get",
            url: "/user/trustNetworkData"
        }).then(function success(response){
            var getNodes = response.data.nodes;// 这个data是将要传到controller.js中去的
            var getEdges = response.data.edges;
            var recommendFriends = response.data.recommendFriends;
            var userid = response.data.userid;
            if (callback) {
                callback(getNodes, getEdges, userid, recommendFriends);// 这样就把data传到controller.js中去了
            }
        }, function error(response){
            // 请求失败执行代码
        });
    }
});