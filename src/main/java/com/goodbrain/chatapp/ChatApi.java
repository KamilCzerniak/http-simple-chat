package com.goodbrain.chatapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@Controller
public class ChatApi {

    private MessageService messageService;

    @Autowired
    public ChatApi(MessageService messageService) {
        this.messageService = messageService;
    }

    @PostMapping("/handleChatMessage")
    @ResponseBody
    public void handleChatMessage(@RequestBody ChatMessage chatMessage) {
        messageService.getChatMessages().add(chatMessage);
    }

    @GetMapping("/windows")
    public String getWindows(Model model) {
        model.addAttribute("chatMessages", messageService.getChatMessages());
        return "chat";
    }

    @GetMapping("/app")
    public String getApp() {
        return "app";
    }

    @GetMapping("/")
    public String addContacts() {
        return "redirect:/contact";
    }


    @PostMapping("/chat")
    public String send(@RequestParam String ip,
                       @RequestParam String value,
                       Model model) {

        String[] contactDetails = ip.split(" ");

        ChatMessage chatMessage = new ChatMessage(contactDetails[0], contactDetails[1], value);
        HttpEntity<ChatMessage> entity = new HttpEntity<>(chatMessage);
        messageService.getChatMessages().add(chatMessage);
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.exchange(
                String.format("http://%s:3000/handleChatMessage", contactDetails[1]),
                HttpMethod.POST,
                entity,
                Void.class
        );

        model.addAttribute("chatMessage", new ChatMessage());
        return "sendMessage";
    }

    @GetMapping("/sendMessage")
    public String get(Model model) {
        model.addAttribute("chatMessage", new ChatMessage());
        model.addAttribute("contact", new Contact());
        model.addAttribute("contacts", messageService.getContacts());
        return "sendMessage";
    }

    @GetMapping("/contact")
    public String getContact(Model model) {
        model.addAttribute("contact", new Contact());
        model.addAttribute("contacts", messageService.getContacts());
        return "contact";
    }


    @PostMapping("/add")
    public String addContact(@RequestParam String name,
                             @RequestParam String ip,
                             Model model) {


        Contact contact = new Contact(name, ip);
        System.out.println(contact.getContactDetails());
        messageService.getContacts().add(contact);
        model.addAttribute("contact", new Contact());
        return "redirect:/contact";
    }

}
