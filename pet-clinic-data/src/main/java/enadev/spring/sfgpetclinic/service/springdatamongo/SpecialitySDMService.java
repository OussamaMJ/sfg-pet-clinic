package enadev.spring.sfgpetclinic.service.springdatamongo;

import enadev.spring.sfgpetclinic.model.Speciality;
import enadev.spring.sfgpetclinic.repositories.SpecialityRepository;
import enadev.spring.sfgpetclinic.service.SpecialityService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@Profile("springdatamongo")
public class SpecialitySDMService implements SpecialityService {
    private final SpecialityRepository specialityRepository;

    public SpecialitySDMService(SpecialityRepository specialityRepository) {
        this.specialityRepository = specialityRepository;
    }

    @Override
    public Set<Speciality> findAll() {
        Set<Speciality> specialities = new HashSet<>();
        specialityRepository.findAll().forEach(specialities::add);
        return specialities;
    }

    @Override
    public Speciality findById(String aLong) {
        return specialityRepository.findById(aLong).orElse(null);
    }

    @Override
    public Speciality save(Speciality object) {
        return specialityRepository.save(object);
    }

    @Override
    public void delete(Speciality object) {
        specialityRepository.delete(object);
    }

    @Override
    public void deleteById(String aLong) {
        specialityRepository.deleteById(aLong);
    }
}
