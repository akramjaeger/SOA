package org.mdw31.tp2;


import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Path("/temperature")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class TemperatureRS {
    private static List<TemperatureData> temperatureDataList = new ArrayList<>();

    private List<TemperatureData> TempFilter = new ArrayList<>();

    @POST
    @Path("/submit")
    public String submitTemperaturedata( TemperatureData d) {
        temperatureDataList.add(d);
        return "Data received and processed.";
    }

    @GET
    @Path("/list")
    public List<TemperatureData> getStoredTemperatureData(){

        for (TemperatureData data : temperatureDataList) {
            System.out.println("Sensor ID: " + data.getSensorId() + ", Value: " + data.getValue());
        }


        return temperatureDataList;
    }

    @PUT
    @Path("/update/{sensorId}")
    public String updateTemperature(@PathParam("sensorId") String sensorId,TemperatureData Data1) {
        for (TemperatureData data : temperatureDataList) {
            if (data.getSensorId().equals(sensorId)){
                data.setValue(Data1.getValue());
                return "Update succeccfull";
            }
        }
        return "Update unsucceccfull";
    }

    @DELETE
    @Path("/delete/{sensorId}")
    public String DeleteTemperature(@PathParam("sensorId") String sensorId){
        for (TemperatureData data : temperatureDataList) {
            if (data.getSensorId().equals(sensorId)){
                temperatureDataList.remove(data);
                return "Delete succeccfull";
            }
        }
        return "Delete unsucceccfull";
    }
}
