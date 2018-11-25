package InterfaceParts;

import modelo.Lance;

public interface InterfaceLogicClientServer {
	public void tratarLance(Lance lance);
	
	public void finalizarJogo();
	
	public void iniciarNovaPartida(int posicao);

}
