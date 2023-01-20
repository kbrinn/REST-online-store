# Controller Package

The controller packages interacts with the service layer. It handles the requests from the client into the service layer.

An HTTP request is made by a client, to a named host, which is located on a server.

Controllers Create, Read, Update and Delete. The aim of CRUD operations is to access
resources on the server. To make the request, the client uses components of a URL:

## The URL is made up of a protocol, a host, a port, a path and a query string.
*
1. The protocol is the method of communication between the client and the server. (REST)

2. The host is the name of the server.

3. The port is the port number of the server. Each port is associated with a different process or service.

4. The path is the location of the resource on the server. ("/api/something/")

5. The query string is the data that is sent to the server.

## Process of HTTP request

1. The client sends the request to the server. The controller acts as a broker

2. The server processes the request and sends a response back to the client.

3. The response contains the status code (HEAD,POST,PATCH, etc) and the data.

4. The status code indicates whether the request was successful or not.

5. The data is the response from the server.

6. The client receives the response and displays it to the user.

The aim of the request is to access a resource on the server. To make the request,
the client uses components of a URL (Uniform Resource Locator), which includes the information
needed to access the resource.