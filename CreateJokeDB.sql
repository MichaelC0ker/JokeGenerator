CREATE DATABASE JokeDB;
GO

USE JokeDB;
GO

CREATE TABLE [BaseJoke] (
  [baseJokeID] INT PRIMARY KEY NOT NULL IDENTITY(1, 1),
  [baseJoke] VARCHAR(2000) NOT NULL
)
GO

CREATE TABLE [Punchline] (
  [punchlineID] INT PRIMARY KEY NOT NULL IDENTITY(1, 1),
  [punchline] VARCHAR(800) NOT NULL
)
GO

CREATE TABLE [Rating] (
  [baseJokeID] INT NOT NULL,
  [punchlineID] INT NOT NULL,
  [rating] TINYINT NOT NULL
)
GO

ALTER TABLE [Rating]
ADD CONSTRAINT [RatingPK] 
PRIMARY KEY ([baseJokeID],[punchlineID])
GO

ALTER TABLE [Rating] ADD FOREIGN KEY ([baseJokeID]) REFERENCES [BaseJoke] ([baseJokeID])
GO

ALTER TABLE [Rating] ADD FOREIGN KEY ([punchlineID]) REFERENCES [Punchline] ([punchlineID])
GO
