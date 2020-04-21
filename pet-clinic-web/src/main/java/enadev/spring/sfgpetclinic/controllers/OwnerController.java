package enadev.spring.sfgpetclinic.controllers;

import enadev.spring.sfgpetclinic.model.Owner;
import enadev.spring.sfgpetclinic.service.OwnerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;

@RequestMapping("/owners")
@Controller
public class OwnerController {
    private final OwnerService ownerService;

    public OwnerController(OwnerService ownerService) {
        this.ownerService = ownerService;
    }

    @InitBinder
    public void setAllowedFields(WebDataBinder dataBinder){
        dataBinder.setDisallowedFields("id");
    }

    @RequestMapping({"", "/", "/index", "/index.html"})
    public String listOwners(Model model){
        model.addAttribute("owners",ownerService.findAll());
        return "owners/index";
    }

    @RequestMapping("/find")
    public String findOwner(Model model){
        model.addAttribute("owner",Owner.builder().build());
        return "owners/findOwners";
    }

    @GetMapping
    public String processFindForm(Owner owner, BindingResult result, Model model){
        if(owner.getLastName() == null){
            owner.setLastName("");
        }
        System.out.println("Owner's Last Name "+owner.getLastName());
        List<Owner> listOwners = ownerService.findAllByLastName(owner.getLastName());
        if(listOwners.isEmpty()){
            result.reject("lastName", new String[]{"notFound"}, "Not Found At All");
            return "owners/findOwners";
        }else if(listOwners.size() == 1){
            owner = listOwners.get(0);
            return "redirect:/owners/"+owner.getId();
        }else{
            model.addAttribute("selections", listOwners);
            return "owners/ownersList";
        }
    }

    @GetMapping("/{ownerId}")
    public ModelAndView showOwner(@PathVariable("ownerId") String ownerId){
        ModelAndView mav = new ModelAndView("owners/ownerDetails");
        mav.addObject(ownerService.findById(ownerId));
        return mav;
    }

    @GetMapping("/new")
    public String initCreationForm(Model model){
        model.addAttribute("owner",Owner.builder().build());
        return "owners/createOrUpdateOwnerForm";
    }

    @PostMapping("/new")
    public String processCreationForm(@Valid Owner owner, BindingResult result){
        if(result.hasErrors()){
            return "owners/createOrUpdateOwnerForm";
        }else{
            Owner savedOwner  = ownerService.save(owner);
            return "redirect:/owners/"+savedOwner.getId();
        }
    }

    @GetMapping("/{ownerId}/edit")
    public String initUpdateOwnerForm(@PathVariable("ownerId") String ownerId, Model model){
        model.addAttribute("owner",ownerService.findById(ownerId));
        return "owners/createOrUpdateOwnerForm";
    }

    @PostMapping("/{ownerId}/edit")
    public String processUpdateOwnerForm(@Valid Owner owner, BindingResult result, @PathVariable("ownerId") String ownerId){
        if(result.hasErrors()){
            return "owners/createOrUpdateOwnerForm";
        }else{
            Owner ownerFromDB  = ownerService.findById(ownerId);
            ownerFromDB.setTelephone(owner.getTelephone());
            ownerFromDB.setCity(owner.getCity());
            ownerFromDB.setLastName(owner.getLastName());
            ownerFromDB.setFirstName(owner.getFirstName());
            ownerFromDB.setAddress(owner.getAddress());

            Owner ownerSavedToDB  = ownerService.save(ownerFromDB);
            return "redirect:/owners/"+ownerFromDB.getId();
        }
    }

}
