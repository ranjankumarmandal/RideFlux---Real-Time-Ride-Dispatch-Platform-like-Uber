import pandas as pd
import joblib

from xgboost import XGBRegressor

df = pd.read_csv(
    "data/surge_training.csv"
)

X = df[
    [
        "demand_index",
        "available_drivers",
        "weather_score",
        "event_score"
    ]
]

y = df["surge_multiplier"]

model = XGBRegressor()

model.fit(X, y)

joblib.dump(
    model,
    "app/model/surge_model.pkl"
)

print("Surge model trained")