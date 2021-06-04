package com.sample.app.SampleApplication;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;




@Repository
public interface RiderRepository extends JpaRepository<Rider,Integer> {

    @Query(value="SELECT * FROM rider WHERE id1=:id1", nativeQuery = true)
	Rider findId(@Param(value="id1") int id1);

	

	
	
}