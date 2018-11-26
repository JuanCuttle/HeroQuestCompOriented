package InterfaceParts;

import InterfaceParts.NetgamesProxyInterface;
import InterfaceParts.PortNGProxyGUI;
import cip.InterfacePort;
import cip.StandardPortOutbox;

public class PortGUINGProxyOutbox extends StandardPortOutbox implements NetgamesProxyInterface {
	
	//public PortNGProxyGUI portProxy;

	@Override
	public boolean conectar(String servidor, String nome) {
		return ((NetgamesProxyInterface) externalPort).conectar(servidor, nome);
	}

	@Override
	public boolean desconectar() {
		return ((NetgamesProxyInterface) externalPort).desconectar();
	}

	@Override
	public void iniciarPartida(int numJog) {
		((NetgamesProxyInterface) externalPort).iniciarPartida(numJog);
	}
	
	public void connect(InterfacePort port){
		externalPort = (PortNGProxyGUI) port;
	}

}
