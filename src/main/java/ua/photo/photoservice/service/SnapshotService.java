package ua.photo.photoservice.service;

import ua.photo.photoservice.domain.Snapshot;

import java.util.List;

public interface SnapshotService {

    List<Snapshot> getSnapshotsByFilter();
    Snapshot getLastSnapshotByCamId(Long camId);
    Snapshot saveSnapshot(Snapshot snapshot);

}
