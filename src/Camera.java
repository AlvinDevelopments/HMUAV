import java.util.Enumeration;
import java.util.Vector;

import javax.media.CaptureDeviceInfo;
import javax.media.CaptureDeviceManager;

public class Camera {
	

	/**
	 * A function that generates a list of CaptureDevices detected via the JMF (Java Media Framework)
	 * This class (as well as the current camera implementation) only works with a 32-bit JDK/JRE and will
	 * require JMF to be installed and configured for the list to generate the devices correctly.
	 * Will only work on Windows platforms**
	 * @return the first device in the list as CaptureDeviceInfo object.
	 */
	public static CaptureDeviceInfo run() {
	
	 VFWAuto vfwObj = new VFWAuto();

	    Vector devices = CaptureDeviceManager.getDeviceList(null);
	    Enumeration deviceEnum = devices.elements();

//	    System.out.println("Device count : " + devices.size());

	    while (deviceEnum.hasMoreElements()) {
	        CaptureDeviceInfo cdi = (CaptureDeviceInfo) deviceEnum.nextElement();
	        System.out.println("Device : " + cdi.getName());
	    }
	
	  devices = CaptureDeviceManager.getDeviceList(null);
	 CaptureDeviceInfo cam = (CaptureDeviceInfo)devices.get(0);
	 System.out.println(devices);
	 
	 	return cam;
	}

}
