package guru.springframework.sfgpetclinic.services.springdatajpa;

import java.util.HashSet;
import java.util.Set;

import org.springframework.stereotype.Service;

import guru.springframework.sfgpetclinic.model.Vet;
import guru.springframework.sfgpetclinic.repositories.VetRepository;
import guru.springframework.sfgpetclinic.services.VetService;

@Service
public class VetSDJpaService implements VetService {

	private final VetRepository vetRepository;
	
	
	public VetSDJpaService(VetRepository vetRepository) {
		this.vetRepository = vetRepository;
	}

	@Override
	public Set<Vet> findAll() {
		Set<Vet> vets = new HashSet<Vet>();
		vetRepository.findAll().iterator().forEachRemaining(vets::add);
		return vets;
	}

	@Override
	public Vet findById(Long id) {
		return vetRepository.findById(id).orElseGet(null);
	}

	@Override
	public Vet save(Vet Object) {
		return vetRepository.save(Object);
	}

	@Override
	public void delete(Vet Object) {
		vetRepository.delete(Object);
	}

	@Override
	public void deleteById(Long id) {
		vetRepository.deleteById(id);
	}

}
