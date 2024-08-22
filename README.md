# Mac Media Controller Backend
This Spring Boot application offers a RESTful API to manage media settings on a Mac, including volume control, media playback (play/pause), skipping forward/backward, and remotely shutting down or putting the system to sleep. You can run this application on your Mac and use your mobile device to access the Mac's IP address for remote control.

## Features

- **Volume Control**: REST endpoints to increase or decrease the volume of the Mac.
- **Media Control**: REST endpoints to play/pause media, and skip forward or backward.
- **Shutdown/Sleep**: REST endpoints to shut down the Mac or put it to sleep.

## Getting Started

### Prerequisites

- Java 17 or later
- Maven
- Mac running macOS

### Installation

1. **Clone the repository:**
   ```bash
   git clone https://github.com/your-username/mac-media-controller-backend.git
   cd mac-media-controller-backend
   ```

2. **Build the project:**
   ```bash
   mvn clean install
   ```

3. **Run the application:**
   ```bash
   mvn spring-boot:run
   ```

   The application will start on the default port `8081`. You can access the API at `http://localhost:8081` or `http://<mac-ip>:8081` from another device.

### Configuration

You can change the default port by editing the `application.properties` file located in `src/main/resources`:

```properties
server.port=8081
```

### API Endpoints

- **Volume Up/Down**: `GET /volume?level={Enter value between 0-100}`
- **Play/Pause Video**: `GET /space`
- **Play/Pause Spotify**: `GET /spotify/playpause`
- **Skipping Backward**: `GET /arrow?type=123`
- **Skipping Forward**: `GET /arrow?type=124`
- **Sleep**: `GET /sleep`
- **Shutdown**: `GET /shutdown`

### Usage

1. **Volume Control:**
   - Use the `/volume?level=N` endpoint to adjust the Mac's volume, where N is the desired level.
   - Example to set volume to 50%:
     ```bash
     curl http://<mac-ip>:8081/volume?level=50
     ```

2. **Media Control:**
   - **Play/Pause Video:** Access the `/space` endpoint to play or pause the video.
   - **Play/Pause Spotify:** Use the `/spotify/playpause` endpoint to control Spotify playback.
   - **Skipping Backward:** Use the `/arrow?type=123` endpoint to skip 5 seconds backward.
   - **Skipping Forward:** Use the `/arrow?type=124` endpoint to skip 5 seconds forward.

3. **Shutdown/Sleep:**
   - **Sleep:** Access the `/sleep` endpoint to put the Mac to sleep.
   - **Shutdown:** Access the `/shutdown` endpoint to remotely shut down the Mac.
   - Example:
     ```bash
     curl http://<mac-ip>:8081/shutdown
     ```

### Security Considerations

This application exposes endpoints that could potentially be misused. It is recommended to secure these endpoints, especially in a production environment, using Spring Security or similar tools.

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
