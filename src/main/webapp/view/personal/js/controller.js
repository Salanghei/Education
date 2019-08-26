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

app.controller("collectionCtrl", function($scope, personalService){
    $scope.goto = function(where){
        window.location.href = where;
    }

    var params = {};
    personalService.getApplyMessage(params, function(friendApplyList, resourceApplyList){
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
}).controller("fileCtrl", function($scope, personalService){
    $scope.goto = function(where){
        window.location.href = where;
    }

    $scope.allResourceView = "background-color: #f0f0f0;";
    $scope.toPassResourceView = "";
    $scope.notPassResourceView = "";
    $scope.downloadView = "";

    var params = {};
    $scope.getPassResourcesByUser = function(){
        $scope.allResourceView = "background-color: #f0f0f0;";
        $scope.toPassResourceView = "";
        $scope.notPassResourceView = "";
        $scope.downloadView = "";
        personalService.passResourcesByUser(params, function(data){
            console.log(data);
            var resourceList = [];
            for(var i = 0; i < data.length; i++){
                var resource = {
                    "resourceid": data[i]["resourceid"],
                    "name": data[i]["name"],
                    "type": classes[data[i]["type"]],
                    "time": data[i]["time"],
                    "userid": data[i]["userid"],
                    "tag": data[i]["tag"],
                    "details": data[i]["details"]
                };
                resourceList.push(resource);
            }
            $scope.resourceList = resourceList;
        });
    }
    $scope.getPassResourcesByUser();

    $scope.getToPassResourcesByUser = function(){
        $scope.allResourceView = "";
        $scope.toPassResourceView = "background-color: #f0f0f0;";
        $scope.notPassResourceView = "";
        $scope.downloadView = "";
        personalService.toPassResourcesByUser(params, function(data){
            console.log(data);
            var resourceList = [];
            for(var i = 0; i < data.length; i++){
                var resource = {
                    "resourceid": data[i]["resourceid"],
                    "name": data[i]["name"],
                    "type": classes[data[i]["type"]],
                    "time": data[i]["time"],
                    "userid": data[i]["userid"],
                    "tag": data[i]["tag"],
                    "details": data[i]["details"]
                };
                resourceList.push(resource);
            }
            $scope.resourceList = resourceList;
        });
    }

    $scope.getNotPassResourcesByUser = function(){
        $scope.allResourceView = "";
        $scope.toPassResourceView = "";
        $scope.notPassResourceView = "background-color: #f0f0f0;";
        $scope.downloadView = "";
        personalService.notPassResourcesByUser(params, function(data){
            console.log(data);
            var resourceList = [];
            for(var i = 0; i < data.length; i++){
                var resource = {
                    "resourceid": data[i]["resourceid"],
                    "name": data[i]["name"],
                    "type": classes[data[i]["type"]],
                    "time": data[i]["time"],
                    "userid": data[i]["userid"],
                    "tag": data[i]["tag"],
                    "details": data[i]["details"]
                };
                resourceList.push(resource);
            }
            $scope.resourceList = resourceList;
        });
    }

    $scope.getResourcesByAuth = function(){
        $scope.allResourceView = "";
        $scope.toPassResourceView = "";
        $scope.notPassResourceView = "";
        $scope.downloadView = "background-color: #f0f0f0;";
        personalService.resourcesByAuth(params, function(data){
            console.log(data);
            var resourceList = [];
            for(var i = 0; i < data.length; i++){
                var resource = {
                    "resourceid": data[i]["resourceid"],
                    "name": data[i]["name"],
                    "type": classes[data[i]["type"]],
                    "time": data[i]["time"],
                    "userid": data[i]["userid"],
                    "tag": data[i]["tag"],
                    "details": data[i]["details"]
                };
                resourceList.push(resource);
            }
            $scope.resourceList = resourceList;
        });
    }

    personalService.getApplyMessage(params, function(friendApplyList, resourceApplyList){
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
}).controller("individualCtrl", function($scope, personalService){
    $scope.goto = function(where){
        window.location.href = where;
    }

    var params = {};
    var myChart = echarts.init(document.getElementById("score-chart"));
    myChart.showLoading();
    personalService.getStudentScore(params, function(courseList, scoreList, learnLength){
        var passCount = 0;
        for(var i = 0; i < courseList.length; i++){
            if(courseList[i]["final_result"] == "Pass" || courseList[i]["final_result"] == "Distinction"){
                passCount += 1;
            }
        }
        $scope.passPercent = (passCount / courseList.length) * 100;

        if(learnLength.length != 0) {
            $scope.learnLength = learnLength;
            $scope.minScore = scoreList[0]["score"];
            $scope.maxScore = scoreList[scoreList.length - 1]["score"];
            var sumScore = 0;
            var indicator = [];
            var data = [];
            var text = scoreList[0]["code_module"];
            for (var i = 0; i < scoreList.length; i++) {
                sumScore += scoreList[i]["score"];

                var axisStr = scoreList[i]["code_presentation"] + "/" + scoreList[i]["assessment_type"] + (i + 1);
                indicator.push({text: axisStr, max: 100});
                data.push(scoreList[i]["score"]);
            }
            $scope.avgScore = sumScore / (scoreList.length);

            myChart.hideLoading();    //隐藏加载动画
            myChart.setOption({        //加载数据图表
                title: {
                    text: text,
                    subtext: '成绩分布情况'
                },
                tooltip: {},
                legend: {
                    x: 'left',
                    y: 'bottom',
                    data: ['成绩']
                },
                radar: [
                    {
                        indicator: indicator
                    }
                ],
                series: [
                    {
                        type: 'radar',
                        itemStyle: {normal: {areaStyle: {type: 'default'}}},
                        data: [
                            {
                                value: data,
                                name: '成绩'
                            }
                        ]
                    }
                ]
            });
        }else{
            myChart.hideLoading();
            alert("暂无成绩信息");
        }
    });

    personalService.getStudentOtherInfo(params, function (resourceCount, resourceClick, friendCount, userid) {
        $scope.resourceCount = resourceCount;
        $scope.resourceClick = resourceClick;
        $scope.friendCount = friendCount;
        $scope.userid = userid;
    });

    personalService.getApplyMessage(params, function(friendApplyList, resourceApplyList){
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