package com.filesample.dto;

import java.io.Serializable;

public class ContentDTO implements Serializable
{
    private static final long serialVersionUID = 153614696006666822L;
    private final String vehicleNo;
    private final String model;
    private final String color;

    public ContentDTO(String vehicleNo, String model, String color)
    {
        this.vehicleNo = vehicleNo;
        this.model = model;
        this.color = color;
    }

    public String getVehicleNo()
    {
        return vehicleNo;
    }

    public String getModel()
    {
        return model;
    }

    public String getColor()
    {
        return color;
    }

    @Override
    public String toString()
    {
        return "ContentDTO{" +
                "vehicleNo='" + vehicleNo + '\'' +
                ", model='" + model + '\'' +
                ", color='" + color + '\'' +
                '}';
    }
}
