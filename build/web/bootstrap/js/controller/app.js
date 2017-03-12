/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 * http://viralpatel.net/blogs/angularjs-routing-and-views-tutorial-with-example/
 */
var app = angular.module("TicketBooking", []);
var geturl="http://localhost:8080/pinku/webresources/";
//var registerurl
var movie=[];
var member =[];
var price=0;
var seatselect='';
var noOfSeats;

app.config(['$routeProvider',function($routeProvider){
    $routeProvider.
            //when('/login',{templateUrl:'partials/login.html',controller: 'LoginController'}).
            when('/register',{templateUrl:'partials/register.html',controller: 'RegisterController'}).
            when('/member',{templateUrl:'partials/member.html',controller: 'MemberController'}).
            when('/admin',{templateUrl:'partials/admin.html',controller: 'AdminController'}).
            when('/home',{templateUrl:'partials/home.html',controller: 'HomeController'}).
            when('/movies',{templateUrl:'partials/movies.html',controller: 'MovieController'}).
            when('/movie',{templateUrl:'partials/movie.html',controller: 'singleMovieController'}).
            when('/seats',{templateUrl:'partials/seats.html',controller: 'singleMovieController'}).
            when('/book',{templateUrl:'partials/book.html',controller: 'bookController'}).
            otherwise({redirectTo:'/login',templateUrl:'partials/login.html',controller: 'LoginController'});
}]);

app.controller("MemberController", function MemberController($scope, $http,$rootScope){
    
    $scope.member=member;
    $scope.logout = function(){
         movie=[];
         $rootScope.glob_admin=false;
         $rootScope.glob_mem=[];
         member =[];
         price=0;
         seatselect='';
         noOfSeats=0;
         alert('Loged out sucessfully');
        window.location="#/login";
    };
    $http.get('http://localhost:8080/pinku/webresources/usermovieservice/usermovies/'+$scope.member.uid).
		        then(function(response) {
		            $scope.usermovies = response.data;
                            //alert(angular.toJson(response));
		            });
});

app.controller("AdminController", function AdminController($scope, $http){
    
    $scope.adminForm={};
    
    $scope.AdminSubmit=function(){
        $scope.adminForm.poster='http://localhost:8080/pinku/image/'+$scope.adminForm.poster+'.jpg';
        console.log($scope.adminForm);
           $http({
            method: 'POST',
            url: 'http://localhost:8080/pinku/webresources/movieservice/addmovie',
            headers: {'Content-Type': 'application/x-www-form-urlencoded'},
            transformRequest: function(obj) {
              var str = [];
              for(var p in obj)
              str.push(encodeURIComponent(p) + "=" + encodeURIComponent(obj[p]));
              return str.join("&");
          },
          data: $scope.adminForm
          }).then(function successCallback(response) {
    // this callback will be called asynchronously
    // when the response is available
    alert('uploaded sucessfully');
    window.location="#/movies";
    //alert(angular.toJson(response));
  }, function errorCallback(response) {
    // called asynchronously if an error occurs
    // or server returns response with an error status.
    alert('error');
    alert(response);
  });
        
    };
});

app.controller("RegisterController", function RegisterController($scope, $http){
    $scope.registerForm ={};
    $scope.RegisterSubmit = function(){
                //alert(registerForm.firstname);
                    //console.log(registerForm.firstname);
       // console.log("HI");

        $http({
            method: 'POST',
            url: geturl+'memberservice/addmember',
            headers: {'Content-Type': 'application/x-www-form-urlencoded'},
            transformRequest: function(obj) {
              var str = [];
              for(var p in obj)
              str.push(encodeURIComponent(p) + "=" + encodeURIComponent(obj[p]));
              return str.join("&");
          },
          data: $scope.registerForm
          }).then(function successCallback(response) {
    // this callback will be called asynchronously
    // when the response is available
    alert('Sucees');
    window.location="#/login";
    //alert(angular.toJson(response));
  }, function errorCallback(response) {
    // called asynchronously if an error occurs
    // or server returns response with an error status.
    alert('error');
    alert(response);
  });
                  
    };
});


app.controller("HomeController", function HomeController($scope, $http){
    
    $scope.member=member;
});

app.controller("LoginController", function LoginController($scope, $http,$rootScope){
    $scope.ret_member = [];
    $scope.member = [];
//    $http.get('http://localhost:8080/pinku/webresources/memberservice/getmember/'+member.email+'/'+member.password).
$scope.LoginSubmit = function(){
                //alert(registerForm.firstname);
                    //console.log(registerForm.firstname);
        //console.log("HI");

        $http({
            method: 'POST',
            url:'http://localhost:8080/pinku/webresources/memberservice/getmember/',
            headers: {'Content-Type': 'application/x-www-form-urlencoded'},
            transformRequest: function(obj) {
              var str = [];
              for(var p in obj)
              str.push(encodeURIComponent(p) + "=" + encodeURIComponent(obj[p]));
              return str.join("&");
          },
          data: $scope.member
          }).then(function successCallback(response) {
    // this callback will be called asynchronously
    // when the response is available
    
    $scope.ret_member=response.data;
    $rootScope.glob_mem =$scope.ret_member;
    console.log($rootScope.glob_mem);
    if($scope.ret_member.uid == 0){
        alert('Check username and password');
    }else{
        if($scope.ret_member.uid == 101){
            $rootScope.glob_admin=true;
        }else{
            $rootScope.glob_admin=false;
        }
        alert('Sucessfully login as '+$scope.ret_member.firstname);
        member=$scope.ret_member
    window.location="#/home";
    }
    
    
  }, function errorCallback(response) {
    // called asynchronously if an error occurs
    // or server returns response with an error status.
    alert('error');
    alert(response);
  });
                  
    };
    
    
});

app.controller("bookController", function RegisterController($scope, $http){
    console.log('MOVIE '+movie);
    console.log('PRICE '+price);
    console.log('SELECTED SEATS '+seatselect);
    console.log('NO OF SEATS '+noOfSeats);
    $scope.movie=movie;
    $scope.price=price;
    $scope.seatselect=seatselect;
    $scope.noOfSeats=noOfSeats;
    $scope.bookForm ={};
    $scope.bookForm.mid=$scope.movie.mid;
    $scope.bookForm.uid=member.uid;
    $scope.bookForm.movie=$scope.movie.movieName;
    $scope.bookForm.seats=$scope.seatselect;
    $scope.bookForm.price=$scope.price;
    $scope.bookForm.noofseats=$scope.noOfSeats;
    
    
        
    $scope.BookSubmit = function(){
                //alert(registerForm.firstname);
                    //console.log(registerForm.firstname);
       // console.log("HI");

        $http({
            method: 'POST',
            url: 'http://localhost:8080/pinku/webresources/usermovieservice/bookmovie',
            headers: {'Content-Type': 'application/x-www-form-urlencoded'},
            transformRequest: function(obj) {
              var str = [];
              for(var p in obj)
              str.push(encodeURIComponent(p) + "=" + encodeURIComponent(obj[p]));
              return str.join("&");
          },
          data: $scope.bookForm
          }).then(function successCallback(response) {
    // this callback will be called asynchronously
    // when the response is available
    alert('Ticket Booked Sucessfully');
    window.location="#/member";
    //alert(angular.toJson(response));
  }, function errorCallback(response) {
    // called asynchronously if an error occurs
    // or server returns response with an error status.
    alert('error');
    alert(response);
  });
                  
    };
    
    //alert('wait');
    
});

app.controller("singleMovieController", function RegisterController($scope, $http){
    $scope.movie = movie;
    
});


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
        //console.log(idd);
          movie=idd;
          console.log(movie);
                  //alert('wai');
          window.location="#/movie";
    };

});

app.service('productService', function() {
  var productList = [];

  var addProduct = function(newObj) {
      productList.push(newObj);
  };

  var getProducts = function(){
      return productList;
  };

  return {
    addProduct: addProduct,
    getProducts: getProducts
  };

});


