# --- Created by Slick DDL
# To stop Slick DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table "REGION" ("ID" SERIAL NOT NULL PRIMARY KEY,"NAME" VARCHAR(254) DEFAULT '' NOT NULL,"POPULATION" VARCHAR(254) DEFAULT '' NOT NULL,"CENTER" VARCHAR(254) DEFAULT '' NOT NULL);
create table "SYMBOL" ("ID" SERIAL NOT NULL PRIMARY KEY,"NAME" VARCHAR(254) DEFAULT '' NOT NULL,"DATE" VARCHAR(254) DEFAULT '' NOT NULL);

# --- !Downs

drop table "SYMBOL";
drop table "REGION";

