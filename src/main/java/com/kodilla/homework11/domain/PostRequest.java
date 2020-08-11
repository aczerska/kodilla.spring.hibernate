package com.kodilla.homework11.domain;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class PostRequest {
    private int id;
    private String message;
    private String extra;
}
