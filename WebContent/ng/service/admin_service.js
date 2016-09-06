'use strict';
app.factory('AdminService', ['$http', '$q',function($http, $q){
    return {
         
             
           
            save: function(testimonial){
            	console.log(' inside the admin service' + testimonial);
            	
            	
            return	$http({
            		  method: 'POST',
            		  url: '/AKFoundation/admin/createTestimonial',
            		  data : testimonial,
          			  dataType : 'json',
          			  timeout : 100000
            		})
            	
                   
            },
             
            createPage: function(pages){
            	console.log('inside the admin service for create page')
            	return	$http({
          		  method: 'POST',
          		  url: '/AKFoundation/admin/createPage',
          		  data : pages,
        			  dataType : 'json',
        			  timeout : 100000
          		})
          	
            },
            
            getPages: function(){
            	console.log('inside the gage pages of admin service')
            	return $http({
            		  method: 'GET',
              		  url: '/AKFoundation/admin/getPages',
              		  data : pages,
            			  dataType : 'json',
            			  timeout : 100000
              		})
            }
            
           
         
    };
 
}]);