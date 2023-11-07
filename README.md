# TCP/IP Server-Client Application

This server-client application allows communication over TCP/IP. The server performs various operations on received data and can execute predefined commands. The client can send commands to the server and receive messages in response.

## Part 2: Client Application

### Functionality

2.1. **Send Commands**: The client can send commands to the server. Enter a command in the console, and it will be sent to the server for processing.

2.2. **Receive Messages**: The client receives messages from the server in response to the commands sent. The client also receives periodic messages from the server every 10 seconds.

2.3. **Log Messages**: The client logs sent and received information in a file named "LogFile."

### Usage

1. Clone the repository and navigate to the client application folder.

2. Compile and run the client application. Use your preferred development environment, or execute the application via the command line:

3. The client will connect to the server at the specified host and port (localhost:8080 by default).

4. Follow the prompts to send commands to the server and receive responses.

## Important Notes

- Make sure the server application is running before starting the client application.
- The "Commands" file can be manually edited to define custom commands and their corresponding responses.

Enjoy using the TCP/IP Server-Client application!