package com.example.demo.services;






/*
 * import java.util.List;
 * 
 * import org.springframework.stereotype.Repository;
 * 
 * @Repository public interface
 * CoronaVirusDataServicesRepository<CoronaVirusData> extends
 * JpaRepository<CoronaVirusData, Long> { List<CoronaVirusData>
 * findByCountry(String country);
 * 
 * <CoronaVirusData> void save(CoronaVirusData coronaVirusData); }
 */

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.model.LocationStates;

public interface CoronaVirusDataServicesRepository extends JpaRepository <LocationStates , Long> {
	   
	    
}


