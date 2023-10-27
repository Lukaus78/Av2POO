package q5_LucasLevi;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Main extends JFrame implements ActionListener {
    private static final long serialVersionUID = 1L;
    private static final int MAX_TENTATIVAS = 5;
    private static final int INTERVALO_NUMEROS = 20;

    private int numeroAlvo;
    private int tentativasRestantes;
    private JTextField campoTentativas;

    public Main() {
        super("Jogo de Adivinhação");
        setLayout(new FlowLayout());

        numeroAlvo = gerarNumeroAleatorio();
        tentativasRestantes = MAX_TENTATIVAS;

        JButton[] botoes = new JButton[INTERVALO_NUMEROS];
        for (int i = 0; i < INTERVALO_NUMEROS; i++) {
            botoes[i] = new JButton(String.valueOf(i + 1));
            botoes[i].addActionListener(this);
            add(botoes[i]);
        }

        campoTentativas = new JTextField(10);
        campoTentativas.setEditable(false);
        add(campoTentativas);

        setSize(300, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton botaoClicado = (JButton) e.getSource();
        int palpiteUsuario = Integer.parseInt(botaoClicado.getText());

        tentativasRestantes--;
        campoTentativas.setText("Tentativas restantes: " + tentativasRestantes);

        if (palpiteUsuario == numeroAlvo) {
            JOptionPane.showMessageDialog(this, "Parabéns! Você acertou o número.", "Sucesso",
                    JOptionPane.INFORMATION_MESSAGE);
            System.out.println("Palpite do usuário: " + palpiteUsuario);
            System.out.println("Número alvo: " + numeroAlvo);
            System.out.println("O usuário acertou!");
            System.exit(0);
        } else if (tentativasRestantes == 0) {
            JOptionPane.showMessageDialog(this,
                    "Suas tentativas acabaram. O número correto era " + numeroAlvo + ".", "Fim de Jogo",
                    JOptionPane.ERROR_MESSAGE);
            System.out.println("Palpite do usuário: " + palpiteUsuario);
            System.out.println("Número alvo: " + numeroAlvo);
            System.out.println("O usuário não acertou.");
            System.exit(0);
        } else {
            System.out.println("Palpite do usuário: " + palpiteUsuario);
            System.out.println("Número alvo: " + numeroAlvo);
            System.out.println("O usuário não acertou. Tentativas restantes: " + tentativasRestantes);
        }
    }

    private int gerarNumeroAleatorio() {
        Random random = new Random();
        return random.nextInt(INTERVALO_NUMEROS) + 1;
    }

    public static void main(String[] args) {
        new Main();
    }
}
