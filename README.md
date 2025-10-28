
# Jfinder

This Back-end API allows you to resolve a word search.This API provide you the x and the y of the first letter of the word (fistX and firstY) and even the x and the y of the last letter of this word (lastX and lastY).This allows a better mapping in th Front-end.This API can't grab words vertically.But not for long!



## Features

- Java 21
- Maven 3.6.3
- Spring boot 4.0.0-M3
- Lombok 1.18.40
- Log4j2
- Git 2.34.1
- Ubuntu 22.4
- Docker 28.2.2

## Future Feature

- JUnit

##To Run Locally

###Option 1
- Java 21
- Git 2.34.1
###Option 2
- Docker 28.2.2

## Run Locally (with java + git)

Clone the project

```bash
  git clone https://link-to-project
```

Go to the project directory

```bash
  cd jfinder
```
Start the application

```bash
  java -jar target/*.jar
```

## Run Locally (with docker)

Pull the image

```bash
  docker pull mateusdev26/jfinder:1.9v
```

Run the container
```bash
  docker run -p 8080:8080 mateusdev26/jfinder:1.9v
```

# API Reference

## Find Words in Grid
All endpoint are provide to **localhost:8080**
```http
  GET /api/jfinder/find
```

### Request

| Parameter | Type | Description |
| :-------- | :------- | :------------------------- |
| `grid` | `string[][]` | **Required**. 2D array of letters |
| `hiddenWords` | `string[]` | **Required**. List of words to find |

### Request Body Example
```json
{
  "grid": [
    ["S", "U", "N"],
    ["S", "E", "A"],
    ["F", "U", "N"]
  ],
  "hiddenWords": [
    "SUN",
    "SEA",
    "FUN"
  ]
}
```

### Response Example
```json
[
  {
    "firstY": 3,
    "fistX": 1,
    "lastX": 3,
    "lastY": 3,
    "word": "SUN"
  },
  {
    "firstY": 2,
    "fistX": 1,
    "lastX": 3,
    "lastY": 2,
    "word": "SEA"
  },
  {
    "firstY": 1,
    "fistX": 1,
    "lastX": 3,
    "lastY": 1,
    "word": "FUN"
  }
]
```
### Important!!!
- **The 2D array must be a perfect square like 3x3 and 5x5**


### Response Fields
- **firstY**: Starting row position (1-based)
- **fistX**: Starting column position (1-based)
- **lastX**: Ending column position (1-based)
- **lastY**: Ending row position (1-based)
- **word**: The found word

### Error Responses
- **400 Bad Request**: Invalid input parameters
- **500 Internal Server Error**: Internal server error

## What's new?
- Version 1.7
- Fixed banner issue
- Added **Docker**
