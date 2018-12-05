package guru.springframework.sfgpetclinic.bootstrap;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import guru.springframework.sfgpetclinic.model.Owner;
import guru.springframework.sfgpetclinic.model.Pet;
import guru.springframework.sfgpetclinic.model.PetType;
import guru.springframework.sfgpetclinic.model.Speciality;
import guru.springframework.sfgpetclinic.model.Vet;
import guru.springframework.sfgpetclinic.model.Visit;
import guru.springframework.sfgpetclinic.services.OwnerService;
import guru.springframework.sfgpetclinic.services.PetTypeService;
import guru.springframework.sfgpetclinic.services.SpecialityService;
import guru.springframework.sfgpetclinic.services.VetService;
import guru.springframework.sfgpetclinic.services.VisitService;

@Component
public class DataLoader implements CommandLineRunner{
	private final OwnerService ownerService;
	private final VetService vetService;
	private final PetTypeService petTypeService;
	private final SpecialityService specialityService;
	private final VisitService visitService;
	
	@Autowired
	public DataLoader(OwnerService ownerService, VetService vetService, 
			PetTypeService petTypeService, SpecialityService specialityService,VisitService visitService) {
		this.ownerService = ownerService;
		this.vetService = vetService;
		this.petTypeService = petTypeService;
		this.specialityService = specialityService;
		this.visitService = visitService;
	}

	@Override
	public void run(String... args) throws Exception {
		
		int count = petTypeService.findAll().size();
		if(count == 0) {
			loadData();
		}
	}

	private void loadData() {
		PetType dog = new PetType();
		dog.setName("dog");
		PetType savedDogPetType = petTypeService.save(dog);
		
		PetType cat = new PetType();
		cat.setName("cat");
		PetType savedCatPetType = petTypeService.save(cat);
		
		Speciality radiology = new Speciality();
		radiology.setDescription("Radiology");
		Speciality savedRadiology = specialityService.save(radiology);
				
		Speciality surgery = new Speciality();
		surgery.setDescription("Surgery");
		Speciality savedSurgery = specialityService.save(surgery);
		
		Speciality dentistry = new Speciality();
		dentistry.setDescription("Dentistry");
		Speciality savedDentistry = specialityService.save(dentistry);
		
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
		
		Visit catVisit = new Visit();
		catVisit.setPet(feonasPet);
		catVisit.setDate(LocalDate.now());
		catVisit.setDescription("Sneezy kitty");
		visitService.save(catVisit);
		System.out.println("Loaded owners....");
			
		Vet vet1 = new Vet();
		vet1.setFirstName("Magic");
		vet1.setLastName("Jimpson");
		vet1.getSpecialities().add(savedRadiology);
		
		vetService.save(vet1);
		
		Vet vet2 = new Vet();
		vet2.setFirstName("Dina");
		vet2.setLastName("Mary");
		vet2.getSpecialities().add(savedSurgery);
		vetService.save(vet2);
		
		System.out.println("Loaded vets....");
	}

	
}
