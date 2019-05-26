import static org.junit.Assert.*;

import org.junit.*;


public class TravelStopTest {

  private TravelStop m_travelStopNull;
  private TravelStop m_travelStop0;
  private TravelStop m_travelStop0Copy;
  private TravelStop m_travelStop1;

  /**
   * @throws java.lang.Exception
   */
  @BeforeClass
  public static void setUpBeforeClass() throws Exception {
  }

  /**
   * @throws java.lang.Exception
   */
  @AfterClass
  public static void tearDownAfterClass() throws Exception {
  }

  /**
   * @throws java.lang.Exception
   */
  @Before
  public void setUp() throws Exception {
    double latitude = 0.0;
    double longitude = 0.0;
    String street = "real street";
    String suburb = "real suburb";
    m_travelStop0 = new TravelStop(latitude, longitude, street, suburb);
    m_travelStop0Copy = new TravelStop(latitude, longitude, street, suburb);

    latitude = 110.0;
    longitude = 112.0;
    street = "real street 2";
    suburb = "real suburb 2";
    m_travelStop1 = new TravelStop(latitude, longitude, street, suburb);
  }

  /**
   * @throws java.lang.Exception
   */
  @After
  public void tearDown() throws Exception {
    // Assuming TravelStop is an immutable class
    testGetLatitude();
    testGetLongitude();
    testGetStreet();
    testGetSuburb();
  }

  /**
   * Test method for {@link TravelStop#TravelStop(double, double, java.lang.String, java.lang.String)}.
   * Tests the creation of a travel stop.
   * Pre-conditions: setUp has been called
   * Post-conditions: state remains const
   */
  @Test
  public void testTravelStop() {
    assertNull(m_travelStopNull);
    assertNotEquals(m_travelStop0, m_travelStop1);
    assertTrue(m_travelStop0 == m_travelStop0);
    assertFalse(m_travelStop0 == m_travelStop0Copy);
    assertNotEquals(m_travelStop0, m_travelStop0Copy); // equals override has not been implemented

    // Test creating an invalid location
    // NOTE: details about the interface to disk checking valid suburbs needs to be faked
    // in order to test this.
    double latitude = 10.0;
    double longitude = 11.0;
    String street = "fake street";
    String suburb = "real suburb";
    assertTrue(throwsIllegalArgumentException(() -> new TravelStop(latitude, longitude, street, suburb)));
  }

  /**
   * Test method for {@link TravelStop#getLatitude()}.
   * Pre-conditions: setUp has been called
   * Post-conditions: state remains const
   */
  @Test
  public void testGetLatitude() {
    assertEquals(0.0, m_travelStop0.getLatitude(), 0.0);
    assertEquals(m_travelStop0.getLatitude(), m_travelStop0Copy.getLatitude(), 0.0);
    assertEquals(110.0, m_travelStop1.getLatitude(),0.0);
  }

  /**
   * Test method for {@link TravelStop#getLongitude()}.
   * Pre-conditions: setUp has been called
   * Post-conditions: state remains const
   */
  @Test
  public void testGetLongitude() {
    assertEquals(0.0, m_travelStop0.getLongitude(), 0.0);
    assertEquals(m_travelStop0.getLongitude(), m_travelStop0Copy.getLongitude(), 0.0);
    assertEquals(112.0, m_travelStop1.getLongitude(), 0.0);
  }

  /**
   * Test method for {@link TravelStop#getStreet()}.
   * Pre-conditions: setUp has been called
   * Post-conditions: state remains const
   */
  @Test
  public void testGetStreet() {
    assertEquals("real street", m_travelStop0.getStreet());
    assertEquals(m_travelStop0.getStreet(), m_travelStop0Copy.getStreet());
    assertEquals("real street 2", m_travelStop1.getStreet());
  }

  /**
   * Test method for {@link TravelStop#getSuburb()}.
   * Pre-conditions: setUp has been called
   * Post-conditions: state remains const
   */
  @Test
  public void testGetSuburb() {
    assertEquals("real suburb", m_travelStop0.getSuburb());
    assertEquals(m_travelStop0.getSuburb(), m_travelStop0Copy.getSuburb());
  }

  // This pattern can be replaced with assertThrows in JUnit5
  private interface ThrowsInterface {
    void operation();
  }

  private boolean throwsIllegalArgumentException(ThrowsInterface object) {
    boolean hasThrown = false;
    try {
      object.operation();
    } catch(IllegalArgumentException e)
    {
      hasThrown = true;
    }
    return hasThrown;
  }
}
