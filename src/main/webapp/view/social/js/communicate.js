app.controller("communicateCtrl", function($scope, socialService){
    $scope.goto = function(where){
        window.location.href = where;
    }

    var params = {};
    var myChart = echarts.init(document.getElementById("chart-network"));
    myChart.showLoading();
    socialService.getTrustNetworkData(params, function(getNodes, getEdges, userid, recommendFriends){
        $scope.recommendFriends = recommendFriends;
        var categories = [
            {name: "中心节点"},
            {name: "直接信任关系"},
            {name: "第一层间接信任关系"},
            {name: "第二层间接信任关系"}
        ];
        var nodes = [];
        var links = [];
        $.each(getNodes, function(key, item){
            nodes.push({category: item["category"], name: item["name"], value: item["value"]});
        });
        console.log(nodes);
        $.each(getEdges, function(key, item){
            links.push({source: item["source"], target: item["target"], weight: item["weight"]});
        });
        console.log(links);

        var option = {
            legend: [{
                data: categories.map(function (a) {
                    return a.name;
                }),
                orient: 'vertical',
                left: 0,
                bottom: 0
            }],
            tooltip : {
                trigger: 'item',
                formatter:function(params){
                    if(params.data.weight){
                        return params.data.source + '-' + params.data.target + '信任值:'+ params.data.weight;
                    }
                    else{
                        return "学生ID:" + params.name;
                    }
                }
            },
            animation: false,
            series: [{
                type: 'graph',
                layout: 'force',
                lineStyle: {
                    normal: {
                        color: 'source'
                    }
                },
                data: nodes.map(function (node){
                    node.itemStyle = null;
                    node.symbolSize = node.value;
                    // Use random x, y
                    node.x = node.y = null;
                    node.draggable = true;
                    if(node.name == userid){
                        node.label = {
                            normal: {
                                show: true,
                                position: 'inside',
                                color: '#ffffff'
                            }
                        };
                    }else{
                        node.label = {
                            normal: {
                                show: false
                            }
                        };
                    }
                    return node;
                }),
                links: links,
                categories: categories,
                label: {
                    normal: {
                        position: 'right'
                    }
                },
                force: {
                    repulsion: 150
                }
            }]
        };
        myChart.hideLoading();
        myChart.setOption(option);
    });

    socialService.getUserCountInfo(params, function(trustList){
        $scope.minTrust = trustList[0];
        $scope.maxTrust = trustList[trustList.length - 1];
        $scope.friendCount = trustList.length;
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
});