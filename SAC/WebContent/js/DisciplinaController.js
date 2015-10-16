app.controller('DisciplinaController', function($scope, $http) {
	
	$scope.listaDisciplinas = [];


	$scope.listar = function() {
		$http.get('http://localhost:8080/SAC/rest/disciplina').success(
			function(dados) {
				alert(dados);
				if(Array.isArray(dados.disciplina)) {
					$scope.listaDisciplinas = dados.disciplina;
				} else {
					$scope.listaDisciplinas.push(dados.disciplina);
				}
			}
		).error(function (data, status, headers, config) {        
        	alert('Erro: '+data+status+headers+config);
    	});
	}

	$scope.listar();	

	$scope.gravar = function() {
				
		$scope.listaDisciplinas.push($scope.disciplina);			

		$scope.disciplina = {};	
	}

	$scope.remover = function(disciplina) {

		var indice = $scope.listaDisciplinas.indexOf(disciplina);

		$scope.listaDisciplinas.splice(indice, 1);				
		
	}


});

