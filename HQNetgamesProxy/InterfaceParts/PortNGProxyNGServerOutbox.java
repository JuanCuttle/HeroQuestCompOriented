package InterfaceParts;

import br.ufsc.inf.leobr.cliente.Jogada;
import br.ufsc.inf.leobr.cliente.Proxy;
import br.ufsc.inf.leobr.cliente.exception.ArquivoMultiplayerException;
import br.ufsc.inf.leobr.cliente.exception.JahConectadoException;
import br.ufsc.inf.leobr.cliente.exception.NaoConectadoException;
import br.ufsc.inf.leobr.cliente.exception.NaoJogandoException;
import br.ufsc.inf.leobr.cliente.exception.NaoPossivelConectarException;
import cip.NonComponentPortOutbox;

public class PortNGProxyNGServerOutbox extends NonComponentPortOutbox {
	
	//public AtorClientServer internalStructure;
	public Proxy proxy;
	
	
	public PortNGProxyNGServerOutbox(){
		proxy = Proxy.getInstance();
	}
	
	public boolean conectar(String servidor, String nome) throws JahConectadoException, NaoPossivelConectarException, ArquivoMultiplayerException{
		proxy.conectar(servidor, nome);
		return true;
	}
	
	public boolean desconectar() throws NaoConectadoException{
		proxy.desconectar();
		return true;
	}
	
	public void iniciarPartida(int numJog) throws NaoConectadoException{
		proxy.iniciarPartida(numJog);
	}
	
	public void enviarJogada(Jogada jogada) throws NaoJogandoException{
		proxy.enviaJogada(jogada);
	}
	
	public void selfDestruct(){
		
	}
	
	public Proxy getProxy(){
		return proxy;
	}

}
