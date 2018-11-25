package InternalStructure;

import modelo.Lance;
import InterfaceParts.InterfaceLogicClientServer;
import cip.InterfacePort;

public class PortLogicClientServer extends InterfacePort implements InterfaceLogicClientServer {

	private PortEnviarJogadaLogicNGProxyOutbox outbox;
	
	@Override
	public void initialize() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void tratarLance(Lance lance) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void finalizarJogo() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void iniciarNovaPartida() {
		// TODO Auto-generated method stub
		
	}

}
