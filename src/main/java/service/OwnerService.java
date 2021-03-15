package service;

import dao.OwnerDao;
import model.Owner;
import utils.UtilMethods;

import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class OwnerService {
    private static Scanner scanner = new Scanner(System.in);
    private static OwnerDao ownerDa0 = new OwnerDao();

    public List<Owner> findAllOwners() {
        return ownerDa0.displayOwners();
    }

    public void createOwner() {
        System.out.println("Please insert owner last name:");
        String lastName = scanner.next() + scanner.nextLine();
        lastName = UtilMethods.firstLetterToUpperCase(lastName);
        System.out.println("Please insert owner first name:");
        String firstname = scanner.next() + scanner.nextLine();
        firstname = UtilMethods.firstLetterToUpperCase(firstname);
        System.out.println("Please insert owner phone number:");
        String phoneNumber = scanner.next();
        System.out.println("Please insert owner email:");
        String email = scanner.next();
        if (isValidEmailAddress(email)) {
            Owner owner = new Owner(lastName, firstname, phoneNumber, email);
            ownerDa0.createOwner(owner);
        } else {
            System.out.println("Your email is invalid!\nPlease insert owner details again\n");
            createOwner();
        }
    }

    public Owner findById(Long ownerId) {
        Owner getOwner = ownerDa0.findByOwnerId(ownerId);
        if (getOwner == null) {
            System.out.println("Owner with ID: " + ownerId + " does not exists!");
            return null;
        } else {
            return getOwner;
        }
    }

    public void deleteOwner() {
        displayAllOwners();
        System.out.println("Please insert owner id you want to delete:");
        long idOwner = scanner.nextLong();
        Owner ownerToDelete = findById(idOwner);
        if (ownerToDelete != null) {
            ownerDa0.deleteOwner(ownerToDelete);
        }
    }

    public boolean isValidEmailAddress(String email) {
        String ePattern = "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$";
        Pattern p = java.util.regex.Pattern.compile(ePattern);
        Matcher m = p.matcher(email);
        return m.matches();
    }

    public void displayAllOwners() {
        List<Owner> owners = findAllOwners();
        System.out.println("Owners: \n");
        for (Owner owner : owners) {
            System.out.println(owner);
        }
    }

    public void update(Owner owner) {
        ownerDa0.updateOwner(owner);
    }
}
