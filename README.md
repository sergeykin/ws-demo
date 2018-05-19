# ws-demo
Simple SOAP server

WSDL model: http://localhost:8081/ws/countries.wsdl

H2 DB Console: http://localhost:8081/console

[Link to the REST Client over this app](https://github.com/EugeneVanchugov/ws-client)


Endpoint: http://localhost:8081/ws

XML **createCountryRequest** example: 

```xml
<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/"
				  xmlns:gs="http://eugene.com/wsdemo/domain">
   <soapenv:Header/>
   <soapenv:Body>
      <gs:createCountryRequest>
      	<gs:country>
                <gs:name>Russia</gs:name>
                <gs:population>146880432</gs:population>
                <gs:capital>Moscow</gs:capital>
                <gs:currency>RUB</gs:currency>
            </gs:country>
      </gs:createCountryRequest>
   </soapenv:Body>
</soapenv:Envelope>
```

Response example: 

```xml
<SOAP-ENV:Envelope xmlns:SOAP-ENV="http://schemas.xmlsoap.org/soap/envelope/">
    <SOAP-ENV:Header/>
    <SOAP-ENV:Body>
        <ns2:getCountryResponse xmlns:ns2="http://eugene.com/wsdemo/domain">
            <ns2:country>
                <ns2:id>1</ns2:id>
                <ns2:name>Russia</ns2:name>
                <ns2:population>146880432</ns2:population>
                <ns2:capital>Moscow</ns2:capital>
                <ns2:currency>RUB</ns2:currency>
            </ns2:country>
        </ns2:getCountryResponse>
    </SOAP-ENV:Body>
</SOAP-ENV:Envelope>
```
