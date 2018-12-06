package guru.springframework.sfgpetclinic.services.map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import guru.springframework.sfgpetclinic.model.Owner;

public class OwnerMapServiceTest {
	
	OwnerMapService ownerMapService;
	Long ownerId = 1L;
	String lastName="Nirmal";
	
	@BeforeEach
	void setUp() throws Exception {
		ownerMapService = new OwnerMapService( new PetMapService(), new PetTypeMapService());
		Owner owner = new Owner();
		owner.setId(ownerId);
		owner.setLastName(lastName);
		ownerMapService.save(owner);
	}

	@Test
	void testFindAll() {
		Set<Owner> ownerSet = ownerMapService.findAll();
		assertEquals(1, ownerSet.size());
	}

	@Test
	void testFindByIdLong() {
		assertEquals(ownerId,ownerMapService.findById(ownerId).getId());
	}

	@Test
	void testSaveExistingId() {
		Long id = 2L;
		Owner owner = new Owner();
		owner.setId(id);
		Owner saveOwner = ownerMapService.save(owner);
		assertEquals(id, saveOwner);
	}
	
	@Test
	void testSaveNoId() {
		Owner owner = new Owner();
		Owner saveOwner = ownerMapService.save(owner);
		assertNotNull( saveOwner);
		assertNotNull( saveOwner.getId());
	}

	@Test
	void testDeleteByIdLong() {
		ownerMapService.deleteById(ownerId);
		assertEquals(0, ownerMapService.findAll().size());
	}

	@Test
	void testDeleteOwner() {
		ownerMapService.delete(ownerMapService.findById(ownerId));
		assertEquals(0, ownerMapService.findAll().size());
	}

	@Test
	void testFindByLastName() {
		Owner owner = ownerMapService.findByLastName(lastName);
		assertNotNull(owner);
		assertEquals(lastName, owner.getLastName());
	}

}
