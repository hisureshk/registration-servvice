package com.bits.scalableservices.group23.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import com.bits.scalableservices.group23.model.Registration;

public interface RegistrationService {

    Optional<Registration> findById(Long registrationId);

    List<Registration> findAll();

    List<Registration> findAllByRegistrationDateBetween(LocalDate startDate, LocalDate endDate);

    Registration create(Registration registration);

    Registration update(Long registrationId, Registration registration);

    Registration updateStatus(Long registrationId, Registration registration);

    void deleteById(Long registrationId);

}
