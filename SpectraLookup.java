import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathFactory;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

/**
 * Created by alexanderwilliams on 9/30/15.
 */


//Major thanks to Gunther on StackOverflow for how to import XML in Java
//Major thanks to GK27 on StackOverflow for how to get attributes from XML code

public class SpectraLookup {

    String accessurl;

    public SpectraLookup(String url) {
        accessurl = url;

    }

    public static NodeList lookup(String accessurl) throws Exception {
        //Grab XML file from the database
        URLConnection nmrspectrum = new URL(accessurl).openConnection();

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

        //Selects all elements that contain the xValues for the NMR Spectrum
        String expression = "/cml/spectrum/peakList/*[@xValue]";

        NodeList nodeList = (NodeList) nmrpath.evaluate(expression, nmrdoc, XPathConstants.NODESET);

        return nodeList;


    }

}