package br.com.caiopaulino.desafiocadastro.domain;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Exceptions {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        String regex = input;
        String texto = "Caio";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(texto);

        while(matcher.find()) {
            System.out.print(texto);
        }
    }

    protected void validateWeight(String weight) {
        float weightValidate = Float.parseFloat(weight);

        if(weightValidate > 60 | weightValidate < 0.5) {
            throw new IllegalArgumentException("Peso deve estar entre 0.5kg e 60kg");
        } else {
            System.out.println(weightValidate + " kg");
        }
    }

    protected void validateAge(String age) {
        int ageValidate = Integer.parseInt(age);

        if(ageValidate > 20) {
            throw new IllegalArgumentException("Idade inválida");
        } else {
            System.out.println(ageValidate + " anos");
        }
    }
}
