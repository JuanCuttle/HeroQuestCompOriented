package InterfaceParts;

import java.util.ArrayList;

import InternalStructure.AtorClientServer;
import InternalStructure.Creature;
import InternalStructure.Directions;
import InternalStructure.Position;
import cip.InterfacePort;
import cip.StandardPortOutbox;

public class PortGUILogicOutbox extends StandardPortOutbox implements InterfaceLogicGUI {
	
	//public PortLogicGUI portLogic;
	
	public void connect(InterfacePort port){
		externalPort = port;
	}

	@Override
	public void abrirPorta(int id) {
		((InterfaceLogicGUI) externalPort).abrirPorta(id);
	}

	@Override
	public void abrirPortaTeclado() {
		((InterfaceLogicGUI) externalPort).abrirPortaTeclado();
	}

	@Override
	public void movimentar(Directions direcao) {
		((InterfaceLogicGUI) externalPort).movimentar(direcao);
	}

	@Override
	public Creature getCriaturaDaVez() {
		return ((InterfaceLogicGUI) externalPort).getCriaturaDaVez();
	}

	@Override
	public void atacar() {
		((InterfaceLogicGUI) externalPort).atacar();
	}

	@Override
	public void usarMagia() {
		((InterfaceLogicGUI) externalPort).usarMagia();
	}

	@Override
	public ArrayList<Creature> getCreatureQueue() {
		return ((InterfaceLogicGUI) externalPort).getCreatureQueue();
	}

	@Override
	public void procurarTesouro() {
		((InterfaceLogicGUI) externalPort).procurarTesouro();
	}

	@Override
	public void selecionarPersonagem() {
		((InterfaceLogicGUI) externalPort).selecionarPersonagem();
	}

	@Override
	public void selecionarPersonagemEscolhida(int resultado) {
		((InterfaceLogicGUI) externalPort).selecionarPersonagemEscolhida(resultado);
	}

	@Override
	public void procurarArmadilhaOuPortaSecreta() {
		((InterfaceLogicGUI) externalPort).procurarArmadilhaOuPortaSecreta();
	}

	@Override
	public void finalizarjogada() {
		((InterfaceLogicGUI) externalPort).finalizarjogada();
	}

	@Override
	public boolean informarConectado() {
		return ((InterfaceLogicGUI) externalPort).informarConectado();
	}

	@Override
	public void estabelecerConectado(boolean valor) {
		((InterfaceLogicGUI) externalPort).estabelecerConectado(valor);
	}

	@Override
	public boolean informarEmAndamento() {
		return ((InterfaceLogicGUI) externalPort).informarEmAndamento();
	}

	@Override
	public void mostrarInventario() {
		((InterfaceLogicGUI) externalPort).mostrarInventario();
	}

	@Override
	public void mostrarInformacoes(int creatureID) {
		((InterfaceLogicGUI) externalPort).mostrarInformacoes(creatureID);
	}

	@Override
	public Position getPosition(byte i, byte j) {
		return ((InterfaceLogicGUI) externalPort).getPosition(i, j);
	}

	@Override
	public void setNomeLocalPlayerAndServer(String idUsuario, String idServer) {
		((InterfaceLogicGUI) externalPort).setNomeLocalPlayerAndServer(idUsuario, idServer);
	}

	@Override
	public AtorClientServer getAtorClienteServidor() {
		return ((InterfaceLogicGUI) externalPort).getAtorClienteServidor();
	}

	@Override
	public void selfDestruct() {
		// TODO Auto-generated method stub
		
	}

}
