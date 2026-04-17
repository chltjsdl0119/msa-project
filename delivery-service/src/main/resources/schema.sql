CREATE TABLE IF NOT EXISTS deliveries (
    id            BIGSERIAL PRIMARY KEY,
    order_id      BIGINT      NOT NULL,
    customer_id   BIGINT      NOT NULL,
    rider_id      BIGINT,
    status        VARCHAR(20) NOT NULL,
    address       VARCHAR(255) NOT NULL,
    created_at    TIMESTAMP   NOT NULL DEFAULT NOW(),
    updated_at    TIMESTAMP   NOT NULL DEFAULT NOW()
);
