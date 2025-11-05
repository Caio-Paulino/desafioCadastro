package br.com.caiopaulino.desafiocadastro.domain;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;

public class SearchInFolder {

        public static void main(String[] args) {

        Path folderPath = Paths.get("C:\\Users\\Lourival\\Documents\\desafiodevmagro\\desafioCadastro\\src\\br\\com\\caiopaulino\\desafiocadastro\\petsCadastrados");

        try (Stream<Path> paths = Files.list(folderPath);
             Scanner sc = new Scanner(System.in)) {

//            System.out.print("Digite o termo de busca: ");
//            String input = sc.nextLine();
//            String regex = input.toLowerCase(Locale.ROOT);
//            Pattern pattern = Pattern.compile(regex);

            // 👇 Lista para armazenar arquivos que correspondem à busca
            List<Path> encontrados = new ArrayList<>();

            // percorre todos os arquivos da pasta
            paths.filter(Files::isRegularFile)
                    .forEach(file -> {
                        try {
                            String text = Files.readString(file);
//                            Matcher matcher = pattern.matcher(text.toLowerCase(Locale.ROOT));
                            System.out.println(file.getFileName());
                            System.out.println(text);
//                            if (matcher.find()) {
//                                System.out.println("Encontrado no arquivo: " + file.getFileName());
//                                System.out.println(text);
//                                encontrados.add(file); // 👈 adiciona à lista
//                            }

                        } catch (IOException e) {
                            System.err.println("Erro ao ler o arquivo: " + file.getFileName());
                        }
                    });

            // 👇 só pergunta qual arquivo alterar depois de listar todos
            if (!encontrados.isEmpty()) {
                System.out.println("\nArquivos encontrados:");
                for (Path p : encontrados) {
                    System.out.println("- " + p.getFileName());
                }

                System.out.print("\nDigite o nome exato do arquivo que deseja alterar: ");
                String nameFile = sc.nextLine();

                // 👇 procura o arquivo escolhido pelo usuário
                Optional<Path> escolhido = encontrados.stream()
                        .filter(f -> f.getFileName().toString().equalsIgnoreCase(nameFile))
                        .findFirst();

                if (escolhido.isPresent()) {
                    System.out.println("Você escolheu: " + escolhido.get());
                    List<String> lines = Files.readAllLines(escolhido.get());
                    System.out.println("Qual linha deseja alterar? Digite o número");
                    int option = sc.nextInt();
                    sc.nextLine();
                    System.out.println("Digite a alteração do texto: ");
                    String newText = sc.nextLine();
                    lines.set(option, newText);
                    Files.write(escolhido.get(), lines);

                    // aqui você pode adicionar a lógica de alteração do arquivo
                } else {
                    System.out.println("Arquivo não encontrado na lista.");
                }
            } else {
                System.out.println("Nenhum arquivo corresponde à busca.");
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        }
    }

