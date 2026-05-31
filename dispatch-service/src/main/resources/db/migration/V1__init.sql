CREATE TABLE dispatch_requests (
    id UUID PRIMARY KEY,
    ride_id UUID NOT NULL,
    rider_id UUID NOT NULL,
    status VARCHAR(30),
    assigned_driver_id UUID,
    created_at TIMESTAMP
);