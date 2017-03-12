/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
var movie=[];
app.controller("MovieController", function RegisterController($scope, $http,productService){
    $scope.movies = {};
//alert("hi")
		    $http.get('http://localhost:8080/pinku/webresources/movieservice/movies').
		        then(function(response) {
		            $scope.movies = response.data;
                            //alert(angular.toJson(response));
		            });
    $scope.getId = function(idd){
        productService.addProduct(idd);
        console.log(idd);
          movie=idd;
          console.log(movie);
          alert('sss');
          window.location="./singam.html";
    };
//    $scope.movieRetrive = function(){
//    $http({
//    method: 'GET',
//    url: 'http://localhost:8080/pinku/webresources/movieservice/movies'
//  }).then(function successCallback(response) {
//        $scope.movies = response.data;
//        alert(angular.toJson(response));
//      
//    }, function errorCallback(response) {
//      alert(angular.toJson(response));
//      
//    });};
});


