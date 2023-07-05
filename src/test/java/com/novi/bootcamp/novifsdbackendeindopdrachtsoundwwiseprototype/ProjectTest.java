package com.novi.bootcamp.novifsdbackendeindopdrachtsoundwwiseprototype;

import com.novi.bootcamp.novifsdbackendeindopdrachtsoundwwiseprototype.models.File;
import com.novi.bootcamp.novifsdbackendeindopdrachtsoundwwiseprototype.models.Project;
import com.novi.bootcamp.novifsdbackendeindopdrachtsoundwwiseprototype.models.Song;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

public class ProjectTest {

    private Project project;

    @BeforeEach
    public void setUp() {
        project = new Project();
    }

    @Test
    public void testAddSongItem() {
        Song song = new Song();
        project.addSongItem(song);

        List<Song> songItems = project.getSongItems();
        assertTrue(songItems.contains(song));
    }

    @Test
    public void testRemoveSongItem() {
        Song song = new Song();
        project.addSongItem(song);
        project.removeSongItem(song);

        List<Song> songItems = project.getSongItems();
        assertFalse(songItems.contains(song));
    }

    @Test
    public void testAddFileItem() {
        File file = new File();
        project.addFileItem(file);

        List<File> fileItems = project.getFileItems();
        assertTrue(fileItems.contains(file));
    }

    @Test
    public void testRemoveFileItem() {
        File file = new File();
        project.addFileItem(file);
        project.removeFileItem(file);

        List<File> fileItems = project.getFileItems();
        assertFalse(fileItems.contains(file));
    }

    @Test
    public void testAddContributor() {
        String contributor = "John Doe";
        project.addContributor(contributor);

        List<String> contributors = project.getContributors();
        assertTrue(contributors.contains(contributor));
    }

    @Test
    public void testRemoveContributor() {
        String contributor = "John Doe";
        project.addContributor(contributor);
        project.removeContributor(contributor);

        List<String> contributors = project.getContributors();
        assertFalse(contributors.contains(contributor));
    }

    @Test
    public void testSetSongItems() {
        List<Song> songItems = new ArrayList<>();
        Song song1 = new Song();
        Song song2 = new Song();
        songItems.add(song1);
        songItems.add(song2);

        project.setSongItems(songItems);

        List<Song> updatedSongItems = project.getSongItems();
        assertTrue(updatedSongItems.contains(song1));
        assertTrue(updatedSongItems.contains(song2));
    }
}

