package com.novi.bootcamp.novifsdbackendeindopdrachtsoundwwiseprototype.dtos;

public class FileDTO {
    private int fileId;
    private String fileName;
    private String fileUrl;

    public FileDTO() {
    }

    public FileDTO(int fileId, String fileName, String fileUrl) {
        this.fileId = fileId;
        this.fileName = fileName;
        this.fileUrl = fileUrl;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFileUrl() {
        return fileUrl;
    }

    public void setFileUrl(String fileUrl) {
        this.fileUrl = fileUrl;
    }

    public int getFileId() {
        return fileId;
    }

    public void setFileId(int fileId) {
        this.fileId = fileId;
    }
}
