from fastapi import APIRouter

from app.schemas.eta_request import EtaRequest
from app.model.predictor import predict_eta

router = APIRouter()

@router.post("/predict")
def predict(request: EtaRequest):

    eta = predict_eta(
        request.distance_km,
        request.traffic_level
    )

    return {
        "predicted_eta_minutes": eta
    }