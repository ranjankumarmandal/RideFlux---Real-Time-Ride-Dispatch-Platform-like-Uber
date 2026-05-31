from pydantic import BaseModel

class DemandRequest(BaseModel):

    hour: int

    day_of_week: int

    weather: int

    event: int