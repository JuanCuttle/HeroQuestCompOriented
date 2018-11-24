package cip;

import java.util.ArrayList;
import cip.InterfacePort;

public abstract class ComponentInterface {
	
	protected String id;
	protected ArrayList<InterfacePort> ports = new ArrayList<InterfacePort> ();
	
	public abstract void initialize();
	
	public String getIId()  {
		return id;
	}

	public InterfacePort getPort (String portId)  {
		for (int i = 0; i < ports.size(); ++i) {
			InterfacePort aPort = ports.get(i);
			if (aPort.getId() == portId) return aPort;
			}
		return null;
	}

	public void connect(InterfacePort externalPort , String portId) {
		InterfacePort myPort = this.getPort(portId);
		if (myPort != null) myPort.connect(externalPort);
	}

	public void connectNonComponent(Object externalReference, String portId) {
		InterfacePort myPort = this.getPort(portId);
		if (myPort != null) myPort.connectNonComponent(externalReference);		
	}

	public void disconnect(InterfacePort externalPort, String portId) {
		InterfacePort myPort = this.getPort(portId);
		if (myPort != null) myPort.disconnect(externalPort);	
	}

	public void disconnect(String portId) {
		InterfacePort myPort = this.getPort(portId);
		if (myPort != null) myPort.disconnect();		
	}

}