package InterfaceParts;

import java.util.ArrayList;

import InternalStructure.AtorJogador;
import InternalStructure.Creature;
import InternalStructure.Spell;
import InternalStructure.Status;
import cip.InterfacePort;
import cip.PortOutbox;

public class PortGUILogic extends InterfacePort implements InterfaceGUI {
	
	//private PortGUILogicOutbox outbox;
	private AtorJogador internalStructure;
	
	public void setInternalReference(AtorJogador gui){
		internalStructure = gui;
	}
	
	public PortOutbox getOutbox(){
		return outbox;
	}
	
	public PortGUILogic(String name) {
		id = name;
	}
	
	@Override
	public void initialize() {
		// TODO Auto-generated method stub
		outbox = new PortGUILogicOutbox();
	}

	@Override
	public void mostrarMensagem(String msg) {
		internalStructure.mostrarMensagem(msg);
	}

	@Override
	public void reportarErro(String msg) {
		internalStructure.reportarErro(msg);
	}

	@Override
	public Spell selecionarMagia(ArrayList<Spell> magiasDisponiveis) {
		return internalStructure.selecionarMagia(magiasDisponiveis);
	}

	@Override
	public Creature selecionarAlvo(ArrayList<Creature> possiveisAlvos) {
		return internalStructure.selecionarAlvo(possiveisAlvos);
	}

	@Override
	public void atualizarInterfaceGrafica() {
		internalStructure.atualizarInterfaceGrafica();
	}

	@Override
	public void mostrarOsCincoPersonagens() {
		internalStructure.mostrarOsCincoPersonagens();
	}

	@Override
	public void anunciarVitoriaDosJogadores() {
		internalStructure.anunciarVitoriaDosJogadores();
	}

	@Override
	public void anunciarVitoriaDoZargon() {
		internalStructure.anunciarVitoriaDoZargon();
	}

	@Override
	public void mostrarInventario(int gold) {
		internalStructure.mostrarInventario(gold);
	}

	@Override
	public void mostrarInformacoes(byte body, byte mind, byte movement,
			Status status, int linha, int coluna, Byte roundsToSleep) {
		internalStructure.mostrarInformacoes(body, mind, movement, status, linha, coluna, roundsToSleep);
	}

	@Override
	public void exibirCriaturas() {
		internalStructure.exibirCriaturas();
	}

	@Override
	public void mostrarAcaoTrap(byte dano, Creature criatura) {
		internalStructure.mostrarAcaoTrap(dano, criatura);
	}

	@Override
	public void mostrarDano(Creature alvo, byte dano, boolean seAtacou) {
		internalStructure.mostrarDano(alvo, dano, seAtacou);
	}

	@Override
	public void anunciarMorteDeCriatura(Creature alvo) {
		internalStructure.anunciarMorteDeCriatura(alvo);
	}

	@Override
	public void anunciarUsoDeMagia(Creature caster, Spell magia, Creature alvo,
			byte dano, Status status) {
		internalStructure.anunciarUsoDeMagia(caster, magia, alvo, dano, status);
	}

	@Override
	public void anunciarMorteDesafortunada(Creature criatura) {
		internalStructure.anunciarMorteDesafortunada(criatura);
	}

	@Override
	public void atualizarArredoresJogador() {
		internalStructure.atualizarArredoresJogador();
	}

	@Override
	public int escolherPorta(ArrayList<String> portaIds) {
		return internalStructure.escolherPorta(portaIds);
	}

	@Override
	public void mostrarRemocaoTrap() {
		internalStructure.mostrarRemocaoTrap();
	}

	@Override
	public byte mostrarOpcoesFallingRock() {
		return internalStructure.mostrarOpcoesFallingRock();
	}

	@Override
	public byte mostrarOpcoesPit() {
		return internalStructure.mostrarOpcoesPit();
	}

}
