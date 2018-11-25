package InternalStructure;

import visao.AtorJogador;
import InterfaceParts.PortGUILogic;
import InterfaceParts.PortGUINGProxy;
import cip.ComponentInterface;
import cip.InterfacePort;

public class HQGameGUI extends ComponentInterface {
	
	public static void main(String[] args) { // Test
		HQGameGUI gui = new HQGameGUI();
		gui.initialize();
	}
	
	private PortGUILogic portLogic;
	private PortGUINGProxy portProxy;

	@Override
	public void initialize() {
		// TODO Auto-generated method stub
		portLogic = new PortGUILogic();
		portLogic.initialize();
		
		portProxy = new PortGUINGProxy();
		portProxy.initialize();
		
		add(portLogic);
		add(portProxy);
		
		AtorJogador frame = new AtorJogador();
		frame.setVisible(true);
	}

	public void add(InterfacePort port){
		ports.add(port);
	}
}
