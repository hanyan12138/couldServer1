package com.pojo;

import java.util.Date;

public class View {
    private int id;
    private int pressure;
    private int temperature;
    private int humidity;
    private int co2;
    private int c2h2;
    private Date time;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPressure() {
        return pressure;
    }

    public void setPressure(int pressure) {
        this.pressure = pressure;
    }

    public int getTemperature() {
        return temperature;
    }

    public void setTemperature(int temperature) {
        this.temperature = temperature;
    }

    public int getHumidity() {
        return humidity;
    }

    public void setHumidity(int humidity) {
        this.humidity = humidity;
    }

    public int getCo2() {
        return co2;
    }

    public void setCo2(int co2) {
        this.co2 = co2;
    }

    public int getC2h2() {
        return c2h2;
    }

    public void setC2h2(int c2h2) {
        this.c2h2 = c2h2;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return  id +"," + pressure +
                "," + temperature +
                "," + humidity +
                "," + co2 +
                "," + c2h2 +
                "," + time
               ;
    }
}
