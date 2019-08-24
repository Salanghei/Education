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

app.controller("collectionCtrl", function($scope){
    $scope.goto = function(where){
        window.location.href = where;
    }
}).controller("fileCtrl", function($scope, personalService){
    $scope.goto = function(where){
        window.location.href = where;
    }

    var params = {};
    $scope.getPassResourcesByUser = function(){
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
}).controller("individualCtrl", function($scope){
    $scope.goto = function(where){
        window.location.href = where;
    }
});