package cip;

public abstract class NonComponentPortOutbox extends PortOutbox {
	
	protected Object externalReference;
	
	public void connectNonComponent(Object argExternalReference) {
		externalReference = argExternalReference;
	}
	
	public void disconnect() {
		externalReference = null;
	}

}
