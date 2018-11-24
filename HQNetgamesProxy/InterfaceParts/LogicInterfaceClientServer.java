package InterfaceParts;

import modelo.Lance;

public interface LogicInterfaceClientServer {
	public void tratarLance(Lance lance);
	
	public void finalizarJogo();
	
	public void iniciarNovaPartida(int posicao);
}
