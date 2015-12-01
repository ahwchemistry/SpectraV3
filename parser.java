import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamReader;
import javax.xml.xpath.*;
import javax.xml.parsers.*;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;


//Major thanks to Gunther on StackOverflow for how to import XML in Java
//Major thanks to GK27 on StackOverflow for how to get attributes from XML code
//Prototype to create the NMR Spectra Viewer.

public class parser{

	
	

	public static void main(String[] args) throws Exception {
	
	
	//Grab XML file from the database
	URLConnection nmrspectrum = new URL("http://nmrshiftdb.nmr.uni-koeln.de/NmrshiftdbServlet/nmrshiftdbaction/searchorpredict/smiles/CC1C=CC(=CC(CC=CC(=CCCC(C=CC=CC(C(OC(=O)C(=C1)C)C(=CC=C(C)CNC(=O)C(CO)NC=O)C)C)OC)C)OC)C/spectrumtype/13C").openConnection();

	//Get inputstream from the xml file
	InputStream nmrdata = nmrspectrum.getInputStream();

	//Build document builder factory
	DocumentBuilderFactory xmlNMR = DocumentBuilderFactory.newInstance();
	
	//Create document builder from document builder factory
	DocumentBuilder NMRBuilder = xmlNMR.newDocumentBuilder();
	
	//Create document from the document builder
	Document nmrdoc = NMRBuilder.parse(nmrdata);
		
	//Parse through the document with XPATH, create new factory for creating xpaths
	XPathFactory nmrfactory = XPathFactory.newInstance();
	
	//Create Xpath
	XPath nmrpath = nmrfactory.newXPath();
	
	String expression = "/cml/spectrum/peakList/*[@xValue]";

   	NodeList nodeList = (NodeList) nmrpath.evaluate(expression, nmrdoc, XPathConstants.NODESET);
   	
   	for (int i = 0; i < nodeList.getLength(); i++)
{
    Node currentItem = nodeList.item(i);
    String key = currentItem.getAttributes().getNamedItem("xValue").getNodeValue();
    
    Double xvalue = Double.parseDouble(key);
    
    System.out.println("" + key);
}


     

	
		
}
	
	}
	