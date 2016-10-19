CREATE DATABASE IF NOT EXISTS `myschema` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `myschema`;

CREATE TABLE Item
(
  id bigint(20) NOT NULL,
  itemDescription varchar(45) DEFAULT NULL,
  itemPrice varchar(45) DEFAULT NULL,
  itemCategory varchar(2) DEFAULT NULL,
  PRIMARY KEY (id)
);

insert into Item values (1234, 'Pens', '50', 'A');
insert into Item values (2345, 'Pencils', '10', 'A');
insert into Item values (3456, 'Papers', '60', 'B');
insert into Item values (4567, 'Clips', '10', 'B');
insert into Item values (5678, 'Bags', '100', 'C');
insert into Item values (6789, 'Mats', '90', 'C');

commit;