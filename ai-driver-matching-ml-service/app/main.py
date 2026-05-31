from fastapi import FastAPI

from app.api.routes import router

app = FastAPI(
    title="RideFlux Driver Matching Service"
)

app.include_router(
    router,
    prefix="/api/v1/matching"
)

@app.get("/health")
def health():
    return {"status": "UP"}