package guru.springframework.sfgpetclinic.services;

import java.util.Set;

import guru.springframework.sfgpetclinic.model.Owner;
import guru.springframework.sfgpetclinic.model.Pet;

public interface PetService {
	Pet findById(Pet pet);
	Pet save(Pet pet);
	Set<Pet> findAll();
}
