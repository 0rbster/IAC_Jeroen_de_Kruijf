package business;
import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.xml.ws.Endpoint;

/**
 * Created by Jeroen on 12-Mar-17.
 */
@WebService()
public class VerbruikService {
  @WebMethod
  public String berekenVerbruik(String verkeerType, String kilometers) {
    int km = Integer.parseInt(kilometers);
    switch (verkeerType){
      case "spits":
        return "Verbruik: "+(0.900 * km)+"KwH";
      case "normaal":
        return "Verbruik: "+(0.400 * km)+"KwH";
      case "snelrijden":
        return "Verbruik: "+(1.2 * km)+"KwH";
    }

    return "0";
  }

  public static void main(String[] argv) {
    Object implementor = new VerbruikService();
    String address = "http://localhost:9000/VerbruikService";
    Endpoint.publish(address, implementor);
  }
}
