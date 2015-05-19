package Vista;

import java.awt.GridBagConstraints;
import java.awt.Insets;

import javax.swing.JButton;

import Controlador.ListaArticulos;
import Modelo.Articulo;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PanelModifcarArticulo extends PanelArticuloConsulta {
	protected JButton btnModificar;
	protected ListaArticulos lista;
	protected Articulo articuloActual;
	
	public PanelModifcarArticulo() {
		super();
		getTxtPrecio().setEditable(true);
		btnModificar = new JButton("Modificar");
		btnModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		GridBagConstraints gbc_btnModificar = new GridBagConstraints();
		gbc_btnModificar.gridwidth = 2;
		gbc_btnModificar.insets = new Insets(0, 0, 5, 5);
		gbc_btnModificar.gridx = 2;
		gbc_btnModificar.gridy = 7;
		add(btnModificar, gbc_btnModificar);
		
		rellenaCombo();		
	}
	private Articulo rellenaFormularioArticuloConsulta(Object item) {
		Articulo instancia = (Articulo) item;
		this.setTxtPrecio(String.valueOf(instancia.getPrecio()));
		this.setTxtPVP(String.valueOf(instancia.getPvp()));
		this.setTxtDesc(instancia.getDescripcion());
		return instancia;

	}

	private void rellenaCombo() {
		this.getComboBox().removeAll();
		for (Articulo articulo : lista.getListaArt()) {
			this.getComboBox().addItem(articulo);
		}
		articuloActual = rellenaFormularioArticuloConsulta(this.getComboBox().getSelectedItem());

	}
}
