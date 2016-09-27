'use strict';
team.controller('TeamController', ['$scope','TeamService',function($scope, TeamService) {

			var self = this;

		
			
			self.createTeam = function(team) {
				console.log('inside the controller team creation' + team);
				TeamService.createTeam(team).then(
						function successCallback(response) {
							self.clear();
							$scope.messages = 'Team Created Successfully'
							// this callback will be called asynchronously
							// when the response is available
						}, function errorCallback(response) {
							// called asynchronously if an error occurs
							// or server returns response with an error status.
						})
			};
			
			
			
			self.fetchAllTeams = function(){
	              TeamService.fetchAllTeams()
	                  .then(
	                               function(d) {
	                            	   console.log('success in controller' + d);
	                                    self.teams = d;
	                               },
	                                function(errResponse){
	                                    console.error('Error while fetching tteams');
	                                }
	                       );
	          };

	          
	          self.fetchPlayers=function(teamID){
	        	  TeamService.fectPlayersForTeam(teamID) .then(
                          function(d) {
                       	   console.log('success in controller' + d);
                               self.users = d;
                          },
                           function(errResponse){
                               console.error('Error while fetching players for team');
                           }
                  );
     };

	          
	          self.fetchAllTeams();
			/*self.clear = function() {
				console.log('clearning the form');
				self.user = {
					fname : '',
					lname : '',
					email : ''
				};
				$scope.myForm.$setPristine();
			}
*/
			self.submit = function() {
				console.log('Creating new team');
				self.createTeam(self.team);

			};

		} ]);
