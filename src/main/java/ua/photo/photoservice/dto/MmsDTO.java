package ua.photo.photoservice.dto;

public class MmsDTO {

    private String phoneNumber;
    private byte[] image;

    public MmsDTO(String phoneNumber, byte[] image) {
        this.phoneNumber = phoneNumber;
        this.image = image;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }
}
