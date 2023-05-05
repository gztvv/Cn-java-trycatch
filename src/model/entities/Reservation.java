package model.entities;

import model.exceptions.DomainException;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Reservation {
    private Integer roomNumber;
    private Date checkOut;
    private Date checkIn;

    public Reservation(Integer roomNumber, Date checkOut, Date checkIn) throws DomainException{
        if (!checkOut.after(checkIn)) {
            throw new DomainException("Reservation dates for update must be future");
        }
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

    public void updateDates (Date checkIn, Date checkOut) throws DomainException {
        Date now = new Date();
        if (checkIn.before(now) || checkOut.before(now)) {
            throw new DomainException("Reservation dates for update must be future");
        }
        if (!checkOut.after(checkIn)) {
            throw new DomainException("Check out date must be after check in date");
        }

        this.checkIn = checkIn;
        this.checkOut = checkOut;

    }

    @Override
    public String toString () {
        return "Room: " + roomNumber + ", check-in: " + sdf.format(checkIn) + ", check-out: " + sdf.format(checkOut)
                + ", " + duration() + "nights";
    }

}
