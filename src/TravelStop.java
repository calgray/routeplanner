
/** Represents a stop on a bus route
 *
 * Once created, it should not change.
 */
public class TravelStop {
  
  private double m_latitutude;
  private double m_longitude;
  private String m_street;
  private String m_suburb;
  
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
    m_latitutude = latitude;
    m_longitude = longitude;
    m_street = street;
    m_suburb = suburb;
  }
  
  /** 
   * @return The latitude of the stop
   */
  public double getLatitude() {
    return m_latitutude;
  }
  
  /**
   * 
   * @return The longitude of the stop
   */
  public double getLongitude() {
    return m_longitude;
  }
  
  /**
   * 
   * @return The street the stop is on
   */
  public String getStreet() {
    return m_street;
  }
  
  /**
   * 
   * @return The suburb the stop is in
   */
  public String getSuburb() {
    return m_suburb;
  }
  
}
