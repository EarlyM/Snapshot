package ua.photo.photoservice.component;

import ua.photo.photoservice.dto.Message;

import java.awt.*;
import java.io.IOException;

public interface MessageSender {

    void sendMessage(Message<Image> message) throws IOException;
}
