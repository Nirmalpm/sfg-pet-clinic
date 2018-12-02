package guru.springframework.sfgpetclinic.services;

import java.util.Set;

import guru.springframework.sfgpetclinic.model.Owner;

public interface OwnerService {
	Owner findByLastName(String lastName);
	Owner findById(Owner owner);
	Owner save(Owner owner);
	Set<Owner> findAll();
}
