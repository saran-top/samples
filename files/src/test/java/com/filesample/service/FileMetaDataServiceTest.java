package com.filesample.service;

import com.filesample.dto.FileMetaDataDTO;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class FileMetaDataServiceTest
{
    private static final Logger logger = LoggerFactory.getLogger(FileMetaDataServiceTest.class);

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
        logger.info("File content {}", new FileMetaDataService().getContents(list));
        assertNotNull(new FileMetaDataService().getContents(list));
    }
}