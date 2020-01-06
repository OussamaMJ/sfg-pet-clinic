package enadev.spring.sfgpetclinic.model;

public class PetType extends BaseEntity{
    private String petName;

    public String getPetName() {
        return petName;
    }

    public void setPetName(String name) {
        this.petName = name;
    }
}
