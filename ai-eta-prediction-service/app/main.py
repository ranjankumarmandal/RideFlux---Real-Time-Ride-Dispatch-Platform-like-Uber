from fastapi import FastAPI

from app.api.routes import router

app = FastAPI(
    title="RideFlux ETA Service"
)

app.include_router(
    router,
    prefix="/api/v1/eta"
)

@app.get("/health")
def health():
    return {"status": "UP"}