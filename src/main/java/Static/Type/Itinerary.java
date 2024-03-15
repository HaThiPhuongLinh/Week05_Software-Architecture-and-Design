package Static.Type;

import java.util.ArrayList;
import java.util.List;

class Itinerary {
    private final List<ScheduleItem> scheduleItems;

    public Itinerary(List<ScheduleItem> scheduleItems) {
        this.scheduleItems = scheduleItems;
    }

    public String print() {
        List<String> printedSchedules = new ArrayList<>();
        for (ScheduleItem item : scheduleItems) {
            /*
            COMPILE ERROR
            printedSchedules is a collection of strings,
            therefore we can not add ScheduleItem instance
            into the collection.

           * printedSchedules.add(item); *
             */

            // FIXED
            printedSchedules.add(item.print());
        }
        return String.join("\n", printedSchedules);
    }
}
