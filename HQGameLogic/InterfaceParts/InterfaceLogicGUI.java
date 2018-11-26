package InterfaceParts;

import java.util.ArrayList;

import InternalStructure.AtorClientServer;
import InternalStructure.Creature;
import InternalStructure.Directions;
import InternalStructure.Position;

public interface InterfaceLogicGUI {
	public void abrirPorta(int id);
	
	public void abrirPortaTeclado();
	
	public void movimentar(Directions direcao);
	
	public Creature getCriaturaDaVez();
	
	public void atacar();
	
	public void usarMagia();
	
	public ArrayList<Creature> getCreatureQueue();
	
	public void procurarTesouro();
	
	public void selecionarPersonagem();
	
	public void selecionarPersonagemEscolhida(int resultado);
	
	public void procurarArmadilhaOuPortaSecreta();
	
	public void finalizarjogada();
	
	public boolean informarConectado();
	
	public void estabelecerConectado(boolean valor);
	
	public boolean informarEmAndamento();
	
	public void mostrarInventario();
	
	public void mostrarInformacoes(int creatureID);
	
	public Position getPosition(byte i, byte j);
	
	public void setNomeLocalPlayerAndServer(String idUsuario, String idServer);
	
	public AtorClientServer getAtorClienteServidor();
	
	public void selfDestruct();
}
