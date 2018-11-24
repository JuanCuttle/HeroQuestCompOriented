package InterfaceParts;

import br.ufsc.inf.leobr.cliente.Jogada;

public interface NetgamesProxyNGServer {
	public void finalizarPartidaComErro(String message);
	
	public void iniciarNovaPartida(int posicao);
	
	public void receberJogada(Jogada jogada);
	
	public void receberMensagem(String msg);
	
	public void tratarConexaoPerdida();
	
	public void tratarPartidaNaoIniciada(String message);
}
