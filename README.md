# Base64 Encoding and Decoding in Java

A comprehensive implementation of Base64 encoding and decoding algorithms in Java, demonstrating how this fundamental data encoding scheme works.

## Table of Contents
- [What is Base64?](#what-is-base64)
- [How Base64 Encoding Works](#how-base64-encoding-works)
- [How Base64 Decoding Works](#how-base64-decoding-works)
- [Implementation Details](#implementation-details)
- [Java Implementation](#java-implementation)
- [Usage Examples](#usage-examples)
- [Technical Specifications](#technical-specifications)
- [Getting Started](#getting-started)

## What is Base64?

Base64 is a binary-to-text encoding scheme that represents binary data in sequences of 24 bits that can be represented by four 6-bit Base64 digits. It's commonly used to encode binary data for transmission over media that are designed to deal with textual data, such as:

- **Email attachments** (MIME encoding)
- **Data URLs** in web applications
- **JSON Web Tokens (JWT)**
- **XML data**
- **HTTP Basic Authentication**

The Base64 alphabet consists of 64 characters:
- **A-Z** (26 characters): Values 0-25
- **a-z** (26 characters): Values 26-51  
- **0-9** (10 characters): Values 52-61
- **+** (1 character): Value 62
- **/** (1 character): Value 63
- **=** (padding character)

## How Base64 Encoding Works

Base64 encoding converts binary data into a text representation using a 64-character alphabet. Here's the step-by-step process:

### Step 1: Convert to Binary
Take the input data and represent it as a continuous string of binary digits (bits).

### Step 2: Group into 6-bit Chunks
Divide the binary string into groups of 6 bits. If the last group has fewer than 6 bits, pad it with zeros.

### Step 3: Convert to Decimal
Convert each 6-bit group to its decimal equivalent (0-63).

### Step 4: Map to Base64 Characters
Use the decimal values as indices into the Base64 character set.

### Step 5: Add Padding
If the input length is not divisible by 3, add padding characters (`=`) to make the output length divisible by 4.

### Example:
```
Input: "Man"
Binary: 01001101 01100001 01101110
Grouped: 010011 010110 000101 101110
Decimal: 19     22     5      46
Base64:  T      W      F      u
Output: "TWFu"
```

## How Base64 Decoding Works

Base64 decoding reverses the encoding process:

### Step 1: Remove Padding
Remove any padding characters (`=`) from the end of the input.

### Step 2: Convert to Indices
Convert each Base64 character back to its 6-bit binary representation.

### Step 3: Concatenate Bits
Join all the 6-bit groups into a continuous binary string.

### Step 4: Group into Bytes
Divide the binary string into 8-bit groups (bytes).

### Step 5: Convert to Characters
Convert each byte to its corresponding character or binary value.

## Implementation Details

This repository provides a Java implementation that demonstrates:

### Core Features
- **Pure Java Implementation**: No external dependencies required
- **Custom Base64 Algorithm**: Hand-coded encoding/decoding logic for educational purposes
- **Standard Compliance**: Follows RFC 4648 specification
- **Error Handling**: Robust input validation and error reporting
- **Performance Optimized**: Efficient bit manipulation operations

### Key Components
1. **Base64Encoder Class**: Handles the encoding process
2. **Base64Decoder Class**: Handles the decoding process
3. **Utility Methods**: Helper functions for binary operations
4. **Test Suite**: Comprehensive unit tests with various test cases

### Algorithm Complexity
- **Time Complexity**: O(n) where n is the input size
- **Space Complexity**: O(n) for the output buffer

## Java Implementation

This repository showcases the implementation of Base64 encoding and decoding using Java. The implementation includes:

### Classes and Structure
```
src/
├── main/
│   └── java/
│       └── com/
│           └── example/
│               ├── Base64Encoder.java    # Main encoding logic
│               ├── Base64Decoder.java    # Main decoding logic
│               ├── Base64Utils.java      # Utility methods
│               └── Main.java             # Demo application
└── test/
    └── java/
        └── com/
            └── example/
                └── Base64Test.java       # Unit tests
```

### Key Features of the Java Implementation

#### 1. Bit Manipulation
- Efficient use of bitwise operations (`>>`, `<<`, `&`, `|`)
- Proper handling of byte boundaries
- Optimized buffer management

#### 2. Character Set Handling
- Support for different character encodings (UTF-8, ASCII)
- Proper Unicode handling
- Binary data processing

#### 3. Memory Management
- Minimal object allocation
- Efficient string building
- Stream-based processing for large files

#### 4. Error Handling
- Input validation
- Malformed Base64 detection
- Graceful error recovery

## Usage Examples

### Basic Encoding
```java
String original = "Hello, World!";
String encoded = Base64Encoder.encode(original);
System.out.println(encoded); // Output: SGVsbG8sIFdvcmxkIQ==
```

### Basic Decoding
```java
String encoded = "SGVsbG8sIFdvcmxkIQ==";
String decoded = Base64Decoder.decode(encoded);
System.out.println(decoded); // Output: Hello, World!
```

### Binary Data Encoding
```java
byte[] binaryData = {72, 101, 108, 108, 111};
String encoded = Base64Encoder.encode(binaryData);
System.out.println(encoded); // Output: SGVsbG8=
```

## Technical Specifications

### Padding Rules
- **No padding needed**: When input length % 3 == 0
- **One padding character**: When input length % 3 == 2
- **Two padding characters**: When input length % 3 == 1

### Character Mapping Table
| Value | Character | Value | Character | Value | Character | Value | Character |
|-------|-----------|-------|-----------|-------|-----------|-------|-----------|
| 0     | A         | 16    | Q         | 32    | g         | 48    | w         |
| 1     | B         | 17    | R         | 33    | h         | 49    | x         |
| ...   | ...       | ...   | ...       | ...   | ...       | ...   | ...       |
| 62    | +         | 63    | /         |       |           |       |           |

### Performance Characteristics
- **Encoding Overhead**: ~33% increase in size
- **Processing Speed**: Linear with input size
- **Memory Usage**: 2x input size (temporary buffers)

## Getting Started

### Prerequisites
- Java 8 or higher
- Maven (optional, for building)

### Running the Implementation
1. Clone this repository:
   ```bash
   git clone https://github.com/Kaemikun/Base64EncodingAndDecoding.git
   ```

2. Navigate to the project directory:
   ```bash
   cd Base64EncodingAndDecoding
   ```

3. Compile the Java files:
   ```bash
   javac -d build src/main/java/com/example/*.java
   ```

4. Run the demo:
   ```bash
   java -cp build com.example.Main
   ```

### Running Tests
```bash
javac -d build -cp .:junit.jar src/test/java/com/example/*.java
java -cp build:junit.jar org.junit.runner.JUnitCore com.example.Base64Test
```

## Educational Value

This implementation is designed to be educational and demonstrates:
- **Bit manipulation techniques** in Java
- **Algorithm implementation** from specification
- **Test-driven development** practices
- **Clean code principles**
- **Performance optimization** strategies

## Contributing

Feel free to contribute by:
- Adding more test cases
- Optimizing the algorithm
- Improving documentation
- Adding new features (URL-safe encoding, streaming support)

## License

This project is open source and available under the [MIT License](LICENSE).

---

*This implementation is created for educational purposes to demonstrate how Base64 encoding and decoding works at a fundamental level.*