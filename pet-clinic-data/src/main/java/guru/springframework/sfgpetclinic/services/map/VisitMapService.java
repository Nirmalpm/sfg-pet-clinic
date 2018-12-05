package guru.springframework.sfgpetclinic.services.map;

import java.util.Set;

import org.springframework.stereotype.Service;

import guru.springframework.sfgpetclinic.model.Visit;
import guru.springframework.sfgpetclinic.services.VisitService;

@Service
public class VisitMapService extends AbstractMapService<Visit, Long> implements VisitService {	
	
	@Override
	public Set<Visit> findAll() {
		return super.findAll();
	}

	@Override
	public Visit findById(Long id) {
		return super.findById(id);
	}

	@Override
	public Visit save(Visit Object) {
		if(Object.getPet() == null || Object.getPet().getOwner() == null
				||Object.getPet().getId() == null || Object.getPet().getOwner().getId() == null) {
			throw new RuntimeException("Invalid visit");
		}
		return super.Save(Object);
	}

	@Override
	public void delete(Visit Object) {
		super.delete(Object);
	}

	@Override
	public void deleteById(Long id) {
		super.deleteById(id);
	}

}
