package interfaceChat;

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import chatgpt.ChatIA;

public class Chat extends JFrame{

	JPanel painelPrincipal, painelSolicitante, painelResposta;
	JTextArea caixaTexto;
	JLabel textoResposta,textoSolicitacao;
	JScrollPane scroll;
	
	public Chat() {
		super("ChatGPT3");
		setLayout(null);
		setSize(400,500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		configComponentes();
		eventos();
		
		setVisible(true);
	}
	
	public void configComponentes() {
		caixaTexto = new JTextArea();
		caixaTexto.setBounds(0,410,400,50);
		add(caixaTexto);
		
		painelPrincipal = new JPanel(null);
		painelPrincipal.setBounds(0,0,400,450);
		painelPrincipal.setBackground(Color.CYAN);
		add(painelPrincipal);
		
		textoResposta = new JLabel("<html>Aguardando ordens do Sr. Capitão...</html>");
		textoResposta.setBounds(50,0,300,400);
		painelPrincipal.add(textoResposta);
	}
	
	public void eventos() {
		caixaTexto.addKeyListener(new KeyListener() {

			int ENTER_KEY = 13;
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}

			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				if(e.getKeyCode()==e.VK_ENTER) {
					ChatIA ia = new ChatIA();
					System.out.println("Solicitação em andamento...");
					ia.solicitar(caixaTexto.getText());
					ia.responder();
					textoResposta.setText("<html>" +ia.resposta +"</html>");
					System.out.println("Solicitação concluída!");
					repaint();
				}
			}

			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}});
	}
	
	public static void main(String[] args) {
		new Chat();
	}
}
