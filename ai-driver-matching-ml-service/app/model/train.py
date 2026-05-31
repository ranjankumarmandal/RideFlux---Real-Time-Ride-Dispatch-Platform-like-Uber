import pandas as pd
import joblib

from xgboost import XGBRegressor

df = pd.read_csv("data/driver_matching.csv")

X = df[
    [
        "distance_km",
        "eta_minutes",
        "driver_rating",
        "acceptance_rate"
    ]
]

y = df["match_score"]

model = XGBRegressor()

model.fit(X, y)

joblib.dump(
    model,
    "app/model/matching_model.pkl"
)

print("Driver matching model trained")