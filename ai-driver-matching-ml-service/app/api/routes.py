from fastapi import APIRouter

from app.schemas.matching_request import MatchingRequest

from app.model.predictor import predict_score

router = APIRouter()

@router.post("/score")
def score_driver(
    request: MatchingRequest
):

    score = predict_score(
        request.distance_km,
        request.eta_minutes,
        request.driver_rating,
        request.acceptance_rate
    )

    return {
        "matching_score": score
    }