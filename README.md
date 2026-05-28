# Todo Test API

Simple Spring Boot REST API for API analyzer testing.

## Endpoints

### Create todo

```http
POST /api/v1/todos
Content-Type: application/json
```

```json
{
  "title": "Write API test fixture",
  "description": "Create a realistic Spring REST API"
}
```

Successful response:

```http
HTTP/1.1 201 Created
```

```json
{
  "id": 1,
  "title": "Write API test fixture",
  "description": "Create a realistic Spring REST API",
  "completed": false,
  "createdAt": "2026-05-28T14:30:00Z"
}
```

### Get todos

```http
GET /api/v1/todos
```

Successful response:

```json
[
  {
    "id": 1,
    "title": "Write API test fixture",
    "description": "Create a realistic Spring REST API",
    "completed": false,
    "createdAt": "2026-05-28T14:30:00Z"
  }
]
```

## Run

```bash
mvn spring-boot:run
```

## Test

```bash
mvn test
```
