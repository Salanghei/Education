app.service("socialService", function($http){
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

    this.getUserCountInfo = function(params, callback){
        $http({
            method: "Get",
            url: "/user/userCountInfo"
        }).then(function success(response){
            var trustList = response.data.trustList;// 这个data是将要传到controller.js中去的
            if (callback) {
                callback(trustList);// 这样就把data传到controller.js中去了
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