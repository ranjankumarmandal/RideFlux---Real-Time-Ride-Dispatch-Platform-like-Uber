CREATE TABLE rides (
    id UUID PRIMARY KEY,
    rider_id UUID NOT NULL,
    pickup_latitude DOUBLE PRECISION,
    pickup_longitude DOUBLE PRECISION,
    drop_latitude DOUBLE PRECISION,
    drop_longitude DOUBLE PRECISION,
    vehicle_type VARCHAR(20),
    status VARCHAR(20),
    created_at TIMESTAMP
);