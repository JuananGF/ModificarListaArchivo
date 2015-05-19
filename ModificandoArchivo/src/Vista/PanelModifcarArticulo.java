package Vista;

import java.awt.GridBagConstraints;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.event.DocumentEvent;

import Controlador.DocumentAdapter;
import Controlador.ListaArticulos;
import Modelo.Articulo;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeEvent;

public class PanelModifcarArticulo extends PanelArticuloConsulta {
	protected JButton btnModificar;
	protected ListaArticulos lista;
	//Esta propiedad me ayuda porque se cual es el articulo que estoy modificando
	protected Articulo articuloActual;
	//Empiezan las banderas
	//detecta si los cambios son producidos por un nuevo elemento
	boolean banderaNuevoElemento=true;
	//Si he modificado un elemento concreto
	boolean elementosModificados=false;
	
	public PanelModifcarArticulo() throws ClassNotFoundException, IOException {
		super();
		getTxtPrecio().getDocument().addDocumentListener(new DocumentAdapter() {
			@Override
			public void insertUpdate(DocumentEvent e) {
				if(!banderaNuevoElemento){
				System.out.println("era solo por enredar pero no hace nada");
				}
				else
					banderaNuevoElemento=false;
			}
			
		});
		lista=new ListaArticulos();
		getTxtPrecio().setEditable(true);
		btnModificar = new JButton("Modificar");
		btnModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				guardarModificacion();
			}

			private void guardarModificacion() {
				if(articuloActual!=null){
					//Me pregunto tontamente si el articulo esta en la lista
					if(lista.getListaArt().contains(articuloActual)){
						//Asumir que siempre ha habido una modificacion
						try {
							articuloActual.setPrecio(Float.parseFloat(
									getTxtPrecio().getText()));
						} catch (NumberFormatException e1) {
							articuloActual.setPrecio(0);
						}
						int posicionArticuloEnLaLista=lista.getListaArt().indexOf(articuloActual);
						lista.getListaArt().set(posicionArticuloEnLaLista,articuloActual);
						try {
							//Guarda la lista existente con el articulo modificado
							lista.guardarNuevoArticulo(null);
						} catch (FileNotFoundException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
				}
			}
		});
		GridBagConstraints gbc_btnModificar = new GridBagConstraints();
		gbc_btnModificar.gridwidth = 2;
		gbc_btnModificar.insets = new Insets(0, 0, 5, 5);
		gbc_btnModificar.gridx = 2;
		gbc_btnModificar.gridy = 7;
		add(btnModificar, gbc_btnModificar);
		
		rellenaCombo();		
		
		getComboBox().addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				banderaNuevoElemento = true;
				rellenaFormularioArticuloConsulta(e.getItem());
			}

		});
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
