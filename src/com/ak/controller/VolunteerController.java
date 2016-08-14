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

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public ResponseEntity<String> createUser(@RequestBody User user) {

        System.out.println("hhhhh" + user);
        //System.out.println(">>>>>" + user.getTeamId());
        user.setUserName(user.getEmailID());
        User returnUser = userService.createUser(user);

        if(user.getDonationYes()){
        
        Stripe.apiKey = "sk_test_A8qmlj5uDMq96RXkRhvqHjvP";

        Map<String, Object> chargeParams = new HashMap<String, Object>();
        chargeParams.put("amount", user.getAmount()*100); // amount in cents, again
        chargeParams.put("currency", "usd");
        chargeParams.put("source", user.getToken());
        chargeParams.put("description", "Example charge");

        PaymentDetail paymentDetail = new PaymentDetail();
        System.out.println("the return user is --  " + user.getChildrenId());
        System.out.println("pay ment detail s-- " + returnUser.getUserID());
        paymentDetail.setChildrenId(user.getChildrenId());
        paymentDetail.setDonationAmount(user.getAmount());
        paymentDetail.setFrequency("0");
        paymentDetail.setUserId(returnUser.getUserID()+"");
        

            System.out.println("going inside the else condition");
            paymentService.savePayment(paymentDetail);
       
        }
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
