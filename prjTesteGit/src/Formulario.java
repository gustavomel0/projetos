import java.awt.Insets;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/*
 * Formulario.java criado em 10/12/2012
 * 
 * Propriedade de Objectos Fábrica de Software LTDA.
 * Reprodução parcial ou total proibida.
 */

/**
 * @author marcio.endo@objectos.com.br (Marcio Endo)
 */
public class Formulario extends JFrame {
	public JButton btnOk;

	public Formulario() {
		this.setTitle("Teste git");
		this.setLayout(null);
		this.setSize(300, 100);
		this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);

		btnOk = new JButton("Ok");
		btnOk.setBounds(50, 15, 50, 25);
		btnOk.setMargin(new Insets(0, 0, 0, 0));
		this.add(btnOk);
		btnOk.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JOptionPane.showMessageDialog(null, "Ok");
			}
		});

	}

}
