/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
app.controller("MovieoneController", function RegisterController($scope, $http,productService){
    $scope.movie = productService.getProducts();;
    console.log($scope.movie);
});


