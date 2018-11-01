package ua.photo.photoservice.service.impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import ua.photo.photoservice.domain.Snapshot;
import ua.photo.photoservice.repository.SnapshotRepository;
import ua.photo.photoservice.service.SnapshotService;

import java.util.List;

@Service
@Repository
public class SnapshotServiceImpl implements SnapshotService {

    private static final Logger LOGGER = LogManager.getLogger(SnapshotServiceImpl.class);

    private SnapshotRepository snapshotRepository;

    @Autowired
    public SnapshotServiceImpl(SnapshotRepository snapshotRepository){
        this.snapshotRepository = snapshotRepository;
    }

    @Override
    public List<Snapshot> getSnapshotsByFilter() {
        return null;
    }

    @Override
    public Snapshot getLastSnapshotByCamId(Long camId) {
        return snapshotRepository.findFirstByCamNumberOrderByDateDesc(camId);
    }

    @Override
    public Snapshot saveSnapshot(Snapshot snapshot) {
        return snapshotRepository.save(snapshot);
    }
}
