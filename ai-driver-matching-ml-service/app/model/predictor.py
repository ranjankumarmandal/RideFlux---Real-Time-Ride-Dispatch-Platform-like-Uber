import joblib
import numpy as np

model = joblib.load(
    "app/model/matching_model.pkl"
)

def predict_score(
    distance_km,
    eta_minutes,
    driver_rating,
    acceptance_rate
):

    prediction = model.predict(
        np.array([[
            distance_km,
            eta_minutes,
            driver_rating,
            acceptance_rate
        ]])
    )

    return round(float(prediction[0]), 2)