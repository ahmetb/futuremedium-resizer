package futuremedium.common2.images;

import java.util.Date;
import org.junit.*;
import static org.junit.Assert.*;

/**
 * Test driver for resizing images.
 * 
 * @author Future Medium Pty. Ltd - http://www.futuremedium.com.au/
 */
public class ImageResizeHandlerTest {

  static final String PATH = "d:\\";
  
  public ImageResizeHandlerTest() {
  }

  @BeforeClass
  public static void setUpClass() throws Exception {
  }

  @AfterClass
  public static void tearDownClass() throws Exception {
  }

  @Before
  public void setUp() {
  }

  @After
  public void tearDown() {
  }

  @Test
  public void testResize_wide() throws Exception {
    ImageResizeRequest request;
    ImageResizeService handler = new ImageResizeService();

    request = new ImageResizeRequest();
    request.setSourceFilePath(PATH + "input_wide.jpg");
    request.setTargetHeight(1000);
    request.setTargetWidth(1000);
    request.setMaintainAspect(true);
    request.setCropToAspect(false);
    request.setDestinationFilePath(PATH + "01_output_maintainaspect_nocrop_a.jpg");
    assertNotNull( handler.resize(request) );
    assertFalse( request.isCropped() );
    assertFalse( request.isResized() );

    request.setTargetHeight(300);
    request.setTargetWidth(300);
    request.setDestinationFilePath(PATH + "01_output_maintainaspect_nocrop_b.jpg");
    assertNotNull( handler.resize(request) );
    assertFalse( request.isCropped() );
    assertTrue( request.isResized() );

    request.setTargetHeight(1000);
    request.setTargetWidth(1000);
    request.setMaintainAspect(false);
    request.setCropToAspect(false);
    request.setDestinationFilePath(PATH + "01_output_nomaintainaspect_nocrop_a.jpg");
    assertNotNull( handler.resize(request) );
    assertFalse( request.isCropped() );
    assertFalse( request.isResized() );

    request.setTargetHeight(300);
    request.setTargetWidth(300);
    request.setDestinationFilePath(PATH + "01_output_nomaintainaspect_nocrop_b.jpg");
    assertNotNull( handler.resize(request) );
    assertFalse( request.isCropped() );
    assertTrue( request.isResized() );

    request.setTargetHeight(1000);
    request.setTargetWidth(1000);
    request.setMaintainAspect(true);
    request.setCropToAspect(true);
    request.setDestinationFilePath(PATH + "01_output_maintainaspect_croptoaspect_a.jpg");
    assertNotNull( handler.resize(request) );
    assertFalse( request.isCropped() );
    assertFalse( request.isResized() );

    request.setTargetHeight(300);
    request.setTargetWidth(300);
    request.setDestinationFilePath(PATH + "01_output_maintainaspect_croptoaspect_b.jpg");
    assertNotNull( handler.resize(request) );
    assertTrue( request.isCropped() );
    assertFalse( request.isResized() );

    request.setResizeAction(ImageResizeAction.ALWAYS);
    request.setDestinationFilePath(PATH + "01_output_maintainaspect_croptoaspect_c.jpg");
    assertNotNull( handler.resize(request) );
    assertTrue( request.isCropped() );
    assertTrue( request.isResized() );

    request.setResizeAction(ImageResizeAction.IF_SMALLER);
    request.setTargetHeight(1000);
    request.setTargetWidth(1000);
    request.setDestinationFilePath(PATH + "01_output_maintainaspect_croptoaspect_d.jpg");
    assertNotNull( handler.resize(request) );
    assertTrue( request.isCropped() );
    assertTrue( request.isResized() );
  }

  @Test
  public void testResize_high() throws Exception {
    ImageResizeRequest request;
    ImageResizeService handler = new ImageResizeService();

    request = new ImageResizeRequest();
    request.setSourceFilePath(PATH + "input_high.jpg");
    request.setTargetHeight(1000);
    request.setTargetWidth(1000);
    request.setMaintainAspect(true);
    request.setCropToAspect(false);
    request.setDestinationFilePath(PATH + "02_output_maintainaspect_nocrop_a.jpg");
    assertNotNull( handler.resize(request) );
    assertFalse( request.isCropped());
    assertFalse( request.isResized());

    request.setTargetHeight(300);
    request.setTargetWidth(300);
    request.setDestinationFilePath(PATH + "02_output_maintainaspect_nocrop_b.jpg");
    assertNotNull( handler.resize(request) );
    assertFalse( request.isCropped() );
    assertTrue( request.isResized() );

    request.setTargetHeight(1000);
    request.setTargetWidth(1000);
    request.setMaintainAspect(false);
    request.setCropToAspect(false);
    request.setDestinationFilePath(PATH + "02_output_nomaintainaspect_nocrop_a.jpg");
    assertNotNull( handler.resize(request) );
    assertFalse( request.isCropped());
    assertFalse( request.isResized());

    request.setTargetHeight(300);
    request.setTargetWidth(300);
    request.setDestinationFilePath(PATH + "02_output_nomaintainaspect_nocrop_b.jpg");
    assertNotNull( handler.resize(request) );
    assertFalse( request.isCropped());
    assertTrue( request.isResized());

    request.setTargetHeight(1000);
    request.setTargetWidth(1000);
    request.setMaintainAspect(true);
    request.setCropToAspect(true);
    request.setDestinationFilePath(PATH + "02_output_maintainaspect_croptoaspect_a.jpg");
    assertNotNull( handler.resize(request) );
    assertFalse( request.isCropped());
    assertFalse( request.isResized());

    request.setTargetHeight(300);
    request.setTargetWidth(300);
    request.setDestinationFilePath(PATH + "02_output_maintainaspect_croptoaspect_b.jpg");
    assertNotNull( handler.resize(request) );
    assertTrue( request.isCropped());
    assertFalse( request.isResized());

    request.setResizeAction(ImageResizeAction.ALWAYS);
    request.setDestinationFilePath(PATH + "02_output_maintainaspect_croptoaspect_c.jpg");
    assertNotNull( handler.resize(request) );
    assertTrue( request.isCropped() );
    assertTrue( request.isResized() );

    request.setResizeAction(ImageResizeAction.IF_SMALLER);
    request.setTargetHeight(1000);
    request.setTargetWidth(1000);
    request.setDestinationFilePath(PATH + "02_output_maintainaspect_croptoaspect_d.jpg");
    assertNotNull( handler.resize(request) );
    assertTrue( request.isCropped() );
    assertTrue( request.isResized() );
  }

  @Test
  public void testResize_wide_timer() throws Exception {
    ImageResizeRequest request;
    ImageResizeService handler = new ImageResizeService();

    Date now = new Date();
    long mills = now.getTime();
    
    for (int i = 0; i <100; i++) {
      request = new ImageResizeRequest();
      request.setSourceFilePath(PATH + "input_wide.jpg");
      request.setTargetHeight(1000);
      request.setTargetWidth(1000);
      request.setResizeAction(ImageResizeAction.ALWAYS);
      request.setMaintainAspect(true);
      request.setCropToAspect(false);
      request.setDestinationFilePath(PATH + "01_output_maintainaspect_nocrop_a.jpg");
      assertNotNull( handler.resize(request) );
    }
    
    now = new Date();
    
    System.out.println("TOTAL TIME: " + (now.getTime() - mills));
   }
}