package InterfaceParts;

import visao.AtorClientServer;
import br.ufsc.inf.leobr.cliente.Jogada;
import cip.InterfacePort;

public class PortNGProxyNGServer extends InterfacePort implements NetgamesProxyNGServer {

	private PortNGProxyNGServerOutbox outbox;
	private AtorClientServer internalStructure;
	
	@Override
	public void initialize() {
		// TODO Auto-generated method stub
		outbox = new PortNGProxyNGServerOutbox();
	}

	@Override
	public void finalizarPartidaComErro(String message) {
		internalStructure.finalizarPartidaComErro(message);
	}

	@Override
	public void iniciarNovaPartida(int posicao) {
		internalStructure.iniciarNovaPartida(posicao);
	}

	@Override
	public void receberJogada(Jogada jogada) {
		internalStructure.receberJogada(jogada);
	}

	@Override
	public void receberMensagem(String msg) {
		internalStructure.receberMensagem(msg);
	}

	@Override
	public void tratarConexaoPerdida() {
		internalStructure.tratarConexaoPerdida();
	}

	@Override
	public void tratarPartidaNaoIniciada(String message) {
		internalStructure.tratarPartidaNaoIniciada(message);
	}
	
	

}
