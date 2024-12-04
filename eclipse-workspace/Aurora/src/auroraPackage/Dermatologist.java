package auroraPackage;

//import all classes from the java util package
import java.util.*;

//Dermatologist class
public class Dermatologist {
    private String name;
    private Set<String> availableDates;
 // Keeps track of booked times per date
    private Map<String, Set<String>> bookedTimes; 

    public Dermatologist(String name, String[] availableDays) {
        this.name = name;
        this.availableDates = new HashSet<>(Arrays.asList(availableDays));
        this.bookedTimes = new HashMap<>();
    }

    public String getName() {
        return name;
    }
//check if the dermalogist is available
    public boolean isAvailable(String date, String time) {
        if (!availableDates.contains(date)) {
            return false;
        }

        Set<String> bookedSlots = bookedTimes.getOrDefault(date, new HashSet<>());
        //if the time slot is not booked, it return true
        return !bookedSlots.contains(time);
    }

    public void bookTime(String date, String time) {
        bookedTimes.putIfAbsent(date, new HashSet<>());
        bookedTimes.get(date).add(time);
    }
}




