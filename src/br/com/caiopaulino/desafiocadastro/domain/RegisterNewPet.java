package br.com.caiopaulino.desafiocadastro.domain;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DecimalFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class RegisterNewPet {
    public void registerNewPet() {
        Pet pet = new Pet();
        Regex regex = new Regex();
        Exceptions exception = new Exceptions();
        Scanner scanner = new Scanner(System.in);

        System.out.print("1 - ");
        String name = scanner.nextLine();
        regex.verificationIsEmpty(name);
        regex.verificationName(name);
        pet.setName(name);

        System.out.print("2 - ");
        String type = scanner.nextLine();
        pet.setPettype(PetType.valueOf(type));
        System.out.println(pet.getPettype());

        System.out.print("3 - ");
        String sex = scanner.nextLine();
        pet.setPetsex(PetSex.valueOf(sex));
        System.out.println(pet.getPetsex());

        System.out.print("4.1 - Número da casa: ");
        String houseNumber = scanner.nextLine();
        regex.verificationIsEmpty(houseNumber);
        System.out.print("4.2 - Cidade: ");
        String city = scanner.nextLine();
        System.out.print("4.3 - Rua: ");
        String street = scanner.nextLine();
        String address = houseNumber + ", " + city + ", " + street;
        pet.setAddress(address);
        System.out.println(pet.getAddress());

        System.out.print("5 - ");
        System.out.println("1. Idade em anos   2. Idade em meses");
        int option = scanner.nextInt();
        scanner.nextLine();
        if(option == 1) {
            System.out.println("Digite a idade do animal: ");
            String age = scanner.nextLine();
            regex.verificationIsEmpty(age);
            regex.verificationNumber(age);
            exception.validateAge(age);
            pet.setAge(age);
        } else if (option == 2) {
            System.out.println("Digite a idade do animal: ");
            String age = scanner.nextLine();
            regex.verificationIsEmpty(age);
//            regex.verificationNumber(age);
            exception.validateAge(age);
            pet.setAge(age);
            float ageMonth = Float.parseFloat(age);
            ageMonth = ageMonth / 12;
            DecimalFormat df = new DecimalFormat("#.##");
            System.out.println(df.format(ageMonth));
        } else {
            throw new IllegalArgumentException("Opção inválida");
        }

        System.out.print("6 - ");
        String weight = scanner.nextLine();
        regex.verificationIsEmpty(weight);
        regex.verificationNumber(weight);
        exception.validateWeight(weight);
        pet.setWeight(weight);

        System.out.print("7 - ");
        String breed = scanner.nextLine();
        regex.verificationIsEmpty(breed);
        regex.verificationBreed(breed);
        pet.setBreed(breed);



        // Nome do arquivo
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("ddMMyyyy'T'HHmm");
        String formattedDate = now.format(formatter);
        name = name.replaceAll(" ", "");
        name = name.toUpperCase();
        String nameFile = formattedDate + "-" + name + ".txt";

        File file = new File("C:\\Users\\Lourival\\Documents\\desafiodevmagro\\desafioCadastro\\src\\br\\com\\caiopaulino\\desafiocadastro\\petsCadastrados\\" + nameFile);
        try(FileWriter fw = new FileWriter(file);) {
            fw.write("1 - " + pet.getName() + "\n");
            fw.write("2 - " + pet.getPettype() + "\n");
            fw.write("3 - " + pet.getPetsex() + "\n");
            fw.write("4 - " + pet.getAddress() + "\n");
            fw.write("5 - " + pet.getAge() + " anos" +"\n");
            fw.write("6 - " + pet.getWeight() + " kg" + "\n");
            fw.write("7 - " + pet.getBreed() + "\n");
            fw.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
