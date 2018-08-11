package com.denysque.testdemo.core.pojo;

public class Forecast {
    private String position;
    private String accuratePosition;
    private String timeOfUpdate;
    private int degree;
    private int maxDegree;
    private int minDegree;

    public Forecast() {
    }

    public Forecast(String position, String accuratePosition, String timeOfUpdate, int degree, int maxDegree, int minDegree) {

        this.position = position;
        this.accuratePosition = accuratePosition;
        this.timeOfUpdate = timeOfUpdate;
        this.degree = degree;
        this.maxDegree = maxDegree;
        this.minDegree = minDegree;
    }

    public int getMaxDegree() {
        return maxDegree;
    }

    public void setMaxDegree(int maxDegree) {
        this.maxDegree = maxDegree;
    }

    public int getMinDegree() {
        return minDegree;
    }

    public void setMinDegree(int minDegree) {
        this.minDegree = minDegree;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getAccuratePosition() {
        return accuratePosition;
    }

    public void setAccuratePosition(String accuratePosition) {
        this.accuratePosition = accuratePosition;
    }

    public String getTimeOfUpdate() {
        return timeOfUpdate;
    }

    public void setTimeOfUpdate(String timeOfUpdate) {
        this.timeOfUpdate = timeOfUpdate;
    }

    public int getDegree() {
        return degree;
    }

    public void setDegree(int degree) {
        this.degree = degree;
    }
}
