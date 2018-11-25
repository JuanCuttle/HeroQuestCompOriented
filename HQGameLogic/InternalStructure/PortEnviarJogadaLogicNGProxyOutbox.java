package InternalStructure;

import modelo.Lance;
import cip.StandardPortOutbox;

public class PortEnviarJogadaLogicNGProxyOutbox extends StandardPortOutbox {
	
	public PortEnviarJogadaNGProxyLogic portNGProxy;

	public void enviarJogada(Lance lance){
		portNGProxy.enviarJogada(lance);
	}
	
	public void selfDestruct(){
		
	}
	
	
}
