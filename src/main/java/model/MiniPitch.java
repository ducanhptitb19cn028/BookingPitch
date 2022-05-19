package model;

import java.math.BigDecimal;

public class MiniPitch {
    private int pid;
    private String pitchtype;
    private String timeslot;
    private BigDecimal price;
    private boolean status;
    public MiniPitch(int pid, String pitchtype, String timeslot, BigDecimal price, boolean status) {
        this.pid = pid;
        this.pitchtype = pitchtype;
        this.timeslot = timeslot;
        this.price = price;
        this.status = status;
    }

    public String getTimeslot() {
        return timeslot;
    }

    public void setTimeslot(String timeslot) {
        this.timeslot = timeslot;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getPitchtype() {
        return pitchtype;
    }

    public void setPitchtype(String pitchtype) {
        this.pitchtype = pitchtype;
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }
}
