CREATE TYPE gameState AS ENUM ('Evening', 'Morning','Lobby','End');
CREATE TYPE playerState AS ENUM('Dead', 'Alive');
CREATE TYPE playerRole AS ENUM('Narrator', 'Vigilante','Sheriff','Lookout','Veteran','Doctor',
  'BodyGuard','Mayor','Escort','Retributionist','Transporter','Godfather','Mafioso','Framer',
  'Blackmailer','Consort','Survivor','Jester','Executioner','Serial Killer');

ALTER TABLE GameSession
  ADD COLUMN State gameState,
  ADD COLUMN PlayerCount INTEGER;

ALTER TABLE Player
  ADD COLUMN Status playerState,
  ADD COLUMN PlayerRole playerRole;