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
            
            
            getPageSectionForPage: function(pageId) {
            	console.log(" the page id in service is --  " + pageId);
            	
            	return $http.get('/AKFoundation/admin/getPageSectionForPage',{params: {pageId: pageId}})
                .then(function(response) {
                  console.log("coming from servicejs", response.data);
                  //return data when promise resolved
                  //that would help you to continue promise chain.
                  return response.data;
                });
                
            	
            },
            
            getPages: function(){
            	console.log('inside the gage pages of admin service')
            	
            	return $http.get('/AKFoundation/admin/getPages')
            .then(function(response) {
              console.log("coming from servicejs", response.data);
              //return data when promise resolved
              //that would help you to continue promise chain.
              return response.data;
            });
            }	
            	
           
         
    };
 
}]);