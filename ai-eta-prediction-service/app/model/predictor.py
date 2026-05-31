import joblib
import numpy as np

model = joblib.load("app/model/eta_model.pkl")

def predict_eta(distance_km: float,
                traffic_level: int):

    prediction = model.predict(
        np.array([[distance_km, traffic_level]])
    )

    return round(float(prediction[0]), 2)