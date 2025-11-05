package br.com.caiopaulino.desafiocadastro.domain;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Test {
    public static void main(String[] args) {
        Path formulary = Paths.get("C:\\Users\\Lourival\\Documents\\desafiodevmagro\\desafioCadastro\\formulario.txt");
        try {
            BufferedReader reader = new BufferedReader(new FileReader(formulary.toFile()));
            int lines = 0;
            while(reader.readLine() != null) {
                lines++;
            }
            System.out.println(lines);
            reader.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
