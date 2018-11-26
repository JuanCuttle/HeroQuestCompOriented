package InterfaceParts;

import InternalStructure.HeroQuest;
import InternalStructure.Lance;
import cip.InterfacePort;
import cip.PortOutbox;

public class PortLogicClientServer extends InterfacePort implements InterfaceLogicClientServer {

	//private PortEnviarJogadaLogicNGProxyOutbox outbox;
	private HeroQuest internalStructure;
	
	public void setInternalReference(HeroQuest game){
		internalStructure = game;
	}
	
	public PortOutbox getOutbox(){
		return outbox;
	}
	
	public PortLogicClientServer(String name) {
		id = name;
	}
	
	@Override
	public void initialize() {
		// TODO Auto-generated method stub
		outbox = new PortEnviarJogadaLogicNGProxyOutbox();
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
