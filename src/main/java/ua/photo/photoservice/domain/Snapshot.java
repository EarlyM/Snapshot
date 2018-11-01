package ua.photo.photoservice.domain;

import javax.imageio.ImageIO;
import javax.persistence.*;
import java.awt.*;
import java.util.Date;

@Entity
@Table(name = "snapshots")
public class Snapshot {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;
    @Column(name = "cam_number")
    private Long camNumber;
    @Column(name = "photo")
    @Lob
    private Image photo;
    @Column(name = "created_date")
    @Temporal(value = TemporalType.TIMESTAMP)
    private Date date;

    public Snapshot() {

    }

    public Snapshot(Long id, Long camNumber, Image photo, Date date) {
        this.id = id;
        this.camNumber = camNumber;
        this.photo = photo;
        this.date = date;
    }


    public Long getId() {
        return id;
    }

    public Snapshot setId(Long id) {
        this.id = id;
        return this;
    }

    public Long getCamNumber() {
        return camNumber;
    }

    public Snapshot setCamNumber(Long camNumber) {
        this.camNumber = camNumber;
        return this;
    }

    public Image getPhoto() {
        return photo;
    }

    public Snapshot setPhoto(Image photo) {
        this.photo = photo;
        return this;
    }

    public Date getDate() {
        return date;
    }

    public Snapshot setDate(Date date) {
        this.date = date;
        return this;
    }
}
