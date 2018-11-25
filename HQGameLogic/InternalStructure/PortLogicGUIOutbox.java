package InternalStructure;

import java.util.ArrayList;

import modelo.Creature;
import modelo.Spell;
import modelo.Status;
import InterfaceParts.InterfaceGUI;
import cip.StandardPortOutbox;

public class PortLogicGUIOutbox extends StandardPortOutbox implements InterfaceGUI {
	
	public PortGUILogic portGUI;

	@Override
	public void mostrarMensagem(String msg) {
		portGUI.mostrarMensagem(msg);
	}

	@Override
	public void reportarErro(String msg) {
		portGUI.reportarErro(msg);
	}

	@Override
	public Spell selecionarMagia(ArrayList<Spell> magiasDisponiveis) {
		return portGUI.selecionarMagia(magiasDisponiveis);
	}

	@Override
	public Creature selecionarAlvo(ArrayList<Creature> possiveisAlvos) {
		return portGUI.selecionarAlvo(possiveisAlvos);
	}

	@Override
	public void atualizarInterfaceGrafica() {
		portGUI.atualizarInterfaceGrafica();
	}

	@Override
	public void mostrarOsCincoPersonagens() {
		portGUI.mostrarOsCincoPersonagens();
	}

	@Override
	public void anunciarVitoriaDosJogadores() {
		portGUI.anunciarVitoriaDosJogadores();
	}

	@Override
	public void anunciarVitoriaDoZargon() {
		portGUI.anunciarVitoriaDoZargon();
	}

	@Override
	public void mostrarInventario(int gold) {
		portGUI.mostrarInventario(gold);
	}

	@Override
	public void mostrarInformacoes(byte body, byte mind, byte movement,
			Status status, int linha, int coluna, Byte roundsToSleep) {
		portGUI.mostrarInformacoes(body, mind, movement, status, linha, coluna, roundsToSleep);
	}

	@Override
	public void exibirCriaturas() {
		portGUI.exibirCriaturas();
	}

	@Override
	public void mostrarAcaoTrap(byte dano, Creature criatura) {
		portGUI.mostrarAcaoTrap(dano, criatura);
	}

	@Override
	public void mostrarDano(Creature alvo, byte dano, boolean seAtacou) {
		portGUI.mostrarDano(alvo, dano, seAtacou);
	}

	@Override
	public void anunciarMorteDeCriatura(Creature alvo) {
		portGUI.anunciarMorteDeCriatura(alvo);
	}

	@Override
	public void anunciarUsoDeMagia(Creature caster, Spell magia, Creature alvo,
			byte dano, Status status) {
		portGUI.anunciarUsoDeMagia(caster, magia, alvo, dano, status);
	}

	@Override
	public void anunciarMorteDesafortunada(Creature criatura) {
		portGUI.anunciarMorteDesafortunada(criatura);
	}

	@Override
	public void atualizarArredoresJogador() {
		portGUI.atualizarArredoresJogador();
	}

	@Override
	public int escolherPorta(ArrayList<String> portaIds) {
		return portGUI.escolherPorta(portaIds);
	}

	@Override
	public void mostrarRemocaoTrap() {
		portGUI.mostrarRemocaoTrap();
	}

	@Override
	public byte mostrarOpcoesFallingRock() {
		return portGUI.mostrarOpcoesFallingRock();
	}

	@Override
	public byte mostrarOpcoesPit() {
		return portGUI.mostrarOpcoesPit();
	}

}
