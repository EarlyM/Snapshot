package ua.photo.photoservice.component.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import ua.photo.photoservice.component.MessageSender;
import ua.photo.photoservice.dto.Message;
import ua.photo.photoservice.dto.MmsDTO;
import ua.photo.photoservice.dto.SnapshotDTO;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.RenderedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

@Component
public class MessageSenderImpl implements MessageSender {

    public static final String PNG = "png";
    public static final String URL_TO_SMS_GATEWAY = null;

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public void sendMessage(Message<Image> message) throws IOException {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ImageIO.write((RenderedImage) message.getBody(), PNG, baos);
        MmsDTO dto = new MmsDTO(message.getPhoneNumber(), baos.toByteArray());
        restTemplate.postForEntity(URL_TO_SMS_GATEWAY, dto, MmsDTO.class);
    }
}
