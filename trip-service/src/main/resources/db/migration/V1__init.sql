CREATE TABLE trips (
    id UUID PRIMARY KEY,
    ride_id UUID NOT NULL,
    rider_id UUID NOT NULL,
    driver_id UUID NOT NULL,
    status VARCHAR(20),
    start_time TIMESTAMP,
    end_time TIMESTAMP,
    created_at TIMESTAMP
);