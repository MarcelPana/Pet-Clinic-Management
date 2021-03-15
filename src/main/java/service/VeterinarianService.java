package service;

import dao.VeterinarianDao;
import model.Veterinarian;
import utils.UtilMethods;

import java.util.List;
import java.util.Scanner;

public class VeterinarianService {

    private static Scanner scanner = new Scanner(System.in);
    private static VeterinarianDao veterinarianDao = new VeterinarianDao();

    public void createVeterinarian() {
        System.out.println("Please insert veterinarian's first name:");
        String firstname = scanner.next() + scanner.nextLine();
        firstname = UtilMethods.firstLetterToUpperCase(firstname);
        System.out.println("Please insert veterinarian's last name:");
        String lastName = scanner.next() + scanner.nextLine();
        lastName = UtilMethods.firstLetterToUpperCase(lastName);
        System.out.println("Please insert veterinarian's address:");
        String address = scanner.next() + scanner.nextLine();
        System.out.println("Please insert veterinarian's speciality:");
        String speciality = scanner.next() + scanner.nextLine();

        Veterinarian veterinarian = new Veterinarian(lastName, firstname, address, speciality);
        veterinarianDao.createVeterinarian(veterinarian);
    }

    public Veterinarian findById(Long veterinarianId) {
        Veterinarian getVeterinarian = veterinarianDao.findByIdVeterinarian(veterinarianId);
        if (getVeterinarian == null) {
            System.out.println("Veterinarian with ID: " + veterinarianId + " does not exists!");
            return null;
        } else {
            return getVeterinarian;
        }
    }

    public void displayAllVeterinarians() {
        List<Veterinarian> veterinarianList = findAllVeterinarians();
        System.out.println("\nVeterinarians: \n");
        for (Veterinarian veterinarian : veterinarianList) {
            System.out.println(veterinarian);
        }
    }

    public void deleteVeterinarian() {
        displayAllVeterinarians();
        System.out.println("Please insert veterinarian id you want to delete:");
        long idVeterinarian = scanner.nextLong();
        Veterinarian vetToDelete = findById(idVeterinarian);
        if (vetToDelete != null) {
            veterinarianDao.deleteVeterinarian(vetToDelete);
        }
    }

    public List<Veterinarian> findAllVeterinarians() {
        return veterinarianDao.displayVet();
    }

    public void update(Veterinarian veterinarian) {
        veterinarianDao.updateVeterinarian(veterinarian);
    }
}
