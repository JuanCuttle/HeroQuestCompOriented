package InternalStructure;

import InterfaceParts.PortLogicClientServer;
import InterfaceParts.PortLogicGUI;
import cip.ComponentInterface;
import cip.InterfacePort;

public class HQGameLogic extends ComponentInterface {
	
	private PortLogicGUI portGUI;
	private PortLogicClientServer portProxy;

	@Override
	public void initialize() {
		// TODO Auto-generated method stub
		portGUI = new PortLogicGUI();
		portGUI.initialize();
		portProxy = new PortLogicClientServer();
		portProxy.initialize();
		
		add(portGUI);
		add(portProxy);
	}
	
	public void add(InterfacePort port){
		ports.add(port);
	}

}
