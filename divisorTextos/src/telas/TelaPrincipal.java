package telas;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import entidades.Idioma;
import threads.ProcessamentoTextos;

public class TelaPrincipal extends JDialog {

	private JPanel painel = new JPanel(new GridBagLayout());

	private JLabel txtEntrada = new JLabel("Texto de Entrada");
	private JLabel txtSaida = new JLabel("Texto de Saída");

	private JTextField campoEntrada = new JTextField();
	private JTextField campoSaida = new JTextField();

	private JButton buttonStart = new JButton("Start");

	private ProcessamentoTextos processador = new ProcessamentoTextos();

	public TelaPrincipal() {
		setTitle("Separador de Idiomas");
		setSize(new Dimension(380, 250));
		setLocationRelativeTo(null);
		setResizable(true);

		GridBagConstraints gridBag = new GridBagConstraints();
		gridBag.gridx = 0;
		gridBag.gridy = 0;
		gridBag.insets = new Insets(5, 5, 5, 5);

		txtEntrada.setPreferredSize(new Dimension(100, 25));
		painel.add(txtEntrada, gridBag);

		gridBag.gridy++;
		campoEntrada.setPreferredSize(new Dimension(250, 25));
		painel.add(campoEntrada, gridBag);

		gridBag.gridy++;
		txtSaida.setPreferredSize(new Dimension(100, 25));
		painel.add(txtSaida, gridBag);

		gridBag.gridy++;
		campoSaida.setPreferredSize(new Dimension(250, 25));
		painel.add(campoSaida, gridBag);

		gridBag.gridy++;
		gridBag.gridx++;
		buttonStart.setPreferredSize(new Dimension(80, 25));
		painel.add(buttonStart, gridBag);

		buttonStart.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				if (processador != null) {
					processador = new ProcessamentoTextos();
					processador.start();
				}
				Idioma caminhoIdioma = new Idioma();
				caminhoIdioma.setCaminhoEntrada(campoEntrada.getText());
				processador.adicionarLinhas(caminhoIdioma);

				caminhoIdioma.setCaminhoSaida(campoSaida.getText());
				processador.adicionarLinhas(caminhoIdioma);

				if (caminhoIdioma.getCaminhoEntrada().equals(caminhoIdioma.getCaminhoSaida())) {
					JOptionPane.showMessageDialog(null, " Error! Not allowed to change the source file ");
					processador.stop();
				}else {
					JOptionPane.showMessageDialog(null, "Wait, please!");
					setVisible(false);
				}

			}
		});

		add(painel);
		setVisible(true);
	}

}
