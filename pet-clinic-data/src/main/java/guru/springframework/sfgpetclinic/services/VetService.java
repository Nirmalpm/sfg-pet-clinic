package guru.springframework.sfgpetclinic.services;

import java.util.Set;

import guru.springframework.sfgpetclinic.model.Vet;

public interface VetService {

	Vet findById(Vet vet);
	Vet save(Vet vet);
	Set<Vet> findAll();
	
}
