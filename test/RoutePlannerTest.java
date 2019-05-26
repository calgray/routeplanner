import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.List;

public class RoutePlannerTest {
  /**
   * @throws java.lang.Exception
   */

  private RoutePlanner m_routePlannerNull;
  private RoutePlanner m_routePlanner0;
  private RoutePlanner m_routePlanner1;
  private RoutePlanner m_routePlanner1Copy;
  private RoutePlanner m_impossibleRoutePlanner;

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
    double startLongitude = 0.0;
    double startLatitude = 0.0;
    Integer leaveHour = 0;
    Integer leaveMinute = 0;
    double destinationLongitude = 0.0;
    double destinationLatitude = 0.0;
    Integer arriveHour = null;
    Integer arriveMinute = null;
    m_routePlanner0 = new RoutePlanner(startLongitude, startLatitude,
            leaveHour, leaveMinute,
            destinationLongitude, destinationLatitude,
            arriveHour, arriveMinute);

    startLongitude = 10.0;
    startLatitude = 11.0;
    leaveHour = null;
    leaveMinute = null;
    destinationLongitude = 20.0;
    destinationLatitude = 40.0;
    arriveHour = 5;
    arriveMinute = 8;
    m_routePlanner1 = new RoutePlanner(
            startLongitude, startLatitude,
            leaveHour, leaveMinute,
            destinationLongitude, destinationLatitude,
            arriveHour, arriveMinute);
    m_routePlanner1Copy = new RoutePlanner(startLongitude, startLatitude,
            leaveHour, leaveMinute,
            destinationLongitude, destinationLatitude,
            arriveHour, arriveMinute);

    startLongitude = 100.0;
    startLatitude = 200.0;
    leaveHour = null;
    leaveMinute = null;
    destinationLongitude = 190.0;
    destinationLatitude = 449.0;
    arriveHour = 6;
    arriveMinute = 3;
    m_impossibleRoutePlanner = new RoutePlanner(
            startLongitude, startLatitude,
            leaveHour, leaveMinute,
            destinationLongitude, destinationLatitude,
            arriveHour, arriveMinute);
  }

  /**
   * @throws java.lang.Exception
   */
  @After
  public void tearDown() throws Exception {
    // Assuming RoutePlanner is an immutable class
    testGetStartLongitude();
    testGetStartLatitude();
    testGetLeaveHour();
    testGetLeaveMinute();
    testGetDestinationLongitude();
    testGetDestinationLatitude();
    testGetLeaveHour();
    testGetLeaveMinute();
  }

  /**
   * Test method for {@link RoutePlanner#RoutePlanner(double, double, java.lang.Integer, java.lang.Integer, double, double, java.lang.Integer, java.lang.Integer)}.
   */
  @Test
  public void testRoutePlanner() {

    // Uninitialized class instance is null
    assertNull(m_routePlannerNull);

    assertTrue(m_routePlanner1 == m_routePlanner1);
    assertFalse(m_routePlanner1 == m_routePlanner1Copy);
    assertNotEquals(m_routePlanner0, m_routePlanner1);
    assertNotEquals(m_routePlanner0, m_routePlanner1Copy); // equals method not implemented

    // Either leave time, arrive time or both can be set to null
    assertFalse(throwsIllegalArgumentException(() -> new RoutePlanner(0,0, null,null,0,0,null, null)));
    assertTrue(throwsIllegalArgumentException(() -> new RoutePlanner(0,0,null,null,0,0,null, 0)));
    assertTrue(throwsIllegalArgumentException(() -> new RoutePlanner(0,0,null,null,0,0,0, null)));
    assertFalse(throwsIllegalArgumentException(() -> new RoutePlanner(0,0,null,null,0,0,0, 0)));

    assertTrue(throwsIllegalArgumentException(() -> new RoutePlanner(0,0, null,0,0,0,null, null)));
    assertTrue(throwsIllegalArgumentException(() -> new RoutePlanner(0,0,null,0,0,0,null, 0)));
    assertTrue(throwsIllegalArgumentException(() -> new RoutePlanner(0,0,null,0,0,0,0, null)));
    assertTrue(throwsIllegalArgumentException(() -> new RoutePlanner(0,0,null,0,0,0,0, 0)));

    assertTrue(throwsIllegalArgumentException(() -> new RoutePlanner(0,0, 0,null,0,0,null, null)));
    assertTrue(throwsIllegalArgumentException(() -> new RoutePlanner(0,0,0,null,0,0,null, 0)));
    assertTrue(throwsIllegalArgumentException(() -> new RoutePlanner(0,0,0,null,0,0,0, null)));
    assertTrue(throwsIllegalArgumentException(() -> new RoutePlanner(0,0,0,null,0,0,0, 0)));

    assertFalse(throwsIllegalArgumentException(() -> new RoutePlanner(0,0, 0,0,0,0,null, null)));
    assertTrue(throwsIllegalArgumentException(() -> new RoutePlanner(0,0,0,0,0,0,null, 0)));
    assertTrue(throwsIllegalArgumentException(() -> new RoutePlanner(0,0,0,0,0,0,0, null)));
    assertTrue(throwsIllegalArgumentException(() -> new RoutePlanner(0,0,0,0,0,0,0, 0)));
  }

  /**
   * Test method for {@link RoutePlanner#getStartLongitude()}.
   */
  @Test
  public void testGetStartLongitude() {
    assertEquals(0.0, m_routePlanner0.getStartLongitude(), 0.0);
    assertEquals(10.0, m_routePlanner1.getStartLongitude(), 0.0);
    assertEquals(10.0, m_routePlanner1Copy.getStartLongitude(), 0.0);
  }

  /**
   * Test method for {@link RoutePlanner#getStartLatitude()}.
   */
  @Test
  public void testGetStartLatitude() {
    assertEquals(0.0, m_routePlanner0.getStartLatitude(), 0.0);
    assertEquals(11.0, m_routePlanner1.getStartLatitude(), 0.0);
    assertEquals(11.0, m_routePlanner1Copy.getStartLatitude(), 0.0);
  }

  /**
   * Test method for {@link RoutePlanner#getLeaveHour()}.
   */
  @Test
  public void testGetLeaveHour() {
    assertEquals(0, (int)m_routePlanner0.getLeaveHour());
    assertNotNull(m_routePlanner1.getLeaveHour());
    assertNotNull(m_routePlanner1Copy.getLeaveHour());
  }

  /**
   * Test method for {@link RoutePlanner#getLeaveMinute()}.
   */
  @Test
  public void testGetLeaveMinute() {
    assertEquals(0, (int)m_routePlanner0.getLeaveMinute());
    assertNotNull(m_routePlanner1.getLeaveMinute());
    assertNotNull(m_routePlanner1Copy.getLeaveMinute());
  }

  /**
   * Test method for {@link RoutePlanner#getDestinationLongitude()}.
   */
  @Test
  public void testGetDestinationLongitude() {
    assertEquals(0.0, m_routePlanner0.getDestinationLongitude(), 0.0);
    assertEquals(20.0, m_routePlanner1.getDestinationLongitude(), 0.0);
    assertEquals(20.0, m_routePlanner1Copy.getDestinationLongitude(), 0.0);
  }

  /**
   * Test method for {@link RoutePlanner#getDestinationLatitude()}.
   */
  @Test
  public void testGetDestinationLatitude() {
    assertEquals(0.0, m_routePlanner0.getDestinationLatitude(), 0.0);
    assertEquals(40.0, m_routePlanner1.getDestinationLatitude(), 0.0);
    assertEquals(40.0, m_routePlanner1Copy.getDestinationLatitude(), 0.0);
  }

  /**
   * Test method for {@link RoutePlanner#getArriveHour()}.
   */
  @Test
  public void testGetArriveHour() {
    assertNotNull(m_routePlanner0.getArriveHour());
    assertEquals(5, (int)m_routePlanner1.getArriveHour());
    assertEquals(5, (int)m_routePlanner1Copy.getArriveHour());
  }

  /**
   * Test method for {@link RoutePlanner#getArriveMinute()}.
   */
  @Test
  public void testGetArriveMinute() {
    assertNotNull(m_routePlanner0.getArriveMinute());
    assertEquals(8, (int)m_routePlanner1.getArriveMinute());
    assertEquals(8, (int)m_routePlanner1Copy.getArriveMinute());
  }

  /**
   * Test method for {@link RoutePlanner#getDirections(String[])}.
   */
  @Test
  public void testGetDirections() {
    // Test arguments
    assertTrue(throwsIllegalArgumentException(() -> m_routePlanner0.getDirections(null)));
    assertTrue(throwsIllegalArgumentException(() -> m_routePlanner0.getDirections(new String[0])));
    assertFalse(throwsIllegalArgumentException(() -> m_routePlanner0.getDirections(new String[1])));
    assertTrue(throwsIllegalArgumentException(() -> m_routePlanner0.getDirections(new String[2])));
    // new initializer syntax
    assertTrue(throwsIllegalArgumentException(() -> m_routePlanner0.getDirections(new String[] {} )));
    assertFalse(throwsIllegalArgumentException(() -> m_routePlanner0.getDirections(new String[] { null } )));
    assertFalse(throwsIllegalArgumentException(() -> m_routePlanner0.getDirections(new String[] { "" } )));
    assertTrue(throwsIllegalArgumentException(() -> m_routePlanner0.getDirections(new String[] { "notempty" } )));
    assertTrue(throwsIllegalArgumentException(() -> m_routePlanner0.getDirections(new String[] { null, "notempty" } )));

    // Test routePlanner0 return value
    List<TravelStop> stops = m_routePlanner0.getDirections(new String[1]);
    assertNotNull(stops);

    //Check route start and end
    double routeStartError = 1.0;
    assertEquals(stops.get(0).getLongitude(), m_routePlanner0.getStartLongitude(), routeStartError);
    assertEquals(stops.get(0).getLatitude(), m_routePlanner0.getStartLatitude(), routeStartError);
    double routeDestinationError = 1.0;
    assertEquals(stops.get(stops.size()-1).getLongitude(), m_routePlanner0.getDestinationLatitude(), routeDestinationError);
    assertEquals(stops.get(stops.size()-1).getLatitude(), m_routePlanner0.getStartLatitude(), routeDestinationError);

    //Check for routePlanner mutation
    assertEquals(0.0, m_routePlanner0.getStartLongitude(), 0.0);
    assertEquals(0.0, m_routePlanner0.getStartLatitude(), 0.0);
    assertEquals(0, (int)m_routePlanner0.getLeaveHour());
    assertEquals(0, (int)m_routePlanner0.getLeaveMinute());
    assertEquals(0.0, m_routePlanner0.getDestinationLongitude(), 0.0);
    assertEquals(0.0, m_routePlanner0.getDestinationLatitude(), 0.0);
    assertNotNull(m_routePlanner0.getArriveHour());
    assertNotNull(m_routePlanner0.getArriveMinute());


    //Test impossibleRoutePlanner
    assertTrue(throwsIllegalStateException(() -> m_impossibleRoutePlanner.getDirections(new String[1])));

    //Check for routePlanner mutation
    assertEquals(100.0, m_impossibleRoutePlanner.getStartLongitude(), 0.0);
    assertEquals(200.0, m_impossibleRoutePlanner.getStartLatitude(), 0.0);
    assertNotNull(m_impossibleRoutePlanner.getLeaveHour());
    assertNotNull(m_impossibleRoutePlanner.getLeaveMinute());
    assertEquals(190.0, m_impossibleRoutePlanner.getDestinationLongitude(), 0.0);
    assertEquals(449.0, m_impossibleRoutePlanner.getDestinationLatitude(), 0.0);
    assertEquals(6, (int)m_impossibleRoutePlanner.getArriveHour());
    assertEquals(3, (int)m_impossibleRoutePlanner.getArriveMinute());
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

  private boolean throwsIllegalStateException(ThrowsInterface object) {
    boolean hasThrown = false;
    try {
      object.operation();
    } catch(IllegalStateException e)
    {
      hasThrown = true;
    }
    return hasThrown;
  }
}
