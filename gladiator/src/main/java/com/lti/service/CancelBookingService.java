package com.lti.service;

import javax.transaction.Transactional;

public interface CancelBookingService {

	void cancelBooking(int bookingId);

}