package Static.Name;

import java.time.OffsetDateTime;

public class ScheduleItem {
    private String flight;
    private String origin;
    private String destination;
    private OffsetDateTime departureDt;
    private OffsetDateTime arrivalDt;

    public String getFlight() {
        return flight;
    }

    public void setFlight(String flight) {
        this.flight = flight;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public OffsetDateTime getDepartureDt() {
        return departureDt;
    }

    public void setDepartureDt(OffsetDateTime departureDt) {
        this.departureDt = departureDt;
    }

    public OffsetDateTime getArrivalDt() {
        return arrivalDt;
    }

    public void setArrivalDt(OffsetDateTime arrivalDt) {
        this.arrivalDt = arrivalDt;
    }

    public String print() {
        return "Flight " + flight + " from " + origin + " on " + departureDt + " to " + destination + " on " + arrivalDt;
    }
}



