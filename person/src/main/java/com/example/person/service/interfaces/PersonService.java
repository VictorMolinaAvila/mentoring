package com.example.person.service.interfaces;

import com.example.person.dto.PersonDTO;

public interface PersonService {

    Long create(PersonDTO personDTO);

    PersonDTO update(PersonDTO personDTO);

    PersonDTO findById(Long id);

    void delete(Long id);

}
