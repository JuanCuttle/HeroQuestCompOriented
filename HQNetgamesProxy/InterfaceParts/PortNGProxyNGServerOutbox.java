package InterfaceParts;

import modelo.Lance;
import br.ufsc.inf.leobr.cliente.Proxy;
import br.ufsc.inf.leobr.cliente.exception.ArquivoMultiplayerException;
import br.ufsc.inf.leobr.cliente.exception.JahConectadoException;
import br.ufsc.inf.leobr.cliente.exception.NaoConectadoException;
import br.ufsc.inf.leobr.cliente.exception.NaoJogandoException;
import br.ufsc.inf.leobr.cliente.exception.NaoPossivelConectarException;
import cip.NonComponentPortOutbox;

public class PortNGProxyNGServerOutbox extends NonComponentPortOutbox {
	
	public Proxy proxy;
	
	
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
	
	public void enviarJogada(Lance lance) throws NaoJogandoException{
		proxy.enviaJogada(lance);
	}
	
	public void selfDestruct(){
		
	}
}
