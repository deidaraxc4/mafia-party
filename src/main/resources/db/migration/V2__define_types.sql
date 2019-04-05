CREATE TYPE timeOfDay AS ENUM ('Evening', 'Morning');
CREATE TYPE playerState AS ENUM('Dead', 'Alive');

ALTER TABLE GameSession
ADD COLUMN State timeOfDay,
ADD COLUMN PlayerCount INTEGER;

ALTER TABLE Player
ADD COLUMN Status playerState;