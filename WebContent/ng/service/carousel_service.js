'use strict';
 
app.factory('CarouselService', ['$http', '$q',function($http, $q){
	
	
	return {
		
		fetchVolunteerPage : function() {
			console.log('inside the service of fetch volunteer');
			return $http({
				url: 'volunteer/register',
				method: 'GET'
			}).then(
                    function(response){
                    	console.log('sucesss in service');
                        return response;
                    }, 
                    function(errResponse){
                    	
                        console.error('Error while fetching players for team'+errResponse);
                        return $q.reject(errResponse);
                    }
            );
		}

	
		
	}
	
	
}
]);

    
         
            /*fetchAllUsers: function() {
                    return $http.get('/AKFoundation/Children/getAll')
                            .then(
                                    function(response){
                                        return response.data;
                                    }, 
                                    function(errResponse){
                                        console.error('Error while fetching users');
                                        return $q.reject(errResponse);
                                    }
                            );
            },*/
            
            	
            /*fetchVolunteerPage: function() {   
            	console.log('going inside the service of fetchplayersforteam');
                return $http({
                    url: '/AKFoundation/volunteer/register', 
                    method: 'GET',
                    //params: {teamID: teamID}
                 })
                        .then(
                                function(response){
                                	console.log('sucesss in service');
                                    return response.data;
                                }, 
                                function(errResponse){
                                	
                                    console.error('Error while fetching players for team'+errResponse);
                                    return $q.reject(errResponse);
                                }
                        );
        },     
    };    */
    	
    	
             
            
