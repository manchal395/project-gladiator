package com.lti.repository;

import com.lti.entity.Seats;

public interface SeatsRepository {

	void addSeat(Seats seat);

	Seats fetchSeat(int fsId, String fclass);

	void changeSeatStatus(Seats seat);

}