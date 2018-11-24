package InterfaceParts;

public interface NetgamesProxyInterface {
	public boolean conectar(String servidor, String nome);
	
	public boolean desconectar();
	
	public void iniciarPartida(int numJog);
}
