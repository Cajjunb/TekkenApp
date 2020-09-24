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
       $('linha'+scope.personagem.id)
       
   };
   
   $scope.limpaPersonagem = function(){
       $scope.personagem = null;
   };
   
   $scope.salvaPersonagem = function(){
<<<<<<< HEAD
       if($scope.personagem.id == null){
=======
       console.log($scope.personagem);
       if("id" in  $scope.personagem){
>>>>>>> 26286ce19a6bf1052e4dde68a5e3286c994e65da
           var registroNovo = {
                'id': $scope.personagem.id != null? $scope.personagem.id :'',
                'nome': $scope.personagem.nome ,
                'fotoUrl': $scope.personagem.foto != null?$scope.personagem.foto: ''
            };
<<<<<<< HEAD
            $http.post(urlPersonagens,registroNovo).then(function(response){
=======
            console.log(registroNovo);
            $http.put(urlPersonagens,registroNovo).then(function(response){
>>>>>>> 26286ce19a6bf1052e4dde68a5e3286c994e65da
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
<<<<<<< HEAD
            $http.put(urlPersonagens,registroNovo).then(function(response){
=======
            $http.post(urlPersonagens,registroNovo).then(function(response){
>>>>>>> 26286ce19a6bf1052e4dde68a5e3286c994e65da
               $scope.personagens.push($scope.personagem);
               $scope.limpaPersonagem();
            }).catch(function(erro){
                alert(erro.toString());
            });
       }
   };
   
   $scope.excluirPersonagem = function(){
        if('id' in $scope.personagem){ 
            var registro = {
                'id': $scope.personagem.id != null? $scope.personagem.id :'',
                'nome': $scope.personagem.nome ,
                'fotoUrl': $scope.personagem.foto != null?$scope.personagem.foto: '',
                'golpes': null
            };
            console.log(registro);
            $http({
                method: 'DELETE',
                url: urlPersonagens,
                data: registro,
                headers: {
                    'Content-type': 'application/json;charset=utf-8'
                }
            }).then(function(response){
                $scope.personagens.splice($scope.personagens.indexOf($scope.personagem));
                console.log(response);
            }).catch(function(erro){
                alert(erro.toString());
            });
        }else{
            console.log('OPA!');
       }
    };
    
});