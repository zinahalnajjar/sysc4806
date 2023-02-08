package org.example;
import java.util.concurrent.atomic.AtomicLong;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
@RestController
public class AddressBookRestController {
    @Autowired
    private AdressBookRepository addressbookRepository;

    @GetMapping("addressBook")
    public AddressBook addressBook(@RequestParam(name = "id") int id) {
        return addressbookRepository.findById(id);

    }

    @PostMapping("/addressBook")
    public AddressBook addressBookCreate() {
        AddressBook addressBook = new AddressBook();
        return addressbookRepository.save(addressBook);



    }
    // how to submit parameters in URL

    @PostMapping("/addressBook/{id}/addBuddy")
    public AddressBook addBuddy(@PathVariable("id") long id, @RequestParam(value = "firstname") String firstname,
                           @RequestParam(value = "lastname") String lastname,
                           @RequestParam(value="phoneNumber") String phoneNumber,
                           @RequestParam(value="age") int age,
                           @RequestParam(value="address") String address) {
        AddressBook addressBook = addressbookRepository.findById(id);
        BuddyInfo buddy = new BuddyInfo(firstname, lastname ,address, phoneNumber,age);
        addressBook.addBuddy(buddy);
        return addressbookRepository.save(addressBook);



    }
}