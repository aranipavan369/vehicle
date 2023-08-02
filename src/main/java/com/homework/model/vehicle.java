package com.homework.model;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

@Data
@Builder
public class vehicle implements Serializable {
    private Long id;
    private String Name;
    private int cost;
}
