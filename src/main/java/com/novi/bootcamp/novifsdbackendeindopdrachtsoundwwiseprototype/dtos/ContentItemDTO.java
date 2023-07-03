package com.novi.bootcamp.novifsdbackendeindopdrachtsoundwwiseprototype.dtos;

public class ContentItemDTO {
    private int contentItemId;
    private String contentItemName;

    // Constructors

    public ContentItemDTO() {
    }

    public ContentItemDTO(int contentItemId, String contentItemName) {
        this.contentItemId = contentItemId;
        this.contentItemName = contentItemName;
    }

    // Getters and Setters

    public int getContentItemId() {
        return contentItemId;
    }

    public void setContentItemId(int contentItemId) {
        this.contentItemId = contentItemId;
    }

    public String getContentItemName() {
        return contentItemName;
    }

    public void setContentItemName(String contentItemName) {
        this.contentItemName = contentItemName;
    }
}

