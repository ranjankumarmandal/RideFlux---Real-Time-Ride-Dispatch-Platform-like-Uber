from pydantic import BaseModel

class PricingRequest(BaseModel):

    demand_index: int

    available_drivers: int

    weather_score: int

    event_score: int