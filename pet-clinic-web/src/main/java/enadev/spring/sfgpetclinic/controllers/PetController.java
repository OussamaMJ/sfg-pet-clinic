package enadev.spring.sfgpetclinic.controllers;

import enadev.spring.sfgpetclinic.model.Owner;
import enadev.spring.sfgpetclinic.model.Pet;
import enadev.spring.sfgpetclinic.model.PetType;
import enadev.spring.sfgpetclinic.service.OwnerService;
import enadev.spring.sfgpetclinic.service.PetService;
import enadev.spring.sfgpetclinic.service.PetTypeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.beans.PropertyEditorSupport;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Collection;

@Controller
@RequestMapping("/owners/{ownerId}")
public class PetController {

    private static final String VIEWS_PETS_CREATE_OR_UPDATE_FORM = "pets/createOrUpdatePetForm";

    private final PetService petService;
    private final OwnerService ownerService;
    private final PetTypeService petTypeService;

    public PetController(PetService petService, OwnerService ownerService, PetTypeService petTypeService) {
        this.petService = petService;
        this.ownerService = ownerService;
        this.petTypeService = petTypeService;
    }

    @ModelAttribute("types")
    public Collection<PetType> populatePetTypes() {
        return petTypeService.findAll();
    }

    @ModelAttribute("owner")
    public Owner findOwner(@PathVariable("ownerId") String ownerId) {
        return ownerService.findById(ownerId);
    }

    @InitBinder("owner")
    public void initBinder( WebDataBinder dataBinder )
    {
        dataBinder.setDisallowedFields("id");

        dataBinder.registerCustomEditor(LocalDate.class, new PropertyEditorSupport() {
            @Override
            public void setAsText(String text) throws IllegalArgumentException {
                setValue(LocalDateTime.parse(text));
                //LocalDateTime.parse( text, DateTimeFormatter.ISO_DATE_TIME );
            }
        });
    }


    @GetMapping("/pets/new")
    public String initCreationForm(Owner owner, Model model){
        Pet pet = new Pet();
        owner.getPets().add(pet);
        model.addAttribute("pet", pet);
        return VIEWS_PETS_CREATE_OR_UPDATE_FORM;
    }

    @PostMapping("/pets/new")
    public String processCreationForm(Owner owner, @Valid Pet pet, BindingResult result, Model model) {
        if (StringUtils.hasLength(pet.getName()) && pet.isNew_()  && owner.getPet(pet.getName(), true) != null){
            result.rejectValue("name", "duplicate", "already exists");
        }
        if (result.hasErrors()) {
            model.addAttribute("pet", pet);
            return VIEWS_PETS_CREATE_OR_UPDATE_FORM;
        } else {
            //Pet petToSave = Pet.builder().name(pet.getName()).birthDay(pet.getBirthDay()).petType(pet.getPetType()).build();
            pet.setId(null);
            petService.save(pet);
            owner.getPets().add(pet);
            ownerService.save(owner);
            return "redirect:/owners/" + owner.getId();
        }
    }

    @GetMapping("/pets/{petId}/edit")
    public String initUpdateForm(@PathVariable String petId, Model model) {
        model.addAttribute("pet", petService.findById(petId));
        return VIEWS_PETS_CREATE_OR_UPDATE_FORM;
    }

    @PostMapping("/pets/{petId}/edit")
    public String processUpdateForm(@Valid Pet pet, BindingResult result, Owner owner, Model model) {
        if (result.hasErrors()) {
            System.out.println("Has binding errors ...");
            model.addAttribute("pet", pet);
            return VIEWS_PETS_CREATE_OR_UPDATE_FORM;
        } else {
            Pet petFromDB = petService.findById(pet.getId());
            petFromDB.setName(pet.getName());
            petFromDB.setBirthDay(pet.getBirthDay());
            petFromDB.setPetType(pet.getPetType());
            petService.save(petFromDB);

            return "redirect:/owners/" + owner.getId();
        }
    }
}
