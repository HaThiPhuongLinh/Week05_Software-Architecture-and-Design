package Static.Meaning;

import java.time.OffsetDateTime;
import java.util.Random;

public class FlightBookingService {
    private static Random random = new Random();

    int FAILURE = 0;
    int SUCCESS = 1;

    public int BookFlight(String flight, OffsetDateTime departureDt){
        if(random.nextDouble() > 0.95){
            return 0;
        }
        return 1;
    }
}
