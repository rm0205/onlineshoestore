package com.sample.app.SampleApplication;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

//import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

	@Autowired
	RiderRepository ride;
	
	@Autowired
	AdminRepository admi;
	
	
//	@GetMapping({"/","/hello"})
//	public String hello(@RequestParam(value="name",defaultValue="World",required=true) String name,Model model)
//	{
//		model.addAttribute("name", name);
//		return "hello";
//		
	
	@GetMapping("")
    public String viewHomePage() {
        return "home";
    }
	@GetMapping("/homei")
    public String HomePage() {
        return "home";
    }
	@GetMapping("/gallrie")
    public String GalleryPage() {
        return "gallery";
    }
	@GetMapping("/vide")
    public String VideoPage() {
        return "videos";
    }
	@GetMapping("/regist")
	public String showRegistrationForm(Model model) {
	    model.addAttribute("rider", new Rider());
	     
	    return "sign_up";
	}
	@GetMapping("/admin_details")                         //register item
	public String AdminRegistrationForm(Model model) {
	    model.addAttribute("admin", new Admin());

	    return "items_details";
	}
	@GetMapping("/searchitems")                      //Search item
	public String SearchItem(Model model) {
	    model.addAttribute("admin", new Admin());
	     
	    return "items_search";
	}
	@PostMapping(path = "/search_item", consumes = "application/json")
	public String SearchData1(Admin admin,Model model) {                //search by id
        
		int id1=admin.getId();
		Admin items=admi.findDetailsById(id1);
		System.out.println(items);
	 model.addAttribute("items", items);
		return "search_id";
	}

	 @PostMapping(path = "/search_item", consumes = "application/x-www-form-urlencoded")
	public String SearchData(Admin admin,Model model) {
		                                                                   //search by id
		int id1=admin.getId();
		Admin items=admi.findDetailsById(id1);
		System.out.println(items.getDescription());
	 model.addAttribute("items", items);
		return "search_id";
	}
	 @PostMapping(path = "/search_desc", consumes = "application/json")
		public String SearchDataDesc(Admin admin,Model model) {                //search by description
	        
			String s1=admin.getDescription();
			System.out.println(admin.getDescription());
			
		 List<Admin> listDesc=admi.findAll();
		 
		 System.out.println(listDesc.size());
		 List<Admin> duplidesc = new ArrayList<>();
		 for(int i=0;i<listDesc.size();i++)
		 {
			    String s=listDesc.get(i).getDescription();
			    if(s.contains(s1))
			    {
			    	duplidesc.add(listDesc.get(i));
			    }
		 }
			//System.out.println(listDesc);
		 model.addAttribute("duplidesc", duplidesc);
			return "search_items_desc";
		
	 }

		 @PostMapping(path = "/search_desc", consumes = "application/x-www-form-urlencoded")
		public String SearchDataDesc1(Admin admin,Model model) {
			                                                                   //search by description
			    
				String s1=admin.getDescription();
				System.out.println(admin.getDescription());
			 List<Admin> listDesc=admi.findAll();
			 List<Admin> duplidesc = new ArrayList<>();
			 for(int i=0;i<listDesc.size();i++)
			 {
				    String s=listDesc.get(i).getDescription();
				    if(s.contains(s1))
				    {
				    	duplidesc.add(listDesc.get(i));
				    }
			 }
				//System.out.println(listDesc);
			 model.addAttribute("duplidesc", duplidesc);
				return "search_items_desc";
		}
	@GetMapping("/items_det")
	public String listItem(Model model) {
	    List<Admin> listItems = admi.findAll();
	    System.out.println(listItems);
	    model.addAttribute("listItems", listItems);
	     
	    return "items_req";
	}
	private byte[] convertToBytes(MultipartFile file) throws IOException {
		 byte[] byteObjects = new byte[file.getBytes().length];
	        int i = 0;
	        for (byte b : file.getBytes()) {
	            byteObjects[i++] = b;
	        }
	        return byteObjects;
	}
	@PostMapping(path = "/item_register", consumes = "application/json")
	public String RegisterItem1(@RequestBody Admin admin,@RequestParam("imagefile") MultipartFile file) throws IOException {
        
		byte[] byteObjects = convertToBytes(file); // we have to convert it to Byte[] array
	       admin.setImage(byteObjects);
		  admi.save(admin);
		 return "Item_submitted";
	}

	
	@PostMapping(path = "/item_register", consumes = "application/x-www-form-urlencoded")
	public String RegisterItem(Admin admin ,@RequestParam("imagefile") MultipartFile file) throws IOException {
		
		byte[] byteObjects = convertToBytes(file); // we have to convert it to Byte[] array
	       admin.setImage(byteObjects);
		admi.save(admin);;
		 return "Item_submitted";
	}
	@PostMapping(path = "/item_register", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	public String RegisterItem2(Admin admin ,@RequestParam("imageFile") MultipartFile file) throws IOException {
		
		byte[] byteObjects = convertToBytes(file); // we have to convert it to Byte[] array
	       admin.setImage(byteObjects);
		admi.save(admin);;
		 return "Item_submitted";
	}
	
	
	
	@PostMapping(path = "/item_check", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	public String CheckItem2(Admin admin,@RequestParam MultipartFile file) throws IOException {
		
		System.out.println("Working fine");
		
		
		byte[] byteObjects = convertToBytes(file); // we have to convert it to Byte[] array
	      // admin.setImage(byteObjects);
	       System.out.println(byteObjects);
		 return "Imagename";
	}
	
	
	
	@GetMapping("/login")
	public String loginPage(Model model)
	{
	    model.addAttribute("rider", new Rider());
		return "login_form";
	}
//	
//	@PostMapping(value="/process_rider",consumes = {"application/x-www-form-urlencoded"})
//	public String  RegisterData(@RequestBody Rider rider)
//	{
//		
//	 
//		ride.save(rider);
//		 return "register_sucess";
//		
//	}
	@PostMapping(path = "/process_rider", consumes = "application/json")
	public String RegisterData1(@Valid Rider rider, BindingResult result) {
        
		if (result.hasErrors()) {
		    return "sign_up";
		  }
		ride.save(rider);
		 return "register_sucess";
	}

	@PostMapping(path = "/process_rider", consumes = "application/x-www-form-urlencoded")
	public String RegisterData(@Valid Rider rider, BindingResult result) {
		if (result.hasErrors()) {
		    return "sign_up";
		  }
		ride.save(rider);
		 return "register_sucess";
	}
	@GetMapping("/riders")
	public String listRider(Model model) {
	    List<Rider> listRiders = ride.findAll();
	    System.out.println(listRiders.get(0));
	    model.addAttribute("listRiders", listRiders);
	     
	    return "riders";
	}
	
	
	@PostMapping(path = "/login_rider", consumes = "application/json")
	public String LoginData1(Rider rider) {
       
//		boolean thereAreErrors = result.hasErrors();
		Rider riding=ride.findId(rider.getId1());
		if(riding==null)
		{
			   return "login_failure";
		}
		
		
		if((rider.getCard_no()==0 && rider.getId1()>0) || (rider.getCard_no()>0 && rider.getId1()==0))
		{
			return "login_failure";
		}
	
		if((rider.getId1() == riding.getId1()) && (rider.getCard_no() !=riding.getCard_no()))
		{
			return "login_failure";
		}
		System.out.println(rider.getId1());
		System.out.println(rider.getCard_no());
		Optional<Rider> rides=ride.findById(rider.getId1());
		if(rides.isPresent())
		{
			return "login_sucess";
		}
		
		 
		return "login_failure";
	}

	@PostMapping(path = "/login_rider", consumes = "application/x-www-form-urlencoded")
public String LoginData(Rider rider) {
		
		Rider riding=ride.findId(rider.getId1());
		if(riding==null)
		{
			   return "login_failure";
		}
	
		
	   
		
		if((rider.getCard_no()==0 && rider.getId1()>0) || (rider.getCard_no()>0 && rider.getId1()==0))
		{
			return "login_failure";
		}
		
		if((rider.getId1() == riding.getId1()) && (rider.getCard_no() !=riding.getCard_no()))
		{
			return "login_failure";
		}
		System.out.println(rider.getId1());
		System.out.println(rider.getCard_no());
		Optional<Rider> rides=ride.findById(rider.getId1());
		System.out.println(rides);
		
		if(rides.isPresent())
		{
			return "login_sucess";
		}
		
		 
		return "login_failure" ;
	}
}
