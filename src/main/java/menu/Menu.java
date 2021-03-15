package menu;

import com.opencsv.exceptions.CsvValidationException;
import dao.VeterinarianDao;
import model.Consult;
import model.Owner;
import model.Pet;
import model.Veterinarian;
import service.ConsultService;
import service.OwnerService;
import service.PetService;
import service.VeterinarianService;
import utils.ExportCSV;
import utils.ImportCSV;
import utils.UtilMethods;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class Menu {
    public static final ExportCSV exportCSV = new ExportCSV();
    public static final ImportCSV importCSV = new ImportCSV();
    private static final Scanner scanner = new Scanner(System.in);
    private static final OwnerService ownerService = new OwnerService();
    private static final PetService petService = new PetService();
    private static final ConsultService consultService = new ConsultService();
    private static final VeterinarianDao veterinarianDao = new VeterinarianDao();
    private static final VeterinarianService veterinarianService = new VeterinarianService();

    public Menu() throws IOException, CsvValidationException {
        showMenu();
    }

    public static void showMenu() throws IOException, CsvValidationException {
        System.out.println("\nMenu ");
        System.out.println("\n0 - Exit\n1 - Create\n2 - Update\n3 - Delete\n4 - Find\n5 - Import/Export Database");
        System.out.println("Enter your choice: ");

        int option = scanner.nextInt();
        showOption(option);
    }

    public static void showOption(int option) throws IOException, CsvValidationException {

        switch (option) {
            case 0:
                System.exit(0);
                break;
            case 1:
                create();
                break;
            case 2:
                update();
                break;
            case 3:
                delete();
                break;
            case 4:
                find();
                break;
            case 5:
                importExport();
                break;
            default:
                System.exit(0);
                break;
        }
    }

    public static void create() throws IOException, CsvValidationException {
        System.out.println("\nCreate Menu:\n0 - Exit\n1 - Create Veterinarian\n2 - Create Pet\n3 - Create Consult\n4 - Create Owner\n5 - Return to Main Menu");
        System.out.println("Enter your choice: ");
        int createOption = scanner.nextInt();

        switch (createOption) {
            case 0:
                System.exit(0);
                break;
            case 1:
                createVet();
                showMenu();
                break;
            case 2:
                createPet();
                showMenu();
                break;
            case 3:
                createConsult();
                showMenu();
                break;
            case 4:
                createOwner();
                showMenu();
                break;
            case 5:
                showMenu();
                break;
            default:
                System.exit(0);
                break;
        }
    }

    public static void update() throws IOException, CsvValidationException {
        System.out.println("\nUpdate Menu\n0 - Exit\n1 - Update Veterinarian\n2 - Update Pet\n3 - Update Consult\n4 - Update Owner\n5 - Return to Main Menu");
        System.out.println("Enter your choice: ");
        int updateOption = scanner.nextInt();

        switch (updateOption) {
            case 0:
                System.exit(0);
                break;
            case 1:
                updateVeterinarian();
                showMenu();
                break;
            case 2:
                updatePet();
                showMenu();
                break;
            case 3:
                updateConsult();
                showMenu();
                break;
            case 4:
                updateOwner();
                showMenu();
                break;
            case 5:
                showMenu();
                break;
            default:
                System.exit(0);
                break;
        }
    }

    public static void delete() throws IOException, CsvValidationException {
        System.out.println("\nDelete Menu\n0 - Exit\n1 - Delete Veterinarian\n2 - Delete Pet\n3 - Delete Consult\n4 - Delete Owner\n5 - Return to Main Menu");
        System.out.println("Enter your choice: ");
        Scanner scanner = new Scanner(System.in);
        int deleteOptions = scanner.nextInt();

        switch (deleteOptions) {
            case 0:
                System.exit(0);
                break;
            case 1:
                deleteVet();
                showMenu();
                break;
            case 2:
                deletePet();
                showMenu();
                break;
            case 3:
                deleteConsult();
                showMenu();
                break;
            case 4:
                deleteOwner();
                showMenu();
                break;
            case 5:
                showMenu();
                break;
            default:
                System.exit(0);
                break;
        }
    }

    public static void find() throws IOException, CsvValidationException {
        System.out.println("\nFind Menu \n0 - Exit \n1 - Find Veterinarian by id\n2 - Find Veterinarian by Name\n3 - Find Pet by id\n4 - Find Consult by id\n5 - Find Owner by id\n6 - Return to Main Menu");
        System.out.println("Enter your choice: ");
        Scanner scanner = new Scanner(System.in);
        int findOption = scanner.nextInt();

        switch (findOption) {
            case 0:
                System.exit(0);
                break;
            case 1:
                findVetById();
                showMenu();
                break;
            case 2:
                findVetByName();
                showMenu();
                break;
            case 3:
                findPetById();
                showMenu();
                break;
            case 4:
                findConsultById();
                showMenu();
                break;
            case 5:
                findOwnerById();
                showMenu();
                break;
            case 6:
                showMenu();
                break;
            default:
                System.exit(0);
                break;
        }
    }

    public static void importExport() throws IOException, CsvValidationException {

        System.out.println("\nImport/Export Menu:\n0 - Exit\n1 - Import from CSV file\n2 - Export to CSV file\n3 - Return to Main Menu");
        System.out.println("Enter your choice: ");

        int createOption = scanner.nextInt();

        switch (createOption) {
            case 0:
                System.exit(0);
                break;
            case 1:
                importFromCsv();
                showMenu();
                break;
            case 2:
                exportToCsv();
                showMenu();
                break;
            case 3:
                showMenu();
                break;
            default:
                System.exit(0);
                break;
        }
    }

    private static void importFromCsv() throws IOException, CsvValidationException {
        System.out.println("\nImport Menu:\n0 - Exit\n1 - Import Pet\n2 - Import Veterinarian\n3 - Import Consult\n4 - Import Owner\n5 - Return to Main Menu");
        System.out.println("Enter your choice: ");

        int createOption = scanner.nextInt();

        switch (createOption) {
            case 0:
                System.exit(0);
                break;
            case 1:
                importPet();
                break;
            case 2:
                importVeterinarian();
                break;
            case 3:
                importConsult();
                break;
            case 4:
                importOwner();
                break;
            case 5:
                showMenu();
                break;
            default:
                System.exit(0);
                break;
        }
    }

    private static void exportToCsv() throws IOException, CsvValidationException {
        System.out.println("\nExport Menu:\n0 - Exit\n1 - Export Pet\n2 - Export Veterinarian\n3 - Export Consult\n4 - Export Owner\n5 - Return to Main Menu");
        System.out.println("Enter your choice: ");

        int createOption = scanner.nextInt();

        switch (createOption) {
            case 0:
                System.exit(0);
                break;
            case 1:
                exportPet();
                break;
            case 2:
                exportVet();
                break;
            case 3:
                exportConsult();
                break;
            case 4:
                exportOwner();
                break;
            case 5:
                showMenu();
                break;
            default:
                System.exit(0);
                break;
        }
    }

    private static void createPet() {
        petService.createPet();
    }

    private static void createVet() {
        veterinarianService.createVeterinarian();
    }

    private static void createConsult() {
        consultService.createConsult();
    }

    private static void createOwner() {
        ownerService.createOwner();
    }

    private static void updatePet() throws IOException, CsvValidationException {
        petService.displayAllPets();
        System.out.println("\nPlease insert pet id you want to update:");
        Long idPet = scanner.nextLong();
        Pet pet = petService.findById(idPet);
        if (pet == null) {
            updatePet();
        } else {
            updatePetMenu(pet);
        }
    }

    private static void updatePetMenu(Pet pet) throws IOException, CsvValidationException {
        System.out.println("\nUpdate Pet Menu\n0 - Exit\n1 - Update Name\n2 - Update Race\n3 - Update BirthDate\n4 - Update isVaccinated\n5 - Update Owner\n6 - Save and Return to Main Menu");
        System.out.println("\t Enter your choice: ");
        int updatePet = scanner.nextInt();

        switch (updatePet) {
            case 0:
                System.exit(0);
                break;
            case 1:
                System.out.println("Please insert pet name");
                String petName = UtilMethods.firstLetterToUpperCase(scanner.next());
                pet.setName(petName);
                updatePetMenu(pet);
                break;
            case 2:
                System.out.println("Please insert pet race");
                pet.setRace(scanner.next());
                updatePetMenu(pet);
                break;
            case 3:
                System.out.println("Please insert pet birthdate!");
                pet.setBirthDate(scanner.next());
                updatePetMenu(pet);
                break;
            case 4:
                System.out.println("Please advise if it's vaccinated");
                pet.setVaccinated(scanner.nextBoolean());
                updatePetMenu(pet);
                break;
            case 5:
                Owner newOwner = petService.selectPetOwner();
                pet.setOwner(newOwner);
                updatePetMenu(pet);
                break;
            case 6:
                petService.update(pet);
                showMenu();
                break;
            default:
                System.exit(0);
        }
    }

    private static void updateConsult() throws IOException, CsvValidationException {
        consultService.displayAllConsults();
        System.out.println("\nPlease insert consult id you want to update:");
        Long idConsult = scanner.nextLong();
        Consult consult = consultService.findById(idConsult);
        if (consult == null) {
            updateConsult();
        } else {
            updateConsultMenu(consult);
        }
    }

    private static void updateConsultMenu(Consult consult) throws IOException, CsvValidationException {
        System.out.println("\nUpdate Consult Menu\n0 - Exit\n1 - Update Date\n2 - Update Description\n3 - Update Veterinarian\n4 - Update Pet\n5 - Save and return to Main Menu");
        System.out.println(" Enter your choice: ");
        int updateConsult = scanner.nextInt();
        switch (updateConsult) {
            case 0:
                System.exit(0);
                break;
            case 1:
                System.out.println("Please insert consult date");
                consult.setDate(scanner.next());
                updateConsultMenu(consult);
                break;
            case 2:
                System.out.println("Please insert consult description");
                consult.setDescription(scanner.next());
                updateConsultMenu(consult);
                break;
            case 3:
                veterinarianService.displayAllVeterinarians();
                System.out.println("Please insert veterinarian id:");
                veterinarianService.update(veterinarianService.findById(scanner.nextLong()));
                updateConsultMenu(consult);
                break;
            case 4:
                System.out.println("Please insert pet id");
                petService.update(petService.findById(scanner.nextLong()));
                updateConsultMenu(consult);
                break;
            case 5:
                consultService.update(consult);
                showMenu();
                break;
            default:
                System.exit(0);
        }
    }

    private static void updateOwner() throws IOException, CsvValidationException {
        ownerService.displayAllOwners();
        System.out.println("\nPlease insert consult id you want to update:");
        Long idOwner = scanner.nextLong();
        Owner owner = ownerService.findById(idOwner);
        if (owner == null) {
            updateOwner();
        } else {
            updateOwnerMenu(owner);
        }
    }

    private static void updateOwnerMenu(Owner owner) throws IOException, CsvValidationException {
        System.out.println("\nUpdate Owner Menu\n0 - Exit\n1 - Update first name\n2 - Update last name\n3 - Update phone number\n4 - Update email\n5 - Return to Main Menu");
        System.out.println(" Enter your choice: ");
        int updateConsult = scanner.nextInt();
        switch (updateConsult) {
            case 0:
                System.exit(0);
                break;
            case 1:
                System.out.println("Please insert owner first name:\n");
                String firstName = UtilMethods.firstLetterToUpperCase(scanner.next());
                owner.setFirstName(firstName);
                updateOwnerMenu(owner);
                break;
            case 2:
                System.out.println("Please insert owner last name:\n");
                String lastName = UtilMethods.firstLetterToUpperCase(scanner.next());
                owner.setLastName(lastName);
                updateOwnerMenu(owner);
                break;
            case 3:
                System.out.println("Please insert owner phone number:\n");
                owner.setPhoneNumber(scanner.next());
                updateOwnerMenu(owner);
                break;
            case 4:
                System.out.println("Please insert owner email:\n");
                String email = scanner.next();
                if (ownerService.isValidEmailAddress(email)) {
                    owner.setEmail(email);
                } else {
                    System.out.println("Your email is invalid!\n");
                }
                updateOwnerMenu(owner);
                break;
            case 5:
                ownerService.update(owner);
                showMenu();
                break;
            default:
                System.exit(0);
        }
    }

    private static void updateVeterinarian() throws IOException, CsvValidationException {
        veterinarianService.displayAllVeterinarians();
        System.out.println("\nPlease insert veterinarian id you want to update:");
        Long idVeterinarian = scanner.nextLong();
        Veterinarian veterinarian = veterinarianService.findById(idVeterinarian);
        if (veterinarian == null) {
            updateVeterinarian();
        } else {
            updateVeterinarianMenu(veterinarian);
        }
    }

    private static void updateVeterinarianMenu(Veterinarian veterinarian) throws IOException, CsvValidationException {
        System.out.println("\nUpdate Veterinarian Menu\n0 - Exit\n1 - Update first name\n2 - Update last name\n3 - Update address\n4 - Update speciality\n5 - Save and return to Main Menu");
        System.out.println(" Enter your choice: ");
        int updateVeterinarian = scanner.nextInt();
        switch (updateVeterinarian) {
            case 0:
                System.exit(0);
                break;
            case 1:
                System.out.println("Please insert veterinarian first name");
                String firstName = UtilMethods.firstLetterToUpperCase(scanner.next());
                veterinarian.setFirstName(firstName);
                updateVeterinarianMenu(veterinarian);
                break;
            case 2:
                System.out.println("Please insert veterinarian last name");
                String lastName = UtilMethods.firstLetterToUpperCase(scanner.next());
                veterinarian.setLastName(lastName);
                updateVeterinarianMenu(veterinarian);
                break;
            case 3:
                System.out.println("Please insert veterinarian address");
                veterinarian.setAddress(scanner.next());
                updateVeterinarianMenu(veterinarian);
                break;
            case 4:
                System.out.println("Please insert veterinarian speciality");
                veterinarian.setSpeciality(scanner.next());
                updateVeterinarianMenu(veterinarian);
                break;
            case 5:
                veterinarianService.update(veterinarian);
                showMenu();
                break;
            default:
                System.exit(0);
        }
    }

    private static void deleteOwner() {
        ownerService.deleteOwner();
    }

    private static void deletePet() {
        petService.deletePet();
    }

    private static void deleteVet() {
        veterinarianService.deleteVeterinarian();
    }

    private static void deleteConsult() {
        consultService.deleteConsult();
    }

    private static void findVetById() {
        System.out.println("Please insert vet id you want to select!");
        long idVeterinarian = scanner.nextLong();
        Veterinarian veterinarian = veterinarianService.findById(idVeterinarian);
        if (veterinarian == null) {
            findVetById();
        } else {
            System.out.println(veterinarian);
        }
    }

    private static void findVetByName() {
        System.out.println("Please insert vet first name you want to select!");
        String firstName = scanner.next();
        List<Veterinarian> veterinarians = veterinarianDao.findByNameVet(firstName);
        if (veterinarians.isEmpty()) {
            System.out.println("Veterinarian with name: " + firstName + " does not exists!");
            findVetByName();
        } else {
            System.out.println(veterinarians);
        }
    }

    private static void findPetById() {
        System.out.println("Please insert pet id you want to select!");
        long idPet = scanner.nextLong();
        Pet pet = petService.findById(idPet);
        if (pet == null) {
            findPetById();
        } else {
            System.out.println(pet);
        }
    }

    private static void findConsultById() {
        System.out.println("Please insert Consult id you want to select!");
        long idConsult = scanner.nextLong();
        Consult consult = consultService.findById(idConsult);
        if (consult == null) {
            findConsultById();
        } else {
            System.out.println(consult);
        }
    }

    private static void findOwnerById() {
        System.out.println("Please insert Owner id you want to select!");
        long idOwner = scanner.nextLong();
        Owner owner = ownerService.findById(idOwner);
        if (owner == null) {
            findOwnerById();
        } else {
            System.out.println(owner);
        }
    }

    public static void exportPet() {
        exportCSV.exportCsvPet(petService.findAllPets());
    }

    public static void exportVet() {
        exportCSV.exportCsvVet(veterinarianService.findAllVeterinarians());
    }

    public static void exportConsult() {
        exportCSV.exportCsvConsult(consultService.findAllConsults());
    }

    private static void exportOwner() {
        exportCSV.exportCsvOwner(ownerService.findAllOwners());
    }

    private static void importPet() throws IOException, CsvValidationException {
        importCSV.importCsvPet();
    }

    private static void importVeterinarian() throws IOException, CsvValidationException {
        importCSV.importCsvVeterinarian();
    }

    private static void importConsult() throws IOException, CsvValidationException {
        importCSV.importCsvConsult();
    }

    private static void importOwner() throws IOException, CsvValidationException {
        importCSV.importCsvOwner();
    }
}

