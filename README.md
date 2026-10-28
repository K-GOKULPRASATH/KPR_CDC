# KPRIET Career Development Cell

A React + Spring Boot starting point for KPRIET's Career Development Cell. **GitHub is the source of truth:** https://github.com/K-GOKULPRASATH/KPR_CDC

## Repository layout
- `frontend/` — React + Vite interface, Recharts visualizations and responsive glassmorphism styling
- `backend/` — Spring Boot REST API, Spring Data JPA and H2 local database
- `backend/README.md` — API run instructions and endpoint reference
- `frontend/README.md` — frontend run instructions

## Run locally
1. Install Node.js 20+, Java 21+, and Maven 3.9+.
2. In terminal 1: `cd backend && mvn spring-boot:run` (API on port 8080).
3. In terminal 2: `cd frontend && cp .env.example .env && npm install && npm run dev` (Vite prints the local URL).

## Demo credentials (development only)
- Student IDs: `24CBL03`, `23CB001`; password: `StudentID123`
- Staff IDs: `CDC01`, `TP026`; password: `StaffID123`

## Current implementation status
The React interface includes role selection, sample dashboards, profile forms, charts, student filtering, placement-status controls, and CSV export. The Spring Boot scaffold provides login validation and student REST endpoints with synthetic seed records. **The React demo currently uses browser-local sample state and is not yet wired to the REST API for shared/persistent updates.** Do not treat demo changes as saved to the backend until this integration is completed.

## Security warning — not production ready
The API currently permits requests without authenticated authorization; the login endpoint validates predictable hard-coded demo credentials. Before any real student records are loaded, implement server-side session/JWT authentication, role and record-ownership checks for every endpoint, secure account provisioning/password storage, rate limiting, audit logging, HTTPS and secret management. Do not deploy publicly with these demo credentials or store actual student data in this initial scaffold.

All seeded student profiles are synthetic placeholders for development and must be reviewed/replaced before institutional use.
