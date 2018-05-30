package com.filesample.service;

import com.filesample.dto.FileMetaDataDTO;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class FileMetaDataServiceTest
{
    @Test
    public void getFiles() throws Exception
    {
        List<FileMetaDataDTO> list = new FileMetaDataService().getFiles("src/test/resources/");
        assertEquals(2, list.size());
    }

    @Test
    public void getContent() throws Exception
    {
        List<FileMetaDataDTO> list = new FileMetaDataService().getFiles("src/test/resources/");
        assertEquals(2, list.size());
        assertNotNull(new FileMetaDataService().getContents(list));
    }
}