from fastapi import APIRouter

from app.schemas.pricing_request import PricingRequest
from app.model.predictor import predict_surge

router = APIRouter()

@router.post("/predict")
def predict(request: PricingRequest):

    surge = predict_surge(
        request.demand_index,
        request.available_drivers,
        request.weather_score,
        request.event_score
    )

    return {
        "surge_multiplier": surge
    }