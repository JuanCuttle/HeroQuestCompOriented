package InternalStructure;

import InterfaceParts.NetgamesProxyInterface;
import cip.StandardPortOutbox;

public class PortGUINGProxyOutbox extends StandardPortOutbox implements NetgamesProxyInterface {
	
	public PortNGProxyGUI portProxy;

	@Override
	public boolean conectar(String servidor, String nome) {
		return portProxy.conectar(servidor, nome);
	}

	@Override
	public boolean desconectar() {
		return portProxy.desconectar();
	}

	@Override
	public void iniciarPartida(int numJog) {
		portProxy.iniciarPartida(numJog);
	}

}
