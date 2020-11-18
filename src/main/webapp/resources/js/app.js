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
                .when("/credenciais",{ 
                        templateUrl: 'paginas/credenciais.html',
                        controller:'credenciaisController'})
                
                .otherwise({redirectTo:'/'});
    };
    appMaster.config(config);
}());