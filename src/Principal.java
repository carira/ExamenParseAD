
public class Principal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		parser parser= new parser();
		parser.parseFicheroXml("DNIExa.xml");
		parser.parseDocument();
		parser.print();
	}

}
