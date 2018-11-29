package InterfaceParts;

import InternalStructure.AtorClientServer;
import br.ufsc.inf.leobr.cliente.Jogada;
import br.ufsc.inf.leobr.cliente.OuvidorProxy;
import cip.InterfacePort;
import cip.PortOutbox;

public class PortNGProxyNGServer extends InterfacePort implements NetgamesProxyNGServer, OuvidorProxy {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//private PortNGProxyNGServerOutbox outbox;
	private AtorClientServer internalStructure;
	
	public void setInternalReference(AtorClientServer proxy){
		internalStructure = proxy;
	}
	
	public PortOutbox getOutbox(){
		return outbox;
	}
	
	public PortNGProxyNGServer(String name) {
		id = name;
	}
	
	@Override
	public void initialize() {
		// TODO Auto-generated method stub
		
		outbox = new PortNGProxyNGServerOutbox();
		((PortNGProxyNGServerOutbox) outbox).getProxy().addOuvinte(this); // This port will receive NGServer calls
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

	@Override
	public void iniciarNovaPartida(Integer posicao) {
		// TODO Auto-generated method stub
		internalStructure.iniciarNovaPartida(posicao);
	}
	
	

}
