package InterfaceParts;

import InternalStructure.HeroQuest;
import cip.ComponentInterface;
import cip.InterfacePort;

public class HQGameLogic extends ComponentInterface {
	
	private PortLogicGUI portGUI;
	private PortLogicClientServer portProxy;
	
	public HQGameLogic(String name) {
		// TODO Auto-generated constructor stub
		id = name;
	}

	@Override
	public void initialize() {
		// TODO Auto-generated method stub
		portGUI = new PortLogicGUI("portGUI");
		portGUI.initialize();
		portProxy = new PortLogicClientServer("portProxy");
		portProxy.initialize();
		
		add(portGUI);
		add(portProxy);
	}
	
	public void add(InterfacePort port){
		ports.add(port);
	}

/*	public void initLogic(HeroQuest game){
		((PortLogicGUI) portGUI).setInternalReference(game);
		((PortLogicClientServer) portProxy).setInternalReference(game);
	}*/

}
