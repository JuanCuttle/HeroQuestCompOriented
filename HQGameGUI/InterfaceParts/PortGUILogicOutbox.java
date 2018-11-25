package InterfaceParts;

import java.util.ArrayList;

import modelo.Creature;
import modelo.Directions;
import modelo.Position;
import visao.AtorClientServer;
import InterfaceParts.InterfaceLogicGUI;
import InterfaceParts.PortLogicGUI;
import cip.StandardPortOutbox;

public class PortGUILogicOutbox extends StandardPortOutbox implements InterfaceLogicGUI {
	
	public PortLogicGUI portLogic;

	@Override
	public void abrirPorta(int id) {
		portLogic.abrirPorta(id);
	}

	@Override
	public void abrirPortaTeclado() {
		portLogic.abrirPortaTeclado();
	}

	@Override
	public void movimentar(Directions direcao) {
		portLogic.movimentar(direcao);
	}

	@Override
	public Creature getCriaturaDaVez() {
		return portLogic.getCriaturaDaVez();
	}

	@Override
	public void atacar() {
		portLogic.atacar();
	}

	@Override
	public void usarMagia() {
		portLogic.usarMagia();
	}

	@Override
	public ArrayList<Creature> getCreatureQueue() {
		return portLogic.getCreatureQueue();
	}

	@Override
	public void procurarTesouro() {
		portLogic.procurarTesouro();
	}

	@Override
	public void selecionarPersonagem() {
		portLogic.selecionarPersonagem();
	}

	@Override
	public void selecionarPersonagemEscolhida(int resultado) {
		portLogic.selecionarPersonagemEscolhida(resultado);
	}

	@Override
	public void procurarArmadilhaOuPortaSecreta() {
		portLogic.procurarArmadilhaOuPortaSecreta();
	}

	@Override
	public void finalizarjogada() {
		portLogic.finalizarjogada();
	}

	@Override
	public boolean informarConectado() {
		return portLogic.informarConectado();
	}

	@Override
	public void estabelecerConectado(boolean valor) {
		portLogic.estabelecerConectado(valor);
	}

	@Override
	public boolean informarEmAndamento() {
		return portLogic.informarEmAndamento();
	}

	@Override
	public void mostrarInventario() {
		portLogic.mostrarInventario();
	}

	@Override
	public void mostrarInformacoes(int creatureID) {
		portLogic.mostrarInformacoes(creatureID);
	}

	@Override
	public Position getPosition(byte i, byte j) {
		return portLogic.getPosition(i, j);
	}

	@Override
	public void setNomeLocalPlayerAndServer(String idUsuario, String idServer) {
		portLogic.setNomeLocalPlayerAndServer(idUsuario, idServer);
	}

	@Override
	public AtorClientServer getAtorClienteServidor() {
		return portLogic.getAtorClienteServidor();
	}

	@Override
	public void selfDestruct() {
		// TODO Auto-generated method stub
		
	}

}
