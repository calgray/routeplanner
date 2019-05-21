import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.Assert;

public class RoutePlannerTest {
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

  private RoutePlanner m_routePlanner;

  /**
   * @throws java.lang.Exception
   */
  @Before
  public void setUp() throws Exception {
        // Note the use of reference objects used here
        double startLongitude = 0.0;
        double startLatitude = 0.0;
        Integer leaveHour = 0;
        Integer leaveMinute = 0;
        double destinationLongitude = 0.0;
        double destinationLatitude = 0.0;
        Integer arriveHour = 0;
        Integer arriveMinute = 0;
    
        m_routePlanner = new RoutePlanner(
          startLongitude,
          startLatitude,
          leaveHour,
          leaveMinute,
          destinationLongitude,
          destinationLatitude,
          arriveHour, 
          arriveMinute);
  }

  /**
   * @throws java.lang.Exception
   */
  @After
  public void tearDown() throws Exception {
  }

  /**
   * Test method for {@link RoutePlanner#RoutePlanner(double, double, java.lang.Integer, java.lang.Integer, double, double, java.lang.Integer, java.lang.Integer)}.
   */
  @Test
  public void testRoutePlanner() {
    fail("Not yet implemented");
  }

  /**
   * Test method for {@link RoutePlanner#getStartLongitude()}.
   */
  @Test
  public void testGetStartLongitude() {
    Assert.assertEquals(m_routePlanner.getStartLongitude(), 0.0);
  }

  /**
   * Test method for {@link RoutePlanner#getStartLatitude()}.
   */
  @Test
  public void testGetStartLatitude() {
    Assert.assertEquals(m_routePlanner.getStartLatitude(), 0.0);
  }

  /**
   * Test method for {@link RoutePlanner#getLeaveHour()}.
   */
  @Test
  public void testGetLeaveHour() {
    Assert.assertEquals(m_routePlanner.getLeaveHour(), new Integer(0));
  }

  /**
   * Test method for {@link RoutePlanner#getLeaveMinute()}.
   */
  @Test
  public void testGetLeaveMinute() {
    Assert.assertEquals(m_routePlanner.getLeaveMinute(), new Integer(0));
  }

  /**
   * Test method for {@link RoutePlanner#getDestinationLongitude()}.
   */
  @Test
  public void testGetDestinationLongitude() {
    Assert.assertEquals(m_routePlanner.getDestinationLongitude(), 0.0);
  }

  /**
   * Test method for {@link RoutePlanner#getDestinationLatitude()}.
   */
  @Test
  public void testGetDestinationLatitude() {
    Assert.assertEquals(m_routePlanner.getDestinationLatitude(), 0.0);
  }

  /**
   * Test method for {@link RoutePlanner#getArriveHour()}.
   */
  @Test
  public void testGetArriveHour() {
    Assert.assertEquals(m_routePlanner.getArriveHour(), new Integer(0));
  }

  /**
   * Test method for {@link RoutePlanner#getArriveMinute()}.
   */
  @Test
  public void testGetArriveMinute() {
    Assert.assertEquals(m_routePlanner.getArriveMinute(), new Integer(0));
  }

  /**
   * Test method for {@link RoutePlanner#getDirections()}.
   */
  @Test
  public void testGetDirections() {
    fail("Not yet implemented");
  }

}
