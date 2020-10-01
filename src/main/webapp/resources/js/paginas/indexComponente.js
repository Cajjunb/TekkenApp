/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


var personagensModulo = angular.module('personagensModulo',[]);

personagensModulo.controller('personagensController',function($scope, $http){
    urlPersonagens = 'http://localhost:8080/TekkenApp/rest/personagens';
    urlGolpes = 'http://localhost:8080/TekkenApp/rest/personagens/golpes';
    
    $scope.listarPersonagens = function(){
        $http.get(urlPersonagens).then(function(response){
            $scope.personagens = response.data;
            $scope.personagens.forEach(function(valor,index,array){
                array[index]['show'] = false;
            });
        }).catch(function(erro){
            alert(erro.toString());
        });
    };
    
    //CHAMA
    $scope.listarPersonagens();
    
    
   $scope.selecionaPersonagem = function(personagemSelecionado){
       $scope.personagem = personagemSelecionado;
       $('linha'+$scope.personagem.id);
       $scope.personagem.show = !$scope.personagem.show;
       if($scope.personagem.show){
            var registroDTO = {
                    'id': $scope.personagem.id ,
                    'nome': $scope.personagem.nome ,
                    'fotoUrl': $scope.personagem.foto != null?$scope.personagem.foto: ''
                };
            $http.post(urlGolpes,registroDTO).then(function(response){
                var i = $scope.personagens.indexOf(personagemSelecionado);
                $scope.personagens[i] = response.data;
                $scope.personagens[i].show = true;
            }).catch(function(erro){
                alert(erro.toString());
            });
        }
   };
   
   $scope.limpaPersonagem = function(){
       $scope.personagem = null;
   };
   
   $scope.salvaPersonagem = function(){
       console.log($scope.personagem);
       if("id" in  $scope.personagem){
           var registroNovo = {
                'id': $scope.personagem.id != null? $scope.personagem.id :'',
                'nome': $scope.personagem.nome ,
                'fotoUrl': $scope.personagem.foto != null?$scope.personagem.foto: ''
            };
            console.log(registroNovo);
            $http.put(urlPersonagens,registroNovo).then(function(response){
               $scope.personagens.push($scope.personagem);
               $scope.limpaPersonagem();
               $scope.listarPersonagens();
            }).catch(function(erro){
                alert(erro.toString());
            });
       }else{
           var registroNovo = {
                'id':$scope.personagem.id,
                'nome': $scope.personagem.nome,
                'fotoUrl': $scope.personagem.foto
            };
            $http.post(urlPersonagens,registroNovo).then(function(response){
               $scope.personagens.push($scope.personagem);
               $scope.limpaPersonagem();
               $scope.listarPersonagens();
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