package InternalStructure;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.TextArea;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.ArrayList;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

import cip.PortOutbox;
import InterfaceParts.PortGUILogicOutbox;
import InterfaceParts.PortGUINGProxyOutbox;

public class AtorJogador extends JFrame {

	protected static final long serialVersionUID = 1L;
	protected JPanel contentPane;
	//protected HeroQuest heroQuest;
	protected PortGUILogicOutbox heroQuest;
	protected PortGUINGProxyOutbox NGproxy;
	protected JButton[][] botoesTabuleiro;
	protected JButton botaoConectar;
	protected JButton botaoDesconectar;
	protected JButton botaoIniciarPartida;
	protected JButton botaoFinalizarJogada;
	protected JButton botaoMostrarInventario;
	protected JButton botaoAtacar;
	protected JButton botaoUsarMagia;
	protected JButton botaoProcurarArmadilha;
	protected JButton botaoProcurarTesouro;
	protected ArrayList<JButton> botoesCriaturas;

	public ListenerDoTeclado listener = new ListenerDoTeclado(this);
	public MusicThread musicThread;
	private TextArea textArea;

	public static Boolean autoConnectToServer = true;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PortGUILogicOutbox logic = null;
					PortGUINGProxyOutbox proxy = null;
					AtorJogador frame = new AtorJogador(logic, proxy);
					frame.setVisible(true);
					if (autoConnectToServer) {
						frame.conectar();
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public AtorJogador(PortOutbox logic, PortOutbox proxy) {
		
		heroQuest = (PortGUILogicOutbox)logic;
		NGproxy = (PortGUINGProxyOutbox)proxy;
		
		
		try {
			createMusic();
		} catch (Exception e) {
			e.printStackTrace();
		}

		setIconImage(Toolkit.getDefaultToolkit().getImage(
				AtorJogador.class.getResource("/imagens/Wizard.png")));
		setTitle("HeroQuestv2.8");
		// Atributos do AtorJogador

		this.botoesTabuleiro = new JButton[27][50];
		this.botoesCriaturas = new ArrayList<JButton>();
		//this.heroQuest = new HeroQuest(this);
		addKeyListener(listener);

		// Configurar a janela
		setSize(1300, 770);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu mnHelp = new JMenu("Menu");
		menuBar.add(mnHelp);

		JButton btnInstructions = new JButton("Instru\u00E7\u00F5es");
		btnInstructions.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Instrucoes instr = null;
				try {
					instr = new Instrucoes();
				} catch (IOException e) {
					e.printStackTrace();
				}
				instr.setVisible(true);
			}
		});
		mnHelp.add(btnInstructions);

		JButton btnCharSelect = new JButton("Selecionar personagem");
		btnCharSelect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				selecionarPersonagem();
			}
		});

		mnHelp.add(btnCharSelect);

		JMenu mnSettings = new JMenu("Settings");
		menuBar.add(mnSettings);

		JButton btnMusic = new JButton("Turn music on/off");
		mnSettings.add(btnMusic);
		btnMusic.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				music();
			}
		});
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		contentPane.setBackground(Color.BLACK);
		setContentPane(contentPane);
		Border invisivel = BorderFactory.createEmptyBorder();
		setFocusable(true);
		requestFocusInWindow();

		// Cria os botões do tabuleiro
		for (int i = 0; i < 27; i++) {
			for (int j = 0; j < 50; j++) {
				JButton botao = new JButton();
				botao.setName("" + i + j);
				botao.setBounds(150 + (j * 23), 89 + (i * 23), 23, 23);
				botao.setBorder(invisivel);
				botao.setVisible(true);
				botao.addKeyListener(listener);
				botao.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						abrirPorta(Integer.parseInt(botao.getName()));
					}
				});
				contentPane.add(botao);
				this.botoesTabuleiro[i][j] = botao;
			}
		}

		// Cria os botões "Fila de criaturas"
		JButton inutil = new JButton("");
		inutil.setVisible(false);
		this.botoesCriaturas.add(inutil);
		for (int i = 1; i <= 23; i++) {
			JButton botao = new JButton();
			botao.setName("" + i);
			botao.setBounds(0, 27 * (i - 1) + 89, 150, 27);
			botao.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					mostrarInformacoes(Integer.parseInt(botao.getName()));
				}
			});
			botao.addKeyListener(listener);
			this.botoesCriaturas.add(i, botao);
			this.contentPane.add(botao);
		}

		this.textArea = new TextArea();
		textArea.setFont(new Font("Viner Hand ITC", Font.BOLD, 15));
		textArea.setBounds(0, 0, 1294, 89);
		contentPane.add(textArea);
		
		if (autoConnectToServer) {
			this.conectar();
		}
	}
	
	@SuppressWarnings("unused")
	private void generateActionbuttons(){
		Border invisivel = BorderFactory.createEmptyBorder();
		// Cria os outros botões
				ImageIcon iconeConectar = new ImageIcon(getClass().getResource(
						"/imagens/BotaoConectar.png"));
				this.botaoConectar = new JButton(iconeConectar);
				this.botaoConectar.setBounds(22 * 1 + 120 * 0, 0, 120, 89);
				this.botaoConectar.setBorder(invisivel);
				this.botaoConectar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						conectar();
					}
				});
				this.botaoConectar.addKeyListener(listener);
				this.contentPane.add(this.botaoConectar);

				ImageIcon iconeDesconectar = new ImageIcon(getClass().getResource(
						"/imagens/BotaoDesconectar.png"));
				this.botaoDesconectar = new JButton(iconeDesconectar);
				this.botaoDesconectar.setBounds(22 * 2 + 120 * 1, 0, 120, 89);
				this.botaoDesconectar.setBorder(invisivel);
				this.botaoDesconectar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						desconectar();
					}
				});
				this.botaoDesconectar.addKeyListener(listener);
				this.contentPane.add(this.botaoDesconectar);

				ImageIcon iconeIniciarPartida = new ImageIcon(getClass().getResource(
						"/imagens/BotaoIniciarPartida.png"));
				this.botaoIniciarPartida = new JButton(iconeIniciarPartida);
				this.botaoIniciarPartida.setBounds(22 * 3 + 120 * 2, 0, 120, 89);
				this.botaoIniciarPartida.setBorder(invisivel);
				this.botaoIniciarPartida.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						iniciarPartida();
					}
				});
				this.botaoIniciarPartida.addKeyListener(listener);
				this.contentPane.add(this.botaoIniciarPartida);

				ImageIcon iconeFinalizarJogada = new ImageIcon(getClass().getResource(
						"/imagens/BotaoFinalizarJogada.png"));
				this.botaoFinalizarJogada = new JButton(iconeFinalizarJogada);
				this.botaoFinalizarJogada.setBounds(22 * 4 + 120 * 3, 0, 120, 89);
				this.botaoFinalizarJogada.setBorder(invisivel);
				this.botaoFinalizarJogada.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						finalizarJogada();
					}
				});
				this.botaoFinalizarJogada.addKeyListener(listener);
				this.contentPane.add(this.botaoFinalizarJogada);

				ImageIcon iconeBotaoMostrarInventario = new ImageIcon(getClass()
						.getResource("/imagens/BotaoMostrarInventario.png"));
				this.botaoMostrarInventario = new JButton(iconeBotaoMostrarInventario);
				this.botaoMostrarInventario.setBounds(22 * 5 + 120 * 4, 0, 120, 89);
				this.botaoMostrarInventario.setBorder(invisivel);
				this.botaoMostrarInventario.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						mostrarInventario();
					}
				});
				this.botaoMostrarInventario.addKeyListener(listener);
				this.contentPane.add(this.botaoMostrarInventario);

				ImageIcon iconeBotaoAtacar = new ImageIcon(getClass().getResource(
						"/imagens/BotaoAtacar.png"));
				this.botaoAtacar = new JButton(iconeBotaoAtacar);
				this.botaoAtacar.setBounds(22 * 6 + 120 * 5, 0, 120, 89);
				this.botaoAtacar.setBorder(invisivel);
				this.botaoAtacar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						atacar();
					}
				});
				this.botaoAtacar.addKeyListener(listener);
				this.contentPane.add(this.botaoAtacar);

				ImageIcon iconeBotaoUsarMagia = new ImageIcon(getClass().getResource(
						"/imagens/BotaoUsarMagia.png"));
				this.botaoUsarMagia = new JButton(iconeBotaoUsarMagia);
				this.botaoUsarMagia.setBounds(22 * 7 + 120 * 6, 0, 120, 89);
				this.botaoUsarMagia.setBorder(invisivel);
				this.botaoUsarMagia.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						usarMagia();
					}
				});
				this.botaoUsarMagia.addKeyListener(listener);
				this.contentPane.add(this.botaoUsarMagia);

				ImageIcon iconeBotaoProcurarArmadilha = new ImageIcon(getClass()
						.getResource("/imagens/BotaoProcurarArmadilha.png"));
				this.botaoProcurarArmadilha = new JButton(iconeBotaoProcurarArmadilha);
				this.botaoProcurarArmadilha.setBounds(22 * 8 + 120 * 7, 0, 120, 89);
				this.botaoProcurarArmadilha.setBorder(invisivel);
				this.botaoProcurarArmadilha.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						procurarArmadilhaOuPortaSecreta();
					}
				});
				this.botaoProcurarArmadilha.addKeyListener(listener);
				this.contentPane.add(botaoProcurarArmadilha);

				ImageIcon iconeBotaoProcurarTesouro = new ImageIcon(getClass()
						.getResource("/imagens/BotaoProcurarTesouro.png"));
				this.botaoProcurarTesouro = new JButton(iconeBotaoProcurarTesouro);
				this.botaoProcurarTesouro.setBounds(22 * 9 + 120 * 8, 0, 120, 89);
				this.botaoProcurarTesouro.setBorder(invisivel);
				this.botaoProcurarTesouro.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						procurarTesouro();
					}
				});
				this.botaoProcurarTesouro.addKeyListener(listener);
				this.contentPane.add(this.botaoProcurarTesouro);
	}

	// //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	public void selecionarPersonagem() {
		this.heroQuest.selecionarPersonagem();
	}

	public void abrirPortaTeclado() {
		this.heroQuest.abrirPortaTeclado();
	}

	public void abrirPorta(int idPorta) {
		this.heroQuest.abrirPorta(idPorta);
	}

	public void mostrarMensagem(String msg) {
		//JOptionPane.showMessageDialog(null, msg);
		textArea.setText(msg);
	}

	public void reportarErro(String msg) {
		//JOptionPane.showMessageDialog(null, msg);
		textArea.setText(msg);
	}

	public void movimentar(Directions direcao) {
		this.heroQuest.movimentar(direcao);
	}

	public void atacar() {
		this.heroQuest.atacar();
	}

	public void usarMagia() {
		this.heroQuest.usarMagia();
	}

	public Spell selecionarMagia(ArrayList<Spell> magiasDisponiveis) {
		String inputDialog = "Digite o n�mero correspondente � magia que deseja usar: ";
		for (int i = 0; i < magiasDisponiveis.size(); i++) {
			inputDialog += "\n" + i + " - "
					+ magiasDisponiveis.get(i).getNome();
		}
		String opcao = JOptionPane.showInputDialog(inputDialog);
		int index = Integer.parseInt(opcao);
		return magiasDisponiveis.get(index);
	}

	public Creature selecionarAlvo(ArrayList<Creature> possiveisAlvos) {
		String inputDialog = "Digite o n�mero correspondente ao alvo escolhido: ";
		for (int i = 0; i < possiveisAlvos.size(); i++) {
			inputDialog += "\n" + i + " - "
					+ possiveisAlvos.get(i).getClass().getSimpleName();
		}
		String opcao = JOptionPane.showInputDialog(inputDialog);
		int index = Integer.parseInt(opcao);
		return possiveisAlvos.get(index);
	}

	public void atualizarInterfaceGrafica() {
		for (byte i = 0; i < 27; i++) {
			for (byte j = 0; j < 50; j++) {
				Position posicao = this.heroQuest.getPosition(i, j);
				this.atualizarBotao(this.botoesTabuleiro[i][j], posicao);
			}
		}
		this.exibirCriaturas();
	}

	public void procurarTesouro() {
		this.heroQuest.procurarTesouro();
	}

	// Chamar TelaSelecionarPersonagem!
	public void mostrarOsCincoPersonagens() {
/*		String inputDialog = "Digite o n�mero correspondente ao personagem escolhido: \nObs.: Zargon controla os monstros, n�o um aventureiro";
		inputDialog += "\n0 - Zargon";
		inputDialog += "\n1 - Barbarian";
		inputDialog += "\n2 - Wizard";
		inputDialog += "\n3 - Elf";
		inputDialog += "\n4 - Dwarf";*/
		
		CharacterSelection cs = new CharacterSelection(this);
		cs.setVisible(true);
		
		/*String opcao = JOptionPane.showInputDialog(null, inputDialog);
		
		int index = Integer.parseInt(opcao);
		return index;*/
	}

	public void procurarArmadilhaOuPortaSecreta() {
		this.heroQuest.procurarArmadilhaOuPortaSecreta();
	}

	public void finalizarJogada() {
		this.heroQuest.finalizarjogada();
	}

	// C�digo n�o usado
	public String obterIdJogador() {
		String idJogador = JOptionPane
				.showInputDialog("Digite o nome do seu personagem: ");
		return idJogador;
	}

	public String obterIdServidor() {
		// String idServidor = ("venus.inf.ufsc.br");
		// String idServidor = ("127.0.0.1");
		String idServidor = ("localhost");
		// String idServidor = ("web.juan.cuttle.vms.ufsc.br");
		//String idServidor = ("netgames.labsoft.ufsc.br");
		if (!autoConnectToServer) {
			idServidor = JOptionPane.showInputDialog(this,
					("Insira o endere�o do servidor"), idServidor);
		}
		return idServidor;
	}

	/*
	 * resultado 0 - conexao com exito 1 - tentativa de conexao com conexao
	 * previamente estabelecida 2 - tentativa de conexao falhou
	 */
	public void conectar() {
		boolean conectado = false;//this.heroQuest.informarConectado();
		if (!conectado) {
			String servidor = this.obterDadosConexao();
			String idUsuario = obterIdJogador();
			/*boolean exito = this.heroQuest.getAtorClienteServidor().conectar(
					servidor, idUsuario);*/
			boolean exito = this.NGproxy.conectar(servidor, idUsuario);
			if (exito) {
				this.heroQuest.estabelecerConectado(true);

				this.heroQuest.setNomeLocalPlayerAndServer(idUsuario, servidor);

				notificarResultado(0);
			} else {
				notificarResultado(2);
			}
		} else {
			notificarResultado(1);
		}

	}

	/**
	 * 
	 * @param resultado
	 */
	public void notificarResultado(int resultado) {
		String mensagem = "";
		switch (resultado) {
		case 0:
			mensagem = "Conexao com exito";
			break;
		case 1:
			mensagem = "Tentativa de conexao com conexao previamente estabelecida";
			break;
		case 2:
			mensagem = "Tentativa de conexao falhou";
			break;
		case 3:
			mensagem = "Desconexao com exito";
			break;
		case 4:
			mensagem = "Tentativa de desconexao sem conexao previamente estabelecida";
			break;
		case 5:
			mensagem = "Tentativa de desconexao falhou";
			break;
		case 6:
			mensagem = "Solicita��o de inicio procedida com exito";
			break;
		case 7:
			mensagem = "Tentativa de inicio sem conexao previamente estabelecida";
			break;
		case 13:
			mensagem = "Partida corrente nao interrompida";
			break;
		default:
			mensagem = "";
			break;
		}
		//JOptionPane.showMessageDialog(null, mensagem);
		textArea.setText(mensagem);
	}

	public String obterDadosConexao() {
		String servidor = this.obterIdServidor();
		return servidor;
	}

	/*
	 * resultado 3 - desconexao com exito 4 - tentativa de desconexao sem
	 * conexao previamente estabelecida 5 - tentativa de desconexao falhou
	 */
	public void desconectar() {
		boolean conectado = this.heroQuest.informarConectado();
		if (conectado) {
			boolean exito = NGproxy.desconectar();//this.heroQuest.getAtorClienteServidor().desconectar();
			if (exito) {
				this.heroQuest.estabelecerConectado(false);
				notificarResultado(3);
			} else {
				notificarResultado(5);
			}
		} else {
			notificarResultado(4);
		}
	}

	/*
	 * resultado 6 - solicita��o de inicio procedida com exito 7 - tentativa
	 * de inicio sem conexao previamente estabelecida 13 - partida corrente nao
	 * interrompida
	 */
	public void iniciarPartida() {
		boolean conectado = false;
		boolean interromper = false;
		boolean emAndamento = this.heroQuest.informarEmAndamento();
		if (emAndamento) {
			interromper = this.avaliarInterrupcao();
		} else {
			conectado = this.heroQuest.informarConectado();
		}
		if (interromper || ((!emAndamento) && conectado)) {
			int numJog = this.informarQuantidadeDePlayers();
			//this.heroQuest.getAtorClienteServidor().iniciarPartida(numJog);
			this.NGproxy.iniciarPartida(numJog);
			notificarResultado(6);
		}
		if (!conectado) {
			notificarResultado(7);
		}
		notificarResultado(13);
	}

	public boolean avaliarInterrupcao() {
		return true;
	}

	public void anunciarVitoriaDosJogadores() {
/*		JOptionPane.showMessageDialog(null,
				"Parab�ns aos aventureiros!\n Voc�s foram vitoriosos!!!");*/
		textArea.setText("Parab�ns aos aventureiros!\n Voc�s foram vitoriosos!!!");
	}

	public void anunciarVitoriaDoZargon() {
/*		JOptionPane.showMessageDialog(null,
				"Oh n�o, o terr�vel Zargon venceu desta vez!");*/
		textArea.setText("Oh n�o, o terr�vel Zargon venceu desta vez!");
	}

	public String informarNomeJogador() {
		String nomeJogador = JOptionPane
				.showInputDialog("Digite o nome do seu personagem: ");
		return nomeJogador;
	}

	public void mostrarInventario() {
		this.heroQuest.mostrarInventario();
	}

	public void mostrarInventario(int gold) {
		/*JOptionPane.showMessageDialog(null, "Voc� possui " + gold
				+ " gold coins no seu invent�rio.");*/
		textArea.setText("Voc� possui " + gold
				+ " gold coins no seu invent�rio.");
	}

	public void mostrarInformacoes(int characterID) {
		this.heroQuest.mostrarInformacoes(characterID);
	}

	public void mostrarInformacoes(byte body, byte mind, byte movement,
			Status status, int linha, int coluna, Byte roundsToSleep) {
		String output = "Body atual: " + body
				+ "\nMind restante: " + mind + "\nMovimento restante: "
				+ movement + "\nStatus atual: " + status + "\nLinha: " + linha
				+ " Coluna: " + coluna;
		if (roundsToSleep != null){
			if (roundsToSleep != 0){
				output += "\nTurns left to sleep: " + roundsToSleep;
			}
		}
		//JOptionPane.showMessageDialog(null, output);
		textArea.setText(output);
	}

	public int informarQuantidadeDePlayers() {
		int numJogadores;
		do {
			String numjog = JOptionPane
					.showInputDialog("Favor digitar a quantidade de jogadores que ir�o participar desta partida: ");
			numJogadores = Integer.parseInt(numjog);
		} while (numJogadores < 2);
		return numJogadores;
	}

	public void atualizarBotao(JButton botao, Position posicao) {
		ImageIcon img;
		String path = "";
		int linha = posicao.getRow();
		int coluna = posicao.getColumn();
		if (!posicao.isVisible()) {
			path = "/imagens/" + "Wall" + ".png";

		} else {
			if (posicao.getCreature() != null) {
				path = "/imagens/"
						+ posicao.getCreature().getClass().getSimpleName()
						+ ".png";

			} else if (posicao.getTrap() != null) {
					if (posicao.getTrap().getVisible()) {
						if (posicao.getTrap() instanceof FallingRock && posicao.getTrap().getTriggered()){
							path = "/imagens/"
									+ "Rubble"
									+ ".png";
						} else {
							path = "/imagens/"
									+ posicao.getTrap().getClass().getSimpleName()
									+ ".png";
						}
					} else {
						path = "/imagens/" + posicao.getClass().getSimpleName()
								+ ".png";
					}
			} else {
				if (posicao instanceof Door) {
					if (!((Door) posicao).isSecreta()) {
						if (((Door) posicao).getPortaEstaAberta()) {
							path = "/imagens/PortaAberta.png";
						} else {
							path = "/imagens/PortaFechada.png";
						}
					} else {
						path = "/imagens/" + "Wall" + ".png";
					}
				} else {
					path = "/imagens/" + posicao.getClass().getSimpleName()
							+ ".png";
				}

				if (linha == 24 && coluna == 24) {
					path = "/imagens/2424.png";
				} else if (linha == 24 && coluna == 25) {
					path = "/imagens/2425.png";
				} else if (linha == 25 && coluna == 24) {
					path = "/imagens/2524.png";
				} else if (linha == 25 && coluna == 25) {
					path = "/imagens/2525.png";
				}
			}
		}
		img = new ImageIcon(getClass().getResource(path));
		botao.setIcon(img);
		botao.invalidate();
		botao.revalidate();
		botao.repaint();
	}

	private void atualizarBotao(JButton botao, Creature criatura,
			int posicaoBotao) {
		if (criatura.isVisible() == true) {
			String nome = criatura.getClass().getSimpleName();
			botao.setText(nome);
		}
		botao.setBounds(0, 27 * posicaoBotao + 89, 150, 27);
		botao.invalidate();
		botao.revalidate();
		botao.repaint();
	}

	public void exibirCriaturas() {
		ArrayList<Creature> criaturas = this.heroQuest.getCreatureQueue();
		for (int i = 0; i < criaturas.size(); i++) {
			Creature criatura = criaturas.get(i);
			this.atualizarBotao(this.botoesCriaturas.get(criatura.getID()),
					criatura, i);
		}
	}

	public void mostrarAcaoTrap(byte dano, Creature criatura) {
/*		JOptionPane
				.showMessageDialog(null, "Oh n�o! "
						+ criatura.getClass().getSimpleName()
						+ " ativou uma armadilha e perdeu " + dano
						+ " de body points!");*/
		textArea.setText("Oh n�o! "
						+ criatura.getClass().getSimpleName()
						+ " ativou uma armadilha e perdeu " + dano
						+ " de body points!");
	}

	public void mostrarDano(Creature alvo, byte dano, boolean seAtacou) {
		if (!seAtacou) {
	/*		JOptionPane.showMessageDialog(null, "A criatura "
					+ alvo.getClass().getSimpleName() + " recebeu " + dano
					+ " de dano.");*/
			textArea.setText("A criatura "
					+ alvo.getClass().getSimpleName() + " recebeu " + dano
					+ " de dano.");
		} else {
/*			JOptionPane.showMessageDialog(null, "A criatura "
					+ alvo.getClass().getSimpleName()
					+ " tenta seppuku e recebe " + dano + " de dano.");*/
			textArea.setText("A criatura "
					+ alvo.getClass().getSimpleName()
					+ " tenta seppuku e recebe " + dano + " de dano.");
		}
	}

	public void anunciarMorteDeCriatura(Creature alvo) {
/*		JOptionPane.showMessageDialog(null, "A criatura "
				+ alvo.getClass().getSimpleName()
				+ " morreu honrosamente em batalha.");*/
		textArea.setText("A criatura "
				+ alvo.getClass().getSimpleName()
				+ " morreu honrosamente em batalha.");
	}

	public void anunciarUsoDeMagia(Creature caster, Spell magia, Creature alvo,
			byte dano, Status status) {
		if (status != null) {
/*			JOptionPane.showMessageDialog(null, "O "
					+ caster.getClass().getSimpleName()
					+ " murmurou algumas palavras m�gicas (" + magia.getNome()
					+ "), e a criatura " + alvo.getClass().getSimpleName()
					+ " modificou em " + dano
					+ " seus body points, e conferiu a ele o estado " + status
					+ "!");*/
			textArea.setText("O "
					+ caster.getClass().getSimpleName()
					+ " murmurou algumas palavras m�gicas (" + magia.getNome()
					+ "), e a criatura " + alvo.getClass().getSimpleName()
					+ " modificou em " + dano
					+ " seus body points, e conferiu a ele o estado " + status
					+ "!");
		} else {
/*			JOptionPane.showMessageDialog(null, "O "
					+ caster.getClass().getSimpleName()
					+ " murmurou algumas palavras m�gicas (" + magia.getNome()
					+ "), e a criatura " + alvo.getClass().getSimpleName()
					+ " modificou em " + dano + " seus body points!");*/
			textArea.setText("O "
					+ caster.getClass().getSimpleName()
					+ " murmurou algumas palavras m�gicas (" + magia.getNome()
					+ "), e a criatura " + alvo.getClass().getSimpleName()
					+ " modificou em " + dano + " seus body points!");
		}

	}

	public void anunciarMorteDesafortunada(Creature criatura) {
/*		JOptionPane.showMessageDialog(null, "Oh n�o! A criatura "
				+ criatura.getClass().getSimpleName()
				+ " morreu ao pisar numa armadilha!");*/
		textArea.setText("Oh n�o! A criatura "
				+ criatura.getClass().getSimpleName()
				+ " morreu ao pisar numa armadilha!");
	}

	public void anunciarDaVez(Creature criatura) {
		Position posicaoCriatura = criatura.getCurrentPosition();
		int linha = posicaoCriatura.getRow();
		int coluna = posicaoCriatura.getColumn();
/*		JOptionPane.showMessageDialog(null, "A vez � da criatura "
				+ criatura.getClass().getSimpleName()
				+ " a qual est� na linha " + linha + ", coluna " + coluna
				+ " do tabuleiro.");*/
		textArea.setText("A vez � da criatura "
				+ criatura.getClass().getSimpleName()
				+ " a qual est� na linha " + linha + ", coluna " + coluna
				+ " do tabuleiro.");
	}

	public void atualizarArredoresJogador() {
		Creature atual = this.heroQuest.getCriaturaDaVez();
		Position p = atual.getCurrentPosition();
		byte linha = p.getRow();
		byte coluna = p.getColumn();

		for (byte i = (byte) (linha - 2); i <= linha + 2; i++) {
			for (byte j = (byte) (coluna - 2); j <= coluna + 2; j++) {
				if (i >= 0 && i < 27 && j >= 0 && j < 50) {
					Position posicao = this.heroQuest.getPosition(i, j);
					this.atualizarBotao(this.botoesTabuleiro[i][j], posicao);
				}
			}
		}
		
		this.exibirCriaturas(); //precisa?
	}

	public int escolherPorta(ArrayList<String> portaIds) {
		String inputDialog = "Escolha a porta a ser aberta: \n";
		for (int i = 0; i < portaIds.size(); i++) {
			inputDialog += i + " - " + portaIds.get(i) + "\n";
		}
		String opcao = JOptionPane.showInputDialog(inputDialog);
		return Integer.parseInt(opcao);

	}

	public void createMusic() throws Exception {

		/*File f = new File("src/musicas/Castlevania Symphony of the Night Track 03 Dance Of Illusions.wav");*/
		String f = "/musicas/Castlevania Symphony of the Night Track 03 Dance Of Illusions.wav";
		AudioInputStream audioIn = null;

		try {
			//audioIn = AudioSystem.getAudioInputStream(f.toURI().toURL());
			audioIn = AudioSystem.getAudioInputStream(getClass().getResource(f));
		} catch (MalformedURLException e2) {
			e2.printStackTrace();
		} catch (UnsupportedAudioFileException e2) {
			e2.printStackTrace();
		} catch (IOException e2) {
			e2.printStackTrace();
		}
		final Clip clip = AudioSystem.getClip();

		try {
			clip.open(audioIn);
		} catch (LineUnavailableException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		this.musicThread = new MusicThread(clip) {

		};
		SwingUtilities.invokeLater(musicThread);

	}

	public void music() {
		this.musicThread.music();
	}

	public void mostrarRemocaoTrap() {
		//JOptionPane.showMessageDialog(null, "O an�o desarmou as armadilhas pr�ximas a ele!");
		textArea.setText("O an�o desarmou as armadilhas pr�ximas a ele!");
	}

	public byte mostrarOpcoesFallingRock() {
		String input = "Oh n�o, voc� est� sendo soterrado! Escolha se deseja ir para frente ou para tr�s:\n";
		input += "0 - para frente\n";
		input += "1 - para tr�s";
		String option = JOptionPane.showInputDialog(input);
		return (byte)Integer.parseInt(option);
	}
	
	public byte mostrarOpcoesPit() {
		String input = "Voc� deseja pular o buraco?\n";
		input += "0 - sim\n";
		input += "1 - n�o";
		String option = JOptionPane.showInputDialog(input);
		return (byte)Integer.parseInt(option);
	}
}
