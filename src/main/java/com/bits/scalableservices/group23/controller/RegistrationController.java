package com.bits.scalableservices.group23.controller;

import com.bits.scalableservices.group23.model.Registration;
import com.bits.scalableservices.group23.service.RegistrationService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/registrations")
public class RegistrationController {

    @Autowired
    private RegistrationService registrationService;

    public RegistrationController() {
    }

    public RegistrationController(RegistrationService registrationService) {
        this.registrationService = registrationService;
    }

    /** GET request to return specific registrations **/
    @RequestMapping(path = "/{registrationId}", method = RequestMethod.GET)
    public Optional<Registration> findById(@PathVariable Long registrationId) {
        return registrationService.findById(registrationId);
    }

    /** GET request to return all registrations **/
    @RequestMapping(path = "/", method = RequestMethod.GET)
    List<Registration> findAll() {
        return registrationService.findAll();
    }

    /** GET request to return all registrations based on a date range and ordered by price **/
    @RequestMapping(method = RequestMethod.GET)
    public List<Registration> findAllByRegistrationDateBetween(@DateTimeFormat(iso = DateTimeFormat.ISO.DATE) @RequestParam("startDate") LocalDate startDate,
                                                              @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) @RequestParam("endDate") LocalDate endDate) {
        return registrationService.findAllByRegistrationDateBetween(startDate, endDate);
    }

    /** POST request to add new registrations **/
    @RequestMapping(method = RequestMethod.POST, produces = "application/json", consumes = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public Registration create(@RequestBody Registration registration) {
        return registrationService.create(registration);
    }

    /** PUT request to update registrations **/
    @RequestMapping(path = "/{registrationId}", method = RequestMethod.PUT, produces = "application/json", consumes = "application/json")
    @ResponseStatus(HttpStatus.OK)
    public Registration update(@PathVariable Long registrationId, @RequestBody Registration registration) {
        return registrationService.update(registrationId, registration);
    }

    /** PATCH request to update status of an registration **/
    @RequestMapping(path = "/{registrationId}", method = RequestMethod.PATCH, produces = "application/json", consumes = "application/json")
    @ResponseStatus(HttpStatus.OK)
    public Registration updateStatus(@PathVariable Long registrationId, @RequestBody Registration registration) {
        return registrationService.updateStatus(registrationId, registration);
    }

    /** DELETE request to delete specific registrations **/
    @RequestMapping(path = "/{registrationId}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.OK)
    void deleteById(@PathVariable Long registrationId) {
        registrationService.deleteById(registrationId);
    }
}
