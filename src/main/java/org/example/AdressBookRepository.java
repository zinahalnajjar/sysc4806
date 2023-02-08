package org.example;

import org.springframework.data.repository.CrudRepository;

public interface AdressBookRepository extends CrudRepository<AddressBook, Long> {
    AddressBook findById(long id);
}
