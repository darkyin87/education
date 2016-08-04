package com.ak.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;

import com.ak.model.PaymentDetail;
import com.ak.model.User;
import com.ak.service.PaymentService;
import com.ak.service.UserService;
import com.stripe.Stripe;

@Controller
@RequestMapping("/volunteer")
public class VolunteerController {
	
	@Autowired
	private UserService userService;
	@Autowired
	private PaymentService paymentService;

	@RequestMapping(value = "/register/{imageName}", method = RequestMethod.GET)
	public String sayHello(@PathVariable("imageName") String imageName, ModelMap model){
		 System.out.println(" is it coming here in the controller" + imageName);
		 model.put("imageName", imageName);
	       // model.addAttribute("greeting", "Hello World from Spring 4 MVC");
	        return "registerVolunteer";
	    }

	
	
    
    
    @RequestMapping(value = "/create", method = RequestMethod.POST)
	public ResponseEntity<String> createUser(@RequestBody User user) {
		
		System.out.println("hhhhh" + user);
		//System.out.println(">>>>>" + user.getTeamId());
		user.setUserName(user.getEmailID());
		Stripe.apiKey = "sk_test_A8qmlj5uDMq96RXkRhvqHjvP";
		
		Map<String, Object> chargeParams = new HashMap<String, Object>();
		  chargeParams.put("amount", 1000); // amount in cents, again
		  chargeParams.put("currency", "usd");
		  chargeParams.put("source", user.getToken());
		  chargeParams.put("description", "Example charge");
		  
		  User returnUser = userService.createUser(user);
		  PaymentDetail paymentDetail = paymentService.checkChildrenPresent(1);
		  System.out.println("pay ment detail s-- " + paymentDetail);
		  
		  if(paymentDetail != null )
		  {
			  System.out.println("going inside the if condition");
			  paymentDetail.setDonationAmount(10+paymentDetail.getDonationAmount());
			  System.out.println(paymentDetail);
			  paymentService.updatePayment(paymentDetail);
			  System.out.println("after ther service call");
		  }else {
		  
		  System.out.println("going inside the else condition");
		  paymentService.savePayment(paymentDetail);
		  }
		  
		 /* try {
			Charge charge = Charge.create(chargeParams);
		} catch (AuthenticationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvalidRequestException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (APIConnectionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (CardException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (APIException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		//User returnUser = userService.createUser(user);

		
		return new ResponseEntity<String>("sucess", HttpStatus.OK);
	}
	
	
	/*@RequestMapping(value = "/create", method = RequestMethod.POST)
	public ResponseEntity<String> createUser(@RequestBody User user) {
		
		System.out.println("hhhhh" + user);
		//System.out.println(">>>>>" + user.getTeamId());
		user.setUserName(user.getEmailID());
		
		User returnUser = userService.createUser(user);

		TeamPlayers teamPlayers = new TeamPlayers();
		teamPlayers.setPlayerId(user.getUserID());
		teamPlayers.setTeamId(user.getTeamId());
		System.out.println(" the return user -- " + returnUser.getUserID() + returnUser.getEmailID() + returnUser.getTeamId());
		System.out.println(" the teampl players --  " + teamPlayers.getPlayerId() + ">>>>>"+ teamPlayers.getTeamId());
		teamService.addPlayersToTeam(teamPlayers);
		return new ResponseEntity<String>("sucess", HttpStatus.OK);
	}*/
	 
}
