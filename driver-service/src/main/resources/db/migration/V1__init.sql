CREATE TABLE drivers (
    id UUID PRIMARY KEY,
    name VARCHAR(100),
    phone VARCHAR(20),
    vehicle_number VARCHAR(50),
    vehicle_type VARCHAR(20),
    status VARCHAR(20),
    created_at TIMESTAMP
);