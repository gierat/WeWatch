INSERT INTO movies (title, description, image_path)
VALUES ('Severance', 'Mark leads a team of office workers whose memories have been surgically divided between their work and personal lives. When a mysterious colleague appears outside of work, it begins a journey to discover the truth about their jobs.', '/api/images/movies/severance.jpg'),
       ('Nosferatu', 'A gothic tale of obsession between a haunted young woman and the terrifying vampire infatuated with her, causing untold horror in its wake.', '/api/images/movies/nosferatu.jpg'),
       ('American Primeval', 'It follows the gritty and adventurous exploration of the birth of the American West, the violent collisions of cults, religion, and men and women fighting for control of the new world.', '/api/images/movies/american_primeval.jpg'),
       ('Back In Action', 'Former CIA spies Emily and Matt are pulled back into espionage after their secret identities are exposed.', '/assets/movies/back_in_action.jpg'),
       ('The Night Agent', 'Low-level FBI agent Peter Sutherland works in the basement of the White House manning a phone that never rings - until the night it does, propelling him into a conspiracy that leads all the way to the Oval Office.', '/api/images/movies/the_night_agent.jpg');

INSERT INTO categories (name)
VALUES ('Action'), ('Drama'), ('Comedy'),('Thriller'), ('Scifi'), ('Horror'), ('Fantasy');

INSERT INTO movie_categories (movie_id, category_id)
VALUES (1, 2),(1, 4),(1,5),
       (2, 6),(2,7),
       (3, 1),(3,2),(3,4),
       (4, 1), (4, 3),
       (5,1), (5, 2), (5 , 4);