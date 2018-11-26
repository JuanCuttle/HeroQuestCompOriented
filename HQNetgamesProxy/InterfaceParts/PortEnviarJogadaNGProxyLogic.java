package InterfaceParts;

import InternalStructure.AtorClientServer;
import InternalStructure.Lance;
import cip.InterfacePort;
import cip.PortOutbox;

public class PortEnviarJogadaNGProxyLogic extends InterfacePort implements EnviarJogadaNGProxyInterface{

	//private PortEnviarJogadaNGProxyLogicOutbox outbox;
	private AtorClientServer internalStructure;
	
	public void setInternalReference(AtorClientServer proxy){
		internalStructure = proxy;
	}
	
	public PortOutbox getOutbox(){
		return outbox;
	}
	
	public PortEnviarJogadaNGProxyLogic(String name) {
		id = name;
	}
	
	@Override
	public void initialize() {
		// TODO Auto-generated method stub
		outbox = new PortEnviarJogadaNGProxyLogicOutbox();
	}

	@Override
	public void enviarJogada(Lance lance) {
		internalStructure.enviarJogada(lance);
	}

}
