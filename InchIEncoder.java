import java.net.URLEncoder;

public class InchIEncoder{

public String inchistring;


public InchIEncoder(String inchi)
{
	inchistring = inchi;

}

public String Encode()
{
	
	String code1 = URLEncoder.encode(inchistring);
	
	String finalcode = URLEncoder.encode(code1);
	
	return finalcode;

}

public static void main(String[] args)
{
	InchIEncoder myinchi = new InchIEncoder("InChI=1S/CH4/h1H4");
	System.out.println(myinchi.Encode());
	
	
}

}