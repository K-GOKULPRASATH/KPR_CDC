# KPRIET CDC Frontend

## Run locally
Requires Node.js 20+.

```bash
cd frontend
cp .env.example .env
npm install
npm run dev
```

Vite prints the local URL. The current UI includes the role-specific demo sign-in screens, glassmorphism dashboard, profile forms, charts, search/filtering and CSV export. UI edits currently operate on the in-browser demo state; connect the `VITE_API_URL` REST endpoints before treating updates as persistent/shared data.
