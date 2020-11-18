/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



(function(app){
   
    var credenciaisController = function($scope, $http){
        $scope.mensagem = "CREDENCIAIS!";
    };   
    app.controller("credenciaisController",credenciaisController);
    
}(angular.module("aplicacao")));