package Controlador;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import Modelo.AccesoFicherosSerializado;
import Modelo.Articulo;

public class ListaArticulos {
	private ArrayList<Articulo> listaArt;
	final String fichero = "articulos.dat";

	public ListaArticulos() throws ClassNotFoundException, IOException {
		try {
			cargarArticulos();
		} catch (FileNotFoundException e) {
			setListaArt(new ArrayList<Articulo>());
		}
	}

	// Leer los articulos del fichero
	public void cargarArticulos() throws ClassNotFoundException, IOException {
		setListaArt((ArrayList<Articulo>) new AccesoFicherosSerializado().leerObjeto(fichero));
	}

	// almacena un nuevo articulo
	public void guardarNuevoArticulo(Articulo articulo) throws FileNotFoundException, IOException {
		//Si el usuario pasa null como parametro guardaré la lista con los mismos
//		articulos que ya tiene
		if (articulo != null) {
			getListaArt().add(articulo);
			Collections.sort(getListaArt(), new Comparator<Articulo>() {
				@Override
				public int compare(Articulo o1, Articulo o2) {
					// Integer valor=new
					// Integer(o1.getNombre().compareTo(o2.getNombre()));
					// System.out.println("valor de la comparacion "+valor);
					// return valor;
					return new Integer(o1.getNombre().compareTo(o2.getNombre()));
				}
			});
		}
		new AccesoFicherosSerializado().escribirObjeto(getListaArt(), fichero);
	}

	public void listarArticulos() throws ClassNotFoundException, IOException {
		cargarArticulos();
		for (Articulo articulo : getListaArt()) {
			System.out.println("articulo " + articulo.toString());
		}
	}

	// public boolean buscarArticulo(String nombre) {
	//
	// }
	public ArrayList<Articulo> getListaArt() {
		return listaArt;
	}

	public void setListaArt(ArrayList<Articulo> listaArt) {
		this.listaArt = listaArt;
	}

	public boolean buscarElemento(String text) {
		for (Articulo articulo : listaArt) {
			if (articulo.toString().equals(text))
				return true;
		}
		return false;
	}

	public void crearNuevoElemento(String nombre, String precio, String descripcion) throws FileNotFoundException,
			IOException {
		Articulo instancia = new Articulo(nombre, Float.parseFloat(precio), descripcion);
		guardarNuevoArticulo(instancia);

	}

}
