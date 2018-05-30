package com.filesample.service;

import com.filesample.dto.ContentDTO;
import com.filesample.dto.FileMetaDataDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class FileMetaDataService
{
    private static final Logger logger = LoggerFactory.getLogger(FileMetaDataService.class);
    private static final List<String> validExtensions = Arrays.asList("csv", "xlsx");

    /**
     * Scans the given directory and returns the meta data of a valid file
     *
     * @param directory the directory to scan
     * @return list of file meta data
     * @throws IOException IO Exception
     */
    public List<FileMetaDataDTO> getFiles(final String directory) throws IOException
    {
        Path path = Paths.get(directory);
        if (Files.exists(path))
        {
            logger.info("Given path [{}] is a valid directory", path);
            return Files.list(path)
                    .filter(Files::isRegularFile)
                    .filter(p -> {
                        String fileName = p.getFileName().toString();
                        return validExtensions.contains(fileName.substring(fileName.lastIndexOf(".") + 1));
                    })
                    .map(p -> {
                        try
                        {
                            String fileName = p.getFileName().toString();
                            String extension = fileName.substring(fileName.lastIndexOf(".") + 1);
                            return new FileMetaDataDTO(
                                    fileName,
                                    p.toFile().length() + " bytes",
                                    extension,
                                    Files.probeContentType(p),
                                    p);
                        }
                        catch (IOException exception)
                        {
                            logger.error("Error", exception);
                            throw new RuntimeException(exception);
                        }
                    })
                    .collect(Collectors.toList());
        }
        else
        {
            logger.info("Given path [{}] is a not valid directory", path);
            return Collections.emptyList();
        }
    }

    /**
     * Returns the content for all the files
     *
     * @param dtoList List of files containing content
     * @return the list of content
     */
    public List<ContentDTO> getContents(final List<FileMetaDataDTO> dtoList)
    {
        List<ContentDTO> contents = new ArrayList<>();
        dtoList.forEach(dto -> {
            try
            {
                Files.lines(dto.getPath()).forEach(content -> {
                    String list[] = content.split(",");
                    if (list.length == 3)
                    {
                        contents.add(new ContentDTO(list[0].trim(), list[1].trim(), list[2].trim()));
                    }
                });
            }
            catch (IOException exception)
            {
                logger.error("Error", exception);
                throw new RuntimeException(exception);
            }
        });
        return contents;
    }
}
