package InterfaceParts;

import visao.AtorClientServer;
import modelo.Lance;
import cip.InterfacePort;

public class PortEnviarJogadaNGProxyLogic extends InterfacePort implements EnviarJogadaNGProxyInterface{

	private PortEnviarJogadaNGProxyLogicOutbox outbox;
	private AtorClientServer internalStructure;
	
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
