INSERT INTO `categories` (`id`, `name`, `supercategory_id`)
VALUES (1, 'Legume', NULL),
       (2, 'Morcovi', 1),
       (3, 'Rosii', 1),
       (4, 'Castraveti', 1),
       (5, 'Cartofi', 1),
       (6, 'Fructe', NULL),
       (7, 'Mere', 6),
       (8, 'Struguri', 6),
       (9, 'Pere', 6),
       (10, 'Avocado', 6),
       (11, 'Cocos', 6);


INSERT INTO `products` (`name`, `description`, `stock`, `unit_type`, `category_id`)
VALUES ('Rosii din Buzau', 'Rosii proaspete', 100, 'KG', 1),
       ('Castraveti din Iasi', 'Castraveti proaspeti', 200, 'KG', 1),
       ('Avocado din Albania', 'Avocado proaspeti', 100, 'PIECE', 1),
       ('Cocos din Africa', 'Nuci de cocos proaspeti', 100, 'PIECE', 1);

INSERT INTO `price_intervals`(`price`,`interval_min`,`interval_max`,`product_id`)
VALUES (5,1,100,1),
       (3,1,100,2),
       (15,1,100,3),
       (25,1,100,4);