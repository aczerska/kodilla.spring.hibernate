package com.kodilla.homework11.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GetResponse {
    private long id;
    private String message;
    private String extra;
}
