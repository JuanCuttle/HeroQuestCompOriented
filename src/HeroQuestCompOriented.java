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
	
/*	public static void main(String[] args) { // Test
		HQGameGUI gui = new HQGameGUI();
		gui.initialize();
	}*/
/*	
	public static void main(String[] args) {
		// Instantiate components
		
		HQGameLogic logic = new HQGameLogic("logic");
		logic.initialize();
		
		HQGameGUI gui = new HQGameGUI("gui");
		gui.initialize();
		
		HQNetgamesProxy proxy = new HQNetgamesProxy("proxy");
		proxy.initialize();
		
		// Connect components
		
		// logic <-> gui
		InterfacePort guiLogic = gui.getPort("logic");
		InterfacePort logicGUI = logic.getPort("gui");
		logic.connect(logicGUI, "gui");
		gui.connect(guiLogic, "logic");
		
		// gui <-> proxy
		InterfacePort guiProxy = gui.getPort("portProxy");
		InterfacePort proxyGUI = proxy.getPort("portGUI");
		guiProxy.connect(proxyGUI);
		proxyGUI.connect(guiProxy);
		
		// logic <-> proxy
		InterfacePort logicProxy = logic.getPort("portProxy");
		InterfacePort proxyLogic = proxy.getPort("portLogic");
		logicProxy.connect(proxyLogic);
		proxyLogic.connect(logicProxy);
		
		gui.initGUI();
		((PortLogicGUI)logicGUI).setInternalReference(new HeroQuest(gui.getFrame()));
		
		// Connect port to non-component ???????
		InterfacePort proxyNG = proxy.getPort("portNG");
		proxyNG.connectNonComponent(new AtorClientServer(gui.getFrame().getHeroQuest()));
	}*/

	
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
		
		HeroQuest game = new HeroQuest(portGUI.getOutbox(), portProxy.getOutbox());
		AtorClientServer ngproxy = new AtorClientServer(portProxyLogic.getOutbox());
		((PortLogicGUI) portGUI).setInternalReference(game);
		((PortNGProxyGUI) proxyGUI).setInternalReference(ngproxy);
		((PortLogicClientServer) portProxy).setInternalReference(game);
		((PortEnviarJogadaNGProxyLogic) portProxyLogic).setInternalReference(ngproxy);
		((PortNGProxyNGServer) proxy.getPort("portNG")).setInternalReference(ngproxy);
		
		gui.initGUI();
	}
}
