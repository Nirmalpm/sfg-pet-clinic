package guru.springframework.sfgpetclinic.services.springdatajpa;

import java.util.HashSet;
import java.util.Set;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import guru.springframework.sfgpetclinic.model.Speciality;
import guru.springframework.sfgpetclinic.repositories.SpecialityRepository;
import guru.springframework.sfgpetclinic.services.SpecialityService;

@Service
@Profile("springDJPa")
public class VetSpecialitySDJpaService implements SpecialityService{

	private final SpecialityRepository specialityRepository;
	
	public VetSpecialitySDJpaService(SpecialityRepository specialityRepository) {
		this.specialityRepository = specialityRepository;
	}

	@Override
	public Set<Speciality> findAll() {
		Set<Speciality> specialities = new HashSet<Speciality>();
		specialityRepository.findAll().iterator().forEachRemaining(specialities::add);
		return specialities;
	}

	@Override
	public Speciality findById(Long id) {
		return specialityRepository.findById(id).orElseGet(null);
	}

	@Override
	public Speciality save(Speciality Object) {
		return specialityRepository.save(Object);
	}

	@Override
	public void delete(Speciality Object) {
		specialityRepository.delete(Object);
		
	}

	@Override
	public void deleteById(Long id) {
		specialityRepository.deleteById(id);
	}

}
