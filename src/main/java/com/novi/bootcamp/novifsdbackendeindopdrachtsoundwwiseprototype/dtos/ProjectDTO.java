package com.novi.bootcamp.novifsdbackendeindopdrachtsoundwwiseprototype.dtos;

import com.novi.bootcamp.novifsdbackendeindopdrachtsoundwwiseprototype.models.Project;
import com.novi.bootcamp.novifsdbackendeindopdrachtsoundwwiseprototype.models.Song;
import com.novi.bootcamp.novifsdbackendeindopdrachtsoundwwiseprototype.models.File;

import java.util.ArrayList;
import java.util.List;

public class ProjectDTO {
    private int projectId;
    private String projectName;
    private String projectArtist;
    private String projectImage;
    private List<SongDTO> songItems;
    private List<FileDTO> fileItems;
    private List<String> contributors;
    private int userId;

    public ProjectDTO() {
        this.songItems = new ArrayList<>();
        this.fileItems = new ArrayList<>();
        this.contributors = new ArrayList<>();
    }

    public ProjectDTO(int projectId, String projectName, String projectArtist, String projectImage,
                      List<SongDTO> songItems, List<File> fileItems, List<String> contributors,
                      int userId) {
        this.projectId = projectId;
        this.projectName = projectName;
        this.projectArtist = projectArtist;
        this.projectImage = projectImage;
        this.songItems = songItems;
        this.fileItems = new ArrayList<>();
        this.contributors = contributors;
        this.userId = userId;

        if (fileItems != null) {
            for (File file : fileItems) {
                this.fileItems.add(new FileDTO(file.getFileName(), file.getFileUrl()));
            }
        }
    }

    public int getProjectId() {
        return projectId;
    }

    public void setProjectId(int projectId) {
        this.projectId = projectId;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getProjectArtist() {
        return projectArtist;
    }

    public void setProjectArtist(String projectArtist) {
        this.projectArtist = projectArtist;
    }

    public String getProjectImage() {
        return projectImage;
    }

    public void setProjectImage(String projectImage) {
        this.projectImage = projectImage;
    }

    public List<SongDTO> getSongItems() {
        return songItems;
    }

    public void setSongItems(List<SongDTO> songItems) {
        this.songItems = songItems;
    }

    public List<FileDTO> getFileItems() {
        return fileItems;
    }

    public void setFileItems(List<FileDTO> fileItems) {
        this.fileItems = fileItems;
    }

    public List<String> getContributors() {
        return contributors;
    }

    public void setContributors(List<String> contributors) {
        this.contributors = contributors;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public static ProjectDTO convertToDTO(Project project) {
        ProjectDTO dto = new ProjectDTO();
        dto.setProjectId(project.getProjectId());
        dto.setProjectName(project.getProjectName());
        dto.setProjectArtist(project.getProjectArtist());
        dto.setProjectImage(project.getProjectImage());
        dto.setUserId(project.getUser().getId()); // Set the user ID

        List<SongDTO> songDTOList = new ArrayList<>();
        for (Song song : project.getSongItems()) {
            SongDTO songDTO = new SongDTO(
                    song.getTitle(),
                    song.getArtist(),
                    song.getFilename(),
                    song.getFilePath(),
                    song.getProject()
            );
            songDTOList.add(songDTO);
        }
        dto.setSongItems(songDTOList);


        List<FileDTO> fileDTOList = new ArrayList<>();
        for (File file : project.getFileItems()) {
            FileDTO fileDTO = new FileDTO(file.getFileName(), file.getFileUrl());
            fileDTOList.add(fileDTO);
        }
        dto.setFileItems(fileDTOList);

        dto.setContributors(project.getContributors());

        return dto;
    }
}
