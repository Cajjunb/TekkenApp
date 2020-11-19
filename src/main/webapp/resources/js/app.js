/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

(function () {
    var appMaster = angular.module('aplicacao', ['ngRoute']);
    var BASE_URL = "http://"+window.location.href;
    var config = function($routeProvider){
        $routeProvider
                .when("/",{ 
                        templateUrl: 'paginas/usuarios.html',
                        controller:'usuarioController'})
                .when("/personagens",{ 
                        templateUrl: 'paginas/personagens.html',
                        controller:'personagensController'})      
                .when("/credenciais",{ 
                        templateUrl: 'paginas/credenciais.html',
                        controller:'credenciaisController'})
                
                .otherwise({redirectTo:'/'});
    };
    
//    appMaster.factory('servico',function(){
//       var servicoInstancia = "STRING SERVIÇO";
//       return servicoInstancia;
//    });
    appMaster.config(config);
    appMaster.factory('notify', function() {
            var msgs = {
                'usuario': 'c1313819',
                'nome': 'Leandro Ramalho'
            };
            return msgs;
     });
    //REGISTRANDO SERVICOS
//    appMaster.factory('servico',function(){
//       this.data = {
//                nome: "NOME",
//                Valor: 10
//       };
//       this.getData = function(){
//           return this.dataServico;
//       };
//       this.setData = function(dataArg){
//           this.data = dataArg ;
//       };
//       
//       
//       
//    });
}());