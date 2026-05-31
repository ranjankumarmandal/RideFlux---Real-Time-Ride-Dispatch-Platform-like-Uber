CREATE TABLE payments (
    id UUID PRIMARY KEY,
    trip_id UUID NOT NULL,
    rider_id UUID NOT NULL,
    driver_id UUID NOT NULL,
    amount DOUBLE PRECISION,
    status VARCHAR(20),
    created_at TIMESTAMP
);