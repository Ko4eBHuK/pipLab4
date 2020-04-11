package util;

public class SendedDot {
    private String x;
    private String y;
    private String r;
    private String pointInArea;
    private String executionTime;
    private String currentTime;

    public SendedDot(String x, String y, String r, String pointInArea, String executionTime, String currentTime) {
        this.x = x;
        this.y = y;
        this.r = r;
        this.pointInArea = pointInArea;
        this.executionTime = executionTime;
        this.currentTime = currentTime;
    }
    public SendedDot() { }

    public String getX() {
        return x;
    }
    public void setX(String x) {
        this.x = x;
    }
    public String getY() {
        return y;
    }
    public void setY(String y) {
        this.y = y;
    }
    public String getR() {
        return r;
    }
    public void setR(String r) {
        this.r = r;
    }
    public String getPointInArea() {
        return pointInArea;
    }
    public void setPointInArea(String pointInArea) {
        this.pointInArea = pointInArea;
    }
    public String getExecutionTime() {
        return executionTime;
    }
    public void setExecutionTime(String executionTime) {
        this.executionTime = executionTime;
    }
    public String getCurrentTime() {
        return currentTime;
    }
    public void setCurrentTime(String currentTime) {
        this.currentTime = currentTime;
    }
}
