package guru.springframework.sfgpetclinic.bootstrap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import guru.springframework.sfgpetclinic.model.Owner;
import guru.springframework.sfgpetclinic.model.PetType;
import guru.springframework.sfgpetclinic.model.Vet;
import guru.springframework.sfgpetclinic.services.OwnerService;
import guru.springframework.sfgpetclinic.services.PetTypeService;
import guru.springframework.sfgpetclinic.services.VetService;

@Component
public class DataLoader implements CommandLineRunner{
	private final OwnerService ownerService;
	private final VetService vetService;
	private final PetTypeService petTypeService;
	
	@Autowired
	public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService) {
		super();
		this.ownerService = ownerService;
		this.vetService = vetService;
		this.petTypeService = petTypeService;
	}

	@Override
	public void run(String... args) throws Exception {
		
		PetType dog = new PetType();
		dog.setName("Kaizer");
		PetType savedDogPetType = petTypeService.save(dog);
		
		PetType cat = new PetType();
		cat.setName("Meaaw");
		PetType savedCatPetType = petTypeService.save(cat);
		
		Owner owner1 =new Owner();
		owner1.setFirstName("Michel");
		owner1.setLastName("Jackson");
		
		ownerService.save(owner1);
		
		Owner owner2 =new Owner();
		owner2.setFirstName("Chuck");
		owner2.setLastName("Johnson");
		
		ownerService.save(owner2);
		
		System.out.println("Loaded owners....");
		
		Vet vet1 = new Vet();
		vet1.setFirstName("Magic");
		vet1.setLastName("Jimpson");
		
		vetService.save(vet1);
		
		Vet vet2 = new Vet();
		vet2.setFirstName("Dina");
		vet2.setLastName("Mary");
		
		vetService.save(vet2);
		
		System.out.println("Loaded vets....");
		
	}

	
}
