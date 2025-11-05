package br.com.caiopaulino.desafiocadastro.domain;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;
import java.util.stream.Stream;

public class ListAllFiles {
    public void listAllFiles() {
        Path folderPath = Paths.get("C:\\Users\\Lourival\\Documents\\desafiodevmagro\\desafioCadastro\\src\\br\\com\\caiopaulino\\desafiocadastro\\petsCadastrados");

        try (Stream<Path> paths = Files.list(folderPath);
             Scanner sc = new Scanner(System.in)) {
             paths.filter(Files::isRegularFile)
                    .forEach(file -> {
                        try {
                            String text = Files.readString(file);
                            System.out.println(file.getFileName());
                            System.out.println(text);
                        } catch (IOException e) {
                            System.err.println("Erro ao ler o arquivo: " + file.getFileName());
                        }
                    });

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
