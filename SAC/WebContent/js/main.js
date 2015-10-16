var app = angular.module('SistemaAcademico', ['ngRoute']);

app.config(['$routeProvider',
      function($routeProvider) {
      $routeProvider.
      when('/cadastro_disciplina', {
        templateUrl: 'cadastro_disciplina.html',
        controller: 'DisciplinaController'
      }).
      when('/cadastro_turma', {
        templateUrl: 'cadastro_turma.html',
        controller: 'TurmaController'
      }).
      when('/cadastro_aluno', {
        templateUrl: 'cadastro_aluno.html',
        controller: 'AlunoController'
      });
}]);



