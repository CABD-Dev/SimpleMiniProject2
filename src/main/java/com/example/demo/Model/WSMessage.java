package com.example.demo.Model;

import lombok.Data;

@Data
public class WSMessage {
    private int id_message;
    private String message;
    private Object data;

}
