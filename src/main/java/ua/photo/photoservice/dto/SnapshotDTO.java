package ua.photo.photoservice.dto;

public class SnapshotDTO {
    private Long cumId;
    private byte[] image;

    public SnapshotDTO() {
    }

    public SnapshotDTO(Long cumId, byte[] image) {
        this.cumId = cumId;
        this.image = image;
    }

    public Long getCumId() {
        return cumId;
    }

    public void setCumId(Long cumId) {
        this.cumId = cumId;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }
}
