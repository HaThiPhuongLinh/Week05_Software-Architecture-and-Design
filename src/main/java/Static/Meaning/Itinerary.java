package Static.Meaning;

import java.util.List;

public class Itinerary {
    int TRUE = 1;
    int FALSE = 0;
    private final List<ScheduleItem> scheduleItems;

    public Itinerary(List<ScheduleItem> scheduleItems) {
        this.scheduleItems = scheduleItems;
    }

    public int BookItinerary() {
        var bookingService = new FlightBookingService();
        for (ScheduleItem item : scheduleItems) {
            int status = bookingService.BookFlight(
                    item.getFlight(),
                    item.getDepartureDt());

            // Check if BookFlight completed successfully by
            // comparing retuned result against string value.
            if (status == 1) {
                return 1;
            }
        }
        return 0;
    }
}
