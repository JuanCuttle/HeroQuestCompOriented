package InterfaceParts;

import cip.ComponentInterface;
import cip.InterfacePort;

public class HQNetgamesProxy extends ComponentInterface{
	
	private PortNGProxyGUI portGUI;
	private PortNGProxyNGServer portNG;
	private PortEnviarJogadaNGProxyLogic portLogic;
	
	public HQNetgamesProxy(String name) {
		// TODO Auto-generated constructor stub
		id = name;
	}

	@Override
	public void initialize() {
		// TODO Auto-generated method stub
		portGUI = new PortNGProxyGUI("portGUI");
		portGUI.initialize();
		
		portNG = new PortNGProxyNGServer("portNG");
		portNG.initialize();
		
		portLogic = new PortEnviarJogadaNGProxyLogic("portLogic");
		portLogic.initialize();
		
		add(portGUI);
		add(portNG);
		add(portLogic);
	}
	
	public void add(InterfacePort port){
		ports.add(port);
	}
	
/*	public void initProxy(AtorClientServer proxy){
		((PortNGProxyGUI) portGUI).setInternalReference(proxy);
		((PortEnviarJogadaNGProxyLogic) portLogic).setInternalReference(proxy);
		((PortNGProxyNGServer) portNG).setInternalReference(proxy);
	}*/

}
