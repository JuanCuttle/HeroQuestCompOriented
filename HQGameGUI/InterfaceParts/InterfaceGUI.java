package InterfaceParts;

import java.util.ArrayList;

import InternalStructure.Creature;
import InternalStructure.Spell;
import InternalStructure.Status;

public interface InterfaceGUI {

	public void mostrarMensagem(String msg); 
	
	public void reportarErro(String msg); 
	
	public Spell selecionarMagia(ArrayList<Spell> magiasDisponiveis); 
	
	public Creature selecionarAlvo(ArrayList<Creature> possiveisAlvos); 
	
	public void atualizarInterfaceGrafica(); 
	
	public void mostrarOsCincoPersonagens(); 
	
	public void anunciarVitoriaDosJogadores(); 
	
	public void anunciarVitoriaDoZargon(); 
	
	public void mostrarInventario(int gold); 
	
	public void mostrarInformacoes(byte body, byte mind, byte movement,
			Status status, int linha, int coluna, Byte roundsToSleep); 
	
	public void exibirCriaturas(); 
	
	public void mostrarAcaoTrap(byte dano, Creature criatura); 
	
	public void mostrarDano(Creature alvo, byte dano, boolean seAtacou); 
	
	public void anunciarMorteDeCriatura(Creature alvo); 
	
	public void anunciarUsoDeMagia(Creature caster, Spell magia, Creature alvo,
			byte dano, Status status); 
	
	public void anunciarMorteDesafortunada(Creature criatura); 
	
	public void atualizarArredoresJogador(); 
	
	public int escolherPorta(ArrayList<String> portaIds); 
	
	public void mostrarRemocaoTrap(); 
	
	public byte mostrarOpcoesFallingRock(); 
	
	public byte mostrarOpcoesPit(); 
}
