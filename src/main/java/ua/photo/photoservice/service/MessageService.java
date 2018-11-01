package ua.photo.photoservice.service;

import ua.photo.photoservice.dto.Message;

import java.awt.*;

public interface MessageService {

    void sendMessage(Message<String> message);
}
