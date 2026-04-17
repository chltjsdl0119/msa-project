CREATE TABLE IF NOT EXISTS notifications (
    id          BIGSERIAL PRIMARY KEY,
    order_id    BIGINT       NOT NULL,
    customer_id BIGINT       NOT NULL,
    type        VARCHAR(20)  NOT NULL,
    message     TEXT         NOT NULL,
    status      VARCHAR(20)  NOT NULL,
    created_at  TIMESTAMP    NOT NULL DEFAULT NOW()
);
