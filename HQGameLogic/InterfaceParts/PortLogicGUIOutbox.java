package InterfaceParts;

import java.util.ArrayList;

import InterfaceParts.InterfaceGUI;
import InternalStructure.Creature;
import InternalStructure.Spell;
import InternalStructure.Status;
import cip.InterfacePort;
import cip.StandardPortOutbox;

public class PortLogicGUIOutbox extends StandardPortOutbox implements InterfaceGUI {
	
	//public PortGUILogic portGUI;
	
	public void connect(InterfacePort port){
		externalPort = (PortGUILogic) port;
	}

	@Override
	public void mostrarMensagem(String msg) {
		((InterfaceGUI) externalPort).mostrarMensagem(msg);
	}

	@Override
	public void reportarErro(String msg) {
		((InterfaceGUI) externalPort).reportarErro(msg);
	}

	@Override
	public Spell selecionarMagia(ArrayList<Spell> magiasDisponiveis) {
		return ((InterfaceGUI) externalPort).selecionarMagia(magiasDisponiveis);
	}

	@Override
	public Creature selecionarAlvo(ArrayList<Creature> possiveisAlvos) {
		return ((InterfaceGUI) externalPort).selecionarAlvo(possiveisAlvos);
	}

	@Override
	public void atualizarInterfaceGrafica() {
		((InterfaceGUI) externalPort).atualizarInterfaceGrafica();
	}

	@Override
	public void mostrarOsCincoPersonagens() {
		((InterfaceGUI) externalPort).mostrarOsCincoPersonagens();
	}

	@Override
	public void anunciarVitoriaDosJogadores() {
		((InterfaceGUI) externalPort).anunciarVitoriaDosJogadores();
	}

	@Override
	public void anunciarVitoriaDoZargon() {
		((InterfaceGUI) externalPort).anunciarVitoriaDoZargon();
	}

	@Override
	public void mostrarInventario(int gold) {
		((InterfaceGUI) externalPort).mostrarInventario(gold);
	}

	@Override
	public void mostrarInformacoes(byte body, byte mind, byte movement,
			Status status, int linha, int coluna, Byte roundsToSleep) {
		((InterfaceGUI) externalPort).mostrarInformacoes(body, mind, movement, status, linha, coluna, roundsToSleep);
	}

	@Override
	public void exibirCriaturas() {
		((InterfaceGUI) externalPort).exibirCriaturas();
	}

	@Override
	public void mostrarAcaoTrap(byte dano, Creature criatura) {
		((InterfaceGUI) externalPort).mostrarAcaoTrap(dano, criatura);
	}

	@Override
	public void mostrarDano(Creature alvo, byte dano, boolean seAtacou) {
		((InterfaceGUI) externalPort).mostrarDano(alvo, dano, seAtacou);
	}

	@Override
	public void anunciarMorteDeCriatura(Creature alvo) {
		((InterfaceGUI) externalPort).anunciarMorteDeCriatura(alvo);
	}

	@Override
	public void anunciarUsoDeMagia(Creature caster, Spell magia, Creature alvo,
			byte dano, Status status) {
		((InterfaceGUI) externalPort).anunciarUsoDeMagia(caster, magia, alvo, dano, status);
	}

	@Override
	public void anunciarMorteDesafortunada(Creature criatura) {
		((InterfaceGUI) externalPort).anunciarMorteDesafortunada(criatura);
	}

	@Override
	public void atualizarArredoresJogador() {
		((InterfaceGUI) externalPort).atualizarArredoresJogador();
	}

	@Override
	public int escolherPorta(ArrayList<String> portaIds) {
		return ((InterfaceGUI) externalPort).escolherPorta(portaIds);
	}

	@Override
	public void mostrarRemocaoTrap() {
		((InterfaceGUI) externalPort).mostrarRemocaoTrap();
	}

	@Override
	public byte mostrarOpcoesFallingRock() {
		return ((InterfaceGUI) externalPort).mostrarOpcoesFallingRock();
	}

	@Override
	public byte mostrarOpcoesPit() {
		return ((InterfaceGUI) externalPort).mostrarOpcoesPit();
	}

}
