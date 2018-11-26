package InterfaceParts;

import InternalStructure.AtorJogador;
import cip.ComponentInterface;
import cip.InterfacePort;
import cip.PortOutbox;

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
		PortOutbox l = portLogic.getOutbox();
		PortOutbox p = portProxy.getOutbox();
/*		System.out.println(l);
		System.out.println(p);*/
		frame = new AtorJogador(l, p);
		frame.setVisible(true);
		
		((PortGUILogic) portLogic).setInternalReference(frame);
	}
}
