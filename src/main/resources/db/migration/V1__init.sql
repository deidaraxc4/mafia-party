CREATE TABLE IF NOT EXISTS Player (
  PlayerId SERIAL PRIMARY KEY NOT NULL,
  PlayerName CHARACTER VARYING(12),
  PlayerRole CHARACTER VARYING
);

CREATE TABLE IF NOT EXISTS Narrator (
  NarratorId SERIAL PRIMARY KEY NOT NULL,
  NarratorName CHARACTER VARYING(12)
);

CREATE TABLE IF NOT EXISTS GameSession (
  GameSessionId SERIAL PRIMARY KEY NOT NULL,
  NarratorId SERIAL REFERENCES  Narrator (NarratorId),
  Player1Id SERIAL REFERENCES Player (PlayerId),
  Player2Id SERIAL REFERENCES Player (PlayerId),
  Player3Id SERIAL REFERENCES Player (PlayerId),
  Player4Id SERIAL REFERENCES Player (PlayerId),
  Player5Id SERIAL REFERENCES Player (PlayerId),
  Player6Id SERIAL REFERENCES Player (PlayerId),
  Player7Id SERIAL REFERENCES Player (PlayerId),
  Player8Id SERIAL REFERENCES Player (PlayerId),
  Player9Id SERIAL REFERENCES Player (PlayerId),
  Player10Id SERIAL REFERENCES Player (PlayerId),
  Player11Id SERIAL REFERENCES Player (PlayerId),
  Player12Id SERIAL REFERENCES Player (PlayerId),
  Player13Id SERIAL REFERENCES Player (PlayerId),
  Player14Id SERIAL REFERENCES Player (PlayerId),
  Player15Id SERIAL REFERENCES Player (PlayerId)
);