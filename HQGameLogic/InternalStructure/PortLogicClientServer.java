package InternalStructure;

import modelo.HeroQuest;
import modelo.Lance;
import InterfaceParts.InterfaceLogicClientServer;
import cip.InterfacePort;

public class PortLogicClientServer extends InterfacePort implements InterfaceLogicClientServer {

	private PortEnviarJogadaLogicNGProxyOutbox outbox;
	private HeroQuest internalStructure;
	
	@Override
	public void initialize() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void tratarLance(Lance lance) {
		internalStructure.tratarLance(lance);
	}

	@Override
	public void finalizarJogo() {
		internalStructure.finalizarJogo();
	}

	@Override
	public void iniciarNovaPartida(int posicao) {
		internalStructure.iniciarNovaPartida(posicao);
	}

}
