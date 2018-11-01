package ua.photo.photoservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ua.photo.photoservice.domain.Snapshot;
import ua.photo.photoservice.dto.SnapshotDTO;
import ua.photo.photoservice.service.SnapshotService;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.concurrent.Callable;

@RestController
public class SnapshotController {


    private final SnapshotService snapshotService;

    @Autowired
    public SnapshotController(SnapshotService snapshotService) {
        this.snapshotService = snapshotService;
    }

    @GetMapping(value = "/photo/{camId}")
    public Callable<ResponseEntity<Snapshot>> getPhoto(@PathVariable Long camId){
        Snapshot snapshot = snapshotService.getLastSnapshotByCamId(camId);
        System.out.println(snapshot.getId());

        return () -> ResponseEntity.ok(snapshotService.getLastSnapshotByCamId(camId));
    }

    @PostMapping(value = "/photo")
    public Callable<ResponseEntity<?>> savePhoto(@RequestBody final SnapshotDTO snapshot){
        return () ->{
            snapshotService.saveSnapshot(dtoToEntry(snapshot));
            return ResponseEntity.status(HttpStatus.CREATED).build();
        };
    }

    private Snapshot dtoToEntry(SnapshotDTO dto) throws IOException {
        Image image = ImageIO.read(new ByteArrayInputStream(dto.getImage()));
        return new Snapshot().setCamNumber(dto.getCumId()).
                setPhoto(image);
    }




}
