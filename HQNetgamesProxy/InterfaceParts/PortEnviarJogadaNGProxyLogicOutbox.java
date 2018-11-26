package InterfaceParts;

import InterfaceParts.PortLogicClientServer;
import InternalStructure.Lance;
import cip.InterfacePort;
import cip.StandardPortOutbox;

public class PortEnviarJogadaNGProxyLogicOutbox extends StandardPortOutbox implements LogicInterfaceClientServer {
	
	//public PortLogicClientServer portLogic;

	@Override
	public void tratarLance(Lance lance) {
		((PortLogicClientServer) externalPort).tratarLance(lance);
	}

	@Override
	public void finalizarJogo() {
		((PortLogicClientServer) externalPort).finalizarJogo();
	}

	@Override
	public void iniciarNovaPartida(int posicao) {
		((PortLogicClientServer) externalPort).iniciarNovaPartida(posicao);
	}

	public void connect(InterfacePort port){
		externalPort = (PortLogicClientServer) port;
	}
	
}
