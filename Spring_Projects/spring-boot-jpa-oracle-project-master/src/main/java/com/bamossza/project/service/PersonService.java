package com.bamossza.project.service;


import com.bamossza.project.entities.PersonDetails;

import java.util.List;
import java.util.Optional;

public interface PersonService {

    void savePerson(PersonDetails person);

    Optional<PersonDetails> getPersonById(int id);

    List<PersonDetails> getAllPersons();


    void updatePerson(PersonDetails person);

    void delete(PersonDetails personDetails);

}
