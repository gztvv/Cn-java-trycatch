package model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import java.util.logging.SimpleFormatter;

public class Reservation {
    private Integer roomNumber;
    private Date checkOut;
    private Date checkIn;

    public Reservation(Integer roomNumber, Date checkOut, Date checkIn) {
        this.roomNumber = roomNumber;
        this.checkOut = checkOut;
        this.checkIn = checkIn;
    }

    private static SimpleDateFormat sdf = new SimpleDateFormat("dd/mm/yyyy");
    public Integer getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(Integer roomNumber) {
        this.roomNumber = roomNumber;
    }

    public Date getCheckOut() {
        return checkOut;
    }

    public Date getCheckIn() {
        return checkIn;
    }
    public long  duration (){
     long diff = checkOut.getTime() - checkIn.getTime();
        return TimeUnit.DAYS.convert(diff,TimeUnit.MILLISECONDS);
    }

    public void updateDates (Date checkIn, Date checkOut){
        this.checkIn = checkIn;
        this.checkOut = checkOut;
    }


    public String ToString () {
        return "Room: " + roomNumber + ", check-in: " + sdf.format(checkIn) + ", check-out: " + sdf.format(checkOut)
                + ", " + duration() + "nights";
    }

}
