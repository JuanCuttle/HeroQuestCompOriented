package cip;

import java.util.ArrayList;

public abstract class BroadcastPortOutbox extends PortOutbox {
	
	protected ArrayList<InterfacePort> externalPorts = new ArrayList<InterfacePort> ();
	
	public void connect(InterfacePort argExternalPort) {
		externalPorts.add(argExternalPort);
	}
	
	public void disconnect(InterfacePort argExternalPort) {
		for (int i = 0; i < externalPorts.size(); ++i) {
			InterfacePort aPort = externalPorts.get(i);
			if (aPort.getId() == argExternalPort.getId()) externalPorts.remove(argExternalPort);
			}
	}
	
	public void disconnect() {
		for (int i = 0; i < externalPorts.size(); ++i) {
			InterfacePort aPort = externalPorts.get(i);
			externalPorts.remove(aPort);
			}
	}

}
