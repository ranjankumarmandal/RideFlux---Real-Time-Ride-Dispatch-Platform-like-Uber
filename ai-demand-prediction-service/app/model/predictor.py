def predict_demand(
        hour,
        day_of_week,
        weather,
        event):

    score = 50

    score += hour * 4

    score += day_of_week * 8

    score += weather * 40

    score += event * 80

    return score