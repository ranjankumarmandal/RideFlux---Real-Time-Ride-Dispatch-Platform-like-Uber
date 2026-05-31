from fastapi import APIRouter

from app.schemas.demand_request import DemandRequest

from app.model.predictor import predict_demand

router = APIRouter()

@router.post("/forecast")
def forecast(
    request: DemandRequest
):

    demand = predict_demand(
        request.hour,
        request.day_of_week,
        request.weather,
        request.event
    )

    return {
        "predicted_demand": demand
    }