import InterfaceParts.HQGameGUI;
import InterfaceParts.HQGameLogic;
import InterfaceParts.HQNetgamesProxy;
import InterfaceParts.PortEnviarJogadaNGProxyLogic;
import InterfaceParts.PortLogicClientServer;
import InterfaceParts.PortLogicGUI;
import InterfaceParts.PortNGProxyGUI;
import InterfaceParts.PortNGProxyNGServer;
import InternalStructure.AtorClientServer;
import InternalStructure.HeroQuest;
import cip.InterfacePort;

public class HeroQuestCompOriented {
	
	public static void main(String[] args) {
		HQGameLogic logic = new HQGameLogic("logic");
		logic.initialize();
		
		HQGameGUI gui = new HQGameGUI("gui");
		gui.initialize();
		
		HQNetgamesProxy proxy = new HQNetgamesProxy("proxy");
		proxy.initialize();
		
		// logic <-> gui
		InterfacePort portGUI = logic.getPort("portGUI");
		InterfacePort portLogic = gui.getPort("portLogic");
		logic.connect(portLogic, "portGUI");
		gui.connect(portGUI, "portLogic");
		
		// logic <-> proxy
		InterfacePort portProxy = logic.getPort("portProxy");
		InterfacePort portProxyLogic = proxy.getPort("portLogic");
		logic.connect(portProxyLogic, "portProxy");
		proxy.connect(portProxy, "portLogic");
		
		// gui <-> proxy
		InterfacePort guiProxy = gui.getPort("portProxy");
		InterfacePort proxyGUI = proxy.getPort("portGUI");
		gui.connect(proxyGUI, "portProxy");
		proxy.connect(guiProxy, "portGUI");
		
		// Create basic game classes
		//AtorJogador frame = new AtorJogador(portLogic.getOutbox(), guiProxy.getOutbox());
		HeroQuest game = new HeroQuest(portGUI.getOutbox(), portProxy.getOutbox());
		AtorClientServer ngproxy = new AtorClientServer(proxy.getPort("portNG").getOutbox(), portProxyLogic.getOutbox());
		
		// Set internal references
		((PortLogicGUI) portGUI).setInternalReference(game);
		((PortLogicClientServer) portProxy).setInternalReference(game);
		
		((PortNGProxyGUI) proxyGUI).setInternalReference(ngproxy);
		((PortEnviarJogadaNGProxyLogic) portProxyLogic).setInternalReference(ngproxy);
		((PortNGProxyNGServer) proxy.getPort("portNG")).setInternalReference(ngproxy);
		
		// Start game GUI
		gui.initGUI();
	}
}
