import java.io.IOException;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import java.util.Iterator;




import org.w3c.dom.Element;
import org.w3c.dom.NodeList;


public class parser {
	
	private Document dom = null;
	private ArrayList<Accion> Acciones = null;

	public parser() {
		Acciones = new ArrayList<Accion>();
	}

	public void parseFicheroXml(String fichero) {
		// creamos una factory
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();

		try {
			// creamos un documentbuilder
			DocumentBuilder db = dbf.newDocumentBuilder();

			// parseamos el XML y obtenemos una representación DOM
			dom = db.parse(fichero);
		} catch (ParserConfigurationException pce) {
			pce.printStackTrace();
		} catch (SAXException se) {
			se.printStackTrace();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}

	}

	public void parseDocument() {
		// obtenemos el elemento raíz
		Element docEle = dom.getDocumentElement();

		// obtenemos el nodelist de elementos
		NodeList nl = docEle.getElementsByTagName("accion");
		if (nl != null && nl.getLength() > 0) {
			for (int i = 0; i < nl.getLength(); i++) {

				// obtenemos un elemento de la lista (libro)
				Element el = (Element) nl.item(i);

				// obtenemos una libro
				Accion a = getaccion(el);

				// lo añadimos al array
				Acciones.add(a);
			}
		}
	}
	
	private Accion getaccion(Element accion){
		
		
		 String nombre= accion.getAttribute("nombre");
		 
		ArrayList <Operacion> Operaciones= getOperacion(accion);
		
		//String titulo = getTextValue(personaEle,"nombre");
		//int edad = getIntValue(personaEle,"edad");
		
		//Creamos una nueva persona con los elementos leídos del nodo
		Accion e = new Accion( nombre, Operaciones);

		return e;		
		
	}
	
	private ArrayList<Operacion> getOperacion (Element accion){
		ArrayList <Operacion> Operaciones= new ArrayList<Operacion> ();
		
		// obtenemos el nodelist de elementos
		NodeList nl = accion.getElementsByTagName("operaciones");
		if (nl != null && nl.getLength() > 0) {
				
				Element el = (Element) nl.item(0);
				
				NodeList nl1 = accion.getElementsByTagName("operacion");
				if (nl1 != null && nl1.getLength() > 0) {
					
					for (int i = 0; i < nl1.getLength(); i++)	{
						
						Element el1 = (Element) nl1.item(i);
						
						String tipo=getTextValue(el1,"tipo");;
						int cantidad=getIntValue(el1,"cantidad");
						double precio=getDoubleValue(el1,"precio");
						
						Operacion auxiliar= new Operacion (tipo, cantidad, precio);
						Operaciones.add(auxiliar);
					}

				}
			
		}
		
		return Operaciones;
	}
	
	
	
	private String getTextValue(Element ele, String tagName) {
		String textVal = null;
		NodeList nl = ele.getElementsByTagName(tagName);
		if(nl != null && nl.getLength() > 0) {
			Element el = (Element)nl.item(0);
			textVal = el.getFirstChild().getNodeValue();
		}		
		return textVal;
	}
	
	private int getIntValue(Element ele, String tagName) {				
		return Integer.parseInt(getTextValue(ele,tagName));
	}
	private double getDoubleValue(Element ele, String tagName) {				
		return  Double.parseDouble(getTextValue(ele,tagName));
	}
	
	public void print(){
		

		Iterator it = Acciones.iterator();
		
		while(it.hasNext()) {
			
			Accion a=(Accion) it.next();
			System.out.println(a.toString());
		}
		
	}
	
	

}