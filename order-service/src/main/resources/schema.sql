CREATE TABLE IF NOT EXISTS orders (
    id          BIGSERIAL PRIMARY KEY,
    customer_id BIGINT      NOT NULL,
    status      VARCHAR(20) NOT NULL,
    total_price DECIMAL     NOT NULL,
    created_at  TIMESTAMP   NOT NULL DEFAULT NOW()
);
