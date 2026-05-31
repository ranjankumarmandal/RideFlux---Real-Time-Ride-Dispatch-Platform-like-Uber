from fastapi import FastAPI

from app.api.routes import router

app = FastAPI(
    title="RideFlux Surge Pricing Service"
)

app.include_router(
    router,
    prefix="/api/v1/surge"
)

@app.get("/health")
def health():
    return {"status": "UP"}