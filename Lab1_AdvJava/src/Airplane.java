import java.time.LocalTime;
public class Airplane {
    private String flightNumber;
    private String destination;
    private LocalTime scheduleDeparture;
    private int delayMinutes;

    public Airplane(String flightNumber, String destination, LocalTime scheduleDeparture){
        this.flightNumber = flightNumber;
        this.destination = destination;
        this.scheduleDeparture = scheduleDeparture;
        this.delayMinutes = 0;
    }

    public String getFlightNumber(){
        return flightNumber;
    }

    public void setFlightNumber(String flightNumber){
        this.flightNumber = flightNumber;
    }

    public String getDestination(){
        return destination;
    }

    public void setDestination(String destination){
        this.destination = destination;
    }

    public LocalTime getScheduledDeparture(){
        return scheduleDeparture;
    }

    public void setScheduledDeparture(LocalTime scheduleDeparture){
        this.scheduleDeparture = scheduleDeparture;
    }

    public int getDelayMinutes(){
        return delayMinutes;
    }

    public void delay(int minutes){
        this.delayMinutes += minutes;
        this.scheduleDeparture = this.scheduleDeparture.plusMinutes(minutes);
    }

    public void checkStatus(){
        if(delayMinutes > 0){
            System.out.println("Flight"  + flightNumber +  " to "  +  destination  +  " is delayed by "  + delayMinutes +  " minutes. "  +  " New departure: "  + scheduleDeparture);
        }else{
            System.out.println("Flight"  + flightNumber +  " to "  + destination  +  "is on time. Departure: " + scheduleDeparture);
        }
    }

    public static void main(String[] args) {
 // Create Airplane objects
         Airplane flight1 = new Airplane("VN123", "Hanoi", LocalTime.of(10, 30));
         Airplane flight2 = new Airplane("VN456", "Da Nang", LocalTime.of(12, 45));
 // Display initial status
         System.out.println("=== Initial Flight Status ===");
         flight1.checkStatus();
         flight2.checkStatus();
 // Apply delay to flight1
        System.out.println("\n=== Applying Delay ===");
        flight1.delay(20); // delay by 20 minutes
        flight1.checkStatus();
 // Display updated departure times
        System.out.println("\n=== Updated Departure Times ===");
        System.out.println("Flight " +  flight1.getFlightNumber()  + " new departure: "  + flight1.getScheduledDeparture());
        System.out.println("Flight " +  flight2.getFlightNumber()  + " departure: "  + flight2.getScheduledDeparture());
 // Modify flight2 details using setters
        System.out.println("\n=== Updating Flight Details ===");
        flight2.setDestination("Hue");
        flight2.delay(15);
        System.out.println("Flight " +  flight2.getFlightNumber()  +  " new destination: " + flight2.getDestination());
        flight2.checkStatus();
 }
}
