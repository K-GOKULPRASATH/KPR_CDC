# KPRIET CDC API

## Run locally
Requirements: Java 21+ and Maven 3.9+.

```bash
cd backend
mvn spring-boot:run
```

The API starts on port 8080 (or `PORT`). H2 file storage is created under `backend/data` when run from the repository root. Configure `DATABASE_URL`, `DATABASE_USERNAME`, and `DATABASE_PASSWORD` to use PostgreSQL or another compatible database.

## Endpoints
- `GET /api/health`
- `POST /api/auth/login` body: `{"id":"24CBL03","password":"StudentID123"}`
- `GET /api/students`
- `GET /api/students/{id}`
- `POST /api/students`
- `PUT /api/students/{id}`
- `DELETE /api/students/{id}`

## Important security status
This is an initial development scaffold, **not production ready**. API routes currently permit requests without authenticated authorization, and the demo login only validates hard-coded development credentials. Before real student data is added, implement server-side session/JWT authentication, role/ownership checks for every endpoint, rate limiting, audit logging, institutional identity integration, secrets management, and HTTPS. Never deploy with the sample passwords or expose actual student data to this scaffold.
