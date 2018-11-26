package InterfaceParts;

import InternalStructure.AtorClientServer;
import cip.InterfacePort;
import cip.PortOutbox;

public class PortNGProxyGUI extends InterfacePort implements NetgamesProxyInterface {
	
	private AtorClientServer internalStructure;
	
	public PortOutbox getOutbox(){
		return outbox;
	}
	
	public PortNGProxyGUI(String name) {
		id = name;
	}

	@Override
	public void initialize() {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public boolean conectar(String servidor, String nome) {
		return internalStructure.conectar(servidor, nome);
	}

	@Override
	public boolean desconectar() {
		return internalStructure.desconectar();
	}

	@Override
	public void iniciarPartida(int numJog) {
		internalStructure.iniciarPartida(numJog);
	}

	public void setInternalReference(AtorClientServer atorClientServer) {
		// TODO Auto-generated method stub
		internalStructure = atorClientServer;
	}

}
