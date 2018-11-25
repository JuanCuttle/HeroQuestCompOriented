package InternalStructure;

import InterfaceParts.PortEnviarJogadaNGProxyLogic;
import InterfaceParts.PortNGProxyGUI;
import InterfaceParts.PortNGProxyNGServer;
import cip.ComponentInterface;
import cip.InterfacePort;

public class HQNetgamesProxy extends ComponentInterface{
	
	private PortNGProxyGUI portGUI;
	private PortNGProxyNGServer portNG;
	private PortEnviarJogadaNGProxyLogic portLogic;

	@Override
	public void initialize() {
		// TODO Auto-generated method stub
		portGUI = new PortNGProxyGUI();
		portGUI.initialize();
		
		portNG = new PortNGProxyNGServer();
		portNG.initialize();
		
		portLogic = new PortEnviarJogadaNGProxyLogic();
		portLogic.initialize();
		
		add(portGUI);
		add(portNG);
		add(portLogic);
	}
	
	public void add(InterfacePort port){
		ports.add(port);
	}

}
