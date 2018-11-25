package InternalStructure;

import modelo.Lance;
import InterfaceParts.LogicInterfaceClientServer;
import cip.StandardPortOutbox;

public class PortEnviarJogadaNGProxyLogicOutbox extends StandardPortOutbox implements LogicInterfaceClientServer {
	
	public PortLogicClientServer portLogic;

	@Override
	public void tratarLance(Lance lance) {
		portLogic.tratarLance(lance);
	}

	@Override
	public void finalizarJogo() {
		portLogic.finalizarJogo();
	}

	@Override
	public void iniciarNovaPartida(int posicao) {
		portLogic.iniciarNovaPartida();
	}

	
}
