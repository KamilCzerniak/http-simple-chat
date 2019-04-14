package com.goodbrain.chatapp;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Contact {

    private String name;
    private String ip;
    private String contactDetails;


    public Contact(String name, String ip) {
        this.name = name;
        this.ip = ip;
        this.contactDetails = this.name + " " + this.ip;
    }
}
