import pandas as pd
import joblib

from xgboost import XGBRegressor

df = pd.read_csv("data/eta_training.csv")

X = df[["distance_km", "traffic_level"]]
y = df["eta_minutes"]

model = XGBRegressor()

model.fit(X, y)

joblib.dump(model, "app/model/eta_model.pkl")

print("ETA model trained")