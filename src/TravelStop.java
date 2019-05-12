
/** Represents a stop on a bus route
 *
 * Once created, it should not change.
 */
public class TravelStop {
  
  /** Create a TravelStop instance. Streets and suburbs will be checked for
   * validity by consulting an on-disk file, and an IllegalArgumentException
   * thrown if they do not exist.
   * 
   * @param latitude   Latitude of the stop
   * @param longitude  Longitude of the stop
   * @param street     Street the stop is on
   * @param suburb     Suburb the stop is in
   */
  public TravelStop(double latitude, double longitude, String street, String suburb) {

  }
  
  /** 
   * @return The latitude of the stop
   */
  public double getLatitude() {
    return 0;
  }
  
  /**
   * 
   * @return The longitude of the stop
   */
  public double getLongitude() {
    return 0;
  }
  
  /**
   * 
   * @return The street the stop is on
   */
  public String getStreet() {
    return "";
  }
  
  /**
   * 
   * @return The suburb the stop is in
   */
  public String getSuburb() {
    return "";
  }
  
}
