package cip;

public abstract class PortOutbox {
	
	public void connect(InterfacePort argExternalPort) { //empty
	}

	public void connectNonComponent(Object externalReference) {	//empty
	}
	
	public void disconnect(InterfacePort argExternalPort) { //empty
	}
	
	public abstract void disconnect();
}
