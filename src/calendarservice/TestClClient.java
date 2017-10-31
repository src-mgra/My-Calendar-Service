package calendarservice;

import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;

public class TestClClient
{
   public static void main( final String[] args ) throws Throwable
   {
      String url = ( args.length > 0 ) ? args[0] : "http://localhost:4434/calendarservice";
      Service service = Service.create(
            new URL( url + "?wsdl" ),
            new QName( "http://calendarservice/", "ShowCalImplService" ) );
      ShowCal showCal = service.getPort( ShowCal.class );
      System.out.println( "\n" + showCal.show( args.length > 1 ? args[1] : "" ) );
   }
}
