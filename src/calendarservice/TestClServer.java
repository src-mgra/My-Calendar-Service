package calendarservice;

import javax.xml.ws.Endpoint;

public class TestClServer
{
   public static void main( final String[] args )
   {
      String url = ( args.length > 0 ) ? args[0] : "http://localhost:4434/calendarservice";
      Endpoint.publish( url, new ShowCalImpl() );
   }
}
