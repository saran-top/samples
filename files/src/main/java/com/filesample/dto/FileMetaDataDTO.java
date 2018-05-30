package com.filesample.dto;

import java.io.Serializable;
import java.nio.file.Path;

public class FileMetaDataDTO implements Serializable
{
    private static final long serialVersionUID = 153614696006666822L;
    private final String name;
    private final String size;
    private final String extension;
    private final String mimeType;
    private final Path path;

    public FileMetaDataDTO(String name, String size, String extension, String mimeType, Path path)
    {
        this.name = name;
        this.size = size;
        this.extension = extension;
        this.mimeType = mimeType;
        this.path = path;
    }

    public String getName()
    {
        return name;
    }

    public String getSize()
    {
        return size;
    }

    public String getExtension()
    {
        return extension;
    }

    public String getMimeType()
    {
        return mimeType;
    }

    public Path getPath()
    {
        return path;
    }

    @Override
    public String toString()
    {
        return "FileMetaDataDTO{" +
                "name='" + name + '\'' +
                ", size='" + size + '\'' +
                ", extension='" + extension + '\'' +
                ", mimeType='" + mimeType + '\'' +
                ", path=" + path +
                '}';
    }
}
