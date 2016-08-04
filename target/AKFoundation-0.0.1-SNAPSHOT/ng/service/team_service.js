'use strict';
 
team.factory('TeamService', ['$http', '$q',function($http, $q){
    return {
         
    	fetchAllTeams: function() {
            return $http.get('/CricketLeague/getAllTeams')
                    .then(
                            function(response){
                            	console.log('sucesss in service');
                                return response.data;
                            }, 
                            function(errResponse){
                            	
                                console.error('Error while fetching users');
                                return $q.reject(errResponse);
                            }
                    );
    },   
    
    fectPlayersForTeam: function(teamID) {   
    	console.log('going inside the service of fetchplayersforteam');
        return $http({
            url: '/CricketLeague/getPlayersByTeamId', 
            method: 'GET',
            params: {teamID: teamID}
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

            
            
            createTeam: function(team){
            	console.log('inside the correct method of servicejjj' + team);
            return	$http({
            		  method: 'POST',
            		  url: '/CricketLeague/createTeam',
            		  data : team,
          			  dataType : 'json',
          			  timeout : 100000
            		})
            	
                   
            }
         
    };
 
}]);