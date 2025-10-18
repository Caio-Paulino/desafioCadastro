package br.com.caiopaulino.desafiocadastro;

public class Pet {
    private String name;
    private String sex;
    private String type;
    private String address;
    private int age;
    private double weight;
    private String breed;

//    public Pet(String name, String sex, String type, String address, int age, double weight, String breed) {
//        this.name = name;
//        this.sex = sex;
//        this.type = type;
//        this.address = address;
//        this.age = age;
//        this.weight = weight; 
//        this.breed = breed;
//    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }
}
