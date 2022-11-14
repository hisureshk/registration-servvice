package com.bits.scalableservices.group23.repo;

import com.bits.scalableservices.group23.model.Registration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.time.LocalDate;
import java.util.List;

@Repository
public interface RegistrationRepo extends JpaRepository<Registration, Long> {

    List<Registration> findAllByRegistrationDateBetween(LocalDate startDate, LocalDate endDate);

}