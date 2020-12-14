package com.areteans.TicketBooking.repository;
import com.areteans.TicketBooking.models.TrainJPA;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface TrainRepository extends JpaRepository<TrainJPA, Long> {
}
