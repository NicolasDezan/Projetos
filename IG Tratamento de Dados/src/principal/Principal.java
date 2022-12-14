/*
 * IG Tratamento de Dados v 3.2
 * 22.12.2022
 * 
 * IFES Vila Velha
 * Nícolas Dezan dos Santos
 * 
 * Melhorias que podem ser feitas: 
 * 1) Refinar a interface e o relatório gerado para "outros" valores de t-student
 * 
 */

package principal;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JRadioButton;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JMenu;
import javax.swing.KeyStroke;
import java.awt.event.KeyEvent;
import java.awt.event.InputEvent;
import javax.swing.SwingConstants;


public class Principal {
	private JFrame frmTratamentoDeDados;
	private JTextField mediaMostrar;
	private JLabel media;
	private JTextField medianaMostrar;
	private JTextField desvpadMostrar;
	private JTextField arquivoMostrar2;
	private JLabel textoSalvoEm;
	private JTextField caminhoMostrar;
	private JTextField icMostrar;
	private JLabel aviso;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Principal window = new Principal();
					window.frmTratamentoDeDados.setVisible(true);
					window.frmTratamentoDeDados.setLocationRelativeTo(null);

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public Principal() {
		initialize();
	}
	
	private void initialize() {
		int linguagemAtual = Config.idioma();
		
		JMenuItem botaoMenuPref = new JMenuItem("Preferências");
		frmTratamentoDeDados = new JFrame();
		frmTratamentoDeDados.setTitle("Tratamento de Dados");
		frmTratamentoDeDados.setBounds(100, 100, 460, 257);
		frmTratamentoDeDados.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JRadioButton selecionar_99 = new JRadioButton("99%");
		selecionar_99.setBounds(234, 78, 57, 23);
		JRadioButton selecionar_95 = new JRadioButton("95%");
		selecionar_95.setBounds(234, 52, 57, 23);
		JLabel n_dados_retorno = new JLabel("n = ");
		n_dados_retorno.setBounds(196, 129, 46, 14);
		JLabel texto_arquivo = new JLabel("Arquivo:");
		texto_arquivo.setBounds(10, 12, 46, 14);
		JLabel desvpad = new JLabel("Desvio Padrão");
		desvpad.setBounds(10, 89, 116, 13);
		JLabel mediana = new JLabel("Mediana");
		mediana.setBounds(10, 65, 81, 13);
		textoSalvoEm = new JLabel("Salvo em:");
		textoSalvoEm.setBounds(10, 158, 57, 14);
		JLabel ic_texto = new JLabel("Intervalo de Confiança");
		ic_texto.setBounds(10, 115, 142, 13);
		JRadioButton selecionar_X = new JRadioButton("Outro");
		selecionar_X.setBounds(234, 102, 80, 23);
		JMenuBar menuBar = new JMenuBar();
		JMenu menuOpcoes = new JMenu("Opções");
		JMenuItem botaoMenuSelecionarArquivo = new JMenuItem("Selecionar arquivo");
		botaoMenuSelecionarArquivo.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E, InputEvent.CTRL_DOWN_MASK));
		JMenu menuArquivo = new JMenu("Arquivo");
		JMenuItem botaoMenuGerarRelatorio = new JMenuItem("Gerar relatorio");
		botaoMenuGerarRelatorio.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_R, InputEvent.CTRL_DOWN_MASK));

	frmTratamentoDeDados.getContentPane().setLayout(null);
	mediaMostrar = new JTextField();
	mediaMostrar.setEditable(false);
	mediaMostrar.setBounds(140, 37, 76, 19);
	frmTratamentoDeDados.getContentPane().add(mediaMostrar);
	mediaMostrar.setColumns(10);	
	media = new JLabel("Média");
	media.setBounds(10, 41, 81, 13);
	frmTratamentoDeDados.getContentPane().add(media);
	frmTratamentoDeDados.getContentPane().add(mediana);	
	medianaMostrar = new JTextField();
	medianaMostrar.setEditable(false);
	medianaMostrar.setBounds(140, 61, 76, 19);
	medianaMostrar.setColumns(10);
	frmTratamentoDeDados.getContentPane().add(medianaMostrar);
	frmTratamentoDeDados.getContentPane().add(desvpad);	
	desvpadMostrar = new JTextField();
	desvpadMostrar.setEditable(false);
	desvpadMostrar.setBounds(140, 85, 76, 19);
	desvpadMostrar.setColumns(10);
	frmTratamentoDeDados.getContentPane().add(desvpadMostrar);
	frmTratamentoDeDados.getContentPane().add(texto_arquivo);	
	arquivoMostrar2 = new JTextField();
	arquivoMostrar2.setEditable(false);
	arquivoMostrar2.setBounds(61, 11, 373, 17);
	arquivoMostrar2.setText("(nenhum arquivo selecionado)");
	arquivoMostrar2.setFont(new Font("Tahoma", Font.PLAIN, 11));
	frmTratamentoDeDados.getContentPane().add(arquivoMostrar2);
	arquivoMostrar2.setColumns(10);
	frmTratamentoDeDados.getContentPane().add(textoSalvoEm);	
	selecionar_X.setFont(new Font("Tahoma", Font.PLAIN, 10));
	caminhoMostrar = new JTextField();
	caminhoMostrar.setEditable(false);
	caminhoMostrar.setBounds(74, 157, 360, 17);
	caminhoMostrar.setFont(new Font("Tahoma", Font.PLAIN, 11));
	caminhoMostrar.setColumns(10);
	frmTratamentoDeDados.getContentPane().add(caminhoMostrar);
	frmTratamentoDeDados.getContentPane().add(ic_texto);	
	icMostrar = new JTextField();
	icMostrar.setEditable(false);
	icMostrar.setBounds(140, 113, 76, 19);
	icMostrar.setColumns(10);
	frmTratamentoDeDados.getContentPane().add(icMostrar);	
	aviso = new JLabel("T_Student - 95%");
	aviso.setBounds(10, 129, 88, 13);
	aviso.setFont(new Font("Tahoma", Font.PLAIN, 9));
	frmTratamentoDeDados.getContentPane().add(aviso);
	selecionar_95.setSelected(true);
	selecionar_95.setFont(new Font("Tahoma", Font.PLAIN, 10));
	frmTratamentoDeDados.getContentPane().add(selecionar_95);
	selecionar_99.setFont(new Font("Tahoma", Font.PLAIN, 10));
	frmTratamentoDeDados.getContentPane().add(selecionar_99);	
	n_dados_retorno.setFont(new Font("Tahoma", Font.PLAIN, 8));
	frmTratamentoDeDados.getContentPane().add(n_dados_retorno);
	frmTratamentoDeDados.getContentPane().add(selecionar_X);
	
	JLabel txtSelecionarNivel = new JLabel("Selecionar o nível de confiança");
	txtSelecionarNivel.setFont(txtSelecionarNivel.getFont().deriveFont(txtSelecionarNivel.getFont().getStyle() | Font.BOLD));
	txtSelecionarNivel.setBounds(237, 37, 203, 14);
	frmTratamentoDeDados.getContentPane().add(txtSelecionarNivel);
	frmTratamentoDeDados.setJMenuBar(menuBar);	
	botaoMenuGerarRelatorio.setHorizontalAlignment(SwingConstants.CENTER);
	menuArquivo.add(botaoMenuSelecionarArquivo);
	menuArquivo.add(botaoMenuGerarRelatorio);	
	menuBar.add(menuArquivo);
	menuBar.add(menuOpcoes);	
	botaoMenuPref.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P, InputEvent.CTRL_DOWN_MASK));
	menuOpcoes.add(botaoMenuPref);
	
	JMenu botaoMenuAjuda = new JMenu("Ajuda");
	menuBar.add(botaoMenuAjuda);
	
	JMenuItem botaoMenuAjudaFuncoes = new JMenuItem("Funções do programa");
	botaoMenuAjuda.add(botaoMenuAjudaFuncoes);	
	JMenuItem botaoMenuAjudaSobre = new JMenuItem("Sobre o programa");

	botaoMenuAjuda.add(botaoMenuAjudaSobre);
	
	// aff ta em ingles
	if(linguagemAtual == 2) {
		botaoMenuPref.setText("Preferences");
		arquivoMostrar2.setText("(no file selected)");
		media.setText("Average");
		desvpad.setText("Standard deviation");
		texto_arquivo.setText("File:");
		mediana.setText("Median");
		menuArquivo.setText("File");
		botaoMenuSelecionarArquivo.setText("Select file");
		botaoMenuGerarRelatorio.setText("Generate report");
		menuOpcoes.setText("Options");
		ic_texto.setText("Confidence:");
		frmTratamentoDeDados.setTitle("Tratamento de Dados (English)");
		textoSalvoEm.setText("Saved in");
		txtSelecionarNivel.setText("Select confidence level");
		selecionar_X.setText("Other");
		botaoMenuAjuda.setText("Help");
		botaoMenuAjudaFuncoes.setText("Program functions");
		botaoMenuAjudaSobre.setText("About the program");
		
	}
	
	
	int abrirJanelaFuncoes = Config.janelaInicial();
	if(abrirJanelaFuncoes == 1) {
		JanelaFuncoes funcoes = new JanelaFuncoes();				
		funcoes.setLocationRelativeTo(null);
		funcoes.setVisible(true);
		funcoes.setResizable(false);
		funcoes.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);		
	}
	
	
	
		botaoMenuSelecionarArquivo.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			
			String s_prefDiretorioDados = null;			
			try {
				File diretorioPref = new File(new java.io.File(".").getPath()+"\\config\\config.txt");
				List<String> pref = Arquivo.lerArquivo(diretorioPref);	
					s_prefDiretorioDados = new File(pref.get(1)).getPath();
				}catch(Exception semConfig) {}		
			
			File prefDiretorioDados = new File(s_prefDiretorioDados);			
			
			File arq = Arquivo.escolherArquivo(prefDiretorioDados);
			
			if(arq != null) {try {
				
			List<String> s_dados = Arquivo.lerArquivo(arq);	
			List<Float> dados = new ArrayList<Float>();
			
			
			for(Integer n = 0; n < s_dados.size();) {

				dados.add(Float.parseFloat(s_dados.get(n).replace(',', '.')));
				n += 1;
			}
											
			
			arquivoMostrar2.setText(String.valueOf(arq));
							
			n_dados_retorno.setText("n = "+ String.valueOf(s_dados.size()));
			Integer n_dados = s_dados.size();
			
			Float media = Calculo.calcularMedia(dados);
			Float mediana = Calculo.calcularMediana(dados);
			Float desvpad = Calculo.calcularDesvioPadrao(dados, media);
			Float ic = (float) 0.1;
			
			
			if(selecionar_95.isSelected()) {
				ic = Calculo.calcularIntervaloDeConfianca_95(n_dados, desvpad);
			}
			if(selecionar_99.isSelected()) {
				ic = Calculo.calcularIntervaloDeConfianca_99(n_dados, desvpad);
			}
			
			
			if(linguagemAtual==1) {
			mediaMostrar.setText(String.valueOf(media).replace('.', ','));
			medianaMostrar.setText(String.valueOf(mediana).replace('.', ','));
			desvpadMostrar.setText(String.valueOf(desvpad).replace('.', ','));
			icMostrar.setText(String.valueOf(ic).replace('.', ','));
			}
			if(linguagemAtual==2) {
			mediaMostrar.setText(String.valueOf(media));
			medianaMostrar.setText(String.valueOf(mediana));
			desvpadMostrar.setText(String.valueOf(desvpad));
			icMostrar.setText(String.valueOf(ic));
			}
			
			}catch(Exception ee) {
				if(linguagemAtual==1) {
				arquivoMostrar2.setText("O arquivo selecionado não pode ser lido.");}
				if(linguagemAtual==2) {
				arquivoMostrar2.setText("The choosed file could not be read");}
	
			}
			
			}
			
		}
	});
		
		botaoMenuGerarRelatorio.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						String ic = icMostrar.getText();
						
						String s_prefDiretorioRelatorio = null;
						
						try {
							File diretorioPref = new File(new java.io.File(".").getPath()+"\\config\\config.txt");
							List<String> pref = Arquivo.lerArquivo(diretorioPref);	
								s_prefDiretorioRelatorio = new File(pref.get(2)).getPath();			
							}catch(Exception semConfig) {}		
						
						File prefDiretorioRelatorio = new File(s_prefDiretorioRelatorio);	
						
						File caminho = Arquivo.escolherArquivo(prefDiretorioRelatorio);												
						
						String media = mediaMostrar.getText();
						String mediana = medianaMostrar.getText();
						String desvpad = desvpadMostrar.getText();
						String confianca = null;
						Float intervalo_menor = 0f;
						Float intervalo_maior = 0f;

						if(selecionar_95.isSelected()) {
							confianca = "95%"; 
						}
						if(selecionar_99.isSelected()) {
							confianca = "99%"; 
						}if (selecionar_X.isSelected()) {
							confianca = "X %";
						}		
						String n_dados = n_dados_retorno.getText().substring(4);				
						
						
						try {
						intervalo_menor = Float.parseFloat(media.replace(',','.'))-Float.parseFloat(ic.replace(',', '.'));
						intervalo_maior = Float.parseFloat(media.replace(',','.'))+Float.parseFloat(ic.replace(',', '.'));
						
						
						String texto = null;
						
						if(linguagemAtual==1) {
							texto =
								"A média dos " + n_dados + " dados fornecidos está entre " + String.valueOf(intervalo_menor).replace('.', ',') + " e " + String.valueOf(intervalo_maior).replace('.', ',') + " com " + confianca + " de confiança." + "\r\n" +
								"\r\n"	+
								"Resultado = ( " + media + " ± " + ic + " )" + "\r\n" + "\r\n" +
								"...................................." + "\r\n" +
								"\r\n"	+
								"Média aritimética = " + media + "\r\n" +
								"Desvio padrão = " + desvpad + "\r\n" +
								"Mediana = " + mediana + "\r\n";
						}
						if(linguagemAtual==2) {
							texto =						
											"Result = ( " + media.replace(',', '.') + " ± " + ic.replace(',', '.') + " )" + "\r\n" + "\r\n" +
											"...................................." + "\r\n" +
											"\r\n"	+
											"Average = " + media.replace(',', '.') + "\r\n" +
											"Standard deviation = " + desvpad.replace(',', '.') + "\r\n" +
											"Median = " + mediana.replace(',', '.') + "\r\n";
							
						}
						
						String _caminho = caminho+".txt";
						File path = new File(_caminho);
						caminhoMostrar.setText(String.valueOf(caminho)+".txt");

						Arquivo.escreverArquivo(texto, path);
					
					}catch(Exception erro3){
						if(linguagemAtual==1) {
						caminhoMostrar.setText("Não foi possível gerar o relatório.");}
						if(linguagemAtual==1) {
						caminhoMostrar.setText("Could not generate report.");}
					
					}
						
					
					
						
				}
				});
				
		selecionar_95.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			aviso.setText("T_Student - 95%");
			selecionar_99.setSelected(false);
			selecionar_X.setSelected(false);

			
			try {
			Float ic = null;
			Float desvpad = Float.parseFloat(desvpadMostrar.getText().replace(',', '.'));
			String n_dados_string = n_dados_retorno.getText();
			Integer n_dados = Integer.parseInt(n_dados_string.substring(4)); // "n = "
			
			ic = Calculo.calcularIntervaloDeConfianca_95(n_dados, desvpad);
			icMostrar.setText(String.valueOf(ic).replace('.', ','));
			}catch(Exception erro) {}
			
		}
		
		
	});
		
		selecionar_99.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				aviso.setText("T_Student - 99%");
				selecionar_95.setSelected(false);
				selecionar_X.setSelected(false);

				try {
				Float ic = null;
				Float desvpad = Float.parseFloat(desvpadMostrar.getText().replace(',', '.'));
				String n_dados_string = n_dados_retorno.getText();
				Integer n_dados = Integer.parseInt(n_dados_string.substring(4)); // "n = "
				
				ic = Calculo.calcularIntervaloDeConfianca_99(n_dados, desvpad);
				icMostrar.setText(String.valueOf(ic).replace('.', ','));
				}catch(Exception erro) {}
				
				
			}
		});
		
		selecionar_X.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				selecionar_99.setSelected(false);
				selecionar_95.setSelected(false);
				
				try {
				Float ic = null;
				Float desvpad = Float.parseFloat(desvpadMostrar.getText().replace(',', '.'));
				String n_dados_string = n_dados_retorno.getText();
				Integer n_dados = Integer.parseInt(n_dados_string.substring(4)); // "n = "
				
				File inicial = new File(new java.io.File(".").getPath()+"\\score_int_confianca");
				File endereco = Arquivo.escolherArquivo(inicial);
				
				ic = Calculo.calcularIntervaloDeConfianca_X(n_dados, desvpad, endereco);
				
				aviso.setText("T_Student - X");

				icMostrar.setText(String.valueOf(ic).replace('.', ','));
				}catch(Exception erro) {
					selecionar_X.setSelected(false);
					aviso.setText("T_Student - ");


				}
				
				
			}
		});
						
		botaoMenuPref.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JanelaPreferencias preferencias = new JanelaPreferencias();				
				preferencias.setLocationRelativeTo(null);
				preferencias.setVisible(true);
				preferencias.setResizable(false);
				preferencias.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				
				
			}
		});
		
		botaoMenuAjudaFuncoes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {				
				JanelaFuncoes preferencias = new JanelaFuncoes();				
				preferencias.setLocationRelativeTo(null);
				preferencias.setVisible(true);
				preferencias.setResizable(false);
				preferencias.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				
				
			}
			
			
			
		});
		
		botaoMenuAjudaSobre.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			    JOptionPane.showMessageDialog(null, ">IG Tratamento de Dados v 3.2 \r\n>22.12.2022 \r\n>By: Nícolas Dezan dos Santos \r\n>IFES Vila Velha - Brazil");				    				
			}
		});
		
		
	}
}
	
