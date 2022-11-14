package com.bits.scalableservices.group23.service;

import com.bits.scalableservices.group23.model.Registration;
import com.bits.scalableservices.group23.repo.RegistrationRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.*;

@Service
public class RegistrationServiceImpl implements RegistrationService {

    @Autowired
    RegistrationRepo registrationRepo;

    public RegistrationServiceImpl() {
    }

    public RegistrationServiceImpl(RegistrationRepo registrationRepo) {
        this.registrationRepo = registrationRepo;
    }

    @Override
    public Optional<Registration> findById(Long registrationId) {
        return registrationRepo.findById(registrationId);
    }

    @Override
    public List<Registration> findAll() {
        return registrationRepo.findAll();
    }

    @Override
    public List<Registration> findAllByRegistrationDateBetween(LocalDate startDate, LocalDate endDate) {
        return registrationRepo.findAllByRegistrationDateBetween(startDate, endDate);
    }

    @Override
    public Registration create(Registration registration) {
        return registrationRepo.save(registration);
    }

    @Override
    public Registration update(Long registrationId, Registration registration) {
        return registrationRepo.save(registration);
    }

    @Override
    public Registration updateStatus(Long registrationId, Registration registration) {

        Optional<Registration> registrationList = registrationRepo.findById(registrationId);

        if(registrationList.isPresent()){
            if(registration.getStatus() != null){
                registrationList.get().setStatus(registration.getStatus());
            }
            return registrationRepo.save(registrationList.get());
        }
        return null;
    }

    @Override
    public void deleteById(Long registrationId) {
        registrationRepo.deleteById(registrationId);
    }
    
}
