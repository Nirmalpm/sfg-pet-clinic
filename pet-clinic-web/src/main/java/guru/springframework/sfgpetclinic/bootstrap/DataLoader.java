package guru.springframework.sfgpetclinic.bootstrap;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import guru.springframework.sfgpetclinic.model.Owner;
import guru.springframework.sfgpetclinic.model.Pet;
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
		dog.setName("dog");
		PetType savedDogPetType = petTypeService.save(dog);
		
		PetType cat = new PetType();
		cat.setName("cat");
		PetType savedCatPetType = petTypeService.save(cat);
		
		
		Owner owner1 =new Owner();
		owner1.setFirstName("Michel");
		owner1.setLastName("Jackson");
		owner1.setAddress("123 Brickerel");
		owner1.setCity("Miami");
		owner1.setTelephone("1232222");
		
		Pet mikesPet = new Pet();
		mikesPet.setPetType(savedDogPetType);
		mikesPet.setOwner(owner1);
		mikesPet.setName("Rosco");
		mikesPet.setBirthDate(LocalDate.now());
		owner1.getPets().add(mikesPet);
		
		ownerService.save(owner1);
		
		Owner owner2 =new Owner();
		owner2.setFirstName("Feona");
		owner2.setLastName("Johnson");
		owner2.setAddress("123 Brickerel");
		owner2.setCity("Miami");
		owner2.setTelephone("1232222");
		
		Pet feonasPet = new Pet();
		feonasPet.setPetType(savedCatPetType);
		feonasPet.setOwner(owner2);
		feonasPet.setName("Ruby");
		feonasPet.setBirthDate(LocalDate.now());
		owner2.getPets().add(feonasPet);
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
