package InternalStructure;

import java.util.ArrayList;

import modelo.Creature;
import modelo.Spell;
import modelo.Status;
import InterfaceParts.InterfaceGUI;
import cip.InterfacePort;

public class PortGUILogic extends InterfacePort implements InterfaceGUI {
	
	private PortGUILogicOutbox outbox;

	@Override
	public void mostrarMensagem(String msg) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void reportarErro(String msg) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Spell selecionarMagia(ArrayList<Spell> magiasDisponiveis) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Creature selecionarAlvo(ArrayList<Creature> possiveisAlvos) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void atualizarInterfaceGrafica() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mostrarOsCincoPersonagens() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void anunciarVitoriaDosJogadores() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void anunciarVitoriaDoZargon() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mostrarInventario(int gold) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mostrarInformacoes(byte body, byte mind, byte movement,
			Status status, int linha, int coluna, Byte roundsToSleep) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void exibirCriaturas() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mostrarAcaoTrap(byte dano, Creature criatura) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mostrarDano(Creature alvo, byte dano, boolean seAtacou) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void anunciarMorteDeCriatura(Creature alvo) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void anunciarUsoDeMagia(Creature caster, Spell magia, Creature alvo,
			byte dano, Status status) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void anunciarMorteDesafortunada(Creature criatura) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void atualizarArredoresJogador() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int escolherPorta(ArrayList<String> portaIds) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void mostrarRemocaoTrap() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public byte mostrarOpcoesFallingRock() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public byte mostrarOpcoesPit() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void initialize() {
		// TODO Auto-generated method stub
		
	}

}
