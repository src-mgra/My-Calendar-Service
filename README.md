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

Demo by wsdlbrowser.com: 

http://wsdlbrowser.com/soapclient?wsdl_url=http%3A%2F%2Fec2-18-194-146-48.eu-central-1.compute.amazonaws.com%3A4435%2Fcalendarservice%3Fwsdl&function_name=show
