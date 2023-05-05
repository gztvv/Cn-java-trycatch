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
     long diff =  checkIn.getTime() - checkOut.getTime();
        return TimeUnit.DAYS.convert(diff,TimeUnit.MILLISECONDS);
    }

    public String updateDates (Date checkIn, Date checkOut){
        Date now = new Date();
        if (checkIn.before(now) || checkOut.before(now)) {
            return "Erro reservation: dates for update need to be after the now date";
        }
        if (!checkOut.after(checkIn)) {
            return  "Check out date need to be after check-in date";
        }

        this.checkIn = checkIn;
        this.checkOut = checkOut;

        return null;

    }

    @Override
    public String toString () {
        return "Room: " + roomNumber + ", check-in: " + sdf.format(checkIn) + ", check-out: " + sdf.format(checkOut)
                + ", " + duration() + "nights";
    }

}
