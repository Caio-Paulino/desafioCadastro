package br.com.caiopaulino.desafiocadastro.domain;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class HomeMenu {
        public void showMenu() {

            System.out.println("1. Cadastrar um novo pet\n");
            System.out.println("2. Alterar os dados do pet cadastrado\n");
            System.out.println("3. Deletar um pet cadastrado\n");
            System.out.println("4. Listar todos os pets cadastrados\n");
            System.out.println("5. Listar pets por algum critério (idade, nome, raça)\n");
            System.out.println("6. Sair\n");

            System.out.println("Escolha uma opção digitando o número correspondente: ");
            Scanner scanner = new Scanner(System.in);
            int option = scanner.nextInt();
            switch (option) {
                case 1:
                    File file = new File("C:\\Users\\Lourival\\Documents\\desafiodevmagro\\desafioCadastro\\formulario.txt");
                    try(Scanner readFile = new Scanner(file);) {
                        while(readFile.hasNextLine()) {
                            String data = readFile.nextLine();
                            System.out.println(data);
                        }
                        Scanner scannerVariable = new Scanner(System.in);
                        String name = scannerVariable.nextLine();
                        System.out.println("Nome: " + name);

                        Pet pet = new Pet();
                        pet.setName(name);
                        System.out.println(pet.getName());

                    } catch (FileNotFoundException e) {
                        throw new RuntimeException(e);
                    }
                    break;
                case 2:
                    System.out.println("2");
                    break;
                case 3:
                    System.out.println("3");
                    break;
                case 4:
                    System.out.println("4");
                    break;
                case 5:
                    System.out.println("5");
                    break;
                case 6:
                    System.out.println("6");
                    break;
                default:
                    System.out.println("Valor inválido");
                    showMenu();
                    break;
            }
        }



    }

