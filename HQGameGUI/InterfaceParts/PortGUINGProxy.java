package InterfaceParts;

import cip.InterfacePort;

public class PortGUINGProxy extends InterfacePort implements InterfaceGUINGProxy {
	
	private PortGUINGProxyOutbox outbox;

	@Override
	public void initialize() {
		// TODO Auto-generated method stub
		outbox = new PortGUINGProxyOutbox();
	}

}
