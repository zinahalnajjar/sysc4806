package org.example;

import java.util.List;

import org.example.BuddyInfo;
import org.springframework.data.repository.CrudRepository;

public interface BuddyRepository extends CrudRepository<BuddyInfo, Long> {

    List<BuddyInfo> findByLastName(String lastName);

    BuddyInfo findById(long id);
}