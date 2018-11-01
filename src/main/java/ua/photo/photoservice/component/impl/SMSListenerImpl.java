package ua.photo.photoservice.component.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ua.photo.photoservice.component.SMSListener;
import ua.photo.photoservice.dto.Message;
import ua.photo.photoservice.service.MessageService;

@Component
public class SMSListenerImpl implements SMSListener {

    @Autowired
    private MessageService messageService;


    @Override
    public void onMessage(Message<String> message) {
        messageService.sendMessage(message);
    }
}
