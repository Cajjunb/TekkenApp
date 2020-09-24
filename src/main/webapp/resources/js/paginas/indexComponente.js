/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


var personagensModulo = angular.module('personagensModulo',[]);

personagensModulo.controller('personagensController',function($scope, $http){
    urlPersonagens = 'http://localhost:8080/TekkenApp/rest/personagens';
    
    $scope.listarPersonagens = function(){
        $http.get(urlPersonagens).then(function(response){
            $scope.personagens = response.data;
        }).catch(function(erro){
            alert(erro.toString());
        });
    };
    
    //CHAMA
    $scope.listarPersonagens();
    
    
   $scope.selecionaPersonagem = function(personagemSelecionado){
       $scope.personagem = personagemSelecionado;
   };
   
   $scope.limpaPersonagem = function(){
       $scope.personagem = null;
   };
   
   $scope.salvaPersonagem = function(){
       if($scope.personagem.id == null){
           var registroNovo = {
                'id': $scope.personagem.id != null? $scope.personagem.id :'',
                'nome': $scope.personagem.nome ,
                'fotoUrl': $scope.personagem.foto != null?$scope.personagem.foto: ''
            };
            $http.post(urlPersonagens,registroNovo).then(function(response){
               $scope.personagens.push($scope.personagem);
               $scope.limpaPersonagem();
            }).catch(function(erro){
                alert(erro.toString());
            });
       }else{
           var registroNovo = {
                'id':$scope.personagem.id,
                'nome': $scope.personagem.nome,
                'fotoUrl': $scope.personagem.foto
            };
            $http.put(urlPersonagens,registroNovo).then(function(response){
               $scope.personagens.push($scope.personagem);
               $scope.limpaPersonagem();
            }).catch(function(erro){
                alert(erro.toString());
            });
       }
   };
   
   $scope.excluirPersonagem = function(){
       $scope.personagens.splice($scope.personagens.indexOf($scope.personagem));
    };
    
});