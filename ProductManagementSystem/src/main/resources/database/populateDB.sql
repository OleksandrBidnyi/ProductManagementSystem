USE productmanagementdb2;

-- products
INSERT INTO products VALUES
  (1, 'Galaxy S8','Samsung','Android phone',550),
  (2, 'iPhone7','Apple','iOS phone',700),
  (3, 'GE 60 2PE Apache Pro','MSI','Gaming Notebook',1300),
  (4, 'Remi Note 3 Pro','Xiaomi','Android phone',250),
  (5, 'Play Station 4','Sony','Gaming Console',350),
  (6, 'MOTO G4','Motorola','Android phone',180),
  (7, 'MacBook Air 13\" (MMGF2UA/A) ','Apple','Notebook',1000),
  (8, 'X9 mini','Doogee','Android phone',80),
  (9, 'M3 Note16Gb ','Meizu ','Android phone',210),
  (10,'M5 Note 16 Gb','Meizu ','Android phone',220);

-- users
INSERT INTO users VALUES
    /*original password for admin and user: '12345678' */
  (1, 'Admin', '$2a$11$smEyFewSCrtmlNUSgNq5H.1V0WT5w7tM8geL.WV4WsjFuzlEMU2Ty', 'ADMIN', FALSE),
  (2, 'User', '$2a$11$RJMC5HReOOWjjgvYXFcMHOtJ0A7jf9FSKkPrttTWu0.cDHSkyHWyO', 'USER', FALSE),
