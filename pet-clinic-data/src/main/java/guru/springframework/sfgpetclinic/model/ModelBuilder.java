package guru.springframework.sfgpetclinic.model;

public class ModelBuilder {
	
	private final String type;
	public static final String OWNER = "owner";
	public static final String VET = "vet";
	public static final String PET = "pet";
	public static final String PET_TYPE = "petType";
	public static final String SPECIALITY = "speciality";
	
	BaseEntity model;
	
	public ModelBuilder(String type) {
		this.type = type;
	}
	
}
