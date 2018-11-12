var app = angular.module('helloworld', ['ui.router']);
app.controller('myCtrl', function($scope, $http) {
    $scope.pageNum=1;
    $scope.lastPage=1;
    $scope.total=1;
    $scope.navigatepageNums=1;
    $scope.pageInfo = function pageData(pageNum) {
        $http.get("getPerson/"+pageNum)
            .then(function (response) {
                $scope.persons = response.data.list;
                $scope.navigatepageNums = response.data.navigatepageNums;
                $scope.pageNum = response.data.pageNum;
                $scope.lastPage = response.data.lastPage;
                $scope.total = response.data.total;
            });
    };
    $scope.delete = function deleteData(id) {
        $http.get("delete/"+id)
            .then(function (response) {
                history.go(0);
            });
    };
    $scope.pageInfo(1);
    // $scope.update = function updateData(id) {
    //
    // };
});

app.config(function ($stateProvider, $urlRouterProvider) {
    $urlRouterProvider.otherwise('main');
    $stateProvider
        .state("main", {
            url: '/main',
            templateUrl: '../templates/personList.html'
        })
        .state("update", {
            url: "/update",
            templateUrl: "../templates/update.html"
        })
});