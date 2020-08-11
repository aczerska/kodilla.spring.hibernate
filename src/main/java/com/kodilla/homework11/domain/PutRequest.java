package com.kodilla.homework11.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PutRequest {
    private int id;
    private String message;
    private String extra;
}
