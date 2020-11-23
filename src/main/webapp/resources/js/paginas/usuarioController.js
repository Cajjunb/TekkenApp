/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



(function(app){
   
    var usuarioController = function($scope, $http,$routeParams,notify){
        
       $scope.usuarioSelecionado = null;
       
       $scope.teste = "STRING TESTE";

       $scope.selecionaUsuario = function(usuario){
           $scope.usuarioSelecionado = usuario;
       };
       
       $scope.printaUsuario = function(){
           console.log(notify);
       };
       

    };   
    app.controller("usuarioController",['$scope','$http','$routeParams','notify',usuarioController]);
    
//}(angular.module("usuario")));
}(angular.module("aplicacao")));