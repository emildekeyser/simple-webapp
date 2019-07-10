
# ┃┃┃┏━┛┏━ ━━┃      ┃ ┃┏━┛┃ ┃┃┃┃┏━┃┏━┃┏━ ┏━┛
# ┃┃┃┏━┛┏━┃┏━┛  ━┛  ┏┛ ┏━┛━┏┛┃┃┃┃ ┃┏┏┛┃ ┃━━┃
# ━━┛━━┛━━ ━━┛      ┛ ┛━━┛ ┛ ━━┛━━┛┛ ┛━━ ━━┛

## ⓒⓛⓘⓔⓝⓣ ⓢⓔⓡⓥⓔⓡ ⓜⓞⓓⓔⓛ

Het client server model beschrijft de relatie tussen twee 
computerprogramma's in een proces. Deze relatie is asymmetrisch. 
De cliënt verstuurt een service verzoek aan een ander programma, 
de server. De server verwerkt het verzoek. Hoewel het client-server 
principe kan worden gebruikt door programma's binnen een enkele 
computer, is het belangrijker binnen een netwerk.

heeft een service nodig <> biedt een service aan
draait client programma <> draait server programma
deelt geen resources 	<> deelt resources met client
begint communicatie		<> wacht op vraag
vraagt (request) 		<> antwoordt (response)

* asymmetrisch
* resources
* service

## HTTP

* hoe boodschappen gevormd en overgebracht moeten worden
* hoe browsers en web servers hiermee moeten omgaan
* protocol 
* communicatie
* WWW

### HTTP requests

* Get, Post, Put, Delete, ...

GET /Web_1_Servlet/index.html 						>request
HTTP/1.1 											}
Host: localhost:8080								}
User-Agent: Mozilla/5.0 (Macintosh; Intel Mac OS 	}
X 10.9; rv:30.0) Gecko/20100101 Firefox/30.0 		}
Accept: text/html,application/ 						}> headers
xhtml+xml,application/xml;q=0.9,*/*;q=0.8 			}
Accept-Language: nl-be,en-gb;q=0.7,en;q=0.3 		}					
Accept-Encoding: gzip, deflate 						}	
Cookie: textwrapon=false; wysiwyg=textarea 			}				
Connection: keep-alive 								}
													> \n =einde

http://localhost:8080/Web_1_Servlet/index.html 		>url
	   -------------- -------------------------
	        host              path

dus request = zie boven <==> response = html+css+js

### Error Codes

* 1xx = Informational
* 2xx = Success
* 3xx = Redirection
* 4xx = Client Error
* 5xx = Server Error

## Servlets

* Web Container: kan alles wat een HTTP server kan, en meer.
* Servlet: naam van een java webcontainer
* Dynamisch <> Statisch
* /file.html <> @Webservlet("/file")public class File{}

instantiation -> init -> (service -> 
doGet/doPost) -> destroy

* Parameters => lezen uit een request (type:string)
* Attributen => schrijven naar een request (type:object)

## Stappen van programeur tot websitebezoeker

1. Ontwikkelaar schrijft html en Java (of php, ...)
2. http request -> Klant vraagt webpagina 
3. Web container vraagt aan de Java klasse om html te genereren
4. De Java klasse genereert html
5. http response -> html wordt teruggegeven aan de browser
6. browser verwerkt html een toont pagina

## JSP

* Scriplet = <% codecodecode.... %>
* Declaration = <%! int getal = 12456 %> 
	(zelfde voor alle gebruikers)
* Directives = <%@ codecodecode %>
* Directive attributes = <%@ include file="header.jsp" %>, 
	<%@ page import="java.util.date" %>
* Expression <%="fuckyou sysout"%>

* Attributen => lezen, krijgen van overervende servlet class

## GET

* Paramaters: in url
* Doel: data ophalen
* Afspraak: GEEN side-effect/aanpassingen op de server
* querystring = key-value pairs en ? & =
* IDEMPOTENT = het mag niet uit maken of een GET vaker gestuurd wordt

http://<host>/<path>?param1=val1&param2=val2
----					------------------------
protcool					querystring


GET Request				| Response
-------------------------------------------------------
* request lijn met URL	| * response lijn met status code
* headers extra info	| * headers met extra info
						| * body met bv. HTML

## POST

* Parameters: in request body
* Dient voor CRUD operaties/side effects toegelaten


## POST vs. GET

* Bookmarks: gaat met GET , niet met POST
* Cache: gaat met GET, niet met POST
* Restrictions on length/type: GET has(not good) and post has not(good)
* Back button: good with GET, warning with POST
* Parameters in history: GET not POST
* Security: POST
* Visibility: GET
	

## Selenium

WATCH OUT NO Separation Of Concerns =>
change className or change the css class => tests need to be 
rewritten

## TDD

* Model => throw exceptions when faulty data is received
* Controller => catch exceptions, pass errromsgs to view
* View => Display errormsgs

* Client side: snelheid+gemak+mooi
* Server side: veiligheid/zekerheid

## JSPF
= java server page fragment

## CRUD
= create read update delete