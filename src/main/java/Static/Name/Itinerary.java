package Static.Name;

import java.util.List;

class Itinerary {
    private final List<ScheduleItem> scheduleItems;

    public Itinerary(List<ScheduleItem> scheduleItems) {
        this.scheduleItems = scheduleItems;
    }

    public void print() {
        for (ScheduleItem item : scheduleItems) {
            System.out.println(item.print());
        }
    }
}
