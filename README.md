# MyCalendarService
MyCalendarService is a soap JAX-WS webservice with a year/month/weekday-view
               
Call URL with Param:
http://localhost:4435/calendarservice Param  
Param = 18-10-2017-J                                                
                                                
________________________________
WSDL of soap service:     

http://ec2-18-194-146-48.eu-central-1.compute.amazonaws.com:4435/calendarservice?wsdl

--> methode show

--> Parameter dateval = dd-mm-yyyy-t

t = J --> year-view / 
t = M --> month-view / 
t = W --> weekday
________________________________

Kalender des Jahres  2017
November
Mo Di Mi Do Fr Sa So
       1  2  3  4  5 
 6  7  8  9 10 11 12 
13 14 15 16 17 18 19 
20 21 22 23 24 25 26 
27 28 29 30

Demo by wsdlbrowser.com: 

http://wsdlbrowser.com/soapclient?wsdl_url=http%3A%2F%2Fec2-18-194-146-48.eu-central-1.compute.amazonaws.com%3A4435%2Fcalendarservice%3Fwsdl&function_name=show

________________________________

See details of implementation (without webservice) here:

https://github.com/src-mgra/MyCalendarService/blob/master/src/calendarservice/ShowCalImpl.java
