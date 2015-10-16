app.controller('DisciplinaController', function($scope, $http) {
	
	$scope.listaDisciplinas = [];


	$scope.listar = function() {
		$http.get('http://localhost:8080/SAC/rest/disciplina').success(
			function(dados) {				
				if(Array.isArray(dados)) {
					$scope.listaDisciplinas = dados;
				} else {
					$scope.listaDisciplinas.push(dados);
				}
			}
		).error(function (data, status, headers, config) {        
        	alert('Erro: '+data+status+headers+config);
    	});
	}

	$scope.listar();
	

	$scope.gravar = function() {
				
		$http.post('http://localhost:8080/SAC/rest/disciplina', $scope.disciplina).success(
				function(dados) { 
					alert(dados);
					$scope.listar();
					$scope.disciplina = {};			
	  			}
	   	).error(function (data, status, headers, config) {        
        	alert('Erro: '+data+status+headers+config);
    	});	
	}

	$scope.remover = function(disciplina) {

		var indice = $scope.listaDisciplinas.indexOf(disciplina);

		$scope.listaDisciplinas.splice(indice, 1);				
		
	}


});

