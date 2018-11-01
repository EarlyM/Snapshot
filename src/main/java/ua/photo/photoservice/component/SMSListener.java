package ua.photo.photoservice.component;


import ua.photo.photoservice.dto.Message;

public interface SMSListener {

    void onMessage(Message<String> message);
}
