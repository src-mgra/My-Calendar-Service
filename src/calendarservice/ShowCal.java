package calendarservice;

import javax.jws.*;

@WebService
public interface ShowCal
{
   public String show( @WebParam( name = "dateval" ) String dateval );
}
