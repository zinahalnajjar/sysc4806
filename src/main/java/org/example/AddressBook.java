package org.example;

import jakarta.persistence.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Entity
public class AddressBook {
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    public static ArrayList<BuddyInfo> buddyInfoCollection;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long addressBookId = null;
    public AddressBook() {
        this.buddyInfoCollection = new ArrayList<>();
    }

    public void addBuddy(BuddyInfo buddy) {
        if (buddy != null) {
            this.buddyInfoCollection.add(buddy);
        }
    }
    public BuddyInfo removeBuddy(int index){
        if(index>=0 && index <buddyInfoCollection.size()){
            return buddyInfoCollection.remove(index);
        }
        return null;

    }

    public String toString(){
        String result = "";
        for(BuddyInfo b : buddyInfoCollection){
            result += b.toString() + "\n";
        }
        return result;
    }


    public Long getAddressBookId() {
        return addressBookId;
    }
    public int size(){
        return buddyInfoCollection.size();
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {


        BuddyInfo buddyHomer = new BuddyInfo("Homer", "Bauer","ottawa", "613555666", 21);
        BuddyInfo buddyJay = new BuddyInfo("Jay", "O'Brian","ottawa", "613555669", 23);
        BuddyInfo buddyAlex = new BuddyInfo("Alex", "Bauer", "ottawa", "613559666", 34);

        AddressBook addressBook = new AddressBook();
        addressBook.addBuddy(buddyHomer);
        addressBook.addBuddy(buddyJay);
        addressBook.addBuddy(buddyAlex);
        addressBook.removeBuddy(0);
        System.out.println("Address Book");


    }



}
