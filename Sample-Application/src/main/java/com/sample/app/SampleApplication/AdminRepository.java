package com.sample.app.SampleApplication;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;
//import org.springframework.data.repository.query.Param;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.sample.app.SampleApplication.Admin;

public interface AdminRepository extends JpaRepository<Admin,Integer> {

	
	@Query(value="SELECT * FROM admin WHERE id=:id1", nativeQuery = true)
	Admin findDetailsById(@Param(value="id1")int id1);


//    @Query(value="SELECT * FROM rider WHERE id1=:id1", nativeQuery = true)
//	Rider findId(@Param(value="id1") int id1);

	

	


}
