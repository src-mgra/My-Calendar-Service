# MyCalendarService
MyCalendarService is a soap JAX-WS webservice with a year/month/weekday-view
               
Call URL with Param:
http://localhost:4435/calendarservice Param  
Param = 18-10-2017-J                                                
                                                
________________________________
WSDL of soap service:     

http://calwsdl.it-docs.de

--> methode show

--> Parameter dateval = dd-mm-yyyy-t

t = J --> year-view / 
t = M --> month-view / 
t = W --> weekday
________________________________


Demo by wsdlbrowser.com: 

http://calservice.it-docs.de/

________________________________

See details of implementation (without webservice) here:

https://github.com/src-mgra/MyCalendarService/blob/master/src/calendarservice/ShowCalImpl.java
