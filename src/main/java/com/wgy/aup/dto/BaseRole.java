package com.wgy.aup.dto;

import lombok.Data;

@Data
public class BaseRole {
    private Long id;

    private Long roleCode;

    private String name;

    private Boolean isDeleted;
}