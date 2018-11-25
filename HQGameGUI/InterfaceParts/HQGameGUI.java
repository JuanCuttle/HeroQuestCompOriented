package InterfaceParts;

import visao.AtorJogador;
import cip.ComponentInterface;
import cip.InterfacePort;

public class HQGameGUI extends ComponentInterface {
	
	private PortGUILogic portLogic;
	private PortGUINGProxy portProxy;
	private AtorJogador frame;

	@Override
	public void initialize() {
		// TODO Auto-generated method stub
		portLogic = new PortGUILogic("portLogic");
		portLogic.initialize();
		
		portProxy = new PortGUINGProxy("portProxy");
		portProxy.initialize();
		
		add(portLogic);
		add(portProxy);
		
		frame = new AtorJogador();
		frame.setVisible(true);
	}

	public void add(InterfacePort port){
		ports.add(port);
	}
	
	public AtorJogador getFrame() {
		return frame;
	}
}
