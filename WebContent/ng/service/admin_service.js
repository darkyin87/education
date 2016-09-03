'use strict';
app.factory('AdminService', ['$http', '$q',function($http, $q){
    return {
         
             
           
            save: function(testimonial){
            	console.log(' inside the admin service' + testimonial);
            	
            	
            return	$http({
            		  method: 'POST',
            		  url: '/AKFoundation/testimonial/save',
            		  data : testimonial,
          			  dataType : 'json',
          			  timeout : 100000
            		})
            	
                   
            }
             
            
            
           
         
    };
 
}]);