package com.example.demo.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import com.example.demo.model.LocationStates;
import com.example.demo.services.CoronaVirusDataServices;
import com.example.demo.services.CoronaVirusDataServicesRepository;

@Controller
public class HomeController 
{
	
	CoronaVirusDataServices crnService;
	
	@Autowired
	CoronaVirusDataServicesRepository repository;
	
	
	
	@Autowired
	  public void setCrnService(CoronaVirusDataServices crnService)
	{
	  this.crnService = crnService; 
	  
	}
	 


	@GetMapping("/")
	public String home(Model model)
	{
		List<LocationStates> allstates=crnService.getAllstates();
		int totalDeathsReported=allstates.stream().mapToInt(stat->stat.getLatestTotalDeaths()).sum();
		int totalNewCases=allstates.stream().mapToInt(stat->stat.getLatestTotalDeaths()).sum();

		model.addAttribute("LocationStates",allstates);
		model.addAttribute("totalDeathsReported",totalDeathsReported);
		model.addAttribute("totalNewCases",totalNewCases);

		return "home";
	}

	  
	  
	 
	
	@GetMapping("/viewChart/{id}")
	public String viewChartByID(@PathVariable("id") int id,Model m)
	{
		m.addAttribute("id",id);
		m.addAttribute("myURL", "http://localhost:8081/collectChartData/"+id);
		return "ViewChart";
	}
	
	@GetMapping(path="/collectChartData/country={name}")
	public String viewChartByCountryName(@RequestParam String name,Model m)
	{
		m.addAttribute("myURL","http://localhost:8081/collectChartData/country?"+name);
		return "ViewChart";
	}
	
	
	
	 @GetMapping(path="/ViewChart", produces = {"application/json"})
	    public String viewChart(Model model) {
	        String myURL = "http://localhost:8081/collectChartData"; // replace with your API URL String
	        String country = " "; // replace with your country name
	        int totalDeathReported = 0; // replace with your total death reported

	        model.addAttribute("myURL", myURL);
	        model.addAttribute("country", country);
	        model.addAttribute("totalDeathReported", totalDeathReported);

	        return "ViewChart";
	    }
	

	
	


	
	}
	 

	


