package guru.springframework.sfgpetclinic.services.springdatajpa;


import static org.hamcrest.CoreMatchers.anything;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.fail;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import guru.springframework.sfgpetclinic.model.Owner;
import guru.springframework.sfgpetclinic.repositories.OwnerRepository;
import guru.springframework.sfgpetclinic.repositories.PetRepository;
import guru.springframework.sfgpetclinic.repositories.PetTypeRepository;

@ExtendWith(MockitoExtension.class)
class OwnerSDJpaServiceTest {
	@Mock
	OwnerRepository ownerRepository;
	@Mock
	PetRepository petRepository;
	@Mock
	PetTypeRepository petTypeRepository;
	@InjectMocks
	OwnerSDJpaService service;
	
	String LAST_NAME="Nirmal";
	Owner returnOwner;	
	@BeforeEach
	void setUp() throws Exception {
		returnOwner = new Owner();	
		returnOwner.setId(1L);
		returnOwner.setLastName(LAST_NAME);
	}

	@Test
	void testFindAll() {
		Owner returnOwner2 = new Owner();	
		returnOwner2.setId(2L);
		returnOwner2.setLastName("Kumar");
		Set<Owner> retwunSet = new HashSet();
		retwunSet.add(returnOwner);
		retwunSet.add(returnOwner2);
		when(ownerRepository.findAll()).thenReturn(retwunSet);
		
		Set <Owner> owners = service.findAll();
		assertNotNull(owners);
		assertEquals(2,owners.size());
		
	}

	@Test
	void testFindById() {
		when(ownerRepository.findById(1L)).thenReturn(Optional.of(returnOwner));
		Owner owner = service.findById(1L);
		assertNotNull(owner);
	}
	
	@Test
	void testFindByIdNotFound() {
		when(ownerRepository.findById(1L)).thenReturn(Optional.empty());
		Owner owner = service.findById(1L);
		assertNull(owner);
	}

	@Test
	void testSave() {
		Owner saveOwner= new Owner();	
		saveOwner.setId(1L);
		saveOwner.setLastName("Kumar");
		when(ownerRepository.save(saveOwner)).thenReturn(returnOwner);
		Owner savedOwner= service.save(saveOwner);
		assertNotNull(savedOwner);
		verify(ownerRepository).save(saveOwner);
	}

	@Test
	void testDelete() {
		service.delete(returnOwner);
		verify(ownerRepository,times(1)).delete(returnOwner);
	}

	@Test
	void testDeleteById() {
		service.deleteById(1L);
		verify(ownerRepository,times(1)).deleteById(1L);
	}

	@Test
	void testFindByLastName() {
		when(ownerRepository.findByLastName(LAST_NAME)).thenReturn(returnOwner);
		Owner nirmal = service.findByLastName(LAST_NAME);
		assertEquals(LAST_NAME,nirmal.getLastName());
		verify(ownerRepository).findByLastName(LAST_NAME);
	}

}
