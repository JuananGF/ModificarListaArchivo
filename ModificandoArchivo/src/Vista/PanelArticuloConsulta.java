package Vista;
import java.awt.Canvas;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;


public class PanelArticuloConsulta extends JPanel {
	private JTextField txtPrecio;
	private JTextField txtPVP;
	private JComboBox comboBox;
	private JTextArea txtDesc;
	/**
	 * Create the panel.
	 */
	public PanelArticuloConsulta() {
		GridBagLayout gbl_TabArticulosAlta = new GridBagLayout();
		gbl_TabArticulosAlta.columnWidths = new int[] {10, 50, 50, 50, 50, 50, 50, 50, 50};
		gbl_TabArticulosAlta.rowHeights = new int[] {30, 0, 0, 0, 30, 30, 30, 30, 0, 0};
		gbl_TabArticulosAlta.columnWeights = new double[]{0.0, 1.0, 1.0, 0.0, 1.0, 0.0, 0.0, 0.0};
		gbl_TabArticulosAlta.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0};
		setLayout(gbl_TabArticulosAlta);
		
		JLabel lblNombre = new JLabel("nombre");
		GridBagConstraints gbc_lblNombre = new GridBagConstraints();
		gbc_lblNombre.insets = new Insets(0, 0, 5, 5);
		gbc_lblNombre.anchor = GridBagConstraints.EAST;
		gbc_lblNombre.gridx = 1;
		gbc_lblNombre.gridy = 1;
		add(lblNombre, gbc_lblNombre);
		
		setComboBox(new JComboBox());
		GridBagConstraints gbc_comboBox = new GridBagConstraints();
		gbc_comboBox.gridwidth = 6;
		gbc_comboBox.insets = new Insets(0, 0, 5, 5);
		gbc_comboBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox.gridx = 2;
		gbc_comboBox.gridy = 1;
		add(getComboBox(), gbc_comboBox);
		
		JLabel lblPrecio = new JLabel("precio");
		GridBagConstraints gbc_lblPrecio = new GridBagConstraints();
		gbc_lblPrecio.anchor = GridBagConstraints.EAST;
		gbc_lblPrecio.insets = new Insets(0, 0, 5, 5);
		gbc_lblPrecio.gridx = 1;
		gbc_lblPrecio.gridy = 2;
		add(lblPrecio, gbc_lblPrecio);
		txtPrecio = new JTextField();
		txtPrecio.setEditable(false);
		GridBagConstraints gbc_txtPrecio = new GridBagConstraints();
		gbc_txtPrecio.gridwidth = 2;
		gbc_txtPrecio.insets = new Insets(0, 0, 5, 5);
		gbc_txtPrecio.fill = GridBagConstraints.BOTH;
		gbc_txtPrecio.gridx = 2;
		gbc_txtPrecio.gridy = 2;
		add(txtPrecio, gbc_txtPrecio);
		txtPrecio.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("pvp");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel.gridx = 5;
		gbc_lblNewLabel.gridy = 2;
		add(lblNewLabel, gbc_lblNewLabel);
		
		txtPVP = new JTextField();
		txtPVP.setEditable(false);
		GridBagConstraints gbc_txtPVP = new GridBagConstraints();
		gbc_txtPVP.insets = new Insets(0, 0, 5, 5);
		gbc_txtPVP.gridwidth = 2;
		gbc_txtPVP.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtPVP.gridx = 6;
		gbc_txtPVP.gridy = 2;
		add(txtPVP, gbc_txtPVP);
		txtPVP.setColumns(10);
		
		JLabel lblFoto = new JLabel("foto");
		GridBagConstraints gbc_lblFoto = new GridBagConstraints();
		gbc_lblFoto.anchor = GridBagConstraints.EAST;
		gbc_lblFoto.fill = GridBagConstraints.VERTICAL;
		gbc_lblFoto.insets = new Insets(0, 0, 5, 5);
		gbc_lblFoto.gridx = 1;
		gbc_lblFoto.gridy = 3;
		add(lblFoto, gbc_lblFoto);
		
		JLabel lblDescr = new JLabel("Descr.");
		GridBagConstraints gbc_lblDescr = new GridBagConstraints();
		gbc_lblDescr.insets = new Insets(0, 0, 5, 5);
		gbc_lblDescr.gridx = 4;
		gbc_lblDescr.gridy = 3;
		add(lblDescr, gbc_lblDescr);
		
		Canvas canvas = new Canvas();
		GridBagConstraints gbc_canvas = new GridBagConstraints();
		gbc_canvas.fill = GridBagConstraints.VERTICAL;
		gbc_canvas.gridheight = 2;
		gbc_canvas.gridwidth = 3;
		gbc_canvas.insets = new Insets(0, 0, 5, 5);
		gbc_canvas.gridx = 1;
		gbc_canvas.gridy = 4;
		add(canvas, gbc_canvas);
		
		txtDesc = new JTextArea();
		txtDesc.setEditable(false);
		GridBagConstraints gbc_txtDesc = new GridBagConstraints();
		gbc_txtDesc.insets = new Insets(0, 0, 5, 5);
		gbc_txtDesc.gridheight = 3;
		gbc_txtDesc.gridwidth = 4;
		gbc_txtDesc.fill = GridBagConstraints.BOTH;
		gbc_txtDesc.gridx = 4;
		gbc_txtDesc.gridy = 4;
		add(txtDesc, gbc_txtDesc);
		
		
	}
	public JTextField getTxtPrecio() {
		return txtPrecio;
	}
	public void setTxtPrecio(String txtPrecio) {
		this.txtPrecio.setText(txtPrecio);
	}
	public JTextField getTxtPVP() {
		return txtPVP;
	}
	public void setTxtPVP(String txtPVP) {
		this.txtPVP.setText(txtPVP);
	}
	public JTextArea getTxtDesc() {
		return txtDesc;
	}
	public void setTxtDesc(String txtDesc) {
		this.txtDesc.setText(txtDesc);
	}
	public JComboBox getComboBox() {
		return comboBox;
	}
	public void setComboBox(JComboBox comboBox) {
		this.comboBox = comboBox;
	}

}
