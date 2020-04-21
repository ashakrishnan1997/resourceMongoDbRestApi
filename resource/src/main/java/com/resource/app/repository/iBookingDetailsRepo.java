package com.resource.app.repository;


import java.time.LocalDate;
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.resource.app.model.BookingDetails;
public interface iBookingDetailsRepo extends MongoRepository<BookingDetails, Long> {
	
	//list all booking details remaining pending
	@Query("{'pending' : 'Y'}")
	List<BookingDetails> listAllBooking();
	
	
	
}
