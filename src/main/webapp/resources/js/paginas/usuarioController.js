/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



(function(app){
   
    var usuarioController = function($scope, $http,$routeParams){
        
       $scope.usuarioSelecionado = null;
       
       $scope.teste = "STRING TESTE";

       $scope.selecionaUsuario = function(usuario){
           $scope.usuarioSelecionado = usuario;
       };

    };   
    app.controller("usuarioController",usuarioController);
    
//}(angular.module("usuario")));
}(angular.module("aplicacao")));