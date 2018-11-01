package ua.photo.photoservice.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import ua.photo.photoservice.component.MessageSender;
import ua.photo.photoservice.domain.Snapshot;
import ua.photo.photoservice.dto.Message;
import ua.photo.photoservice.repository.SnapshotRepository;
import ua.photo.photoservice.service.MessageService;

import javax.annotation.PostConstruct;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

@Service
@Repository
public class MessageServiceImpl implements MessageService {

    @Autowired
    private SnapshotRepository snapshotRepository;
    @Autowired
    private MessageSender sender;
    private Executor executor;

    @PostConstruct
    private void init(){
        executor = Executors.newFixedThreadPool(4);
    }

    @Override
    public void sendMessage(final Message<String> message) {
        executor.execute(() -> {
            Snapshot snapshot = snapshotRepository.findFirstByCamNumberOrderByDateDesc(Long.parseLong(message.getBody()));
            sender.sendMessage(new Message<>(message.getPhoneNumber(), snapshot.getPhoto()));

        });
    }

}
