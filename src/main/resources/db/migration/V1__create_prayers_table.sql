CREATE TABLE pending_prayers (
    id BIGSERIAL PRIMARY KEY,

    firebase_uid VARCHAR(128) NOT NULL,

    prayer_name VARCHAR(20) NOT NULL,

    prayer_date DATE NOT NULL,

    created_at TIMESTAMP NOT NULL DEFAULT NOW()
);

CREATE UNIQUE INDEX uq_pending_prayer
ON pending_prayers(firebase_uid, prayer_name, prayer_date);

CREATE INDEX idx_pending_prayer_uid_date
ON pending_prayers(firebase_uid, prayer_date);