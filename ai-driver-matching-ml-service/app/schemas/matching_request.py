from pydantic import BaseModel

class MatchingRequest(BaseModel):

    distance_km: float

    eta_minutes: float

    driver_rating: float

    acceptance_rate: float