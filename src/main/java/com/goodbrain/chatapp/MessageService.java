package com.goodbrain.chatapp;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Getter
@Setter
@AllArgsConstructor
public class MessageService {

    private List<Contact> contacts;
    private List<ChatMessage> chatMessages;

    public MessageService() {
        contacts = new ArrayList<>();
        chatMessages = new ArrayList<>();
    }


}
