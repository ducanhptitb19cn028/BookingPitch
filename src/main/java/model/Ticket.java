package model;

import java.math.BigDecimal;

public class Ticket {
    private int id;
    private String customerinfo;
    private String pitchinfo;
    private String timeslot;
    private String startdate;
    private String enddate;
    private BigDecimal estimatedtotalprice;
    public  Ticket(int id, String customerinfo, String pitchinfo, String timeslot, String startdate, String enddate, BigDecimal estimatedtotalprice){
        this.id = id;
        this.customerinfo = customerinfo;
        this.pitchinfo = pitchinfo;
        this.timeslot = timeslot;
        this.startdate = startdate;
        this.enddate = enddate;
        this.estimatedtotalprice = estimatedtotalprice;
    }

    public String getTimeslot() {
        return timeslot;
    }

    public void setTimeslot(String timeslot) {
        this.timeslot = timeslot;
    }

    public String getStartdate() {
        return startdate;
    }

    public void setStartdate(String startdate) {
        this.startdate = startdate;
    }

    public String getPitchinfo() {
        return pitchinfo;
    }

    public void setPitchinfo(String pitchinfo) {
        this.pitchinfo = pitchinfo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public BigDecimal getEstimatedtotalprice() {
        return estimatedtotalprice;
    }

    public void setEstimatedtotalprice(BigDecimal estimatedtotalprice) {
        this.estimatedtotalprice = estimatedtotalprice;
    }

    public String getEnddate() {
        return enddate;
    }

    public void setEnddate(String enddate) {
        this.enddate = enddate;
    }

    public String getCustomerinfo() {
        return customerinfo;
    }

    public void setCustomerinfo(String customerinfo) {
        this.customerinfo = customerinfo;
    }
}
