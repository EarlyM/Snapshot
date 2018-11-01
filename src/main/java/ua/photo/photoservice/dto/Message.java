package ua.photo.photoservice.dto;

public class Message<T> {

    private String phoneNumber;
    private T body;

    public Message() {
    }

    public Message(String phoneNumber, T body) {
        this.phoneNumber = phoneNumber;
        this.body = body;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public T getBody() {
        return body;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setBody(T body) {
        this.body = body;
    }
}
