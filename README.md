# URL Shortener Application

A simple and efficient **URL Shortener** built using **Java**. This application allows users to shorten long URLs and expand short URLs back to their original form. The URL shortening process uses **Base62 encoding**, and all URL mappings are stored in a persistent text file (`urlmappings.txt`).

---

## Features

* **Shorten Long URLs**: Convert long, unwieldy URLs into compact, easy-to-share links.
* **Expand Short URLs**: Retrieve the original URL from a shortened version.
* **Persistent Storage**: All shortened URLs and their mappings are saved in a local file, ensuring data persists across sessions.
* **Base62 Encoding**: Short URLs are generated using Base62 encoding, allowing for a large number of unique short links.

---

## How It Works

1. **Shorten URL**:

   * Enter a long URL and click the **"Shorten URL"** button. A unique short URL will be generated and displayed.

2. **Expand URL**:

   * Enter a shortened URL and click the **"Expand URL"** button to retrieve the original long URL.

3. **Persistent Storage**:

   * All URL mappings (short and long) are stored in a text file (`urlmappings.txt`), ensuring that the mappings persist even after the app is closed and reopened.

4. **Base62 Encoding**:

   * The app uses a custom Base62 encoding system (`0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ`) to generate short URLs, ensuring scalability and uniqueness.

---

## Installation

### Prerequisites

Make sure you have **Java 8 or higher** installed on your system.

### Steps to Run Locally

1. **Clone the repository**:

   ```bash
   git clone [https://github.com/kashifraza01]
   cd URL-Shortener
   ```

2. **Compile and Run**:

   * Open the project in your favorite Java IDE (e.g., IntelliJ IDEA, Eclipse).
   * Locate and run the `Gui.java` file to start the application.

3. **Start Shortening URLs**:

   * The graphical user interface (GUI) will open, allowing you to shorten and expand URLs easily.

---

## File Structure

```
URL-Shortener/
│
├── kashif/
│   ├── A.java              # Contains Base62 encoding/decoding logic.
│   ├── Gui.java            # The graphical user interface for interacting with the URL shortener.
│   └── Url.java            # Core URL shortening logic (handling mappings, URL encoding/decoding).
│
├── urlmappings.txt         # Stores URL mappings (Shortened URL -> Long URL).
└── README.md               # This README file.
```

---

## Contributing

Contributions are welcome! If you find any bugs, have suggestions, or want to improve the project, feel free to:

* Fork the repository.
* Open an issue to report a bug or request a feature.
* Submit a pull request with your changes.

---

## License

This project is licensed under the [MIT License](LICENSE).

---

## Contact

Author: [Kashif Raza](https://github.com/kashifraza01)
