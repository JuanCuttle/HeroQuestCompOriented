package InterfaceParts;

import InternalStructure.Lance;
import cip.InterfacePort;
import cip.StandardPortOutbox;

public class PortEnviarJogadaLogicNGProxyOutbox extends StandardPortOutbox {
	
	//public PortEnviarJogadaNGProxyLogic portNGProxy;

	public void enviarJogada(Lance lance){
		((PortEnviarJogadaNGProxyLogic) externalPort).enviarJogada(lance);
	}
	
	public void selfDestruct(){
		
	}
	
	public void connect(InterfacePort port){
		externalPort = (PortEnviarJogadaNGProxyLogic) port;
	}
}
