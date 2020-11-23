/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


(function(app){
    
    app.service('servico',function(){
       var data,getData,setData;
       data = {
                nome: "NOME",
                Valor: 10
       };
       getData = function(){
           return this.dataServico;
       };
       setData = function(dataArg){
           this.data = dataArg ;
       };
       return {
           data:data,
           getData:getData,
           setData:setData
       };
    });
    
}(angular.module('aplicacao')));

