import joblib
import numpy as np

model = joblib.load(
    "app/model/surge_model.pkl"
)

def predict_surge(
        demand_index,
        available_drivers,
        weather_score,
        event_score):

    prediction = model.predict(
        np.array([[
            demand_index,
            available_drivers,
            weather_score,
            event_score
        ]])
    )

    return round(float(prediction[0]), 2)