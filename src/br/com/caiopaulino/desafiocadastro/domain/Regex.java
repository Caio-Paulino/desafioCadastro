package br.com.caiopaulino.desafiocadastro.domain;

public class Regex {

    public void verificationName(String name) {
        String regex = "(([a-zA-Z])+(\\s([a-zA-Z])+)+)*";

        if(name.matches(regex)) {
            System.out.println(name);
        } else {
              throw new IllegalArgumentException("Inválido. Digite nome e sobrenome sem caracteres especiais.");
        }
    }

    public void verificationNumber(String number) {
        String regex = "([0-9])+([,|.])*([0-9])*";

        if(!number.matches(regex)) {
            throw new NumberFormatException("Erro: o campo aceita somente números!");
        }
    }

    public void verificationBreed(String breed) {
        String regex = "([a-zA-Z])+(\\s([a-zA-Z])*)*";

        if(breed.matches(regex)) {
            System.out.println(breed);
        } else {
            throw new IllegalArgumentException("Valor inválido, digite somente letras.");
        }
    }

    public void verificationIsEmpty(String empty) {
        String regex = "(\\s)*";
        IsEmpty isEmpty = IsEmpty.NAOINFORMADO;
        if (empty.matches(regex)) {
            System.out.println(isEmpty);
        }
    }
}
