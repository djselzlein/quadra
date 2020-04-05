package com.djsoftware.quadra.repository;

import com.djsoftware.quadra.domain.Booking;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Spring Data  repository for the Booking entity.
 */
@SuppressWarnings("unused")
@Repository
public interface BookingRepository extends JpaRepository<Booking, Long> {

    @Query("select booking from Booking booking where booking.creator.login = ?#{principal.username}")
    List<Booking> findByCreatorIsCurrentUser();

    @Query("select booking from Booking booking where booking.owner.login = ?#{principal.username}")
    List<Booking> findByOwnerIsCurrentUser();
}
