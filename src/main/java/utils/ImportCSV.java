package utils;

import com.opencsv.exceptions.CsvValidationException;
import model.Consult;
import model.Owner;
import model.Pet;
import model.Veterinarian;
import dao.ConsultDao;
import dao.OwnerDao;
import dao.PetDao;
import java.io.IOException;
import com.opencsv.CSVReader;
import dao.VeterinarianDao;
import java.io.FileReader;
import java.util.Scanner;

public class ImportCSV {

    private static final Scanner scanner = new Scanner(System.in);

    public  void importCsvPet() throws IOException, CsvValidationException {
        System.out.println("Introduceti numele fisierului daca este in acelasi director cu proiectul pet.csv");
        String location = scanner.next();
        CSVReader csvReader = new CSVReader(new FileReader(location));
        String[] line;
        while ((line = csvReader.readNext()) != null) {

            PetDao petDao = new PetDao();
            Pet pet = new Pet();
            OwnerDao ownerDao = new OwnerDao();

            pet.setRace(line[1]);
            pet.setName(line[2]);
            pet.setBirthDate(line[3]);
            pet.setVaccinated(Boolean.parseBoolean(line[4]));
            pet.setOwner(ownerDao.findByOwnerId(Long.parseLong(line[5])));
            petDao.createPet(pet);
        }
    }


    public  void importCsvVeterinarian() throws IOException, CsvValidationException {
        System.out.println("Introduceti numele fisierului daca este in acelasi director cu proiectul vet.csv");
        String location = scanner.next();
        CSVReader csvReader = new CSVReader(new FileReader(location));
        String[] line;
        while ((line = csvReader.readNext()) != null) {

            VeterinarianDao veterinarianDao = new VeterinarianDao();
            Veterinarian veterinarian = new Veterinarian();

            veterinarian.setFirstName(line[1]);
            veterinarian.setLastName(line[2]);
            veterinarian.setAddress(line[3]);
            veterinarian.setSpeciality(line[4]);
            veterinarianDao.createVeterinarian(veterinarian);
        }
    }

    public  void importCsvConsult() throws IOException, CsvValidationException {
        System.out.println("Introduceti numele fisierului daca este in acelasi director cu proiectul consult.csv");
        String location = scanner.next();
        CSVReader csvReader = new CSVReader(new FileReader(location));
        String[] line;
        while ((line = csvReader.readNext()) != null) {

            ConsultDao consultDao = new ConsultDao();
            Consult consult = new Consult();
            VeterinarianDao veterinarianDao1 = new VeterinarianDao();
            PetDao petDao1 = new PetDao();

            consult.setDate(line[1]);
            consult.setDescription(line[2]);
            consult.setVeterinarian(veterinarianDao1.findByIdVeterinarian(Long.parseLong(line[3])));
            consult.setPet(petDao1.findByIdPet(Long.parseLong(line[4])));
            consultDao.createConsult(consult);
        }
    }
    public  void importCsvOwner() throws IOException, CsvValidationException {
        System.out.println("Introduceti numele fisierului daca este in acelasi director cu proiectul consult.csv");
        String location = scanner.next();
        CSVReader csvReader = new CSVReader(new FileReader(location));
        String[] line;
        while ((line = csvReader.readNext()) != null) {

            OwnerDao ownerDao = new OwnerDao();
            Owner owner = new Owner();

            owner.setFirstName(line[1]);
            owner.setLastName(line[2]);
            owner.setPhoneNumber(line[3]);
            owner.setEmail(line[4]);
            ownerDao.createOwner(owner);
        }
    }
}
