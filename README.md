# Mac Media Controller Backend

This Spring Boot application provides a RESTful API to control media settings on a Mac mini, including volume control and shutting down the system remotely.

## Features

- **Volume Control**: REST endpoints to increase or decrease the volume of the Mac mini.
- **Shutdown**: REST endpoint to shut down the Mac mini.

## Getting Started

### Prerequisites

- Java 17 or later
- Maven
- Mac running macOS

### Installation

1. **Clone the repository:**
   ```bash
   git clone https://github.com/your-username/mac-mini-media-controller-backend.git
   cd mac-mini-media-controller-backend
   ```

2. **Build the project:**
   ```bash
   mvn clean install
   ```

3. **Run the application:**
   ```bash
   mvn spring-boot:run
   ```

   The application will start on the default port `8081`. You can access the API at `http://localhost:8081` or `http://<mac-mini-ip>:8081` from another device.

### Configuration

You can change the default port by editing the `application.properties` file located in `src/main/resources`:

```properties
server.port=8081
```

### API Endpoints

- **Volume Up/Down**: `GET /volume?level={Enter value between 0-100}`
- **Pause/Play Video**: `GET /space`
- **Play/Pause Spotify**: `GET /spotify/playpause`
- **skipping backward**: `GET /arrow?type=123`
- **skipping forward**: `GET /arrow?type=124`
- **Shutdown**: `GET /sleep`
- **Shutdown**: `GET /shutdown`

### Usage

1. **Volume Control:**
   - Use the `/volume?level=N endpoint to adjust the Mac's volume, where N is the level desired
   - Example to increase volume:
     ```bash
     curl http://<mac-mini-ip>:8081/volume?=50
     ```

2. **Shutdown:**
   - Access the `/shutdown` endpoint to remotely shut down the Mac mini.
   - Example:
     ```bash
     curl http://<mac-mini-ip>:8081/shutdown
     ```

### Security Considerations

This application exposes a shutdown endpoint that could potentially be misused. It is recommended to secure this endpoint, especially in a production environment, using Spring Security or similar tools.

### Troubleshooting

- **Port Already in Use:** If you encounter a `Web server failed to start. Port 8080 was already in use.` error, change the port in the `application.properties` file.
- **404 Error on Endpoint Access:** Ensure the URL path matches the controller mapping. Check the logs for more details.

### Contributing

Contributions are welcome! Please fork the repository and create a pull request with your changes.

### License

This project is licensed under the MIT License. See the `LICENSE` file for details.

### Acknowledgements

- [Spring Boot](https://spring.io/projects/spring-boot)
- [macOS](https://www.apple.com/macos/)
