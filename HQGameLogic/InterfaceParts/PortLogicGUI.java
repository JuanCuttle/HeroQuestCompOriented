package InterfaceParts;

import java.util.ArrayList;

import InternalStructure.AtorClientServer;
import InternalStructure.Creature;
import InternalStructure.Directions;
import InternalStructure.HeroQuest;
import InternalStructure.Position;
import cip.InterfacePort;
import cip.PortOutbox;

public class PortLogicGUI extends InterfacePort implements InterfaceLogicGUI {
	
	//private PortLogicGUIOutbox outbox;
	private HeroQuest internalStructure;
	
	public void setInternalReference(HeroQuest game){
		internalStructure = game;
	}
	
	public PortOutbox getOutbox(){
		return outbox;
	}
	
	public PortLogicGUI(String name) {
		id = name;
	}
	
	@Override
	public void initialize() {
		// TODO Auto-generated method stub
		outbox = new PortLogicGUIOutbox();
	}
	
	@Override
	public void abrirPorta(int id) {
		internalStructure.abrirPorta(id);
	}

	@Override
	public void abrirPortaTeclado() {
		internalStructure.abrirPortaTeclado();
	}

	@Override
	public void movimentar(Directions direcao) {
		internalStructure.movimentar(direcao);
	}

	@Override
	public Creature getCriaturaDaVez() {
		return internalStructure.getCriaturaDaVez();
	}

	@Override
	public void atacar() {
		internalStructure.atacar();
	}

	@Override
	public void usarMagia() {
		internalStructure.usarMagia();
	}

	@Override
	public ArrayList<Creature> getCreatureQueue() {
		return internalStructure.getCreatureQueue();
	}

	@Override
	public void procurarTesouro() {
		internalStructure.procurarTesouro();
	}

	@Override
	public void selecionarPersonagem() {
		internalStructure.selecionarPersonagem();
	}

	@Override
	public void selecionarPersonagemEscolhida(int resultado) {
		internalStructure.selecionarPersonagemEscolhida(resultado);
	}

	@Override
	public void procurarArmadilhaOuPortaSecreta() {
		internalStructure.procurarArmadilhaOuPortaSecreta();
	}

	@Override
	public void finalizarjogada() {
		internalStructure.finalizarJogada();
	}

	@Override
	public boolean informarConectado() {
		return internalStructure.informarConectado();
	}

	@Override
	public void estabelecerConectado(boolean valor) {
		internalStructure.estabelecerConectado(valor);
	}

	@Override
	public boolean informarEmAndamento() {
		return internalStructure.informarEmAndamento();
	}

	@Override
	public void mostrarInventario() {
		internalStructure.mostrarInventario();
	}

	@Override
	public void mostrarInformacoes(int creatureID) {
		internalStructure.mostrarInformacoes(creatureID);
	}

	@Override
	public Position getPosition(byte i, byte j) {
		return internalStructure.getPosition(i, j);
	}

	@Override
	public void setNomeLocalPlayerAndServer(String idUsuario, String idServer) {
		internalStructure.setNomeLocalPlayerAndServer(idUsuario, idServer);
	}

	@Override
	public AtorClientServer getAtorClienteServidor() {
		return internalStructure.getAtorClienteServidor();
	}

	@Override
	public void selfDestruct() {
		// TODO Auto-generated method stub
		
	}

}
