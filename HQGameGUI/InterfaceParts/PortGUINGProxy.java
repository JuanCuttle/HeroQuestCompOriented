package InterfaceParts;

import cip.InterfacePort;
import cip.PortOutbox;

public class PortGUINGProxy extends InterfacePort implements InterfaceGUINGProxy {
	
	//private PortGUINGProxyOutbox outbox;
	
	public PortGUINGProxy(String name) {
		id = name;
	}

	@Override
	public void initialize() {
		// TODO Auto-generated method stub
		outbox = new PortGUINGProxyOutbox();
	}
	
	public PortOutbox getOutbox(){
		return outbox;
	}

}
