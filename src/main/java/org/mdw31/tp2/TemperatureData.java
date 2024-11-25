package org.mdw31.tp2;

public class TemperatureData {
    private double value;
    private String sensorId;

    public TemperatureData() {

    }
    public double getValue() {

        return value;
    }

    public  String getSensorId() {

        return sensorId;
    }

    public void setValue(double value) {

        this.value = value;
    }

    public void setSensorId(String sensorId) {

        this.sensorId = sensorId;
    }
}
