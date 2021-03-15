package service;

import dao.PetDao;
import model.Owner;
import model.Pet;
import utils.UtilMethods;

import java.util.List;
import java.util.Scanner;

public class PetService {
    private static final Scanner scanner = new Scanner(System.in);
    private static final PetDao petDao = new PetDao();
    private static final OwnerService ownerService = new OwnerService();

    public Pet findById(Long petId) {
        Pet getPet = petDao.findByIdPet(petId);
        if (getPet == null) {
            System.out.println("Pet with ID: " + petId + " does not exists!");
            return null;
        } else {
            return getPet;
        }
    }

    public void createPet() {
        System.out.println("Please insert pet's name: ");
        String name = scanner.next() + scanner.nextLine();
        name = UtilMethods.firstLetterToUpperCase(name);
        System.out.println("Please insert pet's race: ");
        String race = scanner.next() + scanner.nextLine();
        System.out.println("Please insert birthdate of the pet:");
        String birthDate = scanner.next();
        System.out.println("Please advise if he's vaccinated:");
        boolean isVaccinated = scanner.nextBoolean();
        Owner ownerById = selectPetOwner();
        Pet pet = new Pet(race, name, birthDate, isVaccinated, ownerById);
        petDao.createPet(pet);
    }

    public Owner selectPetOwner() {
        List<Owner> owners = ownerService.findAllOwners();
        for (Owner owner : owners) {
            System.out.println(owner);
        }
        System.out.println("Please select owner id from the list");
        Long ownerId = scanner.nextLong();
        Owner selectedOwner = ownerService.findById(ownerId);
        if (selectedOwner == null) {
            return selectPetOwner();
        } else {
            return selectedOwner;
        }
    }

    public List<Pet> findAllPets() {
        return petDao.displayPets();
    }

    public void displayAllPets() {
        List<Pet> pets = findAllPets();
        System.out.println("\tPets: \t");
        for (Pet pet : pets) {
            System.out.println(pet);
        }
    }

    public void update(Pet pet) {
        petDao.updatePet(pet);
    }

    public void deletePet() {
        displayAllPets();
        System.out.println("Please insert pet id you want to delete:");
        long idPet = scanner.nextLong();
        Pet petToDelete = findById(idPet);
        if (petToDelete != null) {
            petDao.deletePet(petToDelete);
        }
    }
}
