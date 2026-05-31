import pandas as pd
import torch

from transformers import AutoTokenizer
from transformers import AutoModel

MODEL_NAME = "distilbert-base-uncased"

tokenizer = AutoTokenizer.from_pretrained(
    MODEL_NAME
)

encoder = AutoModel.from_pretrained(
    MODEL_NAME
)

df = pd.read_csv(
    "data/demand_training.csv"
)

texts = []

for _, row in df.iterrows():

    text = (
        f"hour {row['hour']} "
        f"day {row['day_of_week']} "
        f"weather {row['weather']} "
        f"event {row['event']}"
    )

    texts.append(text)

embeddings = []

for text in texts:

    inputs = tokenizer(
        text,
        return_tensors="pt",
        truncation=True,
        padding=True
    )

    with torch.no_grad():

        outputs = encoder(**inputs)

        embedding = outputs.last_hidden_state.mean(
            dim=1
        )

        embeddings.append(
            embedding.squeeze().numpy()
        )

torch.save(
    embeddings,
    "app/model/demand_model.pt"
)

print("Demand model prepared")