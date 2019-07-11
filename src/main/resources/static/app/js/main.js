var atletikaApp = angular.module("atletikaApp", ['ngRoute']);

atletikaApp.controller("homeCtrl", function($scope){
	$scope.message = "Hello JWD!";
});


atletikaApp.controller("takmicariCtrl", function($scope, $http, $location){
	
	$scope.takmicari = [];
	$scope.skakaonice = [];

//	$scope.newTakmicar = {};
//	$scope.newTakmicar.imeIPrezime = "";
//	$scope.newTakmicar.drzava = "";
//	$scope.newTakmicar.visina = "";
//	$scope.newTakmicar.godinaRodjenja = "";
//	$scope.newTakmicar.email = "";
//	$scope.newTakmicar.skakaonicaId = "";
	
	$scope.searchParams = {};
	$scope.searchParams.skakaonicaId = "";
	$scope.searchParams.imeIPrezime = "";
	$scope.searchParams.drzava = "";
	
	$scope.pageNum = 0;
	$scope.totalPages = 1
	
	var takmicariUrl = "/api/takmicari";
	var skakaoniceUrl = "/api/skakaonice";
	
	var getTakmicari = function(){
		
		var config = { params: {} };		
		
		if($scope.searchParams.destinacija != ""){
			config.params.skakaonicaId = $scope.searchParams.skakaonicaId;
		}
		
		if($scope.searchParams.prevoznikId != ""){
			config.params.imeIPrezime = $scope.searchParams.imeIPrezime;
		}
		
		if($scope.searchParams.cenaKarte != ""){
			config.params.drzava = $scope.searchParams.drzava;
		}
		
		config.params.pageNum = $scope.pageNum;
		
		$http.get(takmicariUrl, config).then(
			function success(res){
				$scope.takmicari = res.data;
				$scope.totalPages = res.headers("totalPages");
			},
			function error(){
				alert("Neupešno dobavljanje takmicara.");
			}
		);
	}
	
	getTakmicari();
	
	
	var getSkakaonice = function(){
		$http.get(skakaoniceUrl).then(
			function success(res){
				$scope.skakaonice = res.data;
			},
			function error(){
				alert("Neuspešno dobavljanje skakaonica.");
			}
		);
	}
	
	getSkakaonice();
	
	
	$scope.goToAdd = function(){
		
		$location.path("/takmicari/add")
		
		$http.post(takmicariUrl, $scope.newTakmicar).then(
			function success(){
				getTakmicari();
				
				$scope.newTakmicar = {};
				$scope.newTakmicar.imeIPrezime = "";
				$scope.newTakmicar.drzava = "";
				$scope.newTakmicar.visina = "";
				$scope.newTakmicar.godinaRodjenja = "";
				$scope.newTakmicar.email = "";

				$scope.skakaonicaId = "";
			},
			function error(){
				alert("Neuspešno čuvanje takmicara!");
			}
		);
	}
	
	$scope.doDelete = function(id){
		var promise = $http.delete(takmicariUrl + "/" + id);
		promise.then(
			function success(){
				getTakmicari();
			},
			function error(){
				alert("Neuspešno brisanje takmicara.");
			}
		);
	}
	
	$scope.goToEdit = function(id){
		$location.path("/takmicari/edit/" + id);
	}
	
	$scope.goToSkok = function(id) {
		$location.path("/skokovi/add/" +id);
	}
	
	$scope.changePage = function(direction){
		$scope.pageNum = $scope.pageNum + direction;
		getTakmicari();
	}
	
	$scope.doSearch = function(){
		$scope.pageNum = 0;
		getTakmicari();
	}
	
	$scope.doReserve = function(id){
		var promise = $http.post(linijeUrl + "/" + id);
		promise.then(
			function success(){
				alert("Uspešno rezervisano mesto.")
				getLinije();
			},
			function error(){
				alert("Neuspešna rezervacija.");
				getLinije();
			}
		);
	}
	
});


atletikaApp.controller("editTakmicarCtrl", function($scope, $http, $routeParams, $location){
	
	var takmicarUrl = "/api/takmicari/" + $routeParams.id;
	var skakaoniceUrl = "/api/skakaonice";

	$scope.skakaonice = [];
	
	$scope.takmicar = {};
	$scope.takmicar.imeIPrezime = "";
	$scope.takmicar.drzava = "";
	$scope.takmicar.visina = "";
	$scope.takmicar.godinaRodjenja = "";
	$scope.takmicar.email = "";


	$scope.skakaoniceId = "";
	
	
	
	
	var getSkakaonice = function(){
		$http.get(skakaoniceUrl).then(
			function success(res){
				$scope.skakaonice = res.data;
			},
			function error(){
				alert("Neuspešno dobavljanje skakaonice.");
			}
		);
	}
	//Ako bismo želeli da radimo kaskadiranje radi omogućavanja ng-selected odabira prevoznika,
	//onda bismo ovo morali da prebacimo u success callback pod getPrevoznici. Tu je izostavljen
	//taj mehanizam radi jednostavnosti.
	getSkakaonice();
	
	var getTakmicar = function(){
		$http.get(takmicarUrl).then(
			function success(res){
				$scope.takmicar = res.data;
			},
			function error(){
				alert("Neuspešno dobavljanje takmicara.");
			}
		);
	}
	
	getTakmicar();
	

	
	
	$scope.doEdit = function(){
		$http.put(takmicarUrl, $scope.takmicar).then(
			function success(){
				$location.path("/takmicari");
			},
			function error(){
				alert("Neuspešno čuvanje takmicara.");
			}
		);
	}
});

atletikaApp.controller("addSkokCtrl", function($scope, $http, $location , $routeParams){

    var addSkokUrl = "/api/skokovi";

    $scope.newSkok = {};
    $scope.newSkok.poeni= "";
    $scope.newSkok.ocenaSudija = "";
    $scope.newSkok.daljina = "";
    $scope.newSkok.takmicarId = $routeParams.id;
    
    $scope.goToSkok = function(){
        
        $http.post(addSkokUrl, $scope.newSkok).then(
            function success(){
                
                
                
                console.log($scope.newSkok);
                
                $scope.newSkok ={};
                $scope.newSkok.poeni= "";
                $scope.newSkok.ocenaSudija = "";
                $scope.newSkok.daljina = "";
                $scope.newSkok.takmicarId = $routeParams.id;
                
                $location.path("/takmicari");
            },
            function error(){
                console.log($scope.newSkok);
                alert("Neuspešno čuvanje skoka!");
            }
        );
    }
    
});


atletikaApp.config(['$routeProvider', function($routeProvider) {
	$routeProvider
		.when('/', {
			templateUrl : '/app/html/home.html',
			controller: 'homeCtrl'
		})
		.when('/takmicari', {
			templateUrl : '/app/html/takmicari.html'
		})
		.when('/takmicari/edit/:id', {
			templateUrl : '/app/html/edit-takmicar.html'
		})
		.when('/takmicari/add', {
			templateUrl : '/app/html/add-takmicar.html'
		})
		.when('/skokovi/add/:id', {
			templateUrl : '/app/html/add-skok.html'
		})
		.otherwise({
			redirectTo: '/'
		});
}]);