package utils;

import model.Consult;
import model.Owner;
import model.Pet;
import model.Veterinarian;
import java.io.*;
import java.util.*;

public class ExportCSV {

    private static final String CSV_SEPARATOR = ",";

    public void exportCsvPet(List<Pet> pets) {
        try {
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("pet.csv"), "UTF-8"));
            for (Pet pet : pets) {
                String oneLine = pet.getPetId() +
                        CSV_SEPARATOR +
                        pet.getRace() +
                        CSV_SEPARATOR +
                        pet.getName() +
                        CSV_SEPARATOR +
                        pet.getBirthDate() +
                        CSV_SEPARATOR +
                        pet.isVaccinated() +
                        CSV_SEPARATOR +
                        pet.getOwner().getOwnerId();
                bw.write(oneLine);
                bw.newLine();
            }
            bw.flush();
            bw.close();
            System.out.println("Pet exported list to .csv!");
        } catch (IOException e) {
            System.out.println("Something went wrong!");
        }
    }

    public void exportCsvVet(List<Veterinarian> veterinarians) {
        try {
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("vet.csv"), "UTF-8"));
            for (Veterinarian veterinarian : veterinarians) {
                String oneLine = veterinarian.getIdVeterinarian() +
                        CSV_SEPARATOR +
                        veterinarian.getFirstName() +
                        CSV_SEPARATOR +
                        veterinarian.getLastName() +
                        CSV_SEPARATOR +
                        veterinarian.getAddress() +
                        CSV_SEPARATOR +
                        veterinarian.getSpeciality();
                bw.write(oneLine);
                bw.newLine();
            }
            bw.flush();
            bw.close();
            System.out.println("Veterinarian list exported to .csv!");
        } catch (IOException e) {
            System.out.println("Something went wrong!");
        }
    }

    public void exportCsvConsult(List<Consult> consults) {
        try {
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("consult.csv"), "UTF-8"));
            for (Consult consult : consults) {
                String oneLine = consult.getConsultId() +
                        CSV_SEPARATOR +
                        consult.getDate() +
                        CSV_SEPARATOR +
                        consult.getDescription() +
                        CSV_SEPARATOR +
                        consult.getVeterinarian().getIdVeterinarian() +
                        CSV_SEPARATOR +
                        consult.getPet().getPetId();
                bw.write(oneLine);
                bw.newLine();
            }
            bw.flush();
            bw.close();
            System.out.println("Consult list exported to .csv!");
        } catch (IOException e) {
            System.out.println("Something went wrong!");
        }
    }

    public void exportCsvOwner(List<Owner> owners) {
        try {
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("owner.csv"), "UTF-8"));
            for (Owner owner : owners) {
                String oneLine = owner.getOwnerId() +
                        CSV_SEPARATOR +
                        owner.getFirstName() +
                        CSV_SEPARATOR +
                        owner.getLastName() +
                        CSV_SEPARATOR +
                        owner.getPhoneNumber() +
                        CSV_SEPARATOR +
                        owner.getEmail();
                bw.write(oneLine);
                bw.newLine();
            }
            bw.flush();
            bw.close();
            System.out.println("Owner list exported to .csv!");
        } catch (IOException e) {
            System.out.println("Something went wrong!");
        }
    }
}