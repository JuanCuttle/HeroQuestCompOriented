package InternalStructure;

import br.ufsc.inf.leobr.cliente.Jogada;
import InterfaceParts.NetgamesProxyNGServer;
import cip.InterfacePort;

public class PortNGProxyNGServer extends InterfacePort implements NetgamesProxyNGServer {

	private PortNGProxyNGServerOutbox outbox;
	
	@Override
	public void initialize() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void finalizarPartidaComErro(String message) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void iniciarNovaPartida(int posicao) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void receberJogada(Jogada jogada) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void receberMensagem(String msg) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void tratarConexaoPerdida() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void tratarPartidaNaoIniciada(String message) {
		// TODO Auto-generated method stub
		
	}
	
	

}
