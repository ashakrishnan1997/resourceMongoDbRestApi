package com.resource.app.controller;

import java.time.LocalDate;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.resource.app.model.BookingDetails;
import com.resource.app.repository.iBookingDetailsRepo;
import com.resource.app.service.SequenceGeneratorService;
import com.resource.app.service.iBookingDetailsService;

@RestController
@RequestMapping("/")
public class BookingDetailsController {

	@Autowired
	private iBookingDetailsService bookingService;

	@Autowired
	private SequenceGeneratorService sequenceGeneratorService;

	// add booking
	@RequestMapping(value = "book", method = RequestMethod.POST)
	public ResponseEntity<?> addBooking(@RequestBody BookingDetails booking) {

		return new ResponseEntity<>(bookingService.addBooking(booking), HttpStatus.OK);
	}

	// find booking details by id 
	
	@GetMapping("booking/{bookingId}")
	public ResponseEntity<BookingDetails> findAllBookingById(@PathVariable("bookingId") Long bookingId) {
		System.out.print("search the booking details by id");
		ResponseEntity<BookingDetails> response = null;
		BookingDetails booking = bookingService.findBookingById(bookingId);
		if (booking == null) {
			response = new ResponseEntity<BookingDetails>(HttpStatus.NOT_FOUND);
		} else {
			response = new ResponseEntity<BookingDetails>(booking, HttpStatus.OK);
		}
		return response;
		
		
	}

	// update booking details
	@PutMapping("booking")
	public ResponseEntity<BookingDetails> updateBooking(@RequestBody BookingDetails booking) {
		return new ResponseEntity<BookingDetails>(bookingService.updateBooking(booking), HttpStatus.OK);
		
	}

	// get all the booking details from booking details table
	@RequestMapping(value = "bookings", method = RequestMethod.GET)
	public ResponseEntity<List<BookingDetails>> listAllBooking() {
		return new ResponseEntity<List<BookingDetails>>(bookingService.listAllBooking(), HttpStatus.OK);
	}

}
