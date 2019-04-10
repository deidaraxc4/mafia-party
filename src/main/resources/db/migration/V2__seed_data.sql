INSERT INTO public.gamesession(
  gamesession_id, game_state, player_count)
VALUES (1, 'Lobby', 2);

INSERT INTO public.player(
  player_id, player_name, gamesession_id, player_status, player_role)
VALUES (1, 'bob', 1, 'Alive', 'Narrator'),
       (2, 'joe', 1, 'Alive', 'Vigilante');