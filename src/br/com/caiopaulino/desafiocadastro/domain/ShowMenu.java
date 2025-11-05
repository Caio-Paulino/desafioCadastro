package br.com.caiopaulino.desafiocadastro.domain;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;

public class ShowMenu {
        public void showMenu() throws IOException {

            System.out.println("1 - Iniciar o sistema para cadastro de PETS");
            System.out.println("2 - Iniciar o sistema para alterar formulário");
            Scanner scanner = new Scanner(System.in);
            int optionHomeMenu = scanner.nextInt();
            if (optionHomeMenu == 1) {
                System.out.println("1. Cadastrar um novo pet\n");
                System.out.println("2. Alterar os dados do pet cadastrado\n");
                System.out.println("3. Deletar um pet cadastrado\n");
                System.out.println("4. Listar todos os pets cadastrados\n");
                System.out.println("5. Sair\n");

                System.out.println("Escolha uma opção digitando o número correspondente: ");

                int optionMenuPet = scanner.nextInt();
                switch (optionMenuPet) {
                    case 1:
                        File file = new File("C:\\Users\\Lourival\\Documents\\desafiodevmagro\\desafioCadastro\\formulario.txt");
                        try(Scanner readFile = new Scanner(file);) {
                            while(readFile.hasNextLine()) {
                                String data = readFile.nextLine();
                                System.out.println(data);
                            }
                            System.out.println();
                            RegisterNewPet registerNewPet = new RegisterNewPet();
                            registerNewPet.registerNewPet();

                        } catch (FileNotFoundException e) {
                            throw new RuntimeException(e);
                        }
                        break;
                    case 2:
                        SearchPet searchPet = new SearchPet();
                        searchPet.searchPet();
                        break;
                    case 3:
                        DeletePet deletePet = new DeletePet();
                        deletePet.delete();
                        break;
                    case 4:
                        ListAllFiles listAllFiles = new ListAllFiles();
                        listAllFiles.listAllFiles();
                        break;
                    case 5:
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Valor inválido");
                        showMenu();
                        break;
                }
            } else if (optionHomeMenu == 2) {

                Path formulary = Paths.get("C:\\Users\\Lourival\\Documents\\desafiodevmagro\\desafioCadastro\\formulario.txt");

                System.out.println("1. Criar nova pergunta\n");
                System.out.println("2. Alterar pergunta existente\n");
                System.out.println("3. Excluir pergunta existente\n");
                System.out.println("4. Voltar para o menu inicial\n");
                System.out.println("5. Sair\n");

                System.out.println("Escolha uma opção digitando o número correspondente: ");

                int optionAlterForm = scanner.nextInt();
                switch (optionAlterForm) {
                    case 1:
                        System.out.println("Digite a nova pergunta: ");
                        scanner.nextLine();
                        String newQuestion = scanner.nextLine();

                        try(BufferedWriter writer = new BufferedWriter(new FileWriter(formulary.toFile(), true))) {
                            writer.newLine();
                            writer.write(newQuestion);

                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                        break;

                    case 2:

                        break;

                    case 3:
                        System.out.println("");
                        break;

                    case 4:
                        showMenu();
                        break;

                    case 5:
                        System.exit(0);
                        break;
                }
            } else {
                System.out.println("Opção inválida");
            }


        }



    }

