package com.resource.app.service;

import java.time.LocalDate;
import java.util.List;

import com.resource.app.model.BookingDetails;

public interface iBookingDetailsService {
	// add booking
	public BookingDetails addBooking(BookingDetails bookingDetails);

    //find by id
	public BookingDetails findBookingById(Long bookingId);

	// update booking
	public BookingDetails updateBooking(BookingDetails bookingDetails);

	// list details
	public List<BookingDetails> listAllBooking();

}
