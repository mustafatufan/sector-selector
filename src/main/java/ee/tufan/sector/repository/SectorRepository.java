package ee.tufan.sector.repository;

import ee.tufan.sector.model.Sector;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("sectorRepository")
public interface SectorRepository extends JpaRepository<Sector, Long> {
}
