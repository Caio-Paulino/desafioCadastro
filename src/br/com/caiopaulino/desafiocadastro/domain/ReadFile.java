package br.com.caiopaulino.desafiocadastro.domain;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ReadFile {
    public static void main(String[] args) {
        File file = new File("C:\\Users\\Lourival\\Documents\\desafiodevmagro\\desafioCadastro\\formulario.txt");
        try(Scanner readFile = new Scanner(file);) {
            while(readFile.hasNextLine()) {
                String data = readFile.nextLine();
                System.out.println(data);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
