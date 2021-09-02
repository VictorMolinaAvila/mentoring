package com.example.person.translator;

import com.example.person.dto.PersonDTO;
import com.example.person.model.Person;
import org.springframework.stereotype.Component;

@Component
public class PersonTranslator {

    public Person personDTOToPerson(PersonDTO personDTO) {
        Person person = new Person();
        person.setId(personDTO.getId());
        person.setName(personDTO.getName());
        return person;
    }

    public PersonDTO personToPersonDTO(Person person) {
        PersonDTO personDTO = new PersonDTO();
        personDTO.setId(person.getId());
        personDTO.setName(person.getName());
        return personDTO;
    }

}
