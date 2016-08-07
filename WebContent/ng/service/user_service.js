'use strict';
app.factory('UserService', ['$http', '$q',function($http, $q){
    return {
         
             
           
            create: function(user){
            	console.log('inside the correct method of servicejjj' + user);
            	
            	
            return	$http({
            		  method: 'POST',
            		  url: '/AKFoundation/volunteer/create',
            		  data : user,
          			  dataType : 'json',
          			  timeout : 100000
            		})
            	
                   
            },
             
            
            
            updateUser: function(user, id){
                    return $http.put('http://localhost:8080/Spring4MVCAngularJSExample/user/'+id, user)
                            .then(
                                    function(response){
                                        return response.data;
                                    }, 
                                    function(errResponse){
                                        console.error('Error while updating user');
                                        return $q.reject(errResponse);
                                    }
                            );
            },
             
            /*deleteUser: function(id){
                    return $http.delete('http://localhost:8080/Spring4MVCAngularJSExample/user/'+id)
                            .then(
                                    function(response){
                                        return response.data;
                                    }, 
                                    function(errResponse){
                                        console.error('Error while deleting user');
                                        return $q.reject(errResponse);
                                    }
                            );
            }*/
         
    };
 
}]);