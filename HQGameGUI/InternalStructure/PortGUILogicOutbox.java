package InternalStructure;

import java.util.ArrayList;

import modelo.Creature;
import modelo.Directions;
import modelo.Position;
import visao.AtorClientServer;
import InterfaceParts.InterfaceLogicGUI;
import cip.StandardPortOutbox;

public class PortGUILogicOutbox extends StandardPortOutbox implements InterfaceLogicGUI {

	@Override
	public void abrirPorta(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void abrirPortaTeclado() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void movimentar(Directions direcao) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Creature getCriaturaDaVez() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void atacar() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void usarMagia() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ArrayList<Creature> getCreatureQueue() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void procurarTesouro() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void selecionarPersonagem() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void selecionarPersonagemEscolhida(int resultado) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void procurarArmadilhaOuPortaSecreta() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void finalizarjogada() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean informarConectado() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void estabelecerConectado(boolean valor) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean informarEmAndamento() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void mostrarInventario() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mostrarInformacoes(int creatureID) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Position getPosition(byte i, byte j) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setNomeLocalPlayerAndServer(String idUsuario, String idServer) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public AtorClientServer getAtorClienteServidor() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void selfDestruct() {
		// TODO Auto-generated method stub
		
	}

}
