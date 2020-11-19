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
                        controller:'usuarioController'
                        })
                .when("/login",{ 
                        templateUrl: 'paginas/login.html',
                        controller:'loginController'
                        })        
                .when("/personagens",{ 
                        templateUrl: 'paginas/personagens.html',
                        controller:'personagensController'
                })      
                .when("/credenciais",{ 
                        templateUrl: 'paginas/credenciais.html',
                        controller:'credenciaisController',
                        resolve:{
                          filtroLogin: function(){
                              var erro = new Error();
                              erro.message = "ERRO DE AUTENTICAÇÃO";
                              erro.name = "AUTERROR";
//                              throw erro;
                              return erro;
                          }  
                        }
                    })
                
                .otherwise({redirectTo:'/'});
    };
    appMaster.config(config);
    appMaster.factory('notify', function() {
            var msgs = {
                'usuario': 'c1313819',
                'nome': 'Leandro Ramalho'
            };
            return msgs;
     });
  
}());