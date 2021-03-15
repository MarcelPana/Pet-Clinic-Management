package service;

import dao.ConsultDao;
import dao.PetDao;
import dao.VeterinarianDao;
import model.Consult;
import model.Pet;
import model.Veterinarian;

import java.util.List;
import java.util.Scanner;

public class ConsultService {

    private static Scanner scanner = new Scanner(System.in);
    private static ConsultDao consultDao = new ConsultDao();
    private static VeterinarianDao veterinarianDao1 = new VeterinarianDao();
    private static VeterinarianService veterinarianService = new VeterinarianService();
    private static PetDao petDao1 = new PetDao();
    private static PetService petService = new PetService();

    public void createConsult() {
        System.out.println("Please insert consults date:");
        String consultDate = scanner.next();
        System.out.println("Please insert the description");
        String description = scanner.next() + scanner.nextLine();
        Veterinarian vetFromList = selectVeterinarian();
        Pet petFromList = selectPet();

        Consult consult = new Consult(consultDate, description, vetFromList, petFromList);
        consultDao.createConsult(consult);
    }

    public Consult findById(Long consultId) {
        Consult getConsult = consultDao.findByConsultId(consultId);
        if (getConsult == null) {
            System.out.println("Consult with ID: " + consultId + " does not exists!");
            return null;
        } else {
            return getConsult;
        }
    }

    public void displayAllConsults() {
        List<Consult> consultList = findAllConsults();
        System.out.println("\nConsults:\n");
        for (Consult consult : consultList) {
            System.out.println(consult);
        }
    }

    public void deleteConsult() {
        displayAllConsults();
        System.out.println("Please insert consult id you want to delete:");
        long idConsult = scanner.nextLong();
        Consult consultToDelete = findById(idConsult);
        if (consultToDelete != null) {
            consultDao.deleteConsult(consultToDelete);
        }
    }

    public Pet selectPet() {
        List<Pet> pets = petService.findAllPets();
        System.out.println("\nCurrent pets: \n");
        for (Pet pet : pets) {
            System.out.println(pet);
        }
        System.out.println("Please select pet id");
        Long petId = scanner.nextLong();
        Pet selectedPet = petService.findById(petId);
        if (selectedPet == null) {
            return selectPet();
        } else {
            return selectedPet;
        }
    }

    public Veterinarian selectVeterinarian() {
        List<Veterinarian> veterinarianList = veterinarianService.findAllVeterinarians();
        System.out.println("\nCurrent veterinarians: \n");
        for (Veterinarian veterinarian : veterinarianList) {
            System.out.println(veterinarian);
        }
        System.out.println("Please select Veterinarian id");
        Long veterinarianId = scanner.nextLong();
        Veterinarian selectedVeterinarian = veterinarianService.findById(veterinarianId);
        if (selectedVeterinarian == null) {
            return selectVeterinarian();
        } else {
            return selectedVeterinarian;
        }
    }

    public List<Consult> findAllConsults() {
        return consultDao.displayConsults();
    }

    public void update(Consult consult) {
        consultDao.updateConsult(consult);
    }
}
