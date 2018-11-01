package ua.photo.photoservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.photo.photoservice.domain.Snapshot;


public interface SnapshotRepository extends JpaRepository<Snapshot, Long> {
    Snapshot findFirstByCamNumberOrderByDateDesc(Long camId);

}
