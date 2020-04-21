package com.resource.app.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.resource.app.model.BookingDetails;
import com.resource.app.repository.iBookingDetailsRepo;

@Service
public class BookingDetailsService implements iBookingDetailsService {

	@Autowired
	private iBookingDetailsRepo bookingRepo;
	@Autowired
	private SequenceGeneratorService sequenceGeneratorService;

	// add booking
	@Transactional
	@Override
	public BookingDetails addBooking(BookingDetails bookingDetails) {
		bookingDetails.setBookingId(sequenceGeneratorService.generateSequence(bookingDetails.SEQUENCE_NAME));
		return bookingRepo.save(bookingDetails);
	}

	// find by id
	@Override
	public BookingDetails findBookingById(Long bookingId) {
		Optional<BookingDetails> findBookingId = bookingRepo.findById(bookingId);
		BookingDetails bookingDetails = findBookingId.isPresent() ? findBookingId.get() : null;
		return bookingDetails;
	}

	// update booking
	@Transactional
	@Override
	public BookingDetails updateBooking(BookingDetails bookingDetails) {
		return bookingRepo.save(bookingDetails);
	}

	// list all
	@Override
	public List<BookingDetails> listAllBooking() {

		return bookingRepo.listAllBooking();
	}

}