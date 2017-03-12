/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

app.controller("RegisterController", function RegisterController($scope, $http){
    $scope.registerForm ={};
    $scope.RegisterSubmit = function(){
                //alert(registerForm.firstname);
                    //console.log(registerForm.firstname);
        console.log("HI");

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
    window.location="./index.html";
    alert(angular.toJson(response));
  }, function errorCallback(response) {
    // called asynchronously if an error occurs
    // or server returns response with an error status.
    alert('error');
    alert(response);
  });
                  
//                .success(function (data) 
//            {
//                alert('aaaa');
//                alert(data);
//              $scope.status=data;
//	 });
    };
});
