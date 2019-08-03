package ee.tufan.sector.service;

import ee.tufan.sector.model.Sector;
import ee.tufan.sector.repository.SectorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.LinkedHashSet;
import java.util.List;

@Service("sectorService")
public class SectorServiceImpl implements SectorService {

	private SectorRepository sectorRepository;

	@Override
	public LinkedHashSet<Sector> getSectorList() {
		List<Sector> sectorList = sectorRepository.findAll();
		sectorList.sort(Comparator.comparing(Sector::getFullName));
		return new LinkedHashSet<>(sectorList);
	}

	@Autowired
	@Qualifier("sectorRepository")
	public void setSectorRepository(SectorRepository sectorRepository) {
		this.sectorRepository = sectorRepository;
	}

}
