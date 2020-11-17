/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


(function(app){
    var appController = function($http,$routeProvider){
        $routeProvider.when("/personagens",{ templateUrl:'paginas/personagens.html', controller:'personagensController'})
                .otherwise({redirectTo: "/"});
        
    };
    
    app.controller("appController",appController);
    
})(angular.module("app"));