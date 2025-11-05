package br.com.caiopaulino.desafiocadastro.domain;

public class Pet {
    private String name;
    private PetSex petsex;
    private PetType pettype;
    private String address;
    private String age;
    private String weight;
    private String breed;

    public PetSex getPetsex() {
        return petsex;
    }

    public void setPetsex(PetSex petsex) {
        this.petsex = petsex;
    }

    public PetType getPettype() {
        return pettype;
    }

    public void setPettype(PetType pettype) {
        this.pettype = pettype;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }
}
