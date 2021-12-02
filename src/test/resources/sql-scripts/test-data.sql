
CREATE TABLE IF NOT EXISTS movies (
  id INT AUTO_INCREMENT PRIMARY KEY,
  name VARCHAR(50) NOT NULL,
  minutes INT NOT NULL,
  genre VARCHAR(50) NOT NULL
);

insert into movies (name, minutes, genre) values
    ('Dark Knight', 152, 'Action'),
    ('Memento', 113, 'Thriller'),
    ('Matrix', 136, 'Action');
