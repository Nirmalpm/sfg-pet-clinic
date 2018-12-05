package guru.springframework.sfgpetclinic.services.springdatajpa;

import java.util.HashSet;
import java.util.Set;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import guru.springframework.sfgpetclinic.model.Pet;
import guru.springframework.sfgpetclinic.model.Pet;
import guru.springframework.sfgpetclinic.repositories.PetRepository;
import guru.springframework.sfgpetclinic.services.PetService;

@Service
@Profile("springDJPa")
public class PetSDJpaService implements PetService {
	
	private final PetRepository petRepository;
	
	public PetSDJpaService(PetRepository petRepository) {
		this.petRepository = petRepository;
	}

	@Override
	public Set<Pet> findAll() {
		Set<Pet> pets = new HashSet<Pet>();
		petRepository.findAll().iterator().forEachRemaining(pets::add);
		return pets;
	}

	@Override
	public Pet findById(Long id) {
		return petRepository.findById(id).orElseGet(null);
	}

	@Override
	public Pet save(Pet Object) {
		return petRepository.save(Object);
	}

	@Override
	public void delete(Pet Object) {
		petRepository.delete(Object);
	}

	@Override
	public void deleteById(Long id) {
		petRepository.deleteById(id);
	}

}
