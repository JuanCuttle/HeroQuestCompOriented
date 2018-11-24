package cip;

public abstract class StandardPortOutbox extends PortOutbox {
	
	protected InterfacePort externalPort;
	
	public void connect(InterfacePort argExternalPort) {
		externalPort = argExternalPort;
	}
	
	public  void disconnect() {
		externalPort = null;
	}
	
	public InterfacePort getExternalPort() {
		return externalPort;
	}
}
