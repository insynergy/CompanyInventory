package com.insynergy.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.insynergy.model.Inventory;
import com.insynergy.model.InventoryModel;
import com.insynergy.model.Login;
import com.insynergy.model.Search;
import com.insynergy.service.InventoryService;
import com.twilio.sdk.TwilioRestClient;
import com.twilio.sdk.TwilioRestException;
import com.twilio.sdk.resource.factory.SmsFactory;
import com.twilio.sdk.resource.instance.Sms;


@Controller
public class InventoryController {
	 
	
	private InventoryService inventoryService;
	
	@Autowired(required=true)
	@Qualifier(value="inventoryService")
	public void setInventoryService(InventoryService is){
		this.inventoryService = is;
	}
	
	public static final String ACCOUNT_SID = "ACfc1b61cdb48cd290953f139f95f6540b";
    public static final String AUTH_TOKEN = "d92940c3fdab3c821ab811d3ff1dc8ca";
    
    
    
    
    
    /*@RequestMapping(value = "/inventories1/add", method = RequestMethod.GET)

	public String add1Inventories(Model model) {
	
		model.addAttribute("inventory", new Inventory());
		model.addAttribute("listInventories", this.inventoryService.listInventories());
		return "inventory";
	}*/
    
	
	@RequestMapping(value = "/inventories", method = RequestMethod.GET)
	public String listInventories(Model model, HttpServletRequest request) {
		
		System.out.println("==================1");
		HttpSession session=request.getSession(true);
       if(session.getAttribute("uname").equals("")&&session.getAttribute("pwd").equals(""))
       {
    	   return "redirect:/loginform";  
       }
		model.addAttribute("inventory", new Inventory());
		model.addAttribute("listInventories", this.inventoryService.listInventories());
		return "searchInventory";
      
       }
	
	
	
	@RequestMapping(value = "/inventories/add", method = RequestMethod.POST)

	public String addInventories(Model model) {
		
		System.out.println("==================2");
		model.addAttribute("inventory", new Inventory());
		model.addAttribute("listInventories", this.inventoryService.listInventories());
		return "inventory";
	}
	
	//For add and update person both
	@RequestMapping(value= "/inventory/add", method = RequestMethod.POST)
	public String addInventory(@ModelAttribute("inventory") Inventory i, HttpServletRequest request, @Valid Inventory inventory, BindingResult result) {
		
		System.out.println("==================3");
	
		if (result.hasErrors()) {
			
			return "inventory";
		} else {
			
		
		HttpSession session=request.getSession(true);
       if(session.getAttribute("uname").equals("")&&session.getAttribute("pwd").equals(""))
       {
    	   return "redirect:/loginform";  
       }
		
			//new person, add it
			this.inventoryService.addInventory(i);
			return "redirect:/inventories";
		
		
		
		
		}
		
	}
	
	@RequestMapping(value= "/inventory/update", method = RequestMethod.POST)
	public String inventoryUpdate(@ModelAttribute("inventory") Inventory i, HttpServletRequest request, @Valid Inventory inventory, BindingResult result) {
		
		System.out.println("==================5"+i);
		
		if (result.hasErrors()) {
			
			return "updateInventory";
		} else {
			
		
		HttpSession session=request.getSession(true);
       if(session.getAttribute("uname").equals("")&&session.getAttribute("pwd").equals(""))
       {
    	   return "redirect:/loginform";  
       }
		
			//existing person, call update
			this.inventoryService.updateInventory(i);
			return "redirect:/update/inventories";
	
		
		//return "redirect:/update/inventories";
		
		}
		
	}
	
	
	@RequestMapping(value="/delete/inventory", method = RequestMethod.POST)
    public String deleteInventory(Model model) {
		
		System.out.println("==================6");
	
		model.addAttribute("inventory", new Inventory());
		model.addAttribute("listInventories", this.inventoryService.listInventories());
		return "deleteInventory";
        
    }
	

	
	@RequestMapping("/remove/{id}")
    public String removeInventory(@PathVariable("id") int id, Model model){
		
		System.out.println("==================7");
			
		
	/*	HttpSession session=request.getSession(true);
       if(session.getAttribute("uname").equals("")&&session.getAttribute("pwd").equals(""))
       {
    	   return "redirect:/loginform";  
       }*/
		
		this.inventoryService.removeInventory(id);
        model.addAttribute("inventory", new Inventory());
		model.addAttribute("listInventories", this.inventoryService.listInventories());
        return "deleteInventory";
    }
	
	
	
	
	
	@RequestMapping(value="/update/inventory", method = RequestMethod.POST)
    public String updateInventory(Model model) {
		
		System.out.println("==================8");
		
		model.addAttribute("inventory", new Inventory());
		model.addAttribute("listInventories", this.inventoryService.listInventories());
		return "updateInventoryList";
        
    }
    @RequestMapping("/edit/{id}")
    public String editInventory(@PathVariable("id") int id, Model model) {
    	
    	System.out.println("==================9");
 
	/*/	HttpSession session=request.getSession(true);
       if(session.getAttribute("uname").equals("")&&session.getAttribute("pwd").equals(""))
       {
    	   return "redirect:/loginform";  
       }*/
        model.addAttribute("inventory", this.inventoryService.getInventoryById(id));
        model.addAttribute("listInventories", this.inventoryService.listInventories());
        return "updateInventory";
    }
    
    @RequestMapping(value = "/update/inventories", method = RequestMethod.GET)
	public String updateInventories(Model model, HttpServletRequest request) {
    	
    	System.out.println("==================10");

		HttpSession session=request.getSession(true);
       if(session.getAttribute("uname").equals("")&&session.getAttribute("pwd").equals(""))
       {
    	   return "redirect:/loginform";  
       }
		model.addAttribute("inventory", new Inventory());
		model.addAttribute("listInventories", this.inventoryService.listInventories());
		return "updateInventoryList";
      
       }
    

    
   
    

    @RequestMapping(value="/search/inventory", method = RequestMethod.POST)
    public String searchInventory(Model model) {
    	
    	System.out.println("==================11");
    
	
		model.addAttribute("inventory", new Inventory());
		model.addAttribute("listInventories", this.inventoryService.listInventories());
		return "searchInventory";
        
    }
	
  
  @RequestMapping(value="/doScarch/inventory",method=RequestMethod.POST)
  public String doSearch(@Valid Search search,Model model)
  {
  	
		System.out.println("==================12");
	  
	  String searchIteam=search.getSearchItem();
	  String serchIteam2=search.getSearchItem();
  	 //String nameMakeModel=(String)search.getNameMakeModel();
   
    model.addAttribute("inventory", new Inventory());
    List <Inventory>  listinventary=this.inventoryService.dosearch(searchIteam);
    if(listinventary.isEmpty()){
  	  model.addAttribute("message", "please enter the value ");
  	  
    }
    model.addAttribute("listInventories", listinventary);
   
    return "searchInventory";
    
  
  }
  
  
    
}

