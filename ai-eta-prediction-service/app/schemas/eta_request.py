from pydantic import BaseModel

class EtaRequest(BaseModel):

    distance_km: float
    traffic_level: int