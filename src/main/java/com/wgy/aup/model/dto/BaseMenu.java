package com.wgy.aup.model.dto;

import lombok.Data;

@Data
public class BaseMenu {
    private Long id;

    private Long code;

    private String name;

    private Long parentId;

    private Byte nodeType;

    private String iconUrl;

    private Integer level;

    private Boolean isDeleted;

    private Integer sort;

    private String linkUrl;

}