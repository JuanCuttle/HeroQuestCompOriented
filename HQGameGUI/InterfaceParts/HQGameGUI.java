package InterfaceParts;

import InternalStructure.AtorJogador;
import cip.ComponentInterface;
import cip.InterfacePort;

public class HQGameGUI extends ComponentInterface {
	
	private PortGUILogic portLogic;
	private PortGUINGProxy portProxy;
	private AtorJogador frame;
	
	public HQGameGUI(String name) {
		// TODO Auto-generated constructor stub
		id = name;
	}

	@Override
	public void initialize() {
		// TODO Auto-generated method stub
		portLogic = new PortGUILogic("portLogic");
		portLogic.initialize();
		
		portProxy = new PortGUINGProxy("portProxy");
		portProxy.initialize();
		
		add(portLogic);
		add(portProxy);
	}

	public void add(InterfacePort port){
		ports.add(port);
	}
	
	public AtorJogador getFrame() {
		return frame;
	}
	
	public void initGUI(){
		frame = new AtorJogador(portLogic.getOutbox(), portProxy.getOutbox());
		frame.setVisible(true);
		((PortGUILogic) portLogic).setInternalReference(frame);
	}
}
