package InternalStructure;

import visao.AtorClientServer;
import cip.InterfacePort;
import InterfaceParts.NetgamesProxyInterface;

public class PortNGProxyGUI extends InterfacePort implements NetgamesProxyInterface {
	
	private AtorClientServer internalStructure;

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

}
